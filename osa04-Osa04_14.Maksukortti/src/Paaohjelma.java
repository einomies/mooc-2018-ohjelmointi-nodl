public class Paaohjelma {

    public static void main(String[] args) {
        // Scanner lukija = new Scanner(System.in);
        
        // Tee tänne koodia jolla testaat että Maksukortti toimii halutulla tavalla
        // muista kuitenkin pyyhkiä ylimääräinen koodi pois tehtävän viimeisessä osassa!
        Maksukortti pekanKortti = new Maksukortti(20);
        Maksukortti matinKortti = new Maksukortti(30);
        pekanKortti.syoMaukkaasti();
        matinKortti.syoEdullisesti();
        tulostaKortit("Pekka", pekanKortti, "Matti", matinKortti);
        pekanKortti.lataaRahaa(20);
        matinKortti.syoMaukkaasti();
        tulostaKortit("Pekka", pekanKortti, "Matti", matinKortti);
        pekanKortti.syoEdullisesti();
        pekanKortti.syoEdullisesti();
        matinKortti.lataaRahaa(50);
        tulostaKortit("Pekka", pekanKortti, "Matti", matinKortti);
    }

    private static void tulostaKortit(String nimi1, Maksukortti kortti1, String nimi2, Maksukortti kortti2) {
        System.out.println(nimi1 +": " +kortti1);
        System.out.println(nimi2 +": " +kortti2);
    }

}
