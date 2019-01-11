
import java.util.Scanner;

public class KahdenLuvunSummaaja {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        // Toteuta ohjelmasi tähän. Muista kysyä kaksi lukua käyttäjältä!
        
        System.out.print("Anna ensimmäinen luku: ");
        int eka = Integer.parseInt(lukija.nextLine());
        System.out.print("Anna toinen luku: ");
        int toka = Integer.parseInt(lukija.nextLine());

        int summa = eka + toka;

        System.out.println("Lukujen summa: " + summa);
    }
}
