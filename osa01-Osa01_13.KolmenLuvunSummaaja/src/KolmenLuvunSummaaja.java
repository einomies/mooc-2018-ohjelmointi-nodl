
import java.util.Scanner;

public class KolmenLuvunSummaaja {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        // Toteuta ohjelmasi tähän. Muista kysyä kolmea lukua käyttäjältä!

        System.out.print("Anna ensimmäinen luku: ");
        int eka = Integer.parseInt(lukija.nextLine());
        System.out.print("Anna toinen luku: ");
        int toka = Integer.parseInt(lukija.nextLine());
        System.out.print("Anna kolmas luku: ");
        int kolmas = Integer.parseInt(lukija.nextLine());

        int summa = eka + toka + kolmas;

        System.out.println("Lukujen summa: " + summa);
    }
}
