/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sovellus;

import java.util.Random;

/**
 *
 * @author einomies
 */
public class ViimeisimmatLuvutTesti {

    public static void main(String[] args) {

        final int lkmMax = 100;
        Random arpoja = new Random();
        int arvotLuvutLkm = 0;

        int[] viimeisimmat = new int[10];
        String viimeisimmatString = "";

        for (int i = 0; i < lkmMax; i++) {
            int luku = arpoja.nextInt(6) + 1;
            arvotLuvutLkm++;
            System.out.println("arvottu luku: " + luku);

            for (int j = viimeisimmat.length - 2; j >= 0; j--) {
                viimeisimmat[j + 1] = viimeisimmat[j];
            }
            viimeisimmat[0] = luku;

            viimeisimmatString = "";

            for (int k = 0; k < viimeisimmat.length; k++) {
                if (k < viimeisimmat.length - 1) {
                    viimeisimmatString += viimeisimmat[k] + ", ";
                } else {
                    viimeisimmatString += viimeisimmat[k];
                }
            }
            System.out.println("viimeisimmatString: " + viimeisimmatString);
        }
    }

}
