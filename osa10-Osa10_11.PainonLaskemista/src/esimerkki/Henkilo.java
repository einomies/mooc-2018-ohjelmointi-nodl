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
public class Henkilo {

    private String nimi;
    private int syntymavuosi;

    public Henkilo(String nimi, int syntymavuosi) {
        this.nimi = nimi;
        this.syntymavuosi = syntymavuosi;
    }

    public String getNimi() {
        return this.nimi;
    }

    public int getSyntymavuosi() {
        return this.syntymavuosi;
    }

    public String toString() {
        return this.nimi + " (" + this.syntymavuosi + ")";
    }

}
