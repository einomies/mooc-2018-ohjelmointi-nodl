/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package valioperaatiot;

import java.util.ArrayList;

/**
 *
 * @author einomies
 */
public class Esim01 {

    /*
    Virran välioperaatiot ovat metodeja, jotka palauttavat arvonaan virran.
    Koska palautettava arvo on virta, voidaan välioperaatioita kutsua peräkkäin.
    Tyypillisiä välioperaatioita ovat arvon muuntaminen muodosta toiseen map
    sekä sen erityistapaus mapToInt, arvojen rajaaminen filter, uniikkien arvojen
    tunnistaminen distinct sekä arvojen järjestäminen sorted (mikäli mahdollista).
     */
    public static void main(String[] args) {
        testi01();
        testi02();
        testi03();
    }

    private static void testi01() {
        /*
        Ongelma 1: Saat käyttöösi listan henkilöitä. Tulosta ennen vuotta 1970
        syntyneiden henkilöiden lukumäärä. Käytetään filter-metodia henkilöiden
        rajaamiseen niihin, jotka ovat syntyneet ennen vuotta 1970. Lasketaan
        tämän jälkeen henkilöiden lukumäärä metodilla count.
         */
//      oletetaan, että käytössämme on lista henkiloita
        ArrayList<Henkilo> henkilot = luoHenkilot01();

        long lkm = henkilot.stream()
                .filter(henkilo -> henkilo.getSyntymavuosi() < 1970)
                .count();
        System.out.println("Lukumäärä: " + lkm);
    }

    private static void testi02() {
        /*
        Ongelma 2: Saat käyttöösi listan henkilöitä. Kuinka monen henkilön etunimi
        alkaa kirjaimella "A"?

        Käytetään filter-metodia henkilöiden rajaamiseen niihin, joiden etunimi
        alkaa kirjaimella "A". Lasketaan tämän jälkeen henkilöiden lukumäärä
        metodilla count.
         */
        ArrayList<Henkilo> henkilot = luoHenkilot01();
        long lkm = henkilot.stream()
                .filter(henkilo -> henkilo.getEtunimi().startsWith("A"))
                .count();
        System.out.println("Lukumäärä: " + lkm);
    }

    private static void testi03() {
        /*
        Ongelma 3: Saat käyttöösi listan henkilöitä. Tulosta henkilöiden uniikit
        etunimet aakkosjärjestyksessä.

        Käytetään ensin map-metodia, jonka avulla henkilö-olioita sisältävä virta
        muunnetaan etunimiä sisältäväksi virraksi. Tämän jälkeen kutsutaan metodia
        distinct, joka palauttaa virran, jossa on uniikit arvot.

        Seuraavaksi kutsutaan metodia sorted, joka järjestää merkkijonot.

        Lopulta kutsutaan metodia forEach, jonka avulla tulostetaan merkkijonot.
         */
        ArrayList<Henkilo> henkilot = luoHenkilot01();
        henkilot.stream()
                .map(henkilo -> henkilo.getEtunimi())
                .distinct()
                .sorted()
                .forEach(nimi -> System.out.println(nimi));
        /*
        Yllä kuvattu distinct-metodi hyödyntää olioiden equals-metodia yhtäsuuruuden
        tarkasteluun. Metodi sorted taas osaa järjestää olioita, joilla on tieto
        siitä, miten olio tulee järjestää -- näitä ovat esimerkiksi luvut ja merkkijonot.
         */
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
        henkilot.add(new Henkilo("Olavi", "Granström", 1970));
        henkilot.add(new Henkilo("Arttu", "Kämäräinen", 2007));
        henkilot.add(new Henkilo("Otso", "Kämäräinen", 2010));
        return henkilot;
    }

}
