/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sovellus;

/**
 *
 * @author einomies
 */
public class Main01 {

    public static void main(String[] args) {

//        testi01();
//        testi02();
        testi03();

    }

    private static void testi01() {
        Vakiosensori kymppi = new Vakiosensori(10);
        Vakiosensori miinusViis = new Vakiosensori(-5);

        System.out.println(kymppi.mittaa());
        System.out.println(miinusViis.mittaa());

        System.out.println(kymppi.onPaalla());
        kymppi.poisPaalta();
        System.out.println(kymppi.onPaalla());
    }

    private static void testi02() {
        Sensori kumpula = new Lampomittari();
        kumpula.paalle();
        System.out.println("lämpötila Kumpulassa " + kumpula.mittaa() + " astetta");

        Sensori kaisaniemi = new Lampomittari();
//        kaisaniemi.paalle();
//        System.out.println("lämpötila Kaisaniemessä " + kaisaniemi.mittaa() + " astetta");

        Sensori helsinkiVantaa = new Lampomittari();

        Keskiarvosensori paakaupunki = new Keskiarvosensori();
        paakaupunki.lisaaSensori(kumpula);
        paakaupunki.lisaaSensori(kaisaniemi);
        paakaupunki.lisaaSensori(helsinkiVantaa);

        paakaupunki.paalle();
        System.out.println("lämpötila Pääkaupunkiseudulla " + paakaupunki.mittaa() + " astetta");
    }

    private static void testi03() {
        Sensori kumpula = new Lampomittari();
        Sensori kaisaniemi = new Lampomittari();
        Sensori helsinkiVantaa = new Lampomittari();

        Keskiarvosensori paakaupunki = new Keskiarvosensori();
        paakaupunki.lisaaSensori(kumpula);
        paakaupunki.lisaaSensori(kaisaniemi);
        paakaupunki.lisaaSensori(helsinkiVantaa);

        paakaupunki.paalle();
        System.out.println("lämpötila Pääkaupunkiseudulla " + paakaupunki.mittaa() + " astetta");
        System.out.println("lämpötila Pääkaupunkiseudulla " + paakaupunki.mittaa() + " astetta");
        System.out.println("lämpötila Pääkaupunkiseudulla " + paakaupunki.mittaa() + " astetta");

        System.out.println("mittaukset: " + paakaupunki.mittaukset());
    }

}
