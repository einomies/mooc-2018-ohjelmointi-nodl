package pong;

import javafx.geometry.Point2D;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Shape;

public class Pallo extends Ellipse {

    static final int SADE = 6;
    private Point2D liike;

    private int alkuX;
    private int alkuY;

    public Pallo(int x, int y) {
        super(0, 0, SADE, SADE);
        this.alkuX = x;
        this.alkuY = y;
    }

    public Pallo(int x, int y, int nykyinenX, int nykyinenY) {
        this(x, y);

        this.setTranslateX(nykyinenX);
        this.setTranslateY(nykyinenY);
    }

    public void alkupisteeseen() {
        this.setTranslateX(this.alkuX);
        this.setTranslateY(this.alkuY);

        double p = Math.random();
        double yllatys = Math.random() - 0.5;

        if (p < 0.25) {
            this.liike = new Point2D(1.5 + yllatys, 1.5 + yllatys);
        } else if (p < 0.5) {
            this.liike = new Point2D(-1.5 + yllatys, 1.5 + yllatys);
        } else if (p < 0.75) {
            this.liike = new Point2D(1.5 + yllatys, -1.5 + yllatys);
        } else {
            this.liike = new Point2D(-1.5 + yllatys, -1.5 + yllatys);
        }
    }

    public void liikuta() {
        this.setTranslateX(this.getTranslateX() + this.liike.getX());
        this.setTranslateY(this.getTranslateY() + this.liike.getY());
    }

    public boolean tormaa(Maila maila) {
        Shape tormaysalue = Shape.intersect(this, maila);
        return tormaysalue.getBoundsInLocal().getWidth() != -1;
    }

    public Point2D getLiike() {
        return liike;
    }

    public int getSade() {
        return SADE;
    }

    public void setLiike(Point2D liike) {
        this.liike = liike;
    }

    public void nopeuta() {
        this.liike = this.liike.multiply(1.05);
    }

    public Pallo kopio() {
        Pallo p = new Pallo(this.alkuX, this.alkuY, (int) getTranslateX(), (int) getTranslateY());
        p.liike = new Point2D(this.liike.getX(), this.liike.getY());
        return p;
    }

}
