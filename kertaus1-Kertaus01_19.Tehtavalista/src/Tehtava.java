/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author einomies
 */
public class Tehtava {
    
    private String kuvaus;
    private boolean onTehty;

    public Tehtava(String kuvaus) {
        this.kuvaus = kuvaus;
        this.onTehty = false;
    }

    void asetaTehdyksi() {
        this.onTehty = true;
    }

    void asetaTekemattomaksi() {
        this.onTehty = false;
    }

    public String getKuvaus() {
        return kuvaus;
    }

    public void setKuvaus(String kuvaus) {
        this.kuvaus = kuvaus;
    }

    public boolean isOnTehty() {
        return onTehty;
    }

    @Override
    public String toString() {
        String onkoTehty;
        if (this.onTehty == true) {
            onkoTehty = "tehty";
        } else {
            onkoTehty = "ei tehty";
        }
        return kuvaus + " (" +onkoTehty +")";
    }
    
}
