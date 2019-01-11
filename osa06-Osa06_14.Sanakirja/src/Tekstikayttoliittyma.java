import java.util.ArrayList;
import java.util.Scanner;

public class Tekstikayttoliittyma {
    
    private Scanner scanner;
    private Sanakirja sanakirja;
    
    public Tekstikayttoliittyma(Scanner lukija, Sanakirja sanakirja) {
        this.scanner = lukija;
        this.sanakirja = sanakirja;
    }
    
    public void kaynnista() {
        lisaaSanat();
        tulostaSanat();
        System.out.println("");
        alkuvalikko();
        kysyValinta();
    }
    
    private static void alkuvalikko() {
        System.out.println("Komennot:");
        System.out.println("lisaa - lisää sanaparin sanakirjaan");
        System.out.println("kaanna - kysyy sanan ja tulostaa sen käännöksen");
        System.out.println("lopeta - poistuu käyttöliittymästä");
    }

    private void kysyValinta() {
        String valinta=null;
        while (true) {
            System.out.println("");
            System.out.print("Komento: ");
            valinta = this.scanner.nextLine();
            
            if (valinta.equals("lopeta")) {
                System.out.println("Hei hei!");
                break;
            }
            
            if (valinta.equals("lisaa")) {
                System.out.print("Suomeksi: ");
                String suomeksi = this.scanner.nextLine();
                System.out.print("Käännös: ");
                String kaannos = this.scanner.nextLine();
                this.sanakirja.lisaa(suomeksi, kaannos);
            } else if (valinta.equals("kaanna")) {
                System.out.print("Anna sana: ");
                String suomeksi = this.scanner.nextLine();
                System.out.println("Käännös: " +this.sanakirja.kaanna(suomeksi));
                /*
                Anna sana: porkkana
                Käännös: carrot
                */
            } else {
                System.out.println("Tuntematon komento");
            }
        }
    }

    private void lisaaSanat() {
        this.sanakirja.lisaa("kitara", "guitar");
        this.sanakirja.lisaa("auto", "car");
        this.sanakirja.lisaa("puhelin", "phone");
        this.sanakirja.lisaa("etsiä", "seek");
        this.sanakirja.lisaa("tuhota", "destroy");
        this.sanakirja.lisaa("koira", "dog");
        this.sanakirja.lisaa("syödä", "eat");
        this.sanakirja.lisaa("kynä", "pen");
        this.sanakirja.lisaa("tylsä", "dull");
        this.sanakirja.lisaa("hiiri", "mouse");
        this.sanakirja.lisaa("paska", "shit");
        this.sanakirja.lisaa("takapiha", "backyard");
        this.sanakirja.lisaa("jääkaappi", "refrigerator");
        this.sanakirja.lisaa("sukka", "sock");
        this.sanakirja.lisaa("rintaliivit", "bra");
        this.sanakirja.lisaa("aasi", "ass");
        this.sanakirja.lisaa("kissa", "cat");
        this.sanakirja.lisaa("nukkua", "sleep");
    }

    private void tulostaSanat() {
        ArrayList<String> lista = this.sanakirja.kaannoksetListana();
        for (String rivi : lista) {
            System.out.println(rivi);
        }
    }
    
}

/*
import java.util.Scanner;

public class Tekstikayttoliittyma {

    private Scanner lukija;
    private Sanakirja sanakirja;

    public Tekstikayttoliittyma(Scanner lukija, Sanakirja sanakirja) {
        this.lukija = lukija;
        this.sanakirja = sanakirja;
    }

    public void kaynnista() {
        System.out.println("Komennot:");
        System.out.println("  lisaa - lisää sanaparin sanakirjaan");
        System.out.println("  kaanna - kysyy sanan ja tulostaa sen käännöksen");
        System.out.println("  lopeta - poistuu käyttöliittymästä");
        System.out.println("");
        while (true) {
            System.out.print("Komento: ");
            String syote = lukija.nextLine();
            if (syote.equals("lopeta")) {
                break;
            }
            hoidaKomento(syote);
            System.out.println("");
        }
        System.out.println("Hei hei!");
    }

    private void hoidaKomento(String komento) {
        if (komento.equals("lisaa")) {
            lisaa();
        } else if (komento.equals("kaanna")) {
            kaanna();
        } else {
            System.out.println("Tuntematon komento.");
        }
    }

    private void lisaa() {
        System.out.print("Suomeksi: ");
        String sana = this.lukija.nextLine();
        System.out.print("Käännös: ");
        String kaannos = this.lukija.nextLine();
        this.sanakirja.lisaa(sana, kaannos);
    }

    private void kaanna() {
        System.out.print("Anna sana: ");
        String sana = this.lukija.nextLine();
        if (this.sanakirja.kaanna(sana) == null) {
            System.out.println("Tuntematon sana!");
        } else {
            System.out.println("Käännös: " + this.sanakirja.kaanna(sana));
        }
    }
}
*/