
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.Reflex;
import org.junit.Test;

@Points("02-22")
public class JakolaskuTest {

    @Test
    public void testMetodinOlemassaolo() {
        Reflex.reflect(Jakolasku.class).staticMethod("jakolasku").returningVoid().taking(int.class, int.class).requirePublic();
    }
}
