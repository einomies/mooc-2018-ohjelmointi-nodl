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
public class Testi01 {

    public static void main(String[] args) {
        int[][] taulukko = new int[2][1];

        taulukko[0][0] = 1;
        taulukko[1][0] = 2;
        tulostaTaulukko(taulukko);
        System.out.println();

        taulukko[0][0] = 0;
        taulukko[0][1] = -1;
        tulostaTaulukko(taulukko);
        System.out.println();
    }

    private static void tulostaTaulukko(int[][] taulukko) {
        for (int i = 0; i < taulukko.length; i++) {
            for (int j = 0; j < taulukko[0].length; j++) {
                System.out.println("["+i+"]["+j+"]: " +taulukko[i][j]);
            }
            
        }
    }
    
}
