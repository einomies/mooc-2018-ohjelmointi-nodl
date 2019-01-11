
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import java.util.Arrays;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.assertTrue;

@Points("02-02")
public class TyontekijanElakevakuutusTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    public void esimerkki1() {
        tarkasta("800", "144", "944", "48", "752", "192");
    }

    @Test
    public void esimerkki2() {
        tarkasta("1000", "180", "1180", "60", "940", "240");
    }

    void tarkasta(String syote, String taMaksu, String ttKustannus, String ttMaksu, String ttPalkka, String tyKulut) {
        String tulostus = annaTulostus(syote + "\n");
        List<String> rivit = Arrays.asList(tulostus.split("\n"));

        assertTrue("Kun bruttopalkaksi syötetään " + syote + ", tulostuksessa pitäisi olla rivi:\nTyönantaja maksaa TyEL-maksuja: 144\n\nNyt tulostus oli:\n" + tulostus, rivit.stream().filter(s -> s.contains("antaja maksaa") && s.contains(taMaksu)).count() == 1);
        assertTrue("Kun bruttopalkaksi syötetään " + syote + ", tulostuksessa pitäisi olla rivi:\nTyöntekijän kustannus työnantajalle vähintään: 944\n\nNyt tulostus oli:\n" + tulostus, rivit.stream().filter(s -> s.contains("tekij") && s.contains("kustannus") && s.contains(ttKustannus)).count() == 1);
        assertTrue("Kun bruttopalkaksi syötetään " + syote + ", tulostuksessa pitäisi olla rivi:\nTyöntekijä maksaa TyEL-maksuja: 48\n\nNyt tulostus oli:\n" + tulostus, rivit.stream().filter(s -> s.contains("tekij") && s.contains("maksaa") && s.contains(ttMaksu)).count() == 1);
        assertTrue("Kun bruttopalkaksi syötetään " + syote + ", tulostuksessa pitäisi olla rivi:\nTyöntekijän palkka TyEL-maksun jälkeen: 752\n\nNyt tulostus oli:\n" + tulostus, rivit.stream().filter(s -> s.contains("tekij") && s.contains("palkka") && s.contains(ttPalkka)).count() == 1);
        assertTrue("Kun bruttopalkaksi syötetään " + syote + ", tulostuksessa pitäisi olla rivi:\nTyEL-kulut yhteensä: 192\n\nNyt tulostus oli:\n" + tulostus, rivit.stream().filter(s -> s.contains("kulut") && s.contains("yht") && s.contains(tyKulut)).count() == 1);

    }

    String annaTulostus(String syote) {
        io.setSysIn(syote);
        try {
            TyontekijanElakevakuutus.main(new String[]{});
        } catch (Throwable t) {

        }

        return io.getSysOut();
    }
}
