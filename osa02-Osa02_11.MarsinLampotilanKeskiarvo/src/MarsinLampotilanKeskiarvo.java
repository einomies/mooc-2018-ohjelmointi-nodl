
import java.util.Scanner;

public class MarsinLampotilanKeskiarvo {

    public static void main(String[] args) {
        final int lukuMin = -140;
        final int lukuMax = 20;
        final int lukuLopetus = 9999;
        int lukuLkm=0;
        int lukuSumma=0;
        Scanner lukija = new Scanner(System.in);
        
        while (true) {
            System.out.print("Syötä mittaus: ");
            int luku = Integer.parseInt(lukija.nextLine());
            if (luku == lukuLopetus) {
                break;
            }
            if (luku >= lukuMin && luku <= lukuMax) {
                lukuLkm++;
                lukuSumma += luku;
            }
        }

        if (lukuLkm > 0) {
            System.out.println("Mittausten keskiarvo: " +(double)lukuSumma / (double)lukuLkm);
        } else {
            System.out.println("Mittausten keskiarvoa ei voitu laskea");
        }
    }
}
