/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author einomies
 */
public class Harjoitusapuri {
    
    private int ika;
    private int leposyke;
    
    public Harjoitusapuri(int ika, int leposyke) {
        this.ika = ika;
        this.leposyke = leposyke;
    }

    public double maksimisyke() {
//      206.3 - (0.711 * ikä)
        return 206.3 - (0.711 * (double)this.ika);
    }
    
    public double tavoitesyke(double prosenttiaMaksimista) {
//     (maksimisyke - leposyke) * (tavoitesykeprosentti) + leposyke
        return (((206.3 - (0.711 * (double)this.ika)) - (double)this.leposyke)) *  prosenttiaMaksimista + (double)this.leposyke;
    }
    /*
    Tässä ehkä selkeämpi tapa laskea tavoitesyke:
    public double tavoitesyke(double prosenttiaMaksimista) {
        double maksimisyke = 206.3 - (0.711 * ika);
        return (maksimisyke - leposyke) * prosenttiaMaksimista + leposyke;
    }
    */
    
    public String toString() {
        return "Ikä=" +this.ika +", leposyke=" +this.leposyke;
    }
}
