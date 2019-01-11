package pong;

import pong.ai.PongAi;
import javafx.geometry.Point2D;

public class Pong {

    public static int MAILAN_LEVEYS = 6;
    public static int MAILAN_KORKEUS = 60;

    private int leveys;
    private int korkeus;

    private Maila pelaajanYksiMaila;
    private Maila pelaajanKaksiMaila;
    private Pallo pallo;

    private PongAi pelaajanYksiTekoaly;
    private PongAi pelaajanKaksiTekoaly;

    private int pelaajanYksiPisteet;
    private int pelaajanKaksiPisteet;

    public Pong(int leveys, int korkeus, PongAi pelaajanYksiAly, PongAi pelaajanKaksiAly) {
        this.leveys = leveys;
        this.korkeus = korkeus;

        this.pelaajanYksiMaila = new Maila(0, korkeus / 2, MAILAN_KORKEUS, MAILAN_LEVEYS);
        this.pelaajanKaksiMaila = new Maila(leveys - MAILAN_LEVEYS, korkeus / 2, MAILAN_KORKEUS, MAILAN_LEVEYS);

        this.pallo = new Pallo(leveys / 2, korkeus / 2);
        this.pallo.alkupisteeseen();

        this.pelaajanYksiTekoaly = pelaajanYksiAly;
        this.pelaajanKaksiTekoaly = pelaajanKaksiAly;

        this.pelaajanYksiPisteet = 0;
        this.pelaajanKaksiPisteet = 0;
    }

    public Maila getPelaajanYksiMaila() {
        return pelaajanYksiMaila;
    }

    public Maila getPelaajanKaksiMaila() {
        return pelaajanKaksiMaila;
    }

    public Pallo getPallo() {
        return pallo;
    }

    public void liikuta() {

        Suunta pelaajanYksiSuunta = pelaajanYksiTekoaly.annaSuunta(pelaajanYksiMaila.kopio(), pelaajanKaksiMaila.kopio(), pallo.kopio());
        Suunta pelaajanKaksiSuunta = pelaajanKaksiTekoaly.annaSuunta(pelaajanKaksiMaila.kopio(), pelaajanYksiMaila.kopio(), pallo.kopio());

        pelaajanYksiMaila.siirra(pelaajanYksiSuunta);
        pelaajanKaksiMaila.siirra(pelaajanKaksiSuunta);

        pallo.liikuta();

        kasitteleMailojenJaPallonTormaykset();

        kasitteleYlaJaAlalaita();

        kasitteleMaalit();

    }

    private void kasitteleMaalit() {
        // osutaanko vasempaan laitaan
        if (pallo.getTranslateX() < 0 + pallo.getRadiusX()) {
            pallo.setLiike(new Point2D(-1 * pallo.getLiike().getX(), pallo.getLiike().getY()));
            pallo.nopeuta();
            pelaajanKaksiPisteet++;

            pallo.alkupisteeseen();
        }

        // osutaanko oikeaan laitaan
        if (pallo.getTranslateX() > leveys - pallo.getRadiusX()) {
            pallo.setLiike(new Point2D(-1 * pallo.getLiike().getX(), pallo.getLiike().getY()));
            pallo.nopeuta();
            pelaajanYksiPisteet++;

            pallo.alkupisteeseen();
        }
    }

    private void kasitteleYlaJaAlalaita() {
        // kimmotaan ylä- ja alalaidasta
        if (pallo.getTranslateY() < 0 + pallo.getRadiusY()) {
            pallo.setLiike(new Point2D(pallo.getLiike().getX(), -1 * pallo.getLiike().getY()));
            // siirretään takaisin pelialueelle tarvittaessa
            while (pallo.getTranslateY() < pallo.getRadiusY()) {
                pallo.setTranslateY(pallo.getTranslateY() + 0.1);
            }
        }

        if (pallo.getTranslateY() > korkeus - pallo.getRadiusY()) {
            pallo.setLiike(new Point2D(pallo.getLiike().getX(), -1 * pallo.getLiike().getY()));

            // siirretään takaisin pelialueelle mikäli tarvis
            while (pallo.getTranslateY() > korkeus - pallo.getRadiusY()) {
                pallo.setTranslateY(pallo.getTranslateY() - 0.1);
            }
        }
    }

    private void kasitteleMailojenJaPallonTormaykset() {
        if (pallo.tormaa(pelaajanYksiMaila)) {
            kimpoa(pelaajanYksiMaila);

            // siirretään takaisin pelialueelle tarvittaessa
            while (pallo.getTranslateX() > leveys - pallo.getRadiusX()) {
                pallo.setTranslateX(pallo.getTranslateX() - 0.1);
            }
        }

        if (pallo.tormaa(pelaajanKaksiMaila)) {
            kimpoa(pelaajanKaksiMaila);

            // siirretään takaisin pelialueelle tarvittaessa
            while (pallo.getTranslateX() < 0 + pallo.getRadiusX()) {
                pallo.setTranslateX(pallo.getTranslateX() + 0.1);
            }
        }
    }

    private void kimpoa(Maila maila) {
        double rnd1 = Math.random() / 10 - 0.05;
        double rnd2 = Math.random() / 10 - 0.05;

        double nopeus = pallo.getLiike().magnitude();

        double liikeX = rnd1 + (pallo.getLiike().getX() * -1);
        double liikeY = rnd2 + (pallo.getLiike().getY());

        pallo.setLiike(new Point2D(liikeX, liikeY).normalize().multiply(nopeus));

//        double angle = Math.atan(pallo.getLiike().getY() / pallo.getLiike().getX());
//        System.out.println(angle);
    }

    public Double tormayskohta(Maila maila, Pallo pallo) {
        double pallonKeskikohta = pallo.getTranslateY() - pallo.getSade();
        double mailanKeskikohta = maila.getTranslateY() + MAILAN_KORKEUS / 2;
        return (mailanKeskikohta - pallonKeskikohta) / (MAILAN_KORKEUS / 2);
    }

    public int getPelaajanYksiPisteet() {
        return pelaajanYksiPisteet;
    }

    public int getPelaajanKaksiPisteet() {
        return pelaajanKaksiPisteet;
    }

}
