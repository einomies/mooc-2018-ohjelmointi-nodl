
import java.util.Scanner;

public class TulostusKolmesti {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        System.out.println("Mikä tulostetaan? ");
        String merkkijono = lukija.nextLine();
        
        tulosta(merkkijono, 3);
    }

    private static void tulosta(String merkkijono, int lkm) {
        for (int i = 0; i < lkm; i++) {
            System.out.print(merkkijono);
        }
    }
}
