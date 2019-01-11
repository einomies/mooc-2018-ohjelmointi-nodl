package jarjestaminen;

import java.util.Arrays;

public class Paaohjelma {

    public static void main(String[] args) {
//        testi01();
//        testi02();
//        testi03();
//        testi04();
//        testi05();
//        testi06();
        testi07();
    }

    private static void testi01() {
        Valintajarjestaminen jarjestaminen = new Valintajarjestaminen();
        int[] taulukko01 = luoTaulukko01();
        tulostaTaulukko(taulukko01);
    }

    private static void testi02() {
        int[] luvut = {6, 5, 8, 7, 11};
        System.out.println("Pienin: " + new Valintajarjestaminen().pienin(luvut));
        //Pienin: 5
    }

    private static void testi03() {
        // indeksit:   0  1  2  3  4
        int[] luvut = {6, 5, 8, 7, 11};
        System.out.println("Pienimmän indeksi: " + new Valintajarjestaminen().pienimmanIndeksi(luvut));
//        Pienimmän indeksi: 1
    }

    private static void testi04() {
        Valintajarjestaminen algoritmi = new Valintajarjestaminen();
//        indeksit:    0  1  2  3   4
        int[] luvut = {-1, 6, 9, 8, 12};
        System.out.println(algoritmi.pienimmanIndeksiAlkaen(luvut, 0));
        System.out.println(algoritmi.pienimmanIndeksiAlkaen(luvut, 1));
        System.out.println(algoritmi.pienimmanIndeksiAlkaen(luvut, 2));
        /*
        0
        1
        3
         */
    }

    private static void tulostaTaulukko(int[] taulukko) {
        System.out.println("taulukko.length: " + taulukko.length);
        for (int i = 0; i < taulukko.length; i++) {
            System.out.println(i + ": " + taulukko[i]);
        }
    }

    private static int[] luoTaulukko01() {
        int[] taulukko = {3, 1, 5, 99, 3, 12};
        return taulukko;
    }

    private static void testi05() {
        int[] luvut = {3, 2, 5, 4, 8};

        System.out.println(Arrays.toString(luvut));
        Valintajarjestaminen algoritmi = new Valintajarjestaminen();

        algoritmi.vaihda(luvut, 1, 0);
        System.out.println(Arrays.toString(luvut));

        algoritmi.vaihda(luvut, 0, 3);
        System.out.println(Arrays.toString(luvut));
        /*
        [3, 2, 5, 4, 8]
        [2, 3, 5, 4, 8]
        [4, 3, 5, 2, 8]
         */
    }

    private static void testi06() {
        int[] luvut = {8, 3, 7, 9, 1, 2, 4};
        System.out.println(Arrays.toString(luvut));
        new Valintajarjestaminen().jarjesta(luvut);
        System.out.println(Arrays.toString(luvut));
        /**
         * Ohjelman tulosteen tulisi olla seuraavanlainen.Huomaa että sinun
         * tulee tulostaa taulukon sisältö jokaisen vaihtamisen jälkeen!
         *
         * [8, 3, 7, 9, 1, 2, 4]
         * [1, 3, 7, 9, 8, 2, 4]
         * [1, 2, 7, 9, 8, 3, 4]
         * [1, 2, 3, 9, 8, 7, 4]
         * [1, 2, 3, 4, 8, 7, 9]
         * [1, 2, 3, 4, 7, 8, 9]
         * [1, 2, 3, 4, 7, 8, 9]
         *
         * Huomaat, miten taulukko tulee pikkuhiljaa järjestykseen alkaen alusta
         * ja edeten loppua kohti.
         */
    }

    private static void testi07() {
        int[] luvut = {8, 3, 7, 9, 1, 2, -1, 99, 3, 0, 1, 0, 1, 143, -76, 4};
        System.out.println(Arrays.toString(luvut));
        new Valintajarjestaminen().jarjesta(luvut);
        System.out.println(Arrays.toString(luvut));
    }

}
