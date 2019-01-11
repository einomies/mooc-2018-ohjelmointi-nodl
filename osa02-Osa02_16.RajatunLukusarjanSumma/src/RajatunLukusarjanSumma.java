
import java.util.Scanner;

public class RajatunLukusarjanSumma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        int luku;
        int lukuMin, lukuMax;
        int tulos = 0;

        System.out.println("Ensimmäinen: ");
        luku = Integer.parseInt(lukija.nextLine());

        System.out.println("Viimeinen: ");
        lukuMax = Integer.parseInt(lukija.nextLine());

        while (luku <= lukuMax) {
            tulos += luku;
            luku++;
        }
        
        System.out.println("Summa on " +tulos);
    }
}
