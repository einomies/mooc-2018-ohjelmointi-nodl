
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import javafx.print.Collation;

public class KiviPaperiSaksetEinoK {

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

//        ArrayList<String> pelaajanLista = luoPelaajanListaRandom();
//        ArrayList<String> pelaajanLista = luoPelaajanListaKivi();
//        ArrayList<String> pelaajanLista = luoPelaajanListaPaperi();
//        ArrayList<String> pelaajanLista = luoPelaajanListaSakset();
        ArrayList<String> pelaajanLista = luoPelaajanListaMerkkijonosta();
        int i = 0;
        int kierros = 0;

        while (true) {
            if (voitot >= voittoraja || tappiot >= voittoraja) {
                break;
            }

            System.out.println("----------------------------------------------------");
            kierros++;
            System.out.println("Kierros nro: " +kierros);

            String tietokoneenArvaus = seuraavaArvaus(muisti, viimeisimmat, kaikki);

            System.out.print("Syötä k, p tai s: ");
            String pelaajanSyote = pelaajanLista.get(i);
            System.out.println(pelaajanLista.get(i));
            i++;
            /*
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
            */
            kaikki = kaikki + pelaajanSyote;
            System.out.println("kaikki: " +kaikki);

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
            tulostaMuisti(muisti);
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

    private static void tulostaMuisti(HashMap<String, Integer> muisti) {
        System.out.println("HashMap muisti kierroksen jälkeen:");
        int i = 1;
        String alkunollat="";
        for (Map.Entry<String, Integer> entry : muisti.entrySet()) {
            if (i < 10) {
                alkunollat="0";
            } else {
                alkunollat="";
            }
            System.out.println("("+alkunollat+i+")" +" key=" +entry.getKey() +" value=" +entry.getValue());
            i++;
        }
    }

    private static ArrayList<String> luoPelaajanListaMerkkijonosta() {
        String s1 = "kkkkkkkkkksssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss";
        String s = s1.replaceAll("\\s+","");
        ArrayList<String> lista = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            lista.add(s.substring(i, i+1));
        }
        return lista;
    }

    private static ArrayList<String> luoPelaajanListaRandom() {
        ArrayList<String> lista = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            lista.add(satunnainen());
        }
        return lista;
    }
    private static String satunnainen() {
        Random random = new Random();
        int luku = random.nextInt(3);
        switch (luku) {
            case 0:
                return "k";
            case 1:
                return "p";
            case 2:
                return "s";
            default:
                return "k";
        }
    }

    private static ArrayList<String> luoPelaajanListaKivi() {
        ArrayList<String> lista = luoPelaajanListaSama("k");
        return lista;
    }
    private static ArrayList<String> luoPelaajanListaPaperi() {
        ArrayList<String> lista = luoPelaajanListaSama("p");
        return lista;
    }
    private static ArrayList<String> luoPelaajanListaSakset() {
        ArrayList<String> lista = luoPelaajanListaSama("s");
        return lista;
    }
    private static ArrayList<String> luoPelaajanListaSama(String valinta) {
        ArrayList<String> lista = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            lista.add(valinta);
        }
        return lista;
    }

}
