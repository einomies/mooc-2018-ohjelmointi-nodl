/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author einomies
 */
public class Suorakulmio {

    private int x;
    private int y;
    private int leveys;
    private int korkeus;

    Suorakulmio(int x, int y, int leveys, int korkeus) {
        this.x = x;
        this.y = y;
        this.leveys = leveys;
        this.korkeus = korkeus;
    }

    public Piste maxPiste() {
        return new Piste(this.x + this.leveys, this.y + this.korkeus);
    }
    
    public boolean pisteAlueella(Piste piste) {
    	if (piste.getX() >= this.x && piste.getX() < (this.x + this.leveys)) {
    		if (piste.getY() >= this.y && piste.getY() < (this.y + this.korkeus)) {
    			return true;
    		}
    	}
    	return false;
    }

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

    public int getLeveys() {
        return leveys;
    }

    public void setLeveys(int leveys) {
        this.leveys = leveys;
    }

    public int getKorkeus() {
        return korkeus;
    }

    public void setKorkeus(int korkeus) {
        this.korkeus = korkeus;
    }
    
    public void tulosta() {
        String rivi="";
        for (int k = this.x; k < this.x + this.korkeus; k++) {
            for (int l = this.y; l < this.y + this.leveys; l++) {
            }
        }
    }

    @Override
    public String toString() {
        return "Suorakulmio{" + "x=" + x + ", y=" + y + ", leveys=" + leveys + ", korkeus=" + korkeus + '}';
    }

}
