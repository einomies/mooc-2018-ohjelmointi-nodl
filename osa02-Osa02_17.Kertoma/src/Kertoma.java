import java.util.Scanner;

public class Kertoma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        int lukuMax;
        int luku = 1;
        int tulos = 1;

//        System.out.println("Ensimmäinen: ");
//        luku = Integer.parseInt(lukija.nextLine());

        System.out.println("Anna luku: ");
        lukuMax = Integer.parseInt(lukija.nextLine());

        while (luku <= lukuMax) {
            tulos *= luku;
            luku++;
        }

        System.out.println("Kertoma on " +tulos);
    }
}
