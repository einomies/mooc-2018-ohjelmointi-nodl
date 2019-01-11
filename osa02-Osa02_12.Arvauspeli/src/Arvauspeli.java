
import java.util.Scanner;

public class Arvauspeli {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        int arvattava = 7;
        int arvausLkm = 0;
        int lukuMin = 1;
        int lukuMax = 10;

        System.out.println("Minäpä tiedän luvun väliltä 1-10, jota sinä et tiedä!");
        
        while (true) {
            System.out.print("Arvaa luku: ");
            int luku = Integer.parseInt(lukija.nextLine());
            if (luku == arvattava) {
                arvausLkm++;
                break;
            }
            if (luku >= lukuMin && luku <= lukuMax) {
                arvausLkm++;
                System.out.println("Ei ollut!");
            } else {
                System.out.println("Epäkelpo luku!");
            }
        }

        System.out.println("Oikein! Arvauksia yhteensä: " +arvausLkm);

    }
}
