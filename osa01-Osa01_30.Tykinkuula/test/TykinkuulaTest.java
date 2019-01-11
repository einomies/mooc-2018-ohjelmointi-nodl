
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.ReflectionUtils;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

@Points("01-30")
public class TykinkuulaTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    public void esimerkki1Suurinkorkeus() {
        String syote = "42.0\n9.81\n";
        List<String> rivit = annaRivit(syote);

        assertTrue("Odotettiin tulostusta \"Tykinkuulan suurin korkeus oli 111.\" kun syöte on:\n" + syote + "Nyt tulostus oli " + tulostus(rivit), rivit.stream().anyMatch(rivi -> rivi.contains("suurin") && rivi.contains("111.")));
        assertFalse("Odotettiin tulostusta \"Tykinkuulan suurin korkeus oli 111.\" kun syöte on:\n" + syote + "Nyt tulostus oli " + tulostus(rivit), rivit.stream().anyMatch(rivi -> rivi.contains("suurin") && rivi.contains("40.")));
    }

    @Test
    public void esimerkki2Suurinkorkeus() {
        String syote = "15\n3.5\n";
        List<String> rivit = annaRivit(syote);

        assertTrue("Odotettiin tulostusta \"Tykinkuulan suurin korkeus oli 40.0\" kun syöte on:\n" + syote + "Nyt tulostus oli " + tulostus(rivit), rivit.stream().anyMatch(rivi -> rivi.contains("suurin") && rivi.contains("40.")));
        assertFalse("Odotettiin tulostusta \"Tykinkuulan suurin korkeus oli 40.0\" kun syöte on:\n" + syote + "Nyt tulostus oli " + tulostus(rivit), rivit.stream().anyMatch(rivi -> rivi.contains("suurin") && rivi.contains("111.")));
    }

    @Test
    public void onSekuntikohtaisetTulostukset() {
        String syote = "15\n3.5\n";
        List<String> rivit = annaRivit(syote);

        for (int luku = 0; luku < 9; luku++) {
            final int i = luku;
            assertTrue("Odotettiin sekuntikohtaista tykinkuulan korkeuden tulostusta.\nRivi sekunnille " + i + " puuttui kun syöte on:\n" + syote + "Nyt tulostus oli " + tulostus(rivit), rivit.stream().anyMatch(rivi -> rivi.trim().startsWith("" + i)));
        }

        assertFalse("Sekuntikohtaisen tulostuksen pitäisi tulostaa vain ne rivit, missä tykinkuula on ilmassa.\nRivi sekunnille 10 on turha kun syöte on:\n" + syote + "Nyt tulostus oli " + tulostus(rivit), rivit.stream().anyMatch(rivi -> rivi.trim().startsWith("" + 10)));
    }

    @Test
    public void tulostusSekunninKohdallaOk() {
        String syote = "15\n3.5\n";
        List<String> rivit = annaRivit(syote);

        assertTrue("Odotettiin että ensimmäiselle sekunnille korkeus on 15.0 ja nopeus 11.5 kun syöte on:\n" + syote + "Nyt tulostus oli " + tulostus(rivit), rivit.stream().anyMatch(rivi -> rivi.trim().startsWith("1") && rivi.contains("15.0") && rivi.contains("11.5")));
    }

    private String tulostus(List<String> rivit) {
        return rivit.stream().reduce("", (a, b) -> a + "\n" + b);
    }

    public List<String> annaRivit(String syote) {
        int oldOut = io.getSysOut().length();
        io.setSysIn(syote);
        callMain(Tykinkuula.class);
        String out = io.getSysOut().substring(oldOut);

        assertTrue("Et tulosta mitään!", out.length() > 0);

        return Arrays.asList(out.split("\n"));
    }

    private void callMain(Class kl) {
        try {
            kl = ReflectionUtils.newInstanceOfClass(kl);
            String[] t = null;
            String x[] = new String[0];
            Method m = ReflectionUtils.requireMethod(kl, "main", x.getClass());
            ReflectionUtils.invokeMethod(Void.TYPE, m, null, (Object) x);
        } catch (Throwable e) {
            fail("Jotain kummallista tapahtui. Saattaa olla että " + kl + "-luokan public static void main(String[] args) -metodi on hävinnyt\n"
                    + "tai ohjelmasi kaatui poikkeukseen. Lisätietoja " + e);
        }
    }
}
