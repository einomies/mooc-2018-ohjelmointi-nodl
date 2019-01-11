package testausta;

import java.util.Scanner;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class OhjelmaTest {

    Scanner scanner = new Scanner("");

    @Test
    public void testi01() {
        assertEquals("Pulloja: 6\n" + "Oppilaita: 3\n" + "Keskiarvo: 2.0",
                Ohjelma.suorita(new Scanner("3\n2\n1\n-1\n")));
    }

    @Test
    public void testi02() {
        assertEquals("Pulloja: 1\n" + "Oppilaita: 2\n" + "Keskiarvo: 0.5",
                Ohjelma.suorita(new Scanner("1\n0\n-55\n-1\n")));
    }

    @Test
    public void testi03() {
        assertEquals("Pulloja: 0\n" + "Oppilaita: 0\n" + "Keskiarvoa ei voida laskea",
                Ohjelma.suorita(new Scanner("-55\n-1\n")));
    }

    @Test
    public void testi04() {
        assertEquals("Pulloja: 0\n" + "Oppilaita: 0\n" + "Keskiarvoa ei voida laskea",
                Ohjelma.suorita(new Scanner("-1\n")));
    }

    @Test
    public void testi05() {
        assertEquals("Pulloja: 35\n" + "Oppilaita: 5\n" + "Keskiarvo: 7.0",
                Ohjelma.suorita(new Scanner("5\n6\n7\n-11\n8\njoku_luku\n9\n-1\n1\n2\n-99\n3\n")));
    }

    @Test
    public void testi99() {
        assertEquals("No mitäs mitäs?", Ohjelma.mitasMitas("asdfasdfasd"));
    }

}
