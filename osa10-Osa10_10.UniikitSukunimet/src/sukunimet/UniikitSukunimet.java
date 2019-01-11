package sukunimet;

import java.util.ArrayList;
import java.util.Scanner;

public class UniikitSukunimet {

    public static void main(String[] args) {
        ArrayList<Henkilo> henkilot = new ArrayList<>();
//        ArrayList<Henkilo> henkilot = luoHenkilot01();

        Scanner lukija = new Scanner(System.in);

        while (true) {
            System.out.println("Syötetäänkö henkilöiden tietoja, \"loppu\" lopettaa:");
            String jatketaan = lukija.nextLine();

            if (jatketaan.equals("loppu")) {
                break;
            }

            System.out.print("Syötä etunimi: ");
            String etunimi = lukija.nextLine();
            System.out.print("Syötä sukunimi: ");
            String sukunimi = lukija.nextLine();
            System.out.print("Syötä syntymävuosi: ");
            int syntymavuosi = Integer.parseInt(lukija.nextLine());

            henkilot.add(new Henkilo(etunimi, sukunimi, syntymavuosi));
            System.out.println("");
        }

        // toteuta uniikkien sukunimien tulostaminen aakkosjärjestyksessä tänne
        henkilot.stream()
                .map(henkilo -> henkilo.getSukunimi())
                .distinct()
                .sorted()
                .forEach(s -> System.out.println(s));
    }

    private static ArrayList<Henkilo> luoHenkilot01() {
        ArrayList<Henkilo> henkilot = new ArrayList<>();
        henkilot.add(new Henkilo("Aimo", "Hokkanen", 1968));
        henkilot.add(new Henkilo("Adele", "McSmith", 1989));
        henkilot.add(new Henkilo("Eino", "Kämäräinen", 1975));
        henkilot.add(new Henkilo("Terhi", "Kämäräinen", 1977));
        henkilot.add(new Henkilo("Katri", "Lamberg", 1965));
        henkilot.add(new Henkilo("Huuko", "Sörsselssön", 1949));
        henkilot.add(new Henkilo("Härski", "Hartikainen", 1955));
        henkilot.add(new Henkilo("Olavi", "Granström", 1951));
        henkilot.add(new Henkilo("Arttu", "Kämäräinen", 2007));
        henkilot.add(new Henkilo("Otso", "Kämäräinen", 2010));
        henkilot.add(new Henkilo("Tarja", "Loponen", 1957));
        henkilot.add(new Henkilo("Aarne", "Tenkanen", 1955));
        henkilot.add(new Henkilo("Zero", "Luotola", 1969));
        return henkilot;
    }

}
