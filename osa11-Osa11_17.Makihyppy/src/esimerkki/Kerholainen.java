/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esimerkki;

/**
 *
 * @author einomies
 */
public class Kerholainen implements Comparable<Kerholainen> {

    private String nimi;
    private int pituus;

    public Kerholainen(String nimi, int pituus) {
        this.nimi = nimi;
        this.pituus = pituus;
    }

    public String getNimi() {
        return this.nimi;
    }

    public int getPituus() {
        return this.pituus;
    }

    @Override
    public String toString() {
        return this.getNimi() + " (" + this.getPituus() + ")";
    }

    @Override
    public int compareTo(Kerholainen kerholainen) {
        if (this.pituus == kerholainen.getPituus()) {
            return 0;
        } else if (this.pituus > kerholainen.getPituus()) {
            return 1;
        } else {
            return -1;
        }
    }
    /**
     * Rajapinnan vaatima metodi compareTo palauttaa kokonaisluvun, joka kertoo 
     * vertausjärjestyksestä. Koska compareTo()-metodista riittää palauttaa 
     * negatiivinen luku, jos this-olio on pienempi kuin parametrina annettu olio 
     * ja nolla, kun pituudet ovat samat, voidaan edellä esitelty metodi compareTo 
     * toteuttaa myös seuraavasti.
     * 
     * @Override
     * public int compareTo(Kerholainen kerholainen) {
     *      return this.pituus - kerholainen.getPituus();
     * }
     */

}
