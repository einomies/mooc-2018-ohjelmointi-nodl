package kortit;

import kortit.Maa;
import kortit.Kortti;
import fi.helsinki.cs.tmc.edutestutils.ReflectionUtils;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author avihavai
 */
public class TestUtils {

    public static Maa m(int luku) {
        for (Maa value : Maa.values()) {
            if (value.ordinal() == luku) {
                return value;
            }
        }

        return null;
    }

    public static int testaaKahta(Kortti h1, Kortti h2) {
        try {
            Method m = compareToMethod(ReflectionUtils.findClass(A_KorttiTest.fullName));

            int tulos = ReflectionUtils.invokeMethod(int.class, m, h1, h2);
            return tulos;
        } catch (Throwable ex) {

            fail("Olethan toteuttanut luokalla \"Kortti\" metodin \"public int compareTo(Kortti toinen)\".\n"
                    + "Toteuttaahan Kortti-luokka myös rajapinnan Comparable<Kortti>?");
            return -111;
        }
    }

    public static void testaa(int a1, Maa m1, int a2, Maa m2, boolean pos) {
        int vastaus = testaaKahta(new Kortti(a1, m1), new Kortti(a2, m2));
        String t = pos ? "positiivinen" : "negatiivinen";
        boolean tulos = pos ? vastaus > 0 : vastaus < 0;

        assertTrue("tuloksen olisi pitänyt olla " + t + " luku\n"
                + "Kortti eka = new Kortti(" + a1 + "," + m1 + ");\n"
                + "Kortti toka = new Kortti(" + a2 + "," + m2 + ");\n"
                + "eka.compareTo(toka)\n"
                + "tulos oli: " + vastaus, tulos);
    }

    public static void testaa(int a1, Maa m1) {
        int vastaus = testaaKahta(new Kortti(a1, m1), new Kortti(a1, m1));

        assertEquals(
                "Kortti eka = new Kortti(" + a1 + "," + m1 + ");\n"
                + "Kortti toka = new Kortti(" + a1 + "," + m1 + ");\n"
                + "eka.compareTo(toka)", 0, vastaus);
    }

    public static Method compareToMethod(Class clazz) {
        Method m = ReflectionUtils.requireMethod(clazz, "compareTo", Kortti.class);
        return m;
    }

    public static String kentta(String toString, String klassName) {
        return toString.replace(klassName + ".", "").replace("java.lang.", "").replace("java.util.", "");
    }
}
