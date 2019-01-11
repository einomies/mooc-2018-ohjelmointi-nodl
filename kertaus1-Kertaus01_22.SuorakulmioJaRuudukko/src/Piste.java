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

    private int x;
    private int y;
    
    public Piste (int x, int y) {
        this.x = x;
        this.y = y;
    }

//    public double etaisyys(Piste toinen) {
//        double x2 = Math.pow((this.getX() - toinen.getX()), 2);
//        double y2 = Math.pow((this.getY() - toinen.getY()), 2);
//        double hypo = Math.sqrt(x2+y2);
//        return hypo;
//    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Piste{" + "x=" + x + ", y=" + y + '}';
    }

}
