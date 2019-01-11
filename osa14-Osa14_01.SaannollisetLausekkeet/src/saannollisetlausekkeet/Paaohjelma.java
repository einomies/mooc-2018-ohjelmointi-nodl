package saannollisetlausekkeet;

import java.util.Scanner;

public class Paaohjelma {

    public static void main(String[] args) {

        Scanner lukija = new Scanner(System.in);
        Tarkistin tarkistin = new Tarkistin();
        String merkkijono = "";

//        merkkijono = lueMerkkijono(lukija);
//        testi01Viikonpaiva(tarkistin, merkkijono);

//        merkkijono = lueMerkkijono(lukija);
//        testi02Vokaali(tarkistin, merkkijono);

        merkkijono = lueMerkkijono(lukija);
        testi03Kellonaika(tarkistin, merkkijono);
    }

    private static String lueMerkkijono(Scanner lukija) {
        System.out.println();
        System.out.print("Anna merkkijono: ");
        return lukija.nextLine();
    }

    private static void muotoOikein() {
        System.out.println("Muoto on oikea.");
    }

    private static void muotoVaarin() {
        System.out.println("Muoto ei ole oikea.");
    }

    private static void testi01Viikonpaiva(Tarkistin tarkistin, String merkkijono) {
        System.out.println("testi01Viikonpaiva()");
        if (tarkistin.onViikonpaiva(merkkijono)) {
            muotoOikein();
        } else {
            muotoVaarin();
        }
    }

    private static void testi02Vokaali(Tarkistin tarkistin, String merkkijono) {
        System.out.println("testi02Vokaali()");
        if (tarkistin.kaikkiVokaaleja(merkkijono)) {
            muotoOikein();
        } else {
            muotoVaarin();
        }
    }

    private static void testi03Kellonaika(Tarkistin tarkistin, String merkkijono) {
        System.out.println("testi03Kellonaika()");
        if (tarkistin.kellonaika(merkkijono)) {
            muotoOikein();
        } else {
            muotoVaarin();
        }
    }

}
