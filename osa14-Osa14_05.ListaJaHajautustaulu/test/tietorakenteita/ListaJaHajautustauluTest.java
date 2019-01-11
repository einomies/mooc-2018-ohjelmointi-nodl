package tietorakenteita;

import fi.helsinki.cs.tmc.edutestutils.Points;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ListaJaHajautustauluTest {

    @Test
    @Points("14-13.1")
    public void osa1() {
        assertTrue(Ohjelma.osiaToteutettu() >= 1);
    }

    @Test
    @Points("14-13.2")
    public void osa2() {
        assertTrue(Ohjelma.osiaToteutettu() >= 2);
    }

//    @Test
    @Points("14-13.3")
    public void osa3() {
        assertTrue(Ohjelma.osiaToteutettu() >= 3);
    }
}
