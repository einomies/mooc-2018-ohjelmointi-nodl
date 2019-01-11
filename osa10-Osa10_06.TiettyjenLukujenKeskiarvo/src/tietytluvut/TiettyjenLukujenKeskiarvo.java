package tietytluvut;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TiettyjenLukujenKeskiarvo {

    public static void main(String[] args) {

        Scanner lukija = new Scanner(System.in);
        List<String> syotteet = new ArrayList<>();
//        syotaLuvut(syotteet);

        while (true) {
            String rivi = lukija.nextLine();
            if (rivi.equals("loppu")) {
                break;
            }
            syotteet.add(rivi);
        }

//        long kahdellaJaollistenLukumaara = syotteet.stream()
//                .mapToInt(s -> Integer.parseInt(s))
//                .filter(luku -> luku % 2 == 0)
//                .count();
// kaikkien lukujen keskiarvo
//        double keskiarvo = syotteet.stream()
//                .mapToInt(s -> Integer.parseInt(s))
//                .average()
//                .getAsDouble();
// positiivisten lukujen keskiarvo
        double keskiarvoPos = syotteet.stream()
                .mapToInt(s -> Integer.parseInt(s))
                .filter(luku -> luku > 0)
                .average()
                .getAsDouble();

// negatiivisten lukujen keskiarvo
        double keskiarvoNeg = syotteet.stream()
                .mapToInt(s -> Integer.parseInt(s))
                .filter(luku -> luku < 0)
                .average()
                .getAsDouble();

        System.out.print("Tulostetaanko negatiivisten vai positiivisten lukujen keskiarvo? (n/p) ");

        if (lukija.nextLine().equals("n")) {
            System.out.println("Negatiivisten lukujen keskiarvo: " + keskiarvoNeg);
        } else {
            System.out.println("Positiivisten lukujen keskiarvo: " + keskiarvoPos);
        }

// tulostetaan tilastot
//        System.out.println("Kahdella jaollisia: " + kahdellaJaollistenLukumaara);
//        System.out.println("Kaikkien lukujen keskiarvo: " + keskiarvo);
//        System.out.println("Positiivisten lukujen keskiarvo: " + keskiarvoPos);
//        System.out.println("Negatiivisten lukujen keskiarvo: " + keskiarvoNeg);
    }

    private static void syotaLuvut(List<String> syotteet) {
        syotteet.add("1");
        syotteet.add("2");
        syotteet.add("3");
        syotteet.add("4");
        syotteet.add("5");
        syotteet.add("11");
        syotteet.add("22");
        syotteet.add("33");
        syotteet.add("44");
        syotteet.add("55");
        syotteet.add("-1");
        syotteet.add("-12");
        syotteet.add("-11");
        syotteet.add("-7");
        syotteet.add("-8");
        syotteet.add("-17");
        syotteet.add("-31");
    }

}

/*
package tietytluvut;

import java.util.ArrayList;
import java.util.Scanner;

public class TiettyjenLukujenKeskiarvo {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        // toteuta ohjelmasi tänne
        System.out.println("Kirjoita syötteitä, \"loppu\" lopettaa.");
        ArrayList<Integer> luetut = new ArrayList<>();
        while (true) {
            String luettu = lukija.nextLine();
            if (luettu.equals("loppu")) {
                break;
            }
            luetut.add(Integer.parseInt(luettu));
        }
        System.out.println("");
        System.out.println("Tulostetaanko negatiivisten vai positiivisten lukujen keskiarvo? (n/p)");
        String valinta = lukija.nextLine();
        if (valinta.equals("n")) {
            System.out.println("Negatiivisten lukujen keskiarvo: " + luetut.stream().filter(l -> l < 0).mapToInt(i -> i).average().getAsDouble());
        } else {
            System.out.println("Positiivisten lukujen keskiarvo: " + luetut.stream().filter(l -> l > 0).mapToInt(i -> i).average().getAsDouble());
        }
    }
}
*/