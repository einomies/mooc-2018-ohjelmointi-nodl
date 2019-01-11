/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author einomies
 */
public class Ympyra {

    /*
    Muuttuja x kuvaa ympyrän keskipisteen x-koordinaattia, muuttuja y ympyrän keskipisteen
    y-koordinaattia sekä sade ympyrän sädettä.
    
    Toteuta tämän jälkeen metodi public boolean osuuko(Ympyra toinen), joka palauttaa true
    jos ympyrä osuu toiseen ympyrään.
    
    Edellisestä tehtävästä on tässä hyötyä.
    */
    private double x;
    private double y;
    private double sade;
    
    public Ympyra(double x, double y, double sade) {
        this.x = x;
        this.y = y;
        this.sade = sade;
    }

    public boolean osuuko(Ympyra toinen) {
        Piste keskipiste1 = new Piste(this.getX(), this.getY());
        Piste keskipiste2 = new Piste(toinen.getX(), toinen.getY());
        double keskipisteidenEtaisyys = keskipiste1.etaisyys(keskipiste2);
        
        if ((this.sade + toinen.sade) > keskipisteidenEtaisyys) {
            return true;
        }
        return false;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getSade() {
        return sade;
    }

    public void setSade(double sade) {
        this.sade = sade;
    }

    @Override
    public String toString() {
        return "Ympyra{" + "x=" + x + ", y=" + y + ", sade=" + sade + '}';
    }

}
