package vaihtaminen;

import java.util.Scanner;

public class AlkioidenArvojenVaihtaminen {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        int[] taulukko = new int[5];
        taulukko[0] = 1;
        taulukko[1] = 3;
        taulukko[2] = 5;
        taulukko[3] = 7;
        taulukko[4] = 9;

        int indeksi = 0;
        while (indeksi < taulukko.length) {
            System.out.println(taulukko[indeksi]);
            indeksi++;
        }
        System.out.println("");

        // Toteuta indeksien kysyminen ja vaihto tänne
        System.out.println("Mitkä indeksit vaihdetaan?");
        int i1 = Integer.parseInt(lukija.nextLine());
        int i2 = Integer.parseInt(lukija.nextLine());
//        int i1 = 1;
//        int i2 = 3;

        int luku1 = taulukko[i1];
        int luku2 = taulukko[i2];

        taulukko[i1] = luku2;
        taulukko[i2] = luku1;

        System.out.println("");
        indeksi = 0;
        while (indeksi < taulukko.length) {
            System.out.println(taulukko[indeksi]);
            indeksi++;
        }
    }

}
/*
package vaihtaminen;

import java.util.Scanner;

public class AlkioidenArvojenVaihtaminen {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        int[] taulukko = new int[5];
        taulukko[0] = 1;
        taulukko[1] = 3;
        taulukko[2] = 5;
        taulukko[3] = 7;
        taulukko[4] = 9;

        int indeksi = 0;
        while (indeksi < taulukko.length) {
            System.out.println(taulukko[indeksi]);
            indeksi++;
        }

        System.out.println("");
        // Toteuta indeksien kysyminen ja vaihto tänne
        System.out.println("Mitkä indeksit vaihdetaan?");
        int eka = Integer.parseInt(lukija.nextLine());
        int toka = Integer.parseInt(lukija.nextLine());

        int apu = taulukko[eka];
        taulukko[eka] = taulukko[toka];
        taulukko[toka] = apu;

        System.out.println("");

        indeksi = 0;
        while (indeksi < taulukko.length) {
            System.out.println(taulukko[indeksi]);
            indeksi++;
        }
    }
}
*/