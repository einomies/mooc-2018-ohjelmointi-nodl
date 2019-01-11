package pong.ai;

import pong.Maila;
import pong.Pallo;
import pong.Suunta;

public interface PongAi {

    Suunta annaSuunta(Maila oma, Maila vastustajan, Pallo pallo);
    String nimi();
}
