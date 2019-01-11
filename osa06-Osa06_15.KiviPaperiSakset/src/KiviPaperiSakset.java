
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import javafx.print.Collation;

public class KiviPaperiSakset {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        HashMap<String, Integer> muisti = new HashMap<>();
        String viimeisimmat = "";
        String kaikki = "";
        String avain = "";

        final int voittoraja = 25;

        int voitot = 0;
        int tappiot = 0;
        int tasapelit = 0;

        while (true) {
            if (voitot >= voittoraja || tappiot >= voittoraja) {
                break;
            }

            String tietokoneenArvaus = seuraavaArvaus(muisti, viimeisimmat, kaikki);

            System.out.print("Syötä k, p tai s: ");
            String pelaajanSyote = lukija.nextLine();
            if (!pelaajanSyote.equalsIgnoreCase("k") 
                    && !pelaajanSyote.equalsIgnoreCase("p") 
                    && !pelaajanSyote.equalsIgnoreCase("s")) {
                if (pelaajanSyote.equals("000")) {
                    break;
                } else {
                    System.out.println("Väärä arvo. Syötä k, p tai s");
                    System.out.println("");
                    continue;
                }
            }

            kaikki = kaikki + pelaajanSyote;

            switch (kaikki.length()) {
                case 0:
                    break;
                case 1:
                    viimeisimmat = kaikki;
                    break;
                case 2:
                    viimeisimmat = kaikki;
                    break;
                default:
                    viimeisimmat = kaikki.substring(kaikki.length()-2, kaikki.length());
                    avain = kaikki.substring(kaikki.length()-3, kaikki.length());
                    if (muisti.containsKey(avain)) {
                        Integer lkm = muisti.get(avain);
                        lkm++;
                        muisti.put(avain, lkm);
                    } else {
                        muisti.putIfAbsent(avain, 1);
                    }
                    break;
            }

            if (tasapeli(pelaajanSyote, tietokoneenArvaus)) {
                tasapelit++;
            } else if (pelaajaVoitti(pelaajanSyote, tietokoneenArvaus)) {
                tappiot++;
            } else if (pelaajaHavisi(pelaajanSyote, tietokoneenArvaus)) {
                voitot++;
            } else {
                System.out.println("Epämääräinen pelitilanne. Pelaaja valitsi " + pelaajanSyote + ", tietokone arvasi " + tietokoneenArvaus);
            }

            System.out.println("Pelaaja: " + pelaajanSyote + ", tekoäly: " + tietokoneenArvaus + ".");
            System.out.println("Tietokoneen voitot: " + voitot);
            System.out.println("Pelaajan voitot: " + tappiot);
            System.out.println("Tasapelit: " + tasapelit);

            System.out.println();
        }

        System.out.println("Peli päättyi.");
    }

    public static String seuraavaArvaus(HashMap<String, Integer> muisti, String viimeisimmat, String kaikki) {
//        System.out.println("KiviPaperiSakset.seuraavaArvaus() viimeisimmat: " +viimeisimmat);
//        System.out.println("KiviPaperiSakset.seuraavaArvaus() muisti.size(): " +muisti.size());
        if (kaikki.length() < 3) {
            return "k";
        }

        String viimKivi = viimeisimmat + "k";
        String viimPaperi = viimeisimmat + "p";
        String viimSakset = viimeisimmat + "s";
        
        int viimKiviLkm = 0;
        int viimPaperiLkm = 0;
        int viimSaksetLkm = 0;
        String arvaus = "k";
        int viimValueMax = 0;
        /*
        Sopivan valinnan etsiminen tehdään tarkastelemalla käyttäjän kahta viimeistä
        syötettä ja vertailemalla niitä koko historiaan. Mikäli historian mukaan
        kahta viimeistä syötettä seuraa useimmin kivi, tekoälyn tulee pelata paperi.
        Mikäli kahta viimeistä syötettä seuraa useimmin paperi, tekoälyn tulee 
        pelata sakset. Mikäli taas kahta viimeistä syötettä seuraa useimmin sakset, 
        tekoälyn tulee pelata kivi. Muissa tapauksissa pelataan kivi.
        */
        if (muisti.containsKey(viimKivi)) {
            viimKiviLkm = muisti.get(viimKivi);
        }
        if (muisti.containsKey(viimPaperi)) {
            viimPaperiLkm = muisti.get(viimPaperi);
        }
        if (muisti.containsKey(viimSakset)) {
            viimSaksetLkm = muisti.get(viimSakset);
        }

        if (viimKiviLkm > viimPaperiLkm && viimKiviLkm > viimSaksetLkm) {
            return "p";
        }
        if (viimPaperiLkm > viimKiviLkm && viimPaperiLkm > viimSaksetLkm) {
            return "s";
        }
        if (viimSaksetLkm > viimKiviLkm && viimSaksetLkm > viimPaperiLkm) {
            return "k";
        }

        return arvaus;
    }

    public static boolean tasapeli(String pelaaja, String tietokone) {
        return pelaaja.equals(tietokone);
    }

    public static boolean pelaajaVoitti(String pelaaja, String tietokone) {
        return ekaVoitti(pelaaja, tietokone);
    }

    public static boolean pelaajaHavisi(String pelaaja, String tietokone) {
        return ekaVoitti(tietokone, pelaaja);
    }

    public static boolean ekaVoitti(String eka, String toka) {
        if (eka.equalsIgnoreCase("k") && toka.equalsIgnoreCase("s")) {
            return true;
        }
        if (eka.equalsIgnoreCase("p") && toka.equalsIgnoreCase("k")) {
            return true;
        }
        if (eka.equalsIgnoreCase("s") && toka.equalsIgnoreCase("p")) {
            return true;
        }
        return false;
    }

}

/*
import java.util.HashMap;
import java.util.Scanner;

public class KiviPaperiSakset {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        HashMap<String, Integer> muisti = new HashMap<>();
        String viimeisimmat = "";
        int voitot = 0;
        int tappiot = 0;
        int tasapelit = 0;

        while (true) {
            // peli päättyy kun jommalla kummalla on yli 25 pistettä
            if (voitot >= 25 || tappiot >= 25) {
                break;
            }
            if (viimeisimmat.length() > 2) {
                viimeisimmat = viimeisimmat.substring(1);
            }

            String tietokoneenArvaus = seuraavaArvaus(muisti, viimeisimmat);
            System.out.print("Syötä k, p tai s: ");
            String pelaajanSyote = lukija.nextLine();

            if (!pelaajanSyote.equals("k") && !pelaajanSyote.equals("p") && !pelaajanSyote.equals("s")) {
                System.out.println("höpönlöpön..");
                continue;
            }

            if (tasapeli(pelaajanSyote, tietokoneenArvaus)) {
                tasapelit++;
            } else if (pelaajaVoitti(pelaajanSyote, tietokoneenArvaus)) {
                tappiot++;
            } else if (pelaajaHavisi(pelaajanSyote, tietokoneenArvaus)) {
                voitot++;
            } else {
                System.out.println("Epämääräinen pelitilanne. Pelaaja valitsi " + pelaajanSyote + ", tietokone arvasi " + tietokoneenArvaus);
            }

            viimeisimmat += pelaajanSyote;
            muisti.put(viimeisimmat, muisti.getOrDefault(viimeisimmat, 0) + 1);
            System.out.println("Pelaaja: " + pelaajanSyote + ", tekoäly: " + tietokoneenArvaus + ".");
            System.out.println("Tietokoneen voitot: " + voitot);
            System.out.println("Pelaajan voitot: " + tappiot);
            System.out.println("Tasapelit: " + tasapelit);
            System.out.println();
        }
        System.out.println("Peli päättyi.");
    }

    public static String seuraavaArvaus(HashMap<String, Integer> muisti, String viimeisimmat) {
        if (viimeisimmat.length() < 2) {
            return "k";
        }

        int kivi = muisti.getOrDefault(viimeisimmat + "k", 0);
        int paperi = muisti.getOrDefault(viimeisimmat + "p", 0);
        int sakset = muisti.getOrDefault(viimeisimmat + "s", 0);

        if (kivi > paperi && kivi > sakset) {
            return "p";
        } else if (paperi > kivi && paperi > sakset) {
            return "s";
        } else if (sakset > kivi && sakset > paperi) {
            return "k";
        }
        return "k";
    }

    public static boolean tasapeli(String pelaaja, String tietokone) {
        return pelaaja.equals(tietokone);
    }

    public static boolean pelaajaVoitti(String pelaaja, String tietokone) {
        return ekaVoitti(pelaaja, tietokone);
    }

    public static boolean pelaajaHavisi(String pelaaja, String tietokone) {
        return ekaVoitti(tietokone, pelaaja);
    }

    public static boolean ekaVoitti(String eka, String toka) {
        if (eka.equals("k") && toka.equals("s")) {
            return true;
        }
        if (eka.equals("p") && toka.equals("k")) {
            return true;
        }
        if (eka.equals("s") && toka.equals("p")) {
            return true;
        }
        return false;
    }
}
*/