package sukunimet;

import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.Reflex;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

@Points("09-05.2")
public class PerheTest {

    private String klassName = "sukunimet.Perhe";
    Reflex.ClassRef<Object> classRef;

    @Before
    public void setUp() {
        classRef = Reflex.reflect(klassName);
    }

    @Test
    public void luokkaOlemassa() {
        assertTrue("Luokan " + s(klassName) + " pitää olla julkinen, eli se tulee määritellä\n"
                + "public class " + s(klassName) + " {...\n}", classRef.isPublic());
    }

    @Test
    public void konstruktori() throws Throwable {
        Reflex.MethodRef0<Object, Object> ctor = classRef.constructor().takingNoParams().withNiceError();
        assertTrue("Määrittele luokalle " + s(klassName) + " julkinen konstruktori: \n"
                + "public " + s(klassName) + "()", ctor.isPublic());
        String v = "virheen aiheutti koodi new " + s(klassName) + "();\n";
        ctor.withNiceError(v).invoke();
    }

    @Test
    public void lisaa() throws Throwable {
        konstruktori();
        String virhe = "Onhan luokalla " + s(klassName) + " metodi public void lisaa(Henkilo henkilo)?\nVirhe kutsuttaessa new Perhe().lisaa(new Henkilo(\"Juan\", \"Gonzales\", \"Zorro\"))";

        Object perhe = perhe();
        Object henkilo = HenkiloTest.newHenkilo("Juan", "Gonzales", "Zorro");

        classRef.method("lisaa").returningVoid().taking(Reflex.reflect(HenkiloTest.klassName).cls()).withNiceError(virhe).invokeOn(perhe, henkilo);

        assertTrue("Kutsun new Perhe().lisaa(new Henkilo(\"Juan\", \"Gonzales\", \"Zorro\")).toString() palauttaman merkkijonon pitäisi sisältää nimi\nJuan Gonzales Zorro.\nNyt palautus oli:\n" + perhe.toString(), perhe.toString().contains("Juan Gonzales Zorro"));

        Object toinen = HenkiloTest.newHenkilo("Zorro", "Mucho", "Tornado");

        classRef.method("lisaa").returningVoid().taking(Reflex.reflect(HenkiloTest.klassName).cls()).withNiceError(virhe).invokeOn(perhe, toinen);

        assertTrue("Kutsun:\nPerhe p = new Perhe();\np.lisaa(new Henkilo(\"Juan\", \"Gonzales\", \"Zorro\"));\np.lisaa(new Henkilo(\"Zorro\", \"Mucho\", \"Tornado\"));String s = p.toString(); palauttaman merkkijonon pitäisi sisältää nimi\nZorro Mucho Tornado.\nNyt palautus oli:\n" + perhe.toString(), perhe.toString().contains("Zorro Mucho Tornado"));
        assertTrue("Kutsun:\nPerhe p = new Perhe();\np.lisaa(new Henkilo(\"Juan\", \"Gonzales\", \"Zorro\"));\np.lisaa(new Henkilo(\"Zorro\", \"Mucho\", \"Tornado\"));String s = p.toString(); palauttaman merkkijonon pitäisi sisältää nimi\nJuan Gonzales Zorro.\nNyt palautus oli:\n" + perhe.toString(), perhe.toString().contains("Juan Gonzales Zorro"));
    }

    @Test
    public void poista() throws Throwable {
        lisaa();
        konstruktori();
        String virhe = "Onhan luokalla " + s(klassName) + " metodi public void lisaa(Henkilo henkilo)?\nVirhe kutsuttaessa new Perhe().lisaa(new Henkilo(\"Juan\", \"Gonzales\", \"Zorro\"))";

        Object perhe = perhe();
        Object henkilo = HenkiloTest.newHenkilo("Juan", "Gonzales", "Zorro");
        Object toinen = HenkiloTest.newHenkilo("Zorro", "Mucho", "Tornado");

        classRef.method("lisaa").returningVoid().taking(Reflex.reflect(HenkiloTest.klassName).cls()).withNiceError(virhe).invokeOn(perhe, henkilo);
        classRef.method("lisaa").returningVoid().taking(Reflex.reflect(HenkiloTest.klassName).cls()).withNiceError(virhe).invokeOn(perhe, toinen);

        String virhe2 = "Onhan luokalla " + s(klassName) + " metodi public void poista(Henkilo henkilo)?\nVirhe kutsuttaessa new Perhe().poista(new Henkilo(\"Juan\", \"Gonzales\", \"Zorro\"))";

        classRef.method("poista").returningVoid().taking(Reflex.reflect(HenkiloTest.klassName).cls()).withNiceError(virhe2).invokeOn(perhe, henkilo);

        assertTrue("Kutsun:\nPerhe p = new Perhe();\np.lisaa(new Henkilo(\"Juan\", \"Gonzales\", \"Zorro\"));\np.lisaa(new Henkilo(\"Zorro\", \"Mucho\", \"Tornado\"));\np.poista(new Henkilo(\"Zorro\", \"Mucho\", \"Tornado\"));\nString s = p.toString(); palauttaman merkkijonon ei pitäisi sisältää nimeä\nZorro Mucho Tornado.\nNyt palautus oli:\n" + perhe.toString(), perhe.toString().contains("Zorro Mucho Tornado"));
        assertFalse("Kutsun:\nPerhe p = new Perhe();\np.lisaa(new Henkilo(\"Juan\", \"Gonzales\", \"Zorro\"));\np.lisaa(new Henkilo(\"Zorro\", \"Mucho\", \"Tornado\"));String s = p.toString(); palauttaman merkkijonon pitäisi sisältää nimi\nJuan Gonzales Zorro.\nNyt palautus oli:\n" + perhe.toString(), perhe.toString().contains("Juan Gonzales Zorro"));

        virhe2 = "Onhan luokalla " + s(klassName) + " metodi public void poista(Henkilo henkilo)?\nVirhe kutsuttaessa new Perhe().poista(new Henkilo(\"Zorro\", \"Mucho\", \"Tornado\"))";

        classRef.method("poista").returningVoid().taking(Reflex.reflect(HenkiloTest.klassName).cls()).withNiceError(virhe2).invokeOn(perhe, toinen);

        assertFalse("Kutsun:\nPerhe p = new Perhe();\np.lisaa(new Henkilo(\"Juan\", \"Gonzales\", \"Zorro\"));\np.lisaa(new Henkilo(\"Zorro\", \"Mucho\", \"Tornado\"));\np.poista(new Henkilo(\"Zorro\", \"Mucho\", \"Tornado\"));\nString s = p.toString(); palauttaman merkkijonon ei pitäisi sisältää nimeä\nZorro Mucho Tornado.\nNyt palautus oli:\n" + perhe.toString(), perhe.toString().contains("Zorro Mucho Tornado"));
        assertFalse("Kutsun:\nPerhe p = new Perhe();\np.lisaa(new Henkilo(\"Juan\", \"Gonzales\", \"Zorro\"));\np.lisaa(new Henkilo(\"Zorro\", \"Mucho\", \"Tornado\"));String s = p.toString(); palauttaman merkkijonon pitäisi sisältää nimi\nJuan Gonzales Zorro.\nNyt palautus oli:\n" + perhe.toString(), perhe.toString().contains("Juan Gonzales Zorro"));

    }

    private String s(String klassName) {
        return klassName.substring(klassName.lastIndexOf(".") + 1);
    }

    private Object perhe() throws Throwable {
        Reflex.MethodRef0<Object, Object> ctor = classRef.constructor().takingNoParams().withNiceError();
        assertTrue("Määrittele luokalle " + s(klassName) + " julkinen konstruktori: \n"
                + "public " + s(klassName) + "()", ctor.isPublic());
        String v = "virheen aiheutti koodi new " + s(klassName) + "();\n";
        return ctor.withNiceError(v).invoke();
    }
}
