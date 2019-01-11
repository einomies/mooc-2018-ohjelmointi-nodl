
import java.util.Scanner;

public class SyotetynLuvunTulostaja {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        int kokonaisluku = Integer.parseInt(lukija.nextLine());
        System.out.println("Syötit: " +kokonaisluku);

    }
}
