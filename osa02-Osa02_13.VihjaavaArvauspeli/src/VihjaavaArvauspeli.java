
import java.util.Scanner;

public class VihjaavaArvauspeli {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        int arvattava = 42;
        int arvausLkm = 0;
        int lukuMin = 1;
        int lukuMax = 100;

        System.out.println("Minäpä tiedän luvun väliltä " +lukuMin +"-" +lukuMax +", jota sinä et tiedä!");
        
        while (true) {
            System.out.print("Arvaa luku: ");
            int luku = Integer.parseInt(lukija.nextLine());
            if (luku == arvattava) {
                arvausLkm++;
                break;
            }
            if (luku >= lukuMin && luku <= lukuMax) {
                arvausLkm++;
                if (arvattava > luku) {
                    System.out.println("Lukuni on isompi!");
                } else {
                    System.out.println("Lukuni on pienempi!");
                }
            } else {
                System.out.println("Epäkelpo luku!");
            }
        }

        System.out.println("Oikein! Arvauksia yhteensä: " +arvausLkm);

    }
}
