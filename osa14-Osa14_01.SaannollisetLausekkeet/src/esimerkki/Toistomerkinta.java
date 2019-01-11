/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esimerkki;

import java.util.Scanner;

/**
 *
 * @author einomies
 */
public class Toistomerkinta {

    public static void main(String[] args) {

        testi01();
        System.out.println();
        testi02();
        System.out.println();
        testi03();
        System.out.println();
        testi04();
        System.out.println();
        testi05();
        System.out.println();
        testi06();
        System.out.println();
        testi07();
        System.out.println();
        testi08();
        System.out.println();
        testi09();
    }

    private static void testi01() {
//      Merkintä * toisto 0... kertaa, esim
        String merkkijono = "trolololololo";
        tulostaMerkkijono(merkkijono);
        System.out.println("merkkijono.matches(\"trolo(lo)*\")");

        if (merkkijono.matches("trolo(lo)*")) {
            System.out.println("Muoto on oikea.");
        } else {
            System.out.println("Muoto ei ole oikea.");
        }
//        Muoto on oikea.
    }

    private static void testi02() {
//       Merkintä + toisto 1... kertaa, esim
        String merkkijono = "trolololololo";
        tulostaMerkkijono(merkkijono);
        System.out.println("merkkijono.matches(\"tro(lo)+\")");

        if (merkkijono.matches("tro(lo)+")) {
            System.out.println("Muoto on oikea.");
        } else {
            System.out.println("Muoto ei ole oikea.");
        }
//        Muoto on oikea.
    }

    private static void testi03() {

        String merkkijono = "nänänänänänänänä Bätmään!";
        tulostaMerkkijono(merkkijono);
        System.out.println("merkkijono.matches(\"(nä)+ Bätmään!\")");

        if (merkkijono.matches("(nä)+ Bätmään!")) {
            System.out.println("Muoto on oikea.");
        } else {
            System.out.println("Muoto ei ole oikea.");
        }
//        Muoto on oikea.
    }

    private static void testi04() {
//        Merkintä ? toisto 0 tai 1 kertaa, esim
        String merkkijono = "You have to accidentally the whole meme";
        tulostaMerkkijono(merkkijono);
        System.out.println("merkkijono.matches(\"You have to accidentally (delete )?the whole meme\")");

        if (merkkijono.matches("You have to accidentally (delete )?the whole meme")) {
            System.out.println("Muoto on oikea.");
        } else {
            System.out.println("Muoto ei ole oikea.");
        }

//      Muoto on oikea.
    }

    private static void testi05() {
//      Merkintä {a} toisto a kertaa, esim
        String merkkijono = "1010";
        tulostaMerkkijono(merkkijono);
        System.out.println("merkkijono.matches(\"(10){2}\")");

        if (merkkijono.matches("(10){2}")) {
            System.out.println("Muoto on oikea.");
        } else {
            System.out.println("Muoto ei ole oikea.");
        }

//        Muoto on oikea.
    }

    private static void testi06() {
//        Merkintä {a,b} toisto a ... b kertaa, esim
        String merkkijono = "1";
        tulostaMerkkijono(merkkijono);
        System.out.println("merkkijono.matches(\"1{2,4}\")");

        if (merkkijono.matches("1{2,4}")) {
            System.out.println("Muoto on oikea.");
        } else {
            System.out.println("Muoto ei ole oikea.");
        }
//        Muoto ei ole oikea.
    }

    private static void testi07() {
//        Merkintä {a,} toisto a ... kertaa, esim

        String merkkijono = "11111";
        tulostaMerkkijono(merkkijono);
        System.out.println("merkkijono.matches(\"1{2,}\")");

        if (merkkijono.matches("1{2,}")) {
            System.out.println("Muoto on oikea.");
        } else {
            System.out.println("Muoto ei ole oikea.");
        }
//        Muoto on oikea.
    }

    private static void testi08() {
        System.out.println("esimerkki.Toistomerkinta.testi08()");
    }

    private static void testi09() {
        System.out.println("esimerkki.Toistomerkinta.testi09()");
    }

    private static void tulostaMerkkijono(String merkkijono) {
        System.out.println("merkkijono: " + merkkijono);
    }

}
