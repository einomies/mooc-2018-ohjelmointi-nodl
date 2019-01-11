
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.ReflectionUtils;
import java.lang.reflect.Method;
import java.util.NoSuchElementException;
import org.junit.*;
import static org.junit.Assert.*;

public class VarastoTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    @Points("03-19.1")
    public void lopeta() {
        io.setSysIn("lopeta\n");
        callMain(Varasto.class);
    }

    @Test
    @Points("03-19.1")
    public void lisaaJaHae1() {
        String syote = "lisaa\nkukka\nhae\nkukka\nlopeta\n";
        io.setSysIn(syote);
        callMain(Varasto.class);

        assertTrue("Kun syöte on:\n" + syote + "Odotetaan, että tulostuksessa on teksti \"Esine kukka löytyy varastosta\".\nOhjelman tulostus:\n" + io.getSysOut(), io.getSysOut().contains("sine kukka") && io.getSysOut().contains("tyy"));
        assertFalse("Kun syöte on:\n" + syote + "Odotetaan, että tulostuksessa ei esiinny merkkijono \"ei\".\nOhjelman tulostus:\n" + io.getSysOut(), io.getSysOut().contains("ei"));
    }

    @Test
    @Points("03-19.1")
    public void lisaaJaHae2() {
        String syote = "lisaa\nnakki\nhae\nnakki\nlopeta\n";
        io.setSysIn(syote);
        callMain(Varasto.class);

        assertTrue("Kun syöte on:\n" + syote + "Odotetaan, että tulostuksessa on teksti \"Esine nakki löytyy varastosta\".\nOhjelman tulostus:\n" + io.getSysOut(), io.getSysOut().contains("sine nakki") && io.getSysOut().contains("tyy"));
        assertFalse("Kun syöte on:\n" + syote + "Odotetaan, että tulostuksessa ei esiinny merkkijono \"ei\".\nOhjelman tulostus:\n" + io.getSysOut(), io.getSysOut().contains("ei"));
    }

    @Test
    @Points("03-19.2")
    public void lisaaJaPoistaJaHae1() {
        String syote = "lisaa\nkukka\npoista\nnakki\nhae\nkukka\nlopeta\n";
        io.setSysIn(syote);
        callMain(Varasto.class);

        assertTrue("Kun syöte on:\n" + syote + "Odotetaan, että tulostuksessa on teksti \"Esine kukka löytyy varastosta\".\nOhjelman tulostus:\n" + io.getSysOut(), io.getSysOut().contains("sine kukka") && io.getSysOut().contains("tyy"));
        assertFalse("Kun syöte on:\n" + syote + "Odotetaan, että tulostuksessa ei esiinny merkkijono \"ei\".\nOhjelman tulostus:\n" + io.getSysOut(), io.getSysOut().contains("ei"));
    }

    @Test
    @Points("03-19.2")
    public void lisaaJaPoistaJaHae2() {
        String syote = "lisaa\nnakki\npoista\nnakki\nhae\nnakki\nlopeta\n";
        io.setSysIn(syote);
        callMain(Varasto.class);

        assertFalse("Kun syöte on:\n" + syote + "Odotetaan, että tulostuksessa on teksti \"Esine nakki löytyy varastosta\".\nOhjelman tulostus:\n" + io.getSysOut(), io.getSysOut().contains("sine nakki") && io.getSysOut().contains("tyy"));
        assertTrue("Kun syöte on:\n" + syote + "Odotetaan, että tulostuksessa ei esiinny merkkijono \"ei\".\nOhjelman tulostus:\n" + io.getSysOut(), io.getSysOut().contains("ei"));
    }

    private void callMain(Class kl) {
        try {
            kl = ReflectionUtils.newInstanceOfClass(kl);
            String x[] = new String[0];
            Method m = ReflectionUtils.requireMethod(kl, "main", x.getClass());
            ReflectionUtils.invokeMethod(Void.TYPE, m, null, (Object) x);
        } catch (NoSuchElementException e) {
            fail("Varmista että kysely lopetetaan kun käyttäjä syöttää merkkijonon lopeta.");
        } catch (Throwable e) {
            fail(kl + "-luokan public static void main(String[] args) -metodi on hävinnyt!");
        }
    }
}
