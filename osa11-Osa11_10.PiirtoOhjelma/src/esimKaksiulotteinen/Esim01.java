/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esimKaksiulotteinen;

/**
 *
 * @author einomies
 */
public class Esim01 {

    public static void main(String[] args) {
        int rivit = 3;
        int sarakkeet = 3;
        int[][] kaksiulotteinenTaulukko = new int[rivit][sarakkeet];
        int y = 0;

        while (y < kaksiulotteinenTaulukko.length) {
            int x = 0;
            while (x < kaksiulotteinenTaulukko[y].length) {
                int arvo = kaksiulotteinenTaulukko[y][x];
                System.out.println("arvo kohdassa (" + x + ", " + y + "): " + arvo);
                x++;
            }
            y++;
        }
    }

}
