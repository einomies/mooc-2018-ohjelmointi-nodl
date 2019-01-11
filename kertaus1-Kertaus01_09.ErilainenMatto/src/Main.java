
import java.util.Scanner;

public class Main {

    /*
	 *
	 *
	 * Kirjoita ohjelma, joka kysyy käyttäjältä maton leveyttä ja korkeutta, ja
	 * tulostaa maton seuraavia sääntöjä noudattaen. Säännöt ovat
	 * tärkeysjärjestyksessä, ja tärkeintä sääntöä tulee noudattaa aina ensin:
	 *
	 * joka toisella rivillä joka toinen merkki on o
	 * joka kolmannella rivillä joka kolmas merkki on z
	 * joka viidennellä rivillä joka viides merkki on s
	 * kaikki muut merkit ovat x-muotoisia
	 *
	 * Leveys: 5 Korkeus: 3
	 *
	 * xxxxx
	 * xoxox
	 * xxzxx
	 *
	 * Leveys: 7 Korkeus: 7
	 *
	 * xxxxxxx
	 * xoxoxox
	 * xxzxxzx
	 * xoxoxox
	 * xxxxsxx
	 * xozoxox
	 * xxxxxxx
     */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Leveys: ");
        int leveys = Integer.parseInt(scanner.nextLine());

        System.out.print("Korkeus: ");
        int korkeus = Integer.parseInt(scanner.nextLine());

        final String merkki1 = "x";
        final String merkki2 = "o";
        final String merkki3 = "z";
        final String merkki5 = "s";

        System.out.println();

        for (int k = 0; k < korkeus; k++) {
            int jaollinen = 0;
            
            if ((k+1) % 5 == 0) {
                jaollinen = 5;
            }
            if ((k+1) % 3 == 0) {
                jaollinen = 3;
            }
            if ((k+1) % 2 == 0) {
                jaollinen = 2;
            }

            for (int l = 0; l < leveys; l++) {
                // joka toisella rivillä joka toinen merkki on o
                // joka kolmannella rivillä joka kolmas merkki on z
                // joka viidennellä rivillä joka viides merkki on s
                // kaikki muut merkit ovat x-muotoisia

                switch (jaollinen) {
                    case 2:
                        if ((l+1) % 2 == 0) {
                            System.out.print(merkki2);
                        } else {
                            System.out.print(merkki1);
                        }
                        break;
                    case 3:
                        if ((l+1) % 3 == 0) {
                            System.out.print(merkki3);
                        } else {
                            System.out.print(merkki1);
                        }
                        break;
                    case 5:
                        if ((l+1) % 5 == 0) {
                            System.out.print(merkki5);
                        } else {
                            System.out.print(merkki1);
                        }
                        break;
                    default:
                        System.out.print(merkki1);
                        break;
                }
            }
            System.out.print("\n");
        }
    }

}
