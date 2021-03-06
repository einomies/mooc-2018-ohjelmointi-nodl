//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
///*
//Uno-pakassa on 108 korttia:
//19 punaista korttia 0–9
//19 vihreää korttia 0–9
//19 sinistä korttia 0–9
//19 keltaista korttia 0–9
//8 nosta kaksi -korttia (kaksi kutakin väriä)
//8 suunnanvaihto -korttia (kaksi kutakin väriä)
//8 ohituskorttia (kaksi kutakin väriä)
//4 villikorttia (näillä saa vaihtaa väriä)
//4 villi + nosta neljä -korttia (näillä saa vaihtaa väriä)
// */
//public class Pakka {
//    private ArrayList<Kortti> kortit;
//    public Pakka() {
//        this.kortit = new ArrayList<>();
//    }
//    public boolean sisaltaaKortteja() {
//        return !this.kortit.isEmpty();
//    }
//    public void sekoita() {
//        Collections.shuffle(this.kortit);
//    }
//    public Kortti otaKortti() {
//        return this.kortit.remove(0);
//    }
//    public void palautaKortti(Kortti kortti) {
//        this.kortit.add(kortti);
//    }
//    public void alusta() {
//        this.kortit.clear();
//        String[] varit = {"Punainen", "Vihreä", "Sininen", "Keltainen"};
//        String[] korttityypit = {"Numero", "Ohitus", "Suunnanvaihto", "Nosta 2", "Villi kortti", "Villi kortti + Nosta 4"};
//        // lisätään villit kortit pakkaan
//        for (int i = 0; i < 4; i++) {
//            this.kortit.add(new Kortti(korttityypit[5], "-", -1));
//            this.kortit.add(new Kortti(korttityypit[4], "-", -1));
//        }
//        // lisätään muut toimintakortit pakkaan
//        for (String vari : varit) {
//            this.kortit.add(new Kortti(korttityypit[3], vari, -1));
//            this.kortit.add(new Kortti(korttityypit[3], vari, -1));
//            this.kortit.add(new Kortti(korttityypit[2], vari, -1));
//            this.kortit.add(new Kortti(korttityypit[2], vari, -1));
//            this.kortit.add(new Kortti(korttityypit[1], vari, -1));
//            this.kortit.add(new Kortti(korttityypit[1], vari, -1));
//        }
//        // lisätään numerokortit pakkaan -- nollia on kutakin väriä yksi,
//        // muita kaksi
//        for (String vari : varit) {
//            this.kortit.add(new Kortti(korttityypit[0], vari, 0));
//            for (int numero = 1; numero <= 9; numero++) {
//                this.kortit.add(new Kortti(korttityypit[0], vari, numero));
//                this.kortit.add(new Kortti(korttityypit[0], vari, numero));
//            }
//        }
//        sekoita();
//    }
//}
//src/Pelaaja.java
//import java.util.ArrayList;
///*
//Pelaaja-rajapinta määrittelee niiden metodien nimet, jotkajokaisen tekoälyn
//tulee toteuttaa. Palaamme termiin rajapinta kurssin myöhemmissä osissa.
//Täällä olevissa metodeissa ei ole toteutusta.
// */
//public interface Pelaaja {
//    /**
//     * Metodia pelaa kutsutaan kun on pelaajan vuoro ja pelaajan tulee valita
//     * seuraavaksi pelattava kortti.
//     *
//     * Parametri omatKortit sisältää pelaajan omat kortit, parametri
//     * paallimmainen kertoo päällimmäisenä näkyvän kortin ja parametri vari
//     * kertoo odotetun värin. Väri kerrotaan esimerkiksi jos edellinen pelaaja
//     * on pelannut Villin kortin, jolla voi valita värin uudestaan.
//     *
//     * Metodin tulee palauttaa sen kortin indeksi, jonka haluat pelata. Jos et
//     * voi pelata mitään korttia, palauta arvo -1. Tässä tapauksessa käteesi
//     * lisätään uusi kortti.
//     */
//    public int pelaa(ArrayList<Kortti> omatKortit, Kortti paallimmainen, String vari, Pelitilanne tilanne);
//    /**
//     * Metodia valitseVari kutsutaan jos olet juuri pelannut villin kortin.
//     * Tällöin sinun tulee kertoa mihin väriin haluat vaihtaa.
//     *
//     * Värin tulee olla sallittu väri, eli joku joukosta "Punainen", "Vihrea",
//     * "Sininen", "Keltainen"
//     */
//    public String valitseVari(ArrayList<Kortti> omatKortit);
//    /**
//     * Metodi nimi kertoo minkä nimiseksi haluat tekoälyäsi kutsuttavan. Nimi
//     * saattaa näkyä myöhemmin jonkinlaisessa turnauslistauksessa -- ei
//     * törkeyksiä kiitos :).
//     */
//    public String nimi();
//}
