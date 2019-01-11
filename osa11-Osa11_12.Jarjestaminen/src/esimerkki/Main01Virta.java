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
public class Main01Virta {

    public static void main(String[] args) {
//        testi01();
//        testi02();
//        testi03();
        testi04();
    }

    private static void testi04() {
        int rivit = 2;
        int sarakkeet = 3;
        int[][] kaksiulotteinenTaulukko = new int[rivit][sarakkeet];
        
        kaksiulotteinenTaulukko[0][1] = 4;
        kaksiulotteinenTaulukko[1][1] = 1;
        kaksiulotteinenTaulukko[1][0] = 8;
        
        for (int y = 0; y < kaksiulotteinenTaulukko.length; y++) {
            for (int x = 0; x < kaksiulotteinenTaulukko[y].length; x++) {
                int arvo = kaksiulotteinenTaulukko[y][x];
                System.out.println("arvo kohdassa (" + x + ", " + y + "): " + arvo);
            }
        }   }

    private static void testi01() {
        int[] luvut = {1, 8, 10, 3, 5};
        Arrays.stream(luvut).forEach(luku -> System.out.println(luku));
        /*
        1
        8
        10
        3
        5
         */
    }

    private static void testi02() {
        int[] luvut = {1, 8, 10, 3, 5};
        Arrays.stream(luvut)
                .filter(luku -> luku <= 5)
                .forEach(luku -> System.out.println(luku));
        /*
        1
        3
        5
         */
    }

    private static void testi03() {
        /*
        Sama onnistuu myös kaksi- ja useampiulotteisessa taulukossa. Tällöin ensimmäinen
        stream-kutsu luo yksiulotteisia taulukoita sisältävän syötevirran. Jokainen
        yksiulotteinen taulukko voidaan myös muuntaa arvoja sisältäväksi syötevirraksi.
         */
        int rivit = 2;
        int sarakkeet = 3;
        int[][] kaksiulotteinenTaulukko = new int[rivit][sarakkeet];

        for (int a = 0; a < kaksiulotteinenTaulukko.length; a++) {
            for (int b = 0; b < kaksiulotteinenTaulukko[a].length; b++) {
                kaksiulotteinenTaulukko[a][b] = b;
            }
        }

        Arrays.stream(kaksiulotteinenTaulukko)
                .forEach(taulukko -> {
                    Arrays.stream(taulukko).forEach(alkio -> System.out.print(alkio + " "));
                    System.out.println();
                });
        /*
        0 1 2
        0 1 2
        */
    }
}
