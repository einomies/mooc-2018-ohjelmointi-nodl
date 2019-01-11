import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Submission {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        
        HashMap<Integer, String> tuotteet = new HashMap<>();

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
                System.out.println("tuotekoodi\tnimi");
                System.out.println("----------\t-------------------------");
                tuotteet.entrySet().forEach((entry) -> {
                    Integer key = entry.getKey();
                    String value = entry.getValue();
                    System.out.println(key +"\t\t" +value);
                });
            }
            if (komento.equals("hae")) {
                System.out.print("Anna tuotekoodi (kokonaisluku): ");
                int koodi = Integer.parseInt(lukija.nextLine());
                if (tuotteet.containsKey(koodi)) {
                    System.out.println(tuotteet.get(koodi));
                } else {
                    System.out.println("Tuotekoodia " +koodi +" ei löydy.");
                }
            }
            if (komento.equals("lisaa")) {
                System.out.print("Anna tuotekoodi (kokonaisluku): ");
                int koodi = Integer.parseInt(lukija.nextLine());
                System.out.print("Anna tuotteen nimi: ");
                String nimi = lukija.nextLine();
                if (tuotteet.containsKey(koodi)) {
                    System.out.println("Tuotekoodi " +koodi +" on jo olemassa.");
                } else {
                    tuotteet.put(koodi, nimi);
                }
            }
            if (komento.equals("paivita")) {
                System.out.print("Anna tuotekoodi (kokonaisluku): ");
                int koodi = Integer.parseInt(lukija.nextLine());
                System.out.print("Anna tuotteen nimi: ");
                String nimi = lukija.nextLine();
                if (tuotteet.containsKey(koodi)) {
                    tuotteet.put(koodi, nimi);
                } else {
                    System.out.println("Tuotekoodia " +koodi +" ei löydy.");
                }
            }
            if (komento.equals("poista")) {
                System.out.print("Anna tuotekoodi (kokonaisluku): ");
                int koodi = Integer.parseInt(lukija.nextLine());
                if (tuotteet.containsKey(koodi)) {
                    tuotteet.remove(koodi);
                    System.out.println("Poistettu.");
                } else {
                    System.out.println("Tuotekoodia " +koodi +" ei löydy.");
                }
            }
        }
    }

    private static void luoAlkutilanne(HashMap<Integer, String> map) {
        map.put(0, "nolla (testituote)");
        map.put(1, "välikaapeli 15 cm");
        map.put(2, "välikaapeli 30 cm");
        map.put(3, "capo");
        map.put(4, "kielisetti 10-46");
        map.put(5, "kielisetti 11-52");
        map.put(6, "xxxxxxxxxxxxxxxxx");
    }

}
