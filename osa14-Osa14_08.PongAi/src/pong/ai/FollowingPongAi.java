package pong.ai;

import pong.Maila;
import pong.Pallo;
import pong.Pong;
import pong.Suunta;

public class FollowingPongAi implements PongAi {

    @Override
    public Suunta annaSuunta(Maila oma, Maila vastustajan, Pallo pallo) {
        if (oma.getTranslateY() + Pong.MAILAN_KORKEUS / 2 > pallo.getTranslateY()) {
            return Suunta.YLOS;
        } else {
            return Suunta.ALAS;
        }
    }

    @Override
    public String nimi() {
        return "Lassie";
    }

}
