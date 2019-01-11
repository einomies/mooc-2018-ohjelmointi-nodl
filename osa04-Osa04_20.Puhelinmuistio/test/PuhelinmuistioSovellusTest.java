import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import java.io.File;
import java.util.UUID;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Rule;
import org.junit.Test;

@Points("04-20")
public class PuhelinmuistioSovellusTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    public void lisaysEiListaa() {
        String randomTiedosto = "tmp-" + UUID.randomUUID().toString().substring(0, 6);
        String syote = "olematon.tsv\nlisaa\netu-123\nsuku-123\npuh-123\nlopeta\n" + randomTiedosto + "\n";
        io.setSysIn(syote);
        PuhelinmuistioSovellus.main(new String[]{});
        String out = io.getSysOut();
        String virhe = "Puhelinmuistioon lisättyä henkilöä ei tule tulostaa ellei tulostusta erikseen pyydetä.\nKokeile toimintaa syötteellä:\n" + syote;
        assertFalse(virhe, out.contains("etu-123"));
        assertFalse(virhe, out.contains("suku-123"));
        assertFalse(virhe, out.contains("puh-123"));

        try {
            new File(randomTiedosto).delete();
        } catch (Exception e) {

        }
    }

    @Test
    public void listausListaa() {
        String randomTiedosto = "tmp-" + UUID.randomUUID().toString().substring(0, 6);
        String syote = "olematon.tsv\nlisaa\netu-123\nsuku-123\npuh-123\nlistaa\nlopeta\n" + randomTiedosto + "\n";
        io.setSysIn(syote);
        PuhelinmuistioSovellus.main(new String[]{});
        String out = io.getSysOut();
        String virhe = "Puhelinmuistioon lisätyt henkilöt tulee tulostaa kun käyttäjä syöttää komennon listaa.\nKokeile toimintaa syötteellä:\n" + syote;
        assertTrue(virhe, out.contains("etu-123"));
        assertTrue(virhe, out.contains("suku-123"));
        assertTrue(virhe, out.contains("puh-123"));

        try {
            new File(randomTiedosto).delete();
        } catch (Exception e) {

        }
    }


    @Test
    public void poistoPoistaa() {
        String randomTiedosto = "tmp-" + UUID.randomUUID().toString().substring(0, 6);
        String syote = "olematon.tsv\nlisaa\netu-123\nsuku-123\npuh-123\npoista\netu-123\nsuku-123\nlistaa\nlopeta\n" + randomTiedosto + "\n";
        io.setSysIn(syote);
        PuhelinmuistioSovellus.main(new String[]{});
        String out = io.getSysOut();
        String virhe = "Poistetun henkilön ei tule näkyä listauksessa.\nKokeile toimintaa syötteellä:\n" + syote;
        assertFalse(virhe, out.contains("etu-123"));
        assertFalse(virhe, out.contains("suku-123"));
        assertFalse(virhe, out.contains("puh-123"));

        try {
            new File(randomTiedosto).delete();
        } catch (Exception e) {

        }
    }

    @Test
    public void poistoPoistaaHalutun() {
        String randomTiedosto = "tmp-" + UUID.randomUUID().toString().substring(0, 6);
        String syote = "olematon.tsv\nlisaa\netu-123\nsuku-123\npuh-123\npoista\netunimi-olematon\nsuku-123\nlistaa\nlopeta\n" + randomTiedosto + "\n";
        io.setSysIn(syote);
        PuhelinmuistioSovellus.main(new String[]{});
        String out = io.getSysOut();
        String virhe = "Poiston tulee poistaa vain henkilö, joka halutaan poistaa. Kokeile toimintaa syötteellä:\n" + syote;

        assertTrue(virhe, out.contains("etu-123"));
        assertTrue(virhe, out.contains("suku-123"));
        assertTrue(virhe, out.contains("puh-123"));

        try {
            new File(randomTiedosto).delete();
        } catch (Exception e) {

        }
    }

    @Test
    public void etsiLoytaaHalutun() {
        String randomTiedosto = "tmp-" + UUID.randomUUID().toString().substring(0, 6);
        String syote = "olematon.tsv\nlisaa\netu-123\nsuku-123\npuh-123\netsi\npuh-123\nlopeta\n" + randomTiedosto + "\n";
        io.setSysIn(syote);
        PuhelinmuistioSovellus.main(new String[]{});
        String out = io.getSysOut();
        String virhe = "Komennon etsi tulee listata ne henkilöt, joiden puhelinnumero sisältää haetun merkkijonon. Kokeile toimintaa syötteellä:\n" + syote;

        assertTrue(virhe, out.contains("etu-123"));
        assertTrue(virhe, out.contains("suku-123"));
        assertTrue(virhe, out.contains("puh-123"));

        try {
            new File(randomTiedosto).delete();
        } catch (Exception e) {

        }
    }

    @Test
    public void etsiEiTulostaEiEtsittya() {
        String randomTiedosto = "tmp-" + UUID.randomUUID().toString().substring(0, 6);
        String syote = "olematon.tsv\nlisaa\netu-123\nsuku-123\npuh-123\netsi\npuh-321\nlopeta\n" + randomTiedosto + "\n";
        io.setSysIn(syote);
        PuhelinmuistioSovellus.main(new String[]{});
        String out = io.getSysOut();
        String virhe = "Komennon etsi tulee listata vain ne henkilöt, joiden puhelinnumero sisältää haetun merkkijonon. Kokeile toimintaa syötteellä:\n" + syote;

        assertFalse(virhe, out.contains("etu-123"));
        assertFalse(virhe, out.contains("suku-123"));
        assertFalse(virhe, out.contains("puh-123"));

        try {
            new File(randomTiedosto).delete();
        } catch (Exception e) {

        }
    }
}
