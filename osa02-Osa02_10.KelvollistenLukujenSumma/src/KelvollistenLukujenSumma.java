
import java.util.Scanner;

public class KelvollistenLukujenSumma {

    public static void main(String[] args) {
        final int lukuMin = -140;
        final int lukuMax = 20;
        final int lukuLopetus = 9999;
        int lukuLkm=0;
        int lukuSumma=0;
        Scanner lukija = new Scanner(System.in);
        while (true) {
            System.out.print("Syötä luku: ");
            int luku = Integer.parseInt(lukija.nextLine());
            if (luku == lukuLopetus) {
                break;
            }
            if (luku >= lukuMin && luku <= lukuMax) {
                lukuLkm++;
                lukuSumma += luku;
            } else {
                System.out.print("Kelvoton luku\n");
            }
        }
//        System.out.print("\nKelvollisia lukuja yhteensä: " +lukuLkm);
        System.out.print("\nKelvollisten lukujen summa: " +lukuSumma);
    }
}
