
import java.util.Scanner;


public class Paaohjelma {

    public static void main(String[] args) {
//        testi01();
//        testi02();
//        testi03();
//        testi04();
//        testi05();
//        testi06();
//        testi07();
        testi08();
    }

    private static void testi01() {
        Varasto varasto = new Varasto();
        varasto.lisaaTuote("maito", 3, 10);
        varasto.lisaaTuote("kahvi", 5, 7);

        System.out.println("hinnat:");
        System.out.println("maito: " + varasto.hinta("maito"));
        System.out.println("kahvi: " + varasto.hinta("kahvi"));
        System.out.println("sokeri: " + varasto.hinta("sokeri"));
        /*
        Tulostuu:
        hinnat:
        maito: 3
        kahvi: 5
        sokeri: -99
         */
    }

    private static void testi02() {
        Varasto varasto = new Varasto();
        varasto.lisaaTuote("kahvi", 5, 1);

        System.out.println("saldot:");
        System.out.println("kahvi:  " + varasto.saldo("kahvi"));
        System.out.println("sokeri: " + varasto.saldo("sokeri"));

        System.out.println("otetaan kahvi " + varasto.ota("kahvi"));
        System.out.println("otetaan kahvi " + varasto.ota("kahvi"));
        System.out.println("otetaan sokeri " + varasto.ota("sokeri"));

        System.out.println("saldot:");
        System.out.println("kahvi:  " + varasto.saldo("kahvi"));
        System.out.println("sokeri: " + varasto.saldo("sokeri"));
        /*
        Tulostuu:
        saldot:
        kahvi:  1
        sokeri: 0
        otetaan kahvi true
        otetaan kahvi false
        otetaan sokeri false
        saldot:
        kahvi:  0
        sokeri: 0
         */
    }

    private static void testi03() {
        Varasto varasto = new Varasto();
        varasto.lisaaTuote("maito", 3, 10);
        varasto.lisaaTuote("kahvi", 5, 6);
        varasto.lisaaTuote("piimä", 2, 20);
        varasto.lisaaTuote("jugurtti", 2, 20);

        System.out.println("tuotteet:");

        for (String tuote : varasto.tuotteet()) {
            System.out.println(tuote);
        }
        /*
        tuotteet:
        piimä
        jugurtti
        kahvi
        maito
         */
    }

    private static void testi04() {
        Ostos ostos = new Ostos("maito", 4, 2);
        System.out.println("ostoksen joka sisältää 4 maitoa yhteishinta on " + ostos.hinta());
        System.out.println(ostos);
        ostos.kasvataMaaraa();
        System.out.println(ostos);
        /*
        ostoksen joka sisältää 4 maitoa yhteishinta on 8
        maito: 4
        maito: 5
         */
    }

    private static void testi05() {
        Ostoskori kori = new Ostoskori();
        kori.lisaa("maito", 3);
        kori.lisaa("piimä", 2);
        kori.lisaa("juusto", 5);
        System.out.println("korin hinta: " + kori.hinta());
        kori.lisaa("tietokone", 899);
        System.out.println("korin hinta: " + kori.hinta());
        /*
        korin hinta: 10
        korin hinta: 909
         */
    }

    private static void testi06() {
        Ostoskori kori = new Ostoskori();
        kori.lisaa("maito", 3);
        kori.lisaa("piimä", 2);
        kori.lisaa("juusto", 5);
        kori.lisaa("tietokone", 899);
        kori.tulosta();
    }

    private static void testi07() {
        Ostoskori kori = new Ostoskori();
        kori.lisaa("maito", 3);
        kori.tulosta();
        System.out.println("korin hinta: " + kori.hinta() + "\n");

        kori.lisaa("piimä", 2);
        kori.tulosta();
        System.out.println("korin hinta: " + kori.hinta() + "\n");

        kori.lisaa("maito", 3);
        kori.tulosta();
        System.out.println("korin hinta: " + kori.hinta() + "\n");

        kori.lisaa("maito", 3);
        kori.tulosta();
        System.out.println("korin hinta: " + kori.hinta() + "\n");
        /*
        maito: 1
        korin hinta: 3

        piimä: 1
        maito: 1
        korin hinta: 5

        piimä: 1
        maito: 2
        korin hinta: 8

        piimä: 1
        maito: 3
        korin hinta: 11
         */
    }

    private static void testi08() {
        Varasto varasto = new Varasto();
        varasto.lisaaTuote("kahvi", 5, 10);
        varasto.lisaaTuote("maito", 3, 20);
        varasto.lisaaTuote("piimä", 2, 55);
        varasto.lisaaTuote("leipä", 7, 8);

        Kauppa kauppa = new Kauppa(varasto, new Scanner(System.in));
        kauppa.asioi("Pekka");
    }

}
