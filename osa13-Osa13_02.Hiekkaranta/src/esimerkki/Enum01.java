/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esimerkki;

import hiekkaranta.Tyyppi;

/**
 *
 * @author einomies
 */
public class Enum01 {

    public static void main(String[] args) {

        Tyyppi t = Tyyppi.TYHJA;
        if (t == Tyyppi.TYHJA) {
            System.out.println("Tyhjää täynnä.");
        }
        if (t == Tyyppi.HIEKKA) {
            System.out.println("Hiekalta näyttää.");
        }

        Tyyppi[] taulukko = new Tyyppi[10];
        taulukko[0] = Tyyppi.VESI;
        System.out.println(taulukko.length);
    }

}
