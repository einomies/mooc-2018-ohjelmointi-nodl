/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author einomies
 */
public class Kirja {
    
    private String kirjailija;
    private String nimi;
    private int sivuja;
    
    public Kirja(String kirjailija, String nimi, int sivuja) {
        this.kirjailija = kirjailija;
        this.nimi = nimi;
        this.sivuja = sivuja;
    }

    public String getKirjailija() {
        return kirjailija;
    }

    public void setKirjailija(String kirjailija) {
        this.kirjailija = kirjailija;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public int getSivuja() {
        return sivuja;
    }

    public void setSivuja(int sivuja) {
        this.sivuja = sivuja;
    }
    
    public String toString() {
        return this.kirjailija +", " +this.nimi +", " +this.sivuja +" sivua";
    }
}
