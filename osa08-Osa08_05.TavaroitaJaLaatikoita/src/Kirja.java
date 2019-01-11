/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author einomies
 */
public class Kirja implements Talletettava {

    private String tekija;
    private String nimi;
    private double paino;

    public Kirja(String tekija, String nimi, double paino) {
        this.tekija = tekija;
        this.nimi = nimi;
        this.paino = paino;
    }

    @Override
    public double paino() {
        return this.paino;
    }

    @Override
    public String toString() {
        return this.tekija + ": " + this.nimi;
    }

}
/*
public class Kirja implements Talletettava {

    private double paino;
    private String kirjoittaja;
    private String nimi;

    public Kirja(String kirjoittaja, String nimi, double paino) {
        this.paino = paino;
        this.kirjoittaja = kirjoittaja;
        this.nimi = nimi;
    }

    @Override
    public double paino() {
        return this.paino;
    }

    @Override
    public String toString() {
        return this.kirjoittaja + ": " + this.nimi;
    }

}
*/