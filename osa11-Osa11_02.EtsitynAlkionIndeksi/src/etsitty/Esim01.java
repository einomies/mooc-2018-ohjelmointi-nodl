/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etsitty;

/**
 *
 * @author einomies
 */
public class Esim01 {

    public static void main(String[] args) {

        testi01();
    }

    private static void testi01() {
        int[] luvut = new int[4];
        luvut[0] = 42;
        luvut[1] = 13;
        luvut[2] = 12;
        luvut[3] = 7;

        System.out.println("Taulukossa on " + luvut.length + " alkiota.");

        int indeksi = 0;
        while (indeksi < luvut.length) {
            System.out.println(luvut[indeksi]);
            indeksi++;
        }
        /*
        Taulukossa on 4 alkiota.
        42
        13
        12
        7
         */
    }

}
