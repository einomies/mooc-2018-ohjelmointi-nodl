package sukunimet;

import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.Reflex;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

@Points("09-05.1")
public class HenkiloTest {

    public static String klassName = "sukunimet.Henkilo";
    Reflex.ClassRef<Object> classRef;

    @Before
    public void setUp() {
        classRef = Reflex.reflect(klassName);
    }

    @Test
    public void luokkaOlemassa() {
        assertTrue("Luokan " + s(klassName) + " pitää olla julkinen, eli se tulee määritellä\n"
                + "public class " + klassName + " {...\n}", classRef.isPublic());
    }

    @Test
    public void konstruktoriMerkkijonoilla() throws Throwable {

        Reflex.MethodRef3<Object, Object, String, String, String> ctor = classRef.constructor().taking(String.class, String.class, String.class).withNiceError();
        assertTrue("Määrittele luokalle " + s(klassName) + " julkinen konstruktori: \n"
                + "public " + s(klassName) + "(String etunimi, String ensimmainenSukunimi, String toinenSukunimi)", ctor.isPublic());
        String v = "virheen aiheutti koodi new Henkilo(\"El\", \"Barto\", \"Simpsones\");\n";

        Object obj = ctor.withNiceError(v).invoke("El", "Barto", "Simpsones");
        assertEquals("Koodin new Henkilo(\"El\", \"Barto\", \"Simpsones\").toString() tulee palauttaa merkkijono\nEl Barto Simpsones\nNyt palautus oli " + obj.toString(), "El Barto Simpsones", obj.toString());

        v = "virheen aiheutti koodi new Henkilo(\"Muy\", \"Mucho\", \"Grande\");\n";
        obj = ctor.withNiceError(v).invoke("Muy", "Mucho", "Grande");
        assertEquals("Koodin new Henkilo(\"Muy\", \"Mucho\", \"Grande\").toString() tulee palauttaa merkkijono\nMuy Mucho Grande\nNyt palautus oli " + obj.toString(), "Muy Mucho Grande", obj.toString());
    }

    @Test
    public void konstruktoriHenkiloilla() throws Throwable {
        konstruktoriMerkkijonoilla();

        Reflex.MethodRef3 ctor = classRef.constructor().taking(String.class, classRef.cls(), classRef.cls()).withNiceError();
        assertTrue("Määrittele luokalle " + s(klassName) + " julkinen konstruktori: \n"
                + "public " + s(klassName) + "(String etunimi, Henkilo isa, Henkilo aiti)", ctor.isPublic());

        Reflex.MethodRef3<Object, Object, String, String, String> stringCtor = classRef.constructor().taking(String.class, String.class, String.class).withNiceError();

        String v = "virheen aiheutti koodi new Henkilo(\"El\", \"Barto\", \"Simpsones\");\n";
        Object obj = stringCtor.withNiceError(v).invoke("El", "Barto", "Simpsones");
        assertEquals("Koodin new Henkilo(\"El\", \"Barto\", \"Simpsones\").toString() tulee palauttaa merkkijono\nEl Barto Simpsones\nNyt palautus oli " + obj.toString(), "El Barto Simpsones", obj.toString());

        v = "virheen aiheutti koodi new Henkilo(\"Muy\", \"Mucho\", \"Grande\");\n";
        obj = stringCtor.withNiceError(v).invoke("Muy", "Mucho", "Grande");
        assertEquals("Koodin new Henkilo(\"Muy\", \"Mucho\", \"Grande\").toString() tulee palauttaa merkkijono\nMuy Mucho Grande\nNyt palautus oli " + obj.toString(), "Muy Mucho Grande", obj.toString());

        v = "virheen aiheutti koodi new Henkilo(\"MuchoBarto\", new Henkilo(\"El\", \"Barto\", \"Simpsones\"), new Henkilo(\"Muy\", \"Mucho\", \"Grande\"))";
        Object res = classRef.constructor().taking(String.class, classRef.cls(), classRef.cls()).withNiceError(v).invoke("MuchoBarto", stringCtor.withNiceError(v).invoke("El", "Barto", "Simpsones"), stringCtor.withNiceError(v).invoke("Muy", "Mucho", "Grande"));

        assertEquals("Koodin koodi new Henkilo(\"MuchoBarto\", new Henkilo(\"El\", \"Barto\", \"Simpsones\"), new Henkilo(\"Muy\", \"Mucho\", \"Grande\")).toString() tulee palauttaa merkkijono\nMuchoBarto Barto Mucho", "MuchoBarto Barto Mucho", res.toString());

    }

    public static Object newHenkilo(String omanimi, String ensimmainenSukunimi, String toinenSukunimi) throws Throwable {
        Reflex.ClassRef<Object> classRef = Reflex.reflect(klassName);
        Reflex.MethodRef3<Object, Object, String, String, String> ctor = classRef.constructor().taking(String.class, String.class, String.class).withNiceError();
        return ctor.invoke(omanimi, ensimmainenSukunimi, toinenSukunimi);
    }

    private String s(String klassName) {
        return klassName.substring(klassName.lastIndexOf(".") + 1);
    }
}
