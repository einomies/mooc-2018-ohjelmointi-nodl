/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esimerkki;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author einomies
 */
public class Esim01 {

    public static void main(String[] args) {
        List<Kirja> kirjat = luoKirjat01();

        System.out.println();
        System.out.println("Kaikki kirjat:");
        kirjat.stream().forEach(k -> System.out.println(k));

//      kirjailijoiden syntymävuosien keskiarvo
        double keskiarvo = kirjat.stream()
                .map(kirja -> kirja.getKirjailija())
                .mapToInt(kirjailija -> kirjailija.getSyntymavuosi())
                .average()
                .getAsDouble();
// muunnoksen kirjasta kirjailijan syntymävuoteen pystyisi tekemään myös yhdellä map-kutsulla
// double keskiarvo = kirjat.stream()
//     .mapToInt(kirja -> kirja.getKirjailija().getSyntymavuosi())
//     ...
        System.out.println("Kirjailijoiden syntymävuosien keskiarvo: " + keskiarvo);

        System.out.println();
        System.out.println("Kirjojen, joiden kirjan nimessä esiintyy sana \"Potter\", kirjailijoiden nimet:");
        kirjat.stream()
                .filter(kirja -> kirja.getNimi().contains("Potter"))
                .map(kirja -> kirja.getKirjailija().getNimi())
                .forEach(k -> System.out.println(k));

        /*
        Myös monimutkaisempien merkkijonoesitysten rakentaminen on virran avulla
        mahdollista. Alla olevassa esimerkissä tulostamme "Kirjailijan nimi: Kirja"
        -parit aakkosjärjestyksessä.
         */
        System.out.println();
        System.out.println("\"Kirjailijan nimi: Kirja\" -parit aakkosjärjestyksessä:");
        kirjat.stream()
                .map(kirja -> kirja.getKirjailija().getNimi() + ": " +kirja.getNimi())
                .sorted()
                .forEach(nimi -> System.out.println(nimi));
    }

    private static List<Kirja> luoKirjat01() {
        List<Kirja> kirjat = new ArrayList<>();
        kirjat.add(new Kirja(new Henkilo("Kaarina Kapula", 1982), "Paluu", 123));
        kirjat.add(new Kirja(new Henkilo("Vladimir Kostantinov", 1886), "Sota ja valtiot", 88));
        kirjat.add(new Kirja(new Henkilo("Kari Hotakainen", 1951), "Klassikko", 442));
        kirjat.add(new Kirja(new Henkilo("Francois Benjamour", 1905), "Kapeat kujat", 237));
        kirjat.add(new Kirja(new Henkilo("Meri Kukkanen", 1990), "Hiphei", 500));
        kirjat.add(new Kirja(new Henkilo("Carita von Tötterström", 1976), "Niteitä tyhmille", 921));
        kirjat.add(new Kirja(new Henkilo("Timo K. Mukka", 1943), "Maa on syntinen laulu", 342));
        kirjat.add(new Kirja(new Henkilo("John Witt", 1969), "Mr. Crowley", 511));
        kirjat.add(new Kirja(new Henkilo("Nayami Moyoto", 1958), "Lilja 44", 92));
        kirjat.add(new Kirja(new Henkilo("J. K. Rowling", 1965), "Harry Potter ja viisasten kivi", 335));
        kirjat.add(new Kirja(new Henkilo("J. K. Rowling", 1965), "Harry Potter ja salaisuuksien kammio", 251));
        kirjat.add(new Kirja(new Henkilo("Sven Ekberg", 1961), "Isien pellot", 301));
        return kirjat;
    }

    private static void tulostaKaikki(List<Kirja> kirjat) {
        kirjat.stream().forEach(k -> System.out.println(k));
    }

}
