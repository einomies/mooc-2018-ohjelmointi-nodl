
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reseptihaku {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        System.out.print("Mistä luetaan? ");
        String tiedosto = lukija.nextLine();
//        String tiedosto = "reseptit.txt";
//        System.out.print(tiedosto);
        
//        ArrayList<String> lista = new ArrayList<>();
        ArrayList<Resepti> reseptit = new ArrayList<>();

        try (Scanner tiedostonLukija = new Scanner(new File(tiedosto))) {
            while (tiedostonLukija.hasNextLine()) {
                Resepti resepti = new Resepti(tiedostonLukija.nextLine());
                reseptit.add(resepti);
                
                int reseptiRivi = 0;
                while (tiedostonLukija.hasNextLine()) {
                    if (reseptiRivi == 0) {
                        resepti.setKokkausaika(Integer.parseInt(tiedostonLukija.nextLine()));
                        reseptiRivi++;
                    } else {
                        String raakaAine = tiedostonLukija.nextLine();
                        if (raakaAine.isEmpty()) {
                            break;
                        }
                        resepti.lisaaRaakaAine(raakaAine);
                    }
                }
            }

            System.out.println("");
            System.out.println("Komennot:");
            System.out.println("listaa - listaa reseptit");
            System.out.println("lopeta - lopettaa ohjelman");
            System.out.println("hae nimi - hakee reseptiä nimen perusteella");
            System.out.println("hae keittoaika - hakee reseptiä keittoajan perusteella");
            System.out.println("hae aine - hakee reseptiä raaka-aineen perusteella");
            System.out.println("");
            
            String komento = "";

            while (!komento.equals("lopeta")) {

                System.out.println("");
                System.out.print("Syötä komento: ");
                komento = lukija.nextLine();

                if (komento.equals("listaa")) {
                    System.out.println("");
                    System.out.println("Reseptit:");

                    for (Resepti resepti : reseptit) {
                        System.out.println(resepti.tulostaOtsikko());
                    }
                } else if (komento.equals("hae nimi")) {
                    System.out.print("Mitä haetaan: ");
                    String hakusana = lukija.nextLine();
                    
                    System.out.println("");
                    System.out.println("Reseptit:");
                    
                    for (Resepti resepti : reseptit) {
                        if (resepti.getNimi().contains(hakusana)) {
                            System.out.println(resepti.tulostaOtsikko());
                        }
                    }
                } else if (komento.equals("hae keittoaika")) {
                    System.out.print("Keittoaika korkeintaan: ");
                    int aika = Integer.parseInt(lukija.nextLine());
                    
                    System.out.println("");
                    System.out.println("Reseptit:");
                    
                    for (Resepti resepti : reseptit) {
                        if (resepti.getKokkausaika() <= aika) {
                            System.out.println(resepti.tulostaOtsikko());
                        }
                    }
                } else if (komento.equals("hae aine")) {
                    System.out.print("Mitä raaka-ainetta haetaan: ");
                    String hakusana = lukija.nextLine();
                    
                    System.out.println("");
                    System.out.println("Reseptit:");
                    
                    for (Resepti resepti : reseptit) {
                        for (int i = 0; i < resepti.getRaakaAineet().size(); i++) {
//                            if (resepti.getRaakaAineet().get(i).contains(hakusana)) {
                            if (resepti.getRaakaAineet().get(i).equals(hakusana)) {
                                System.out.println(resepti.tulostaOtsikko());
                            }
                        }
                    }
                }
            }

        } catch (IOException ex) {
            System.out.println("Tiedoston " + tiedosto + " lukeminen epäonnistui.");
            System.out.println("IOException Message: " +ex.getMessage());
        }
    }

}

/*
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Reseptihaku {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        ArrayList<Resepti> reseptit = new ArrayList<>();
        System.out.println("Mistä luetaan?");
        String tiedosto = lukija.nextLine();

        try (Scanner tiedostonLukija = new Scanner(new File(tiedosto))) {
            // luetaan reseptit ja raaka-aineet
            while (tiedostonLukija.hasNextLine()) {
                // luetaan resepti ja luodaan sitä vastaava olio
                String reseptinNimi = tiedostonLukija.nextLine();
                int reseptinAika = Integer.parseInt(tiedostonLukija.nextLine());
                Resepti resepti = new Resepti(reseptinNimi, reseptinAika);
                // lisätään resepti listalle
                reseptit.add(resepti);
                // lisätään reseptiin raaka-aineet
                while (tiedostonLukija.hasNextLine()) {
                    String raakaAine = tiedostonLukija.nextLine();
                    // reseptin raaka-aineet lopetetaan tyhjällä rivillä
                    if (raakaAine.isEmpty()) {
                        // poistutaan tästä while-toistolauseesta
                        // (ulompi jatkaa)
                        break;
                    }
                    resepti.lisaaRaakaAine(raakaAine);
                }
            }
        } catch (Exception e) {
            System.out.println("Virhe: " + e.getMessage());
        }

        System.out.println("Komennot:\n"
                + "listaa - listaa reseptit\n"
                + "lopeta - lopettaa ohjelman\n"
                + "hae nimi - hakee reseptiä nimen perusteella\n"
                + "hae keittoaika - hakee reseptiä keittoajan perusteella\n"
                + "hae aine - hakee reseptiä raaka-aineen perusteella");

        while (true) {
            System.out.print("Syötä komento: ");
            String komento = lukija.nextLine();
            if (komento.equals("lopeta")) {
                break;
            }
            if (komento.equals("listaa")) {
                System.out.println("Reseptit:");
                for (Resepti resepti : reseptit) {
                    System.out.println(resepti);
                }
            }
            if (komento.equals("hae nimi")) {
                System.out.print("Mitä haetaan: ");
                String haettava = lukija.nextLine();
                for (Resepti resepti : reseptit) {
                    if (resepti.nimiSisaltaa(haettava)) {
                        System.out.println(resepti);
                    }
                }
            }
            if (komento.equals("hae keittoaika")) {
                System.out.print("Keittoaika korkeintaan: ");
                int korkeintaan = Integer.parseInt(lukija.nextLine());
                for (Resepti resepti : reseptit) {
                    if (resepti.keittoaikaKorkeintaan(korkeintaan)) {
                        System.out.println(resepti);
                    }
                }
            }
            if (komento.equals("hae aine")) {
                System.out.print("Mitä raaka-ainetta haetaan: ");
                String aine = lukija.nextLine();
                for (Resepti resepti : reseptit) {
                    if (resepti.sisaltaaRaakaAineen(aine)) {
                        System.out.println(resepti);
                    }
                }
            }
        }
    }
}
*/