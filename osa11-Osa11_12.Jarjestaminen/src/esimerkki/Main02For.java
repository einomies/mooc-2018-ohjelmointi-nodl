/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esimerkki;

import java.util.Arrays;

/**
 *
 * @author einomies
 */
public class Main02For {

    public static void main(String[] args) {
        testi01();
    }

    private static void testi01() {
        int rivit = 2;
        int sarakkeet = 3;
        int[][] kaksiulotteinenTaulukko = new int[rivit][sarakkeet];

        kaksiulotteinenTaulukko[0][1] = 4;
        kaksiulotteinenTaulukko[1][1] = 1;
        kaksiulotteinenTaulukko[1][0] = 8;
        /*
        taulukko
        [
        [0, 4, 0],
        [8, 1, 0]
        ]
        */

        for (int y = 0; y < kaksiulotteinenTaulukko.length; y++) {
            for (int x = 0; x < kaksiulotteinenTaulukko[y].length; x++) {
                int arvo = kaksiulotteinenTaulukko[y][x];
                System.out.println("arvo kohdassa (" + x + ", " + y + "): " + arvo);
            }
        }
        /*
        arvo kohdassa (0, 0): 0
        arvo kohdassa (1, 0): 4
        arvo kohdassa (2, 0): 0
        arvo kohdassa (0, 1): 8
        arvo kohdassa (1, 1): 1
        arvo kohdassa (2, 1): 0
        */
    }

}
