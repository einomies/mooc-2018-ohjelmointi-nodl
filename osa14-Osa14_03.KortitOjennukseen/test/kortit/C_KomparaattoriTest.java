package kortit;

import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.ReflectionUtils;
import fi.helsinki.cs.tmc.edutestutils.Reflex;
import java.util.Arrays;
import static kortit.TestUtils.m;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class C_KomparaattoriTest {

    String packageName = "kortit";
    String klassName = "SamatMaatVierekkainArvojarjestykseen";
    String fullName = packageName + "." + klassName;
    Reflex.ClassRef<Object> klass;

    @Before
    public void setUp() {
        klass = Reflex.reflect(fullName);
    }

    @Test
    @Points("14-03.5")
    public void luokkaJulkinen() {
        assertTrue("Luokan " + klassName + " pitää olla julkinen, eli se tulee määritellä\npublic class " + klassName + " {...\n}", klass.isPublic());
    }

    @Points("14-03.5")
    @Test
    public void onImplementComparableKasi() {
        String nimi = klassName;
        Class kl;
        try {
            kl = ReflectionUtils.findClass(fullName);
            Class is[] = kl.getInterfaces();
            Class oikein[] = {java.util.Comparator.class};

            assertTrue("Varmista että " + nimi + " toteuttaa (vain!) rajapinnan Comparator<Kortti>",
                    Arrays.equals(is, oikein));

        } catch (Throwable t) {
            fail("Toteuttaahan luokka " + nimi + " rajapinnan \"Comparator<Kortti>\"");
        }
    }

    @Test
    @Points("14-03.5")
    public void onCompareMetodi() throws Throwable {
        String metodi = "compare";

        Object k1 = klass.constructor().takingNoParams().invoke();

        assertTrue("tee luokalle " + klassName + " metodi public int " + metodi + "(Kortti k1, Kortti k2)",
                klass.method(k1, metodi)
                        .returning(int.class).taking(Kortti.class, Kortti.class).isPublic());

        String v = "\nVirheen aiheuttanut koodi\n"
                + "SamatMaatVierekkainArvojarjestykseen vertailija = new SamatMaatVierekkainArvojarjestykseen();\n"
                + "Kortti k1 = new Kortti(3, Maa.HERTTA);\n"
                + "Kortti k2 = new Kortti(4, Maa.PATA));\n"
                + "vertailija.compareTo(k1, k2);";

        klass.method(k1, metodi)
                .returning(int.class).taking(Kortti.class, Kortti.class).withNiceError(v).
                invoke(new Kortti(3, Maa.HERTTA), new Kortti(4, Maa.PATA));
    }

    @Test
    @Points("14-03.5")
    public void testaa() throws Throwable {
        testaa(1, Maa.RUUTU);
//        testaa(5, 8);
        testaa(14, Maa.PATA);

        int[][] luvut = {
            {2, 2, 4, 3},
            {3, 0, 2, 3},
            {4, 2, 5, 2},
            {7, 4, 12, 4},};

        for (int[] is : luvut) {
            testaa(is[0], m(is[1]), is[2], m(is[3]), false);
            testaa(is[2], m(is[3]), is[0], m(is[1]), true);
        }
    }

    public int testaaKahta(Kortti h1, Kortti h2) throws Throwable {
        String metodi = "compare";

        Object komparaattori = klass.constructor().takingNoParams().invoke();

        return klass.method(komparaattori, metodi)
                .returning(int.class).taking(Kortti.class, Kortti.class).
                invoke(h1, h2);
    }

    public void testaa(int a1, Maa m1, int a2, Maa m2, boolean pos) throws Throwable {
        int vastaus = testaaKahta(new Kortti(a1, m1), new Kortti(a2, m2));
        String t = pos ? "positiivinen" : "negatiivinen";
        boolean tulos = pos ? vastaus > 0 : vastaus < 0;

        assertTrue("tuloksen olisi pitänyt olla " + t + " luku\n"
                + "SamatMaatVierekkainArvojarjestykseen vertailija = new SamatMaatVierekkainArvojarjestykseen();\n"
                + "Kortti eka = new Kortti(" + a1 + "," + m1 + ");\n"
                + "Kortti toka = new Kortti(" + a2 + "," + m2 + ");\n"
                + "vertailija.compare(eka,toka)\n"
                + "tulos oli: " + vastaus, tulos);
    }

    public void testaa(int a1, Maa m1) throws Throwable {
        int vastaus = testaaKahta(new Kortti(a1, m1), new Kortti(a1, m1));

        assertEquals(
                "SamatMaatVierekkainArvojarjestykseen vertailija = new SamatMaatVierekkainArvojarjestykseen();\n"
                + "Kortti eka = new Kortti(" + a1 + "," + m1 + ");\n"
                + "Kortti toka = new Kortti(" + a1 + "," + m1 + ");\n"
                + "vertailija.compare(eka,toka)", 0, vastaus);
    }

}
