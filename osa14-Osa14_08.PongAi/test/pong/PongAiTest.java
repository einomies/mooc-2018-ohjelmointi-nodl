package pong;

import pong.ai.MunPongAly;
import pong.ai.FollowingPongAi;
import fi.helsinki.cs.tmc.edutestutils.Points;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

@Points("14-08")
public class PongAiTest {

    @Test(timeout = 10000)
    public void voittaaSeuraajanKunPelaajanaYksi() {
        Pong p = new Pong(640, 480, new MunPongAly(), new FollowingPongAi());
        for (int i = 0; i < 25000; i++) {
            p.liikuta();
        }

        int pelaajanPisteet = p.getPelaajanYksiPisteet();
        int tekoalynPisteet = p.getPelaajanKaksiPisteet();

        assertTrue(pelaajanPisteet > tekoalynPisteet);
    }

    @Test(timeout = 10000)
    public void voittaaSeuraajanKunPelaajanaKaksi() {
        Pong p = new Pong(640, 480, new FollowingPongAi(), new MunPongAly());
        for (int i = 0; i < 25000; i++) {
            p.liikuta();
        }

        int tekoalynPisteet = p.getPelaajanYksiPisteet();
        int pelaajanPisteet = p.getPelaajanKaksiPisteet();

        assertTrue(pelaajanPisteet > tekoalynPisteet);
    }
}
