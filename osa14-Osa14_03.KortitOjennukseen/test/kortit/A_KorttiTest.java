package kortit;

import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.ReflectionUtils;
import fi.helsinki.cs.tmc.edutestutils.Reflex;
import java.lang.reflect.Method;
import java.util.Arrays;
import static kortit.TestUtils.compareToMethod;
import static kortit.TestUtils.m;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

@Points("14-03.1")
public class A_KorttiTest {

    Class korttiClass;
    static String packageName = "kortit";
    static String klassName = "Kortti";
    static String fullName = packageName + "." + klassName;
    Reflex.ClassRef<Object> klass;

    @Before
    public void setUp() {
        klass = Reflex.reflect(fullName);

        try {
            korttiClass = ReflectionUtils.findClass(fullName);
        } catch (Throwable t) {
            fail("Onhan tehtävässä luokka \"" + klassName + "\", joka on pakkauksessa " + packageName + "");
        }
    }

    @Test
    public void onLuokka() {
        assertTrue("Luokan " + klassName + " pitää olla julkinen, eli se tulee määritellä\npublic class " + klassName + " {...\n}", klass.isPublic());
    }

    @Test
    public void onImplementComparableKortti() {
        Class kl;
        try {
            kl = korttiClass;
            Class is[] = kl.getInterfaces();
            Class oikein[] = {java.lang.Comparable.class};
            for (int i = 0; i < is.length; i++) {
            }
            assertTrue("Varmista että " + klassName + " toteuttaa (vain!) rajapinnan Comparable",
                    Arrays.equals(is, oikein));

        } catch (Throwable t) {
            fail("Toteuttaahan luokka " + klassName + " rajapinnan \"Comparable<Kortti>\"");
        }
    }

    @Test
    public void onCompareToMetodi() throws Throwable {
        String metodi = "compareTo";

        Kortti eka = new Kortti(1, Maa.HERTTA);
        Kortti toka = new Kortti(10, Maa.RISTI);

        assertTrue("tee luokalle " + klassName + " metodi public int " + metodi + "(Kortti verrattava)",
                klass.method(eka, metodi)
                        .returning(int.class).taking(Kortti.class).isPublic());

        String v = "\nVirheen aiheuttanut koodi\n"
                + "Kortti eka = new Kortti(1,Kortti.HERTTA);\n"
                + "Kortti toka = new Kortti(10,Kortti.RISTI);\n"
                + "eka.compareTo(toka);";

        klass.method(eka, metodi)
                .returning(int.class).taking(Kortti.class).withNiceError(v).invoke(toka);

        try {
            ReflectionUtils.requireMethod(korttiClass, int.class, "compareTo", Kortti.class);
        } catch (Throwable t) {
            fail("Olethan luonut metodin \"public int compareTo(Kortti toinen)\"");
        }
    }


    @Test
    public void testaaCompareTo() {
        try {
            Object h1 = new Kortti(1, Maa.HERTTA);
            Object h2 = new Kortti(2, Maa.HERTTA);
            Method m = compareToMethod(korttiClass);
            int tulos = ReflectionUtils.invokeMethod(int.class, m, h1, h2);

        } catch (Throwable ex) {

            fail("Olethan toteuttanut luokalla \"Kortti\" metodin \"public int compareTo(Kortti toinen)\".\n"
                    + "Toteuttaahan Kortti-luokka myös rajapinnan Comparable<Kortti>?");
        }
    }

    @Test
    public void toteuttaaComparablen() {
        try {
            assertTrue("Kortti-luokkasi ei toteuta rajapintaa Comparable!", korttiClass.getInterfaces()[0].equals(Comparable.class));
        } catch (Throwable t) {
            fail("Kortti-luokkasi ei toteuta rajapintaa Comparable!");
        }
    }

    @Test
    public void testaa() {
        TestUtils.testaa(1, Maa.RUUTU);
        TestUtils.testaa(5, Maa.HERTTA);
        TestUtils.testaa(14, Maa.PATA);

        int[][] luvut = {
            {4, 2, 5, 2},
            {3, 2, 4, 3},
            {6, 2, 8, 3},
            {10, 2, 10, 3},
            {11, 1, 11, 2}
        };

        for (int[] is : luvut) {
            TestUtils.testaa(is[0], m(is[1]), is[2], m(is[3]), false);
            TestUtils.testaa(is[2], m(is[3]), is[0], m(is[1]), true);
        }
    }

}
