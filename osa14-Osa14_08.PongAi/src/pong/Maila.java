package pong;

import javafx.scene.shape.Polygon;

public class Maila extends Polygon {

    private int mailanKorkeus;
    private int mailanLeveys;

    public Maila(int x, int y, int mailanKorkeus, int mailanLeveys) {
        super(0, 0,
                mailanLeveys, 0,
                mailanLeveys, mailanKorkeus,
                0, mailanKorkeus);

        setTranslateX(x);
        setTranslateY(y);

        this.mailanKorkeus = mailanKorkeus;
        this.mailanLeveys = mailanLeveys;
    }

    public void siirra(Suunta suunta) {
        if (suunta == null || Suunta.PAIKALLAAN.equals(suunta)) {
            return;
        }

        if (Suunta.YLOS.equals(suunta)) {
            this.setTranslateY(this.getTranslateY() - 1);
        }

        if (Suunta.ALAS.equals(suunta)) {
            this.setTranslateY(this.getTranslateY() + 1);
        }
    }

    public Maila kopio() {
        return new Maila((int) this.getTranslateX(), (int) this.getTranslateY(), mailanKorkeus, mailanLeveys);
    }
}
