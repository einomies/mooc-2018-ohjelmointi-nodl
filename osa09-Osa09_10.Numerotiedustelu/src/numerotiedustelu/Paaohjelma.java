package numerotiedustelu;

import java.util.Scanner;

public class Paaohjelma {

    public static void main(String[] args) {
        // tee tästä ohjelmasi käynnistyspiste
        // HUOM: ohjelmassa saa luoda Scanner-olion vain kertaalleen
        Henkilohallinta henkilohallinta = new Henkilohallinta();
        Scanner scanner = new Scanner(System.in);
        Tekstikayttoliittyma ui = new Tekstikayttoliittyma(henkilohallinta, scanner);
        ui.kaynnista();
        /*
         Esimerkki ohjelman toiminnasta:

        numerotiedustelu
        käytettävissä olevat komennot:
        1 lisää numero
        2 hae numerot
        3 hae puhelinnumeroa vastaava henkilö
        4 lisää osoite
        5 hae henkilön tiedot
        6 poista henkilön tiedot
        7 filtteröity listaus
        x lopeta

        komento: 1
        kenelle: pekka
        numero: 040-123456

        komento: 2
        kenen: jukka
          ei löytynyt

        komento: 2
        kenen: pekka
            040-123456

        komento: 1
        kenelle: pekka
        numero: 09-222333

        komento: 2
        kenen: pekka
          040-123456
          09-222333

        komento: 3
        numero: 02-444123
          ei löytynyt

        komento: 3
        numero: 09-222333
          pekka

        komento: 5
        kenen: pekka
          osoite ei tiedossa
          puhelinnumerot:
            040-123456
            09-222333

        komento: 4
        kenelle: pekka
        katu: ida ekmanintie
        kaupunki: helsinki

        komento: 5
        kenen: pekka
          osoite: ida ekmanintie helsinki
          puhelinnumerot:
            040-123456
            09-222333

        komento: 4
        kenelle: jukka
        katu: korsontie
        kaupunki: vantaa

        komento: 5
        kenen: jukka
          osoite: korsontie vantaa
          ei puhelinta

        komento: 7
        hakusana (jos tyhjä, listataan kaikki): kk

          jukka
            osoite: korsontie vantaa
            ei puhelinta

          pekka
            osoite: ida ekmanintie helsinki
            puhelinnumerot:
              040-123456
              09-222333

        komento: 7
        hakusana (jos tyhjä, listataan kaikki): vantaa

          jukka
            osoite: korsontie vantaa
            ei puhelinta

        komento: 7
        hakusana (jos tyhjä, listataan kaikki): seppo
          ei löytynyt

        komento: 6
        kenet: jukka

        komento: 5
        kenen: jukka
          ei löytynyt

        komento: x
        */
    }
}
