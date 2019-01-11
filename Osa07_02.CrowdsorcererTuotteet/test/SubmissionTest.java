import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.ReflectionUtils;
import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@Points("01-11")
public class SubmissionTest {

    @Rule
    public MockStdio io = new MockStdio();

    public SubmissionTest() {

    }
    
    @Test
    public void test01() {
        toimii("lisaa\n7\ntuote7\nhae\n7\nlopeta", "tuote7");
    }

    @Test
    public void test02() {
        toimii("lisaa\n7\ntuote7\npoista\n7\nlopeta", "Poistettu.");
    }

    private void toimii(String input, String output) {
        ReflectionUtils.newInstanceOfClass(Submission.class);
        io.setSysIn(input);
        Submission.main(new String[0]);
        String out = io.getSysOut();
        assertTrue("Kun syöte oli '" + input.replaceAll("\\n", "\\\\\\n") + "' tulostus oli: '" + out.replaceAll("\\n", "\\\\\\n") + "', mutta se ei sisältänyt: '" + output.replaceAll("\\n", "\\\\\\n") + "'.", out.contains(output));
    }

}
