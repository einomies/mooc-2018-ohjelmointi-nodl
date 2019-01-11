
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.ReflectionUtils;
import java.lang.reflect.Method;
import java.util.NoSuchElementException;
import org.junit.*;
import static org.junit.Assert.*;

@Points("06-15")
public class KiviPaperiSaksetTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    public void syotteetPelkkaaKivea() {
        String syote = "";
        for (int i = 0; i < 50; i++) {
            syote += "k\n";
        }

        tarkista(syote, "pelkkää kiveä", "Pelaajan voitot: 0", "Tietokoneen voitot: 25");
        tarkistaEi(syote, "pelkkää kiveä", "Pelaajan voitot: 1", "Tietokoneen voitot: 26");
    }

    @Test
    public void syotteetPelkkaaPaperia() {
        String syote = "";
        for (int i = 0; i < 50; i++) {
            syote += "p\n";
        }

        tarkista(syote, "pelkkää paperia", "Pelaajan voitot: 3", "Tietokoneen voitot: 25");
        tarkistaEi(syote, "pelkkää paperia", "Pelaajan voitot: 4", "Tietokoneen voitot: 26");
    }
    
    @Test
    public void syotteetPelkkiaSaksia() {
        String syote = "";
        for (int i = 0; i < 50; i++) {
            syote += "s\n";
        }

        tarkista(syote, "pelkkiä saksia", "Pelaajan voitot: 0", "Tietokoneen voitot: 25");
        tarkistaEi(syote, "pelkkiä saksia", "Pelaajan voitot: 1", "Tietokoneen voitot: 26");
    }

    @Test
    public void kiveaJaSaksia() {
        String syote = "";
        for (int i = 0; i < 10; i++) {
            syote += "k\n";
        }
        for (int i = 0; i < 40; i++) {
            syote += "s\n";
        }

        String kuvaus = "ensin kymmenen k:tä sitten pelkkää s:ää";
        tarkista(syote, kuvaus, "Pelaajan voitot: 1", "Tietokoneen voitot: 25");
        tarkistaEi(syote, kuvaus, "Pelaajan voitot: 2", "Tietokoneen voitot: 26");
    }
    
    @Test
    public void saksiaJaKivea() {
        String syote = "";
        for (int i = 0; i < 10; i++) {
            syote += "s\n";
        }
        for (int i = 0; i < 40; i++) {
            syote += "k\n";
        }

        String kuvaus = "ensin kymmenen s:ää sitten pelkkää k:ta";
        tarkista(syote, kuvaus, "Pelaajan voitot: 0", "Tietokoneen voitot: 25");
        tarkistaEi(syote, kuvaus, "Pelaajan voitot: 1", "Tietokoneen voitot: 26");
    }
    
    @Test
    public void paperiaJaSaksia() {
        String syote = "";
        for (int i = 0; i < 10; i++) {
            syote += "p\n";
        }
        for (int i = 0; i < 40; i++) {
            syote += "s\n";
        }

        String kuvaus = "ensin kymmenen paperia ja sitten pelkkiä saksia";
        tarkista(syote, kuvaus, "Pelaajan voitot: 3", "Tietokoneen voitot: 25");
        tarkistaEi(syote, kuvaus, "Pelaajan voitot: 4", "Tietokoneen voitot: 26");
    }

    @Test
    public void testi1() {
        String kuvaus = "k k s s k s k k k k s s s k s k s k s k k k k k s k s s s k s s s s s s s s s s k k k k k k k k k k k k k k k k";
        tarkista(kuvaus, kuvaus, "Pelaajan voitot: 7", "Tietokoneen voitot: 25");
        tarkistaEi(kuvaus, kuvaus, "Pelaajan voitot: 8", "Tietokoneen voitot: 26");
    }

    @Test
    public void testi2() {
        String kuvaus = "k k p p k p k k k k p p p k p k p k p k k k k k p k p p p k p p k p p k p k p p k k k k k k k k k k k k k k k k";
        tarkista(kuvaus, kuvaus, "Pelaajan voitot: 11", "Tietokoneen voitot: 25");
        tarkistaEi(kuvaus, kuvaus, "Pelaajan voitot: 12", "Tietokoneen voitot: 26");
    }

    @Test
    public void testi3() {
        String kuvaus = "p p s p s p s s s s p p p s p s p s p s p s p s p s p p p s p p s p p s p s p p s s s s s s s s s s s s s s s s";
        tarkista(kuvaus, kuvaus, "Pelaajan voitot: 10", "Tietokoneen voitot: 25");
        tarkistaEi(kuvaus, kuvaus, "Pelaajan voitot: 11", "Tietokoneen voitot: 26");
    }
    
    @Test
    public void testi4() {
        String kuvaus = "s s k k p p s k s k k p p k s k k s k s k k s s k k k s s p s p s k k p k s p s k p s s s s s p s p s s s k s s k p k p p s k s k s s s s s p k s p s";
        tarkista(kuvaus, kuvaus, "Pelaajan voitot: 18", "Tietokoneen voitot: 25");
        tarkistaEi(kuvaus, kuvaus, "Pelaajan voitot: 19", "Tietokoneen voitot: 26");
    }
    
    @Test
    public void testi5() {
        String kuvaus = "k p s p k k k s p s p p p p p p s p k s k p s p s k p p s p s k s p p p s k s p p p s p k p p s p p p k s s p k s k s k s p k p p k k s k k k s p k s";
        tarkista(kuvaus, kuvaus, "Pelaajan voitot: 25", "Tietokoneen voitot: 19");
        tarkistaEi(kuvaus, kuvaus, "Pelaajan voitot: 26", "Tietokoneen voitot: 20", "Tietokoneen voitot: 25");
    }

    private void tarkista(String syote, String syotteenKuvaus, String... odotettuLopussa) {
        if (syote.contains(" ")) {
            syote = syote.replaceAll(" ", "\n");
        }

        int oldOut = io.getSysOut().length();

        io.setSysIn(syote);
        callMain(KiviPaperiSakset.class);
        String out = io.getSysOut().substring(oldOut);

        assertTrue("et tulosta mitään!", out.length() > 0);

        assertTrue("Tulostuksessa pitäisi esiintyä teksti \"Tietokoneen voitot: \". Nyt ei esiintynyt.", io.getSysOut().contains("Tietokoneen voitot: "));
        assertTrue("Tulostuksessa pitäisi esiintyä teksti \"Pelaajan voitot: \". Nyt ei esiintynyt.", io.getSysOut().contains("Pelaajan voitot: "));

        for (String s : odotettuLopussa) {
            assertTrue("Kun syöte on\n" + syotteenKuvaus + "\ntulostuksessa pitäisi esiintyä teksti \"" + s + "\". Nyt ei esiintynyt.", io.getSysOut().contains(s));
        }
    }

    private void tarkistaEi(String syote, String syotteenKuvaus, String... eiOdotettuLopussa) {
        if (syote.contains(" ")) {
            syote = syote.replaceAll(" ", "\n");
        }

        int oldOut = io.getSysOut().length();

        io.setSysIn(syote);
        callMain(KiviPaperiSakset.class);
        String out = io.getSysOut().substring(oldOut);

        assertTrue("et tulosta mitään!", out.length() > 0);

        assertTrue("Tulostuksessa pitäisi esiintyä teksti \"Tietokoneen voitot: \". Nyt ei esiintynyt.", io.getSysOut().contains("Tietokoneen voitot: "));
        assertTrue("Tulostuksessa pitäisi esiintyä teksti \"Pelaajan voitot: \". Nyt ei esiintynyt.", io.getSysOut().contains("Pelaajan voitot: "));

        for (String s : eiOdotettuLopussa) {
            assertFalse("Kun syöte on " + syotteenKuvaus + ", tulostuksessa ei pitäisi esiintyä tekstiä \"" + s + "\".", io.getSysOut().contains(s));
        }
    }

    private void callMain(Class kl) {
        try {
            kl = ReflectionUtils.newInstanceOfClass(kl);
            String[] t = null;
            String x[] = new String[0];
            Method m = ReflectionUtils.requireMethod(kl, "main", x.getClass());
            ReflectionUtils.invokeMethod(Void.TYPE, m, null, (Object) x);
        } catch (NoSuchElementException e) {
            fail("Ohjelmasi koitti lukea liikaa syötettä. Muista lukea nextLine()-metodilla!");
        } catch (Throwable e) {
            fail(kl + "-luokan public static void main(String[] args) -metodi on hävinnyt "
                    + "tai jotain muuta odottamatonta tapahtunut, lisätietoja " + e);
        }
    }
}
