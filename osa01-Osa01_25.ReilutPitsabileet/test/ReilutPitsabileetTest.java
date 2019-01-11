
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;
import org.junit.Rule;

@Points("01-25")
public class ReilutPitsabileetTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    public void esimerkki1() {
        run("5\n2\n6\n", 2);
    }
    
    @Test
    public void esimerkki2() {
        run("14\n2\n6\n", 12);
    }
    
    @Test
    public void case3() {
        run("1\n1\n8\n", 0);
    }

    public void run(String syote, int odotettu) {
        io.setSysIn(syote);
        ReilutPitsabileet.main(new String[]{});
        String[] out = io.getSysOut().replaceAll("[^\\d.]", " ").trim().split("\\s+");
        assertTrue("Odotettiin vähintään 1 rivi tulostuksessa kun syöte oli:\n" + syote + "Tulostus oli:\n" + io.getSysOut(), out.length > 0);
        int luku = -1;
        try {
            luku = Integer.parseInt(out[out.length - 1]);
        } catch (Throwable t) {
            fail("Ohjelman tulostuksen tulee päättyä yli jäävien palojen lukumäärää kuvaavaan lukuun. Nyt lopussa ei ollut lukua. Tulostus oli:\n" + io.getSysOut());
        }

        assertTrue("Odotettiin että yli jääviä paloja on " + odotettu + " kun syöte oli:\n" + syote + "Nyt yli jääviä paloja oli " + luku + ".", luku == odotettu);
    }
}
