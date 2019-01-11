/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makihyppy;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author einomies
 */
public class Kayttoliittyma {

    private Scanner scanner;
    private Kilpailu kilpailu;

    public Kayttoliittyma(Scanner scanner, Kilpailu kilpailu) {
        this.scanner = scanner;
        this.kilpailu = kilpailu;
    }

    public void kaynnista() {
        System.out.println("Kumpulan mäkiviikot");
        System.out.println();
        System.out.println("Syötä kilpailun osallistujat yksi kerrallaan, tyhjällä merkkijonolla siirtyy hyppyvaiheeseen.");

        while (true) {
            System.out.print("  Osallistujan nimi: ");
            String nimi = this.scanner.nextLine();
            if (nimi.isEmpty()) {
                break;
            } else {
                kilpailu.lisaaHyppaaja(nimi);
            }
        }

        System.out.println();
        System.out.println("Kilpailu alkaa!");

        int kierrosInd = 0;
        while (true) {
            System.out.println();
            System.out.print("Kirjoita \"hyppaa\" niin hypätään, muuten lopetetaan: ");
            String komento = this.scanner.nextLine();
            if (komento.equals("hyppaa")) {
                hyppaaKierros(kierrosInd);
                kierrosInd++;
            } else {
                break;
            }
        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println();
        System.out.println("Kilpailun lopputulokset:\n" + "Sija    Nimi");
        tulostaLopputulokset(this.kilpailu);
    }

    private void hyppaaKierros(int i) {
        System.out.println();
        System.out.println(i + 1 + ". kierros");
        System.out.println();
        System.out.println("Hyppyjärjestys:");
        ArrayList<Hyppaaja> jarjestys = this.kilpailu.haeHyppyjarjestys();
        for (int j = 0; j < jarjestys.size(); j++) {
            System.out.println("  " + (j + 1) + ". " + jarjestys.get(j).toString());
        }
        this.kilpailu.hyppaaKierros();
        System.out.println();
        System.out.println(this.kilpailu.haeViimeisimmanKierroksenTulokset());
    }

    private static void tulostaLopputulokset(Kilpailu kilpailu) {
        ArrayList<Hyppaaja> hyppaajat = kilpailu.haeLopputulokset();
        int i = 1;
        for (Hyppaaja hyppaaja : hyppaajat) {
            System.out.println(i + "       " + hyppaaja);
            ArrayList<Integer> hypyt = hyppaaja.getHypyt();
            String hypytString = "";
            for (int j = 0; j < hypyt.size(); j++) {
                if (j == hypyt.size() - 1) {
                    hypytString += hypyt.get(j) + " m";
                } else {
                    hypytString += hypyt.get(j) + " m, ";
                }
            }
            System.out.println("          hyppyjen pituudet: " + hypytString);
            i++;
        }
    }

}
