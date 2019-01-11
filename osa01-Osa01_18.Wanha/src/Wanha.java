
import java.util.Scanner;

public class Wanha {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        // Toteuta ohjelmasi tähän.
        System.out.print("Anna vuosiluku: ");
        int luku = Integer.parseInt(lukija.nextLine());

        if (luku < 2015) {
            System.out.println("Wanha!");
        }
    }
}
