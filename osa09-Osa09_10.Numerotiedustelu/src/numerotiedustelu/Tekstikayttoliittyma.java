/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numerotiedustelu;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author einomies
 */
public class Tekstikayttoliittyma {

    private Henkilohallinta henkilohallinta;
    private Scanner lukija;

    public Tekstikayttoliittyma(Henkilohallinta henkilohallinta, Scanner lukija) {
        this.henkilohallinta = henkilohallinta;
        this.lukija = lukija;
    }

    public void kaynnista() {
        // tehdään käynnistys kahdessa osassa -- ensin käynnistetään hallinta,
        // sitten lentopalvelu
        kaynnistaHallinta();
        System.out.println();
//        kaynnistaLentoPalvelu();
        System.out.println();
    }

    private void kaynnistaHallinta() {
        System.out.println("numerotiedustelu");
        System.out.println("--------------------");

        while (true) {
            System.out.println();
            System.out.println("käytettävissä olevat komennot:");
            System.out.println("1 lisää numero");
            System.out.println("2 hae numerot");
            System.out.println("3 hae puhelinnumeroa vastaava henkilö");
            System.out.println("4 lisää osoite");
            System.out.println("5 hae henkilön tiedot");
            System.out.println("6 poista henkilön tiedot");
            System.out.println("7 filtteröity listaus");
            System.out.println("x lopeta");
            System.out.println();

            System.out.print("komento: ");
            String vastaus = lukija.nextLine();

            if (vastaus.equals("1")) {
                lisaaNumero();
            } else if (vastaus.equals("2")) {
                haeNumerot();
            } else if (vastaus.equals("3")) {
                haeNumeroaVastaavaHenkilo();
            } else if (vastaus.equals("4")) {
                lisaaOsoite();
            } else if (vastaus.equals("5")) {
                haeHenkilonTiedot();
            } else if (vastaus.equals("6")) {
                poistaHenkilonTiedotNimella();
            } else if (vastaus.equals("7")) {
                suodatettuListaus();
            } else if (vastaus.equals("x")) {
                break;
            }
        }
    }

    private void lisaaNumero() {
        System.out.print("kenelle: ");
        String nimi = lukija.nextLine();
        System.out.print("numero: ");
        String numero = lukija.nextLine();

        henkilohallinta.lisaaNumero(nimi, numero);

        /*
        System.out.print("Anna lentokoneen tunnus: ");
        String tunnus = lukija.nextLine();
        System.out.print("Anna lentokoneen kapasiteetti: ");
        int kapasiteetti = Integer.parseInt(lukija.nextLine());

        this.lentohallinta.lisaaLentokone(tunnus, kapasiteetti);
         */
    }

    private void haeNumerot() {
        System.out.print("kenen: ");
        String nimi = lukija.nextLine();
        ArrayList<String> tiedot = henkilohallinta.haeNumerotNimella(nimi);
        tulostaHakutulokset(tiedot);
    }

    private void haeNumeroaVastaavaHenkilo() {
        System.out.print("numero: ");
        String numero = lukija.nextLine();
        ArrayList<String> tiedot = henkilohallinta.haeTiedotNumerolla(numero);
        tulostaHakutulokset(tiedot);
    }

    private void lisaaOsoite() {
        System.out.print("kenelle: ");
        String nimi = lukija.nextLine();
        System.out.print("katu: ");
        String osoiteKatu = lukija.nextLine();
        System.out.print("kaupunki: ");
        String osoiteKaupunki = lukija.nextLine();

        henkilohallinta.lisaaOsoite(nimi, osoiteKatu, osoiteKaupunki);
    }

    private void haeHenkilonTiedot() {
        System.out.print("kenen: ");
        String nimi = lukija.nextLine();
        ArrayList<String> tiedot = henkilohallinta.haeTiedotNimella(nimi);
        tulostaHakutulokset(tiedot);
    }

    private void poistaHenkilonTiedotNimella() {
        System.out.print("kenet: ");
        String nimi = lukija.nextLine();

        henkilohallinta.poistaHenkilonTiedotNimella(nimi);
    }

    private void suodatettuListaus() {
        System.out.print("hakusana (jos tyhjä, listataan kaikki): ");
        String hakusana = lukija.nextLine();
        ArrayList<String> tiedot = henkilohallinta.haeTiedot(hakusana);
        tulostaHakutulokset(tiedot);
    }

    private void tulostaHakutulokset(ArrayList<String> lista) {
        System.out.println();
        for (String rivi : lista) {
            System.out.println(rivi);
        }
    }

}
