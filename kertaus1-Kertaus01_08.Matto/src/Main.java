
import java.util.Scanner;

public class Main {

    /*
Kirjoita ohjelma, joka kysyy käyttäjältä maton leveyttä ja korkeutta, ja tulostaa x-merkeistä koostuvan maton,
jonka joka toisella rivillä joka toinen merkki on o.

Leveys: 4
Korkeus: 2

xxxx
xoxo

Leveys: 5
Korkeus: 5

xxxxx
xoxox
xxxxx
xoxox
xxxxx
     */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Leveys: ");
        int leveys = Integer.parseInt(scanner.nextLine());

        System.out.print("Korkeus: ");
        int korkeus = Integer.parseInt(scanner.nextLine());

        final String merkki1 = "x";
        final String merkki2 = "o";

        System.out.println();

        for (int k = 0; k < korkeus; k++) {
            for (int l = 0; l < leveys; l++) {
                if (k % 2 == 0) {
                    System.out.print(merkki1);
                } else {
                    if (l % 2 == 0) {
                        System.out.print(merkki1);
                    } else {
                        System.out.print(merkki2);
                    }
                }
            }
            System.out.print("\n");
        }
    }

}
