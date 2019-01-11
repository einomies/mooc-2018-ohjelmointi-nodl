
import java.util.Scanner;

public class IanTarkistus {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        final int alaraja = 0;
        final int ylaraja = 120;
        int ika;

        System.out.print("Kuinka vanha olet? ");
        ika = Integer.parseInt(lukija.nextLine());
        
        if (ika >= alaraja && ika <= ylaraja) {
            System.out.println("OK");
        } else {
            System.out.println("Mahdotonta!");
        }
    }
}
