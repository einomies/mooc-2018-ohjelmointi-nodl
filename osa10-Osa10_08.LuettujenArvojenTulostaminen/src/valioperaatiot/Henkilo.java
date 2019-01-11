/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package valioperaatiot;

/**
 *
 * @author einomies
 */
public class Henkilo {

    private String etunimi;
    private String sukunimi;
    private int syntymavuosi;

    public Henkilo(String etunimi, String sukunimi, int syntymavuosi) {
        this.etunimi = etunimi;
        this.sukunimi = sukunimi;
        this.syntymavuosi = syntymavuosi;
    }

    public String getEtunimi() {
        return this.etunimi;
    }

    public String getSukunimi() {
        return this.sukunimi;
    }

    public int getSyntymavuosi() {
        return this.syntymavuosi;
    }
}
