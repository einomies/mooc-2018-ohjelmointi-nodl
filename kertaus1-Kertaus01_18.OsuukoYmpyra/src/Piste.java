/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author einomies
 */
public class Piste {

    private double x;
    private double y;
    
    public Piste (double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double etaisyys(Piste toinen) {
        double x2 = Math.pow((this.getX() - toinen.getX()), 2);
        double y2 = Math.pow((this.getY() - toinen.getY()), 2);
        double hypo = Math.sqrt(x2+y2);
        return hypo;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }
    
    @Override
    public String toString() {
        return "Piste{" + "x=" + x + ", y=" + y + '}';
    }

}
