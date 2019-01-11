
import java.util.Scanner;

public class Main {

    /*
Kirjoita ohjelma, joka kysyy käyttäjältä suorakulmion leveyttä ja korkeutta, ja tulostaa x-merkeistä muodostuvan suorakulmion.

Leveys: 4
Korkeus: 2

xxxx
xxxx

Leveys: 4
Korkeus: 3

xxxx
xxxx
xxxx
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Leveys: ");
        int leveys = Integer.parseInt(scanner.nextLine());

        System.out.print("Korkeus: ");
        int korkeus = Integer.parseInt(scanner.nextLine());

        final String merkki = "x";

        System.out.println();

        for (int k = 0; k < korkeus; k++) {
            for (int l = 0; l < leveys; l++) {
                System.out.print(merkki);
            }
            System.out.print("\n");
        }

    }

}
