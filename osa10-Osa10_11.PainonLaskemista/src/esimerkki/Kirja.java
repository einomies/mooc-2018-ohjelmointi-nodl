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
public class Kirja {

    private Henkilo kirjailija;
    private String nimi;
    private int sivujenLukumaara;

    public Kirja(Henkilo kirjailija, String nimi, int sivuja) {
        this.kirjailija = kirjailija;
        this.nimi = nimi;
        this.sivujenLukumaara = sivuja;
    }

    public Henkilo getKirjailija() {
        return this.kirjailija;
    }

    public String getNimi() {
        return this.nimi;
    }

    public int getSivujenLukumaara() {
        return this.sivujenLukumaara;
    }

    @Override
    public String toString() {
        return "Kirja{" + "kirjailija=" + kirjailija + ", nimi=" + nimi + ", sivujenLukumaara=" + sivujenLukumaara + '}';
    }

}
