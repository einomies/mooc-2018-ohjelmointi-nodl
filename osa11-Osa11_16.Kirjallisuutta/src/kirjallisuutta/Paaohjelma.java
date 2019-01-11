package kirjallisuutta;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import javafx.print.Collation;

public class Paaohjelma {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String kirjanNimi;
        int kirjanKohdeMinimiIka;

//        ArrayList<Kirja> kirjat = luoKirjat01();
//        ArrayList<Kirja> kirjat = luoKirjat02();
//        ArrayList<Kirja> kirjat = luoKirjat03();
        ArrayList<Kirja> kirjat = kyseleKirjat(scanner);

//        tulostaKirjatEiJarjestysta(kirjat);
//        tulostaKirjatKohdeikajarjestys(kirjat);
        tulostaKirjatKohdeikaNimijarjestys(kirjat);
    }

    private static ArrayList<Kirja> kyseleKirjat(Scanner scanner) throws NumberFormatException {
        String kirjanNimi;
        int kirjanKohdeMinimiIka;
        ArrayList<Kirja> kirjat = new ArrayList<>();
        while (true) {

            System.out.print("Syötä kirjan nimi, tyhjä lopettaa: ");
            kirjanNimi = scanner.nextLine();
            if (kirjanNimi.isEmpty()) {
                break;
            }
            System.out.print("Syötä kirjan pienin kohdeikä: ");
            kirjanKohdeMinimiIka = Integer.parseInt(scanner.nextLine());

            kirjat.add(new Kirja(kirjanNimi, kirjanKohdeMinimiIka));

            System.out.println();
        }
        return kirjat;
    }

    private static ArrayList<Kirja> luoKirjat01() {
        ArrayList<Kirja> kirjat = new ArrayList<>();
        kirjat.add(new Kirja("Soiva tuutulaulukirja", 0));
        kirjat.add(new Kirja("Kurkkaa kulkuneuvot", 0));
        kirjat.add(new Kirja("Lunta tupaan", 12));
        kirjat.add(new Kirja("Litmanen 10", 10));
        return kirjat;
    }

    private static ArrayList<Kirja> luoKirjat02() {
        ArrayList<Kirja> kirjat = new ArrayList<>();
        kirjat.add(new Kirja("bbbb", 1));
        kirjat.add(new Kirja("aaaa", 1));
        kirjat.add(new Kirja("cccc", 1));
        kirjat.add(new Kirja("dddd", 0));
//        [bbbb, 1, aaaa, 1, cccc, 1, dddd, 0]
        return kirjat;
    }

    private static ArrayList<Kirja> luoKirjat03() {
        ArrayList<Kirja> kirjat = new ArrayList<>();
        kirjat.add(new Kirja("Aapinen1", 30));
        kirjat.add(new Kirja("Kukkonen1", 40));
        kirjat.add(new Kirja("Aapinen2", 50));
        kirjat.add(new Kirja("kukkonen2", 10));
        kirjat.add(new Kirja("Kukkonen3", 20));
        kirjat.add(new Kirja("Aapinen3", 60));
        String in = "Aapinen1\n30"
                + "\nKukkonen1\n40"
                + "\nAapinen2\n50"
                + "\nkukkonen2\n10"
                + "\nKukkonen3\n20"
                + "\nAapinen3\n60\n\n";
        return kirjat;
    }

    private static void tulostaKirjatEiJarjestysta(ArrayList<Kirja> kirjat) {
        tulostaOtsikot(kirjat);

        kirjat.stream().forEach(k -> System.out.println(k));
    }

    private static void tulostaKirjatKohdeikajarjestys(ArrayList<Kirja> kirjat) {
        tulostaOtsikot(kirjat);

        kirjat.stream().sorted((k1, k2) -> {
            if (k1.getKohdeMinimiIka() > k2.getKohdeMinimiIka()) {
                return 1;
            }
            if (k1.getKohdeMinimiIka() < k2.getKohdeMinimiIka()) {
                return -1;
            }
            return 0;
        }).forEach(t -> System.out.println(t));
    }

    private static void tulostaKirjatKohdeikaNimijarjestys(ArrayList<Kirja> kirjat) {
        tulostaOtsikot(kirjat);
        kirjat.stream().sorted().forEach(k -> System.out.println(k));
    }

    private static void tulostaOtsikot(ArrayList<Kirja> kirjat) {
        System.out.println();
        System.out.println("Yhteensä " + kirjat.size() + " kirjaa.");
        System.out.println();
        System.out.println("Kirjat:");
    }

}
