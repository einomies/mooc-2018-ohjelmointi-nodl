import java.util.Scanner;
import java.util.HashMap;

public class TuotteetMain {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        Tuotteet tuotteet = new Tuotteet();

        luoAlkutilanne(tuotteet);

        System.out.println("Komennot:");
        System.out.println("\tlistaa  - listaa kaikki tuotteet");
        System.out.println("\thae     - hae yksittäinen tuote tuotekoodilla");
        System.out.println("\tlisaa   - lisää tuote listaan");
        System.out.println("\tpaivita - päivitä tuotteen nimi");
        System.out.println("\tpoista  - poista tuote tuotekoodin perusteella");
        System.out.println("\tlopeta  - lopettaa ohjelman");

        while (true) {
            System.out.println();
            System.out.print("Komento: ");
            String komento = lukija.nextLine();
            if (komento.equals("lopeta")) {
                break;
            }
            if (komento.equals("listaa")) {
                tuotteet.listaa();
            }
            if (komento.equals("hae")) {
                int koodi = kysyTuotekoodi(lukija);
                System.out.println(tuotteet.hae(koodi));
            }
            if (komento.equals("lisaa")) {
                int koodi = kysyTuotekoodi(lukija);
                String nimi = kysyTuotenimi(lukija);
                tuotteet.lisaa(koodi, nimi);
            }
            if (komento.equals("paivita")) {
                int koodi = kysyTuotekoodi(lukija);
                String nimi = kysyTuotenimi(lukija);
                tuotteet.paivita(koodi, nimi);
            }
            if (komento.equals("poista")) {
                int koodi = kysyTuotekoodi(lukija);
                tuotteet.poista(koodi);
            }
        }
    }

    private static void luoAlkutilanne(Tuotteet map) {
        map.lisaa(0, "nolla (testituote)");
        map.lisaa(1, "välikaapeli 15 cm");
        map.lisaa(2, "välikaapeli 30 cm");
        map.lisaa(3, "capo");
        map.lisaa(4, "kielisetti 10-46");
        map.lisaa(5, "kielisetti 11-52");
        map.lisaa(6, "xxxxxxxxxxxxxxxxx");
    }

    private static int kysyTuotekoodi(Scanner lukija) {
        System.out.print("Anna tuotekoodi (kokonaisluku): ");
        return Integer.parseInt(lukija.nextLine());
    }

    private static String kysyTuotenimi(Scanner lukija) {
        System.out.print("Anna tuotteen nimi: ");
        return lukija.nextLine();
    }

}
