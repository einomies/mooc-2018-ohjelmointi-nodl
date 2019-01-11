import java.util.Scanner;

public class PuhelinmuistioSovellus {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        Puhelinmuistio muistio = new Puhelinmuistio();

//        System.out.print("Minkä niminen tiedosto ladataan? ");
//        String latausnimi = lukija.nextLine();
//        muistio.lataa(latausnimi);
//        muistio.lataa("gc01.tsv");
        muistio.lataa("nimet.tsv");

        String etunimi;
        String sukunimi;
        String puhelinnumero;
        
        while (true) {
            System.out.println("");
            System.out.println("Puhelinmuistio");
            System.out.println("Komennot:");
            System.out.println("\tlopeta  - lopettaa puhelinmuistion");
            System.out.println("\tlisaa   - lisää uuden henkilön puhelinmuistioon");
            System.out.println("\tlistaa  - listaa puhelinmuistion sisällön");
            System.out.println("\tetsi    - etsii puhelinmuistiosta annettua numeroa");
            System.out.println("\tpoista  - poistaa henkilön puhelinmuistiosta");
            System.out.println("");
            System.out.print("Anna komento: ");

            String komento = lukija.nextLine();

            if (komento.equalsIgnoreCase("lopeta")) {
                break;
            }
            
            if (komento.equalsIgnoreCase("lisaa")) {
                System.out.print("etunimi: ");
                etunimi = lukija.nextLine();
                System.out.print("sukunimi: ");
                sukunimi = lukija.nextLine();
                System.out.print("puhelinnumero: ");
                puhelinnumero = lukija.nextLine();
                muistio.lisaa(etunimi, sukunimi, puhelinnumero);
            }
            
            if (komento.equalsIgnoreCase("listaa")) {
                muistio.listaa();
            }
            
            if (komento.equalsIgnoreCase("etsi")) {
                System.out.print("Mitä numeroa etsitään? ");
                String merkkijono = lukija.nextLine();
                if (merkkijono.equals("")) {
                    System.out.println("xxxxxxxxxxxxxxx");
                } else {
                    muistio.etsiPuhelinnumerolla(merkkijono);
                }
//                muistio.etsiEtunimella(merkkijono);
//                muistio.etsiSukunimella(merkkijono);
            }
            
            if (komento.equalsIgnoreCase("poista")) {
                System.out.print("etunimi: ");
                etunimi = lukija.nextLine();
                System.out.print("sukunimi: ");
                sukunimi = lukija.nextLine();
                if (etunimi.equals("") || sukunimi.equals("")) {
                    System.out.println("xxxxxxxxxxxxxxx");
                } else {
                    muistio.poista(etunimi, sukunimi);
                }
            }
        }
        
        muistio.tallenna("nimet-2.tsv");
        // tee toteutuksesi tänne
//        System.out.print("Minkä nimiseen tiedostoon muistio tallennetaan?");
//        String tallennusnimi = lukija.nextLine();
//        muistio.tallenna(tallennusnimi);
    }

}
