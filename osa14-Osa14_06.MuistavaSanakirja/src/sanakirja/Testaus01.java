package sanakirja;

import java.util.Scanner;

import sanakirja.MuistavaSanakirja;

public class Testaus01 {

    public static void main(String[] args) {
//        testi01();
//        testi02();
//        testi03();
//        testi04();
        testi05();
    }

    private static void testi01() {
        MuistavaSanakirja sanakirja = new MuistavaSanakirja();
        sanakirja.lisaa("apina", "monkey");
        sanakirja.lisaa("apina", "monkey");
        sanakirja.lisaa("monkey", "apina");
        sanakirja.lisaa("banaani", "banana");
        sanakirja.lisaa("apina", "apfe");

        System.out.println(sanakirja.kaanna("apina"));
        System.out.println(sanakirja.kaanna("monkey"));
        System.out.println(sanakirja.kaanna("ohjelmointi"));
        System.out.println(sanakirja.kaanna("banana"));

//         monkey
//         apina
//         null
//         banaani
    }

    private static void testi02() {
        MuistavaSanakirja sanakirja = new MuistavaSanakirja();
        sanakirja.lisaa("apina", "monkey");
        sanakirja.lisaa("banaani", "banana");
        sanakirja.lisaa("banana", "jepulisjee");
        sanakirja.lisaa("ohjelmointi", "programming");
        sanakirja.poista("apina");
        sanakirja.poista("banana");

        System.out.println(sanakirja.kaanna("apina"));
        System.out.println(sanakirja.kaanna("monkey"));
        System.out.println(sanakirja.kaanna("banana"));
        System.out.println(sanakirja.kaanna("banaani"));
        System.out.println(sanakirja.kaanna("ohjelmointi"));
        /*
        null
        null
        null
        null
        programming
         */
    }

    private static void testi03() {
        MuistavaSanakirja sanakirja = new MuistavaSanakirja("src/sanat.txt");
        boolean onnistui = sanakirja.lataa();

        if (onnistui) {
            System.out.println("sanakirjan lataaminen onnistui");
        }

        System.out.println(sanakirja.kaanna("apina"));
        System.out.println(sanakirja.kaanna("ohjelmointi"));
        System.out.println(sanakirja.kaanna("alla oleva"));

        /*
        sanakirjan lataaminen onnistui
        monkey
        null
        below
         */
    }

    private static void testi04() {
        MuistavaSanakirja sanakirja = new MuistavaSanakirja("src/sanat.txt");
        boolean onnistui = sanakirja.lataa();
        if (onnistui) {
            System.out.println("sanakirjan lataaminen onnistui");
            System.out.println();
            sanakirja.tulostaKaikki();
            sanakirja.lisaa("ohjelmointi", "programming");
            sanakirja.lisaa("hiiri", "mouse");
            sanakirja.lisaa("hiiri", "muusse");
            sanakirja.lisaa("asdf", "hiiri");
            System.out.println();
            sanakirja.tulostaKaikki();
            System.out.println();
            sanakirja.poista("hiiri");
            sanakirja.tulostaKaikki();
            sanakirja.tallenna();
        }
    }

    private static void testi05() {
        MuistavaSanakirja s = new MuistavaSanakirja("src/sanat.txt");
        s.lataa();
        System.out.println(s.tallenna());
    }

}
