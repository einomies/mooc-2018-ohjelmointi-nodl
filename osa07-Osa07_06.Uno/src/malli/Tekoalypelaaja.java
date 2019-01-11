//import java.util.ArrayList;
//// luo tänne luokkaan oma tekoälysi Uno-peliä varten
//public class Tekoalypelaaja implements Pelaaja {
//    // Saat luoda tarvittaessa oliomuuttujia. Jos luot konstruktorin, varmista
//    // että tekoäly toimii myös parametrittomalla konstruktorilla, eli kutsulla
//    // Tekoalypelaaja pelaaja = new Tekoalypelaaja();
//    @Override
//    public int pelaa(ArrayList<Kortti> omatKortit, Kortti paallimmaisin, String vari, Pelitilanne tilanne) {
//        for (int i = 0; i < omatKortit.size(); i++) {
//            if (omatKortit.get(i).saaPelataKortin(paallimmaisin, vari)) {
//                return i;
//            }
//        }
//        return -1;
//    }
//    @Override
//    public String valitseVari(ArrayList<Kortti> omatKortit) {
//        String[] okVarit = {"Punainen", "Vihreä", "Sininen", "Keltainen"};
//        return okVarit[0];
//    }
//    @Override
//    public String nimi() {
//        // kirjoita tänne nimimerkkisi, jonka haluat mahdollisesti näkyvän
//        // myös muualla
//        return "Esimerkki";
//    }
//}
