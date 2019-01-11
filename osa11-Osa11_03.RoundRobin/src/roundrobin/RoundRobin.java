package roundrobin;

import java.util.Scanner;

public class RoundRobin {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        int[] taulukko = new int[5];
        taulukko[0] = 1;
        taulukko[1] = 3;
        taulukko[2] = 5;
        taulukko[3] = 7;
        taulukko[4] = 9;

        while (true) {
            System.out.print("Anna komento: ");
            String komento = lukija.nextLine();

            if (komento.equals("lopeta")) {
                break;
            }

            if (komento.equals("tulosta")) {
                int indeksi = 0;
                while (indeksi < taulukko.length) {
                    System.out.print(taulukko[indeksi] + " ");
                    indeksi++;
                }
                System.out.println("");
            }

            // toteuta siirtotoiminnallisuus tänne
            if (komento.equals("siirra")) {
                int ekaVikaksi = taulukko[0];
                for (int i = 1; i < taulukko.length; i++) {
                    taulukko[i - 1] = taulukko[i];
                }
                taulukko[taulukko.length - 1] = ekaVikaksi;
                System.out.println("");
            }
        }
    }

}
