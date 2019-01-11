
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.ReflectionUtils;
import static org.junit.Assert.assertTrue;
import org.junit.Rule;
import org.junit.Test;

@Points("01-13")
public class KolmenLuvunSummaajaTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    public void testSummaaja() {
        summaajaToimii(6, 2, 62);
    }
    
    @Test
    public void testSummaajaNegatiivisilla() {
        summaajaToimii(-10, -5, -2);
    }
    
    @Test
    public void testSummaajaNollilla() {
        summaajaToimii(0, 0, 0);
    }
    
    private void summaajaToimii(int ekaLuku, int tokaLuku, int kolmasLuku) {
        ReflectionUtils.newInstanceOfClass(KolmenLuvunSummaaja.class);
        io.setSysIn(ekaLuku + "\n" + tokaLuku + "\n" + kolmasLuku + "\n");
        KolmenLuvunSummaaja.main(new String[0]);

        String out = io.getSysOut();

        assertTrue("Et kysynyt käyttäjältä mitään!", out.trim().length() > 0);
        
        assertTrue("Tulosteessasi pitäisi olla teksti \"Lukujen summa:\", nyt ei ollut. Tulosteesi oli: "+out,
                   out.contains("ukujen summa"));

        String summaMjono = out.substring(out.indexOf("summa") + "summa".length());

        int summa = ekaLuku + tokaLuku + kolmasLuku;
        assertTrue("Laskun " + ekaLuku + " + " + tokaLuku + " + "  + kolmasLuku + " summan pitäisi olla " + summa + ", ehdotit: " + summaMjono, summaMjono.contains("" + summa));
    }
}
