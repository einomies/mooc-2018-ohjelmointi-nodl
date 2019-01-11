
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import org.junit.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@Points("02-08")
public class JuupasEipasTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    public void juupas1() {
        tarkista("1\n0\n", "Juupas", "Eip");
    }

    @Test
    public void juupas2() {
        tarkista("99999\n0\n", "Juupas", "Eip");
    }

    @Test
    public void eipas1() {
        tarkista("-1\n0\n", "Eip", "Juupas");
    }

    @Test
    public void eipas2() {
        tarkista("-9999\n0\n", "Eip", "Juupas");
    }

    @Test
    public void vainNolla() {
        tarkista("0\n", "", "Juupas");
        tarkista("0\n", "", "Eip");
    }

    @Test
    public void molemmat() {
        tarkista("1\n-1\n0\n", "Juupas", null);
        tarkista("1\n-1\n0\n", "Eip", null);
    }

    void tarkista(String syote, String odotettu, String eiOdotettu) {

        io.setSysIn(syote);
        try {
            JuupasEipas.main(new String[]{});
        } catch (Throwable t) {

        }

        assertTrue("Kun syöte oli\n " + syote + "\nodotettiin että tulostuksessa on teksti " + odotettu + "\n\nNyt tulostus oli:\n" + io.getSysOut(), io.getSysOut().contains(odotettu));

        if (eiOdotettu != null) {
            assertFalse("Kun syöte oli\n " + syote + "\nodotettiin että tulostuksessa ei ole tekstiä " + eiOdotettu + "\n\nNyt tulostus oli:\n" + io.getSysOut(), io.getSysOut().contains(eiOdotettu));
        }

    }

}
