
import java.util.Scanner;

public class Tykinkuula {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        double suurinkorkeus = 0;
        int sekunteja = 0;
        double korkeus = 0;
        
        System.out.println("Syötä tykinkuulan lähtönopeus:");
        double nopeus = Double.parseDouble(lukija.nextLine());
        System.out.println("Syötä painovoima:");
        double painovoima = Double.parseDouble(lukija.nextLine());

//        System.out.println("Sekunnit: " + sekunteja);
//        System.out.println("Nopeus: " + nopeus);
//        System.out.println("Korkeus: " + korkeus);

        System.out.println("");
        System.out.println(sekunteja + "\t" + korkeus + "\t" + nopeus);
        
        while (true) {
            korkeus = korkeus + nopeus;
            sekunteja = sekunteja + 1;
            nopeus = nopeus - painovoima;

            if (korkeus < 0) {
                break;
            }

            if (korkeus > suurinkorkeus) {
                suurinkorkeus = korkeus;
            }
            System.out.println(sekunteja + "\t" + korkeus + "\t" + nopeus);

//            System.out.println("");
//            System.out.println("Sekunnit: " + sekunteja);
//            System.out.println("Nopeus: " + nopeus);
//            System.out.println("Korkeus: " + korkeus);
        }

        System.out.println("");
        System.out.println("Tykinkuulan suurin korkeus oli " + suurinkorkeus);
    }
}
