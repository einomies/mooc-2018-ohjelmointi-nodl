
import java.util.Scanner;

public class MihinJaMista {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        int luku;
        int lukuMax;

        System.out.println("Mihin asti? ");
        lukuMax = Integer.parseInt(lukija.nextLine());

        System.out.println("Mistä lähtien? ");
        luku = Integer.parseInt(lukija.nextLine());

        while (luku <= lukuMax) {
            System.out.println(luku);
            luku++;
        }
    }
}
