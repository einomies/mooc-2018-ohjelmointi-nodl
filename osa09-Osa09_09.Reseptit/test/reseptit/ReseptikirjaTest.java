package reseptit;

import fi.helsinki.cs.tmc.edutestutils.Points;
import java.lang.reflect.Field;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ReseptikirjaTest {

    Reseptikirja reseptikirja;

    @Before
    public void setUp() {
        reseptikirja = new Reseptikirja();
    }

    @Test
    @Points("09-09.1")
    public void lisaaReseptiJaHaeNimella() {
        Resepti r = new Resepti("Puolukkasurvos");
        r.lisaaRaakaAine("puolukka");
        r.lisaaRaakaAine("sokeri");

        reseptikirja.lisaaResepti(r);

        assertEquals("Reseptin lisääminen ja/tai haku epäonnistui. Tarkastele testejä ja etsi syy.", r, reseptikirja.haeNimella("Puolukkasurvos"));
        assertNull("Reseptin lisääminen ja/tai haku epäonnistui. Tarkastele testejä ja etsi syy.", reseptikirja.haeNimella("Juolukkasurvos"));
    }

    @Test
    @Points("09-09.1")
    public void lisaaReseptiJaHaeNimella2() {
        Resepti r = new Resepti("Puolukkasurvos");
        r.lisaaRaakaAine("puolukka");
        r.lisaaRaakaAine("sokeri");

        reseptikirja.lisaaResepti(r);

        assertEquals("Reseptin lisääminen ja/tai haku epäonnistui. Tarkastele testejä ja etsi syy.", r, reseptikirja.haeNimella("Puolukkasurvos"));
        assertNull("Reseptin lisääminen ja/tai haku epäonnistui. Tarkastele testejä ja etsi syy.", reseptikirja.haeNimella("Juolukkasurvos"));

        Resepti j = new Resepti("Juolukkasurvos");
        j.lisaaRaakaAine("juolukka");

        reseptikirja.lisaaResepti(j);

        assertEquals("Reseptin lisääminen ja/tai haku epäonnistui. Tarkastele testejä ja etsi syy.", r, reseptikirja.haeNimella("Puolukkasurvos"));
        assertNotNull("Reseptin lisääminen ja/tai haku epäonnistui. Tarkastele testejä ja etsi syy.", reseptikirja.haeNimella("Juolukkasurvos"));
        assertEquals("Reseptin lisääminen ja/tai haku epäonnistui. Tarkastele testejä ja etsi syy.", j, reseptikirja.haeNimella("Juolukkasurvos"));
    }

    @Test
    @Points("09-09.2")
    public void lisaaReseptiJaHaeRaakaAineella() {
        Resepti r = new Resepti("Puolukkasurvos");
        r.lisaaRaakaAine("puolukka");
        r.lisaaRaakaAine("sokeri");

        reseptikirja.lisaaResepti(r);

        Resepti j = new Resepti("Juolukkasurvos");
        j.lisaaRaakaAine("juolukka");
        j.lisaaRaakaAine("sokeri");

        reseptikirja.lisaaResepti(j);

        assertEquals("Reseptin lisääminen ja/tai raaka-aineella haku ei toiminut odotetusti. Tarkastele testejä ja etsi syy.", 2, reseptikirja.haeRaakaAineella("sokeri").size());
        assertEquals("Reseptin lisääminen ja/tai raaka-aineella haku ei toiminut odotetusti. Tarkastele testejä ja etsi syy.", 0, reseptikirja.haeRaakaAineella("pokeri").size());
        assertEquals("Reseptin lisääminen ja/tai raaka-aineella haku ei toiminut odotetusti. Tarkastele testejä ja etsi syy.", 1, reseptikirja.haeRaakaAineella("puolukka").size());
        assertEquals("Reseptin lisääminen ja/tai raaka-aineella haku ei toiminut odotetusti. Tarkastele testejä ja etsi syy.", 1, reseptikirja.haeRaakaAineella("juolukka").size());
        assertEquals("Reseptin lisääminen ja/tai raaka-aineella haku ei toiminut odotetusti. Tarkastele testejä ja etsi syy.", 0, reseptikirja.haeRaakaAineella("Juolukkasurvos").size());
        assertEquals("Reseptin lisääminen ja/tai raaka-aineella haku ei toiminut odotetusti. Tarkastele testejä ja etsi syy.", 0, reseptikirja.haeRaakaAineella("Puolukkasurvos").size());
        assertEquals("Reseptin lisääminen ja/tai raaka-aineella haku ei toiminut odotetusti. Tarkastele testejä ja etsi syy.", 0, reseptikirja.haeRaakaAineella("uolukka").size());

        assertTrue("Reseptin lisääminen ja/tai raaka-aineella haku ei toiminut odotetusti. Tarkastele testejä ja etsi syy.", reseptikirja.haeRaakaAineella("puolukka").contains(r));
        assertTrue("Reseptin lisääminen ja/tai raaka-aineella haku ei toiminut odotetusti. Tarkastele testejä ja etsi syy.", reseptikirja.haeRaakaAineella("sokeri").contains(r));
        assertTrue("Reseptin lisääminen ja/tai raaka-aineella haku ei toiminut odotetusti. Tarkastele testejä ja etsi syy.", reseptikirja.haeRaakaAineella("sokeri").contains(j));
    }

    @Test
    @Points("09-09.2")
    public void lisaaReseptiJaHaeRaakaAineella2() {
        Resepti r = new Resepti("Puolukkasurvos");
        r.lisaaRaakaAine("puolukka");
        r.lisaaRaakaAine("sokeri");

        reseptikirja.lisaaResepti(r);

        assertEquals("Reseptin lisääminen ja/tai raaka-aineella haku ei toiminut odotetusti. Tarkastele testejä ja etsi syy.", 1, reseptikirja.haeRaakaAineella("sokeri").size());
        assertEquals("Reseptin lisääminen ja/tai raaka-aineella haku ei toiminut odotetusti. Tarkastele testejä ja etsi syy.", 0, reseptikirja.haeRaakaAineella("pokeri").size());
        assertEquals("Reseptin lisääminen ja/tai raaka-aineella haku ei toiminut odotetusti. Tarkastele testejä ja etsi syy.", 1, reseptikirja.haeRaakaAineella("puolukka").size());
        assertEquals("Reseptin lisääminen ja/tai raaka-aineella haku ei toiminut odotetusti. Tarkastele testejä ja etsi syy.", 0, reseptikirja.haeRaakaAineella("Puolukkasurvos").size());
        assertEquals("Reseptin lisääminen ja/tai raaka-aineella haku ei toiminut odotetusti. Tarkastele testejä ja etsi syy.", 0, reseptikirja.haeRaakaAineella("uolukka").size());
        assertTrue("Reseptin lisääminen ja/tai raaka-aineella haku ei toiminut odotetusti. Tarkastele testejä ja etsi syy.", reseptikirja.haeRaakaAineella("puolukka").contains(r));
        assertTrue("Reseptin lisääminen ja/tai raaka-aineella haku ei toiminut odotetusti. Tarkastele testejä ja etsi syy.", reseptikirja.haeRaakaAineella("sokeri").contains(r));
    }

    private String kentta(String toString, String klassName) {
        return toString.replace(klassName + ".", "").replace("java.lang.", "").replace("java.util.", "").replace("java.io.", "");
    }

    @Test
    public void vainMapOlioMuuttujia() {
        Field[] kentat = Reseptikirja.class.getDeclaredFields();

        for (Field field : kentat) {
            assertFalse("et tarvitse \"stattisia muuttujia\", poista luokalta Reseptikirja muuttuja " + kentta(field.toString(), "Reseptikirja"), field.toString().contains("static") && !field.toString().contains("final"));
            assertFalse("et tarvitse \"stattisia muuttujia\", poista luokalta Reseptikirja muuttuja " + kentta(field.toString(), "Reseptikirja"), field.toString().contains("static") && !field.toString().contains("final"));
            assertTrue("luokan kaikkien oliomuuttujien näkyvyyden tulee olla private, mutta luokalta Reseptikirja löytyi: " + kentta(field.toString(), "Reseptikirja"), field.toString().contains("private"));
            assertTrue("Ovathan kaikki luokan Reseptikirja oliomuuttujat Map-tyyppisiä?\nOliomuuttuja " + field.getName() + " on ilmeisesti jotain muuta...", field.getType().toString().contains("java.util.Map"));
        }
    }

}
