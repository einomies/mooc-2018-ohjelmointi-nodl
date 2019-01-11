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
public enum Vari {
    // konstruktorin parametrit määritellään vakioarvoja lueteltaessa
    PUNAINEN("#FF0000"),
    VIHREA("#00FF00"),
    SININEN("#0000FF");

    private String koodi;        // oliomuuttuja

    private Vari(String koodi) { // konstruktori
        this.koodi = koodi;
    }

    public String getKoodi() {
        return this.koodi;
    }

}
