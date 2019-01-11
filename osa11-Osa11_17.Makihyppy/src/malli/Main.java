package malli;

import malli.logiikka.Kilpailu;
import malli.ui.Kayttoliittyma;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Kirjoita pääohjelma tänne. Omien luokkien tekeminen on erittäin hyödyllistä.
        Scanner lukija = new Scanner(System.in);
        Kilpailu kilpailu = new Kilpailu("Kumpulan mäkiviikot");
        new Kayttoliittyma(lukija, kilpailu).kaynnista();
    }
}
