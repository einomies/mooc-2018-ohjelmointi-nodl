/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esimerkki;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author einomies
 */
public class Main01 {

    public static void main(String[] args) {
// alustetaan lukija ja lista, johon syotteet luetaan
        Scanner lukija = new Scanner(System.in);
        List<String> syotteet = new ArrayList<>(); // luetaan syotteet

        while (true) {
            String rivi = lukija.nextLine();
            if (rivi.equals("loppu")) {
                break;
            }

            syotteet.add(rivi);
        }

// selvitetään kolmella jaollisten lukumaara
        long kolmellaJaollistenLukumaara = syotteet.stream()
                .mapToInt(s -> Integer.parseInt(s))
                .filter(luku -> luku % 3 == 0)
                .count();

// selvitetään keskiarvo
        double keskiarvo = syotteet.stream()
                .mapToInt(s -> Integer.parseInt(s))
                .average()
                .getAsDouble();

// tulostetaan tilastot
        System.out.println("Kolmella jaollisia: " + kolmellaJaollistenLukumaara);
        System.out.println("Lukujen keskiarvo: " + keskiarvo);
    }

}
