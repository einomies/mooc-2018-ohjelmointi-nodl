
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.ReflectionUtils;
import static org.junit.Assert.assertTrue;
import org.junit.Rule;
import org.junit.Test;

@Points("01-11")
public class SyotetynLuvunTulostajaTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    public void test1() {
        toimii("1");
    }

    @Test
    public void test2() {
        toimii("2");
    }

    @Test
    public void test3() {
        toimii("4242");
    }

    @Test
    public void test4() {
        toimii("2344524");
    }

    @Test
    public void test5() {
        toimii("-123");
    }

    private void toimii(String syote) {
        ReflectionUtils.newInstanceOfClass(SyotetynLuvunTulostajaTest.class);
        io.setSysIn(syote + "\n");
        SyotetynLuvunTulostaja.main(new String[0]);

        String out = io.getSysOut();

        assertTrue("Et kysynyt käyttäjältä mitään!", out.trim().length() > 0);

        assertTrue("Kun syöte on \"" + syote + "\" pitäisi tulostuksessa olla teksti \"Syötit: " + syote + "\", nyt ei ollut. Tulosteesi oli:\n" + out,
                out.contains("tit: " + syote));
        
    }
}
