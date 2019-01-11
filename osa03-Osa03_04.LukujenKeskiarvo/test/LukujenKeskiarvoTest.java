
import fi.helsinki.cs.tmc.edutestutils.Points;
import org.junit.*;
import static org.junit.Assert.*;
import static org.powermock.api.easymock.PowerMock.*;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.rule.PowerMockRule;

@Points("03-04")
@PrepareForTest(LukujenKeskiarvo.class)
//@RunWith(PowerMockRunner.class)
public class LukujenKeskiarvoTest {

    @Rule
    public PowerMockRule p = new PowerMockRule();

    @Test
    public void onkoAloittanut() {
        double tulos = LukujenKeskiarvo.keskiarvo(1, 1, 1, 1);
        assertFalse("Palautat -1, palautat mallissa olevan vastauksen. luvuilla 1, 1, 1, ja 1  keskiarvo on 1",
                -1 == tulos);
    }

    @Test
    public void onkoKeskiarvoOikein1() {
        assertEquals("Keskiarvo ei ole oikein luvuilla -12, 2, 8 ja 0, Onkohan kyseessä Int-muuttujilla jako?",
                -0.5, LukujenKeskiarvo.keskiarvo(-12, 2, 8, 0), 0.0001);
    }

    @Test
    public void onkoKeskiarvoOikein2() {
        assertEquals("Keskiarvo ei ole oikein luvuilla 1, 2, 3 ja 4, Onkohan kyseessä Int-muuttujilla jako?",
                2.5, LukujenKeskiarvo.keskiarvo(1, 2, 3, 4), 0.0001);
    }

    @Test
    public void testaaApumetodinKaytto() {
        mockStaticPartial(LukujenKeskiarvo.class, "summa");
        reset(LukujenKeskiarvo.class);

        LukujenKeskiarvo.summa(1, 2, 3, 4);
        expectLastCall().andReturn(10);

        replay(LukujenKeskiarvo.class);

        try {
            LukujenKeskiarvo.keskiarvo(1, 2, 3, 4);
            verifyAll();
        } catch (AssertionError e) {
            fail("metodin keskiarvo tulee laskea parametrinaan saamansa lukujen "
                    + "summa metodin summa avulla\n"
                    + "keskiarvo-metodin tulee kutsua summa-metodia vain kertaalleen!"
                    + "Kun kutsuttiin keskiarvo(1,2,3,4) " + e);
        }

    }

    public void testaaApumetodinKaytto2() {
        mockStaticPartial(LukujenKeskiarvo.class, "summa");
        reset(LukujenKeskiarvo.class);

        LukujenKeskiarvo.summa(4, 2, 3, 7);
        expectLastCall().andReturn(16);

        replay(LukujenKeskiarvo.class);

        try {
            LukujenKeskiarvo.keskiarvo(4, 2, 3, 7);
            verifyAll();
        } catch (AssertionError e) {
            fail("metodin keskiarvo tulee laskea parametrinaan saamansa lukujen "
                    + "summa metodin summa avulla\n"
                    + "Kun kutsuttiin keskiarvo(4,2,3,7) " + e);
        }

    }
}
