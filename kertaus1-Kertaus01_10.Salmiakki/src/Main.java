
import java.util.Scanner;

public class Main {

    /*
Tee ohjelma, joka kysyy salmiakin korkeutta, jonka jälkeen se tulostaa "salmiakin".

Korkeus: 1

*

Korkeus: 5

  *
 * *
*   *
 * *
  *

Korkeus: 6

  *
 * *
*   *
*   *
 * *
  *

Korkeus: 7

   *
  * *
 *   *
*     *
 *   *
  * *
   *

     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Korkeus: ");
//        int korkeus = Integer.parseInt(scanner.nextLine());
        int korkeus = scanner.nextInt();
        
        boolean korkeusParillinen = false;

        int maxLeveys = 0;
//        maxLeveys on aina pariton luku
        if (korkeus % 2 == 0) {
            maxLeveys = korkeus - 1;
            korkeusParillinen = true;
        } else {
            maxLeveys = korkeus;
        }

        final String tahti = "x";
        final String vali = " ";
        int i=0;
        int riviNro = 1;

        System.out.println();

        int tyhjaLkm, tahtiLkm;

//        ensin yläkolmio
        tyhjaLkm = maxLeveys / 2 + 1;
        tahtiLkm = 1;
        i = 0;
        while (i < maxLeveys / 2 + 1) {
            tulostaTyhjaa(tyhjaLkm);
            tulostaTahtia(tahtiLkm);
            System.out.println(); // rivin vaihto
            tyhjaLkm = tyhjaLkm - 1;
            tahtiLkm = tahtiLkm + 2;
            i++;
            riviNro++;
        }
//        sitten alakolmio
//        System.out.println("tyhjaLkm: " +tyhjaLkm);
//        System.out.println("tahtiLkm: " +tahtiLkm);
        if (korkeusParillinen) {
            tyhjaLkm = tyhjaLkm + 1;
            tahtiLkm = tahtiLkm - 2;
        } else {
            tyhjaLkm = tyhjaLkm + 2;
            tahtiLkm = tahtiLkm - 4;
        }
        i = 0;
        while (i < maxLeveys / 2 + 1) {
            tulostaTyhjaa(tyhjaLkm);
            tulostaTahtia(tahtiLkm);
            System.out.println(); // rivin vaihto
            tyhjaLkm = tyhjaLkm + 1;
            tahtiLkm = tahtiLkm - 2;
            i++;
            riviNro++;
        }
    }

    private static void tulostaTahtia(int lkm) {
//        tulostetaan tähdet vain ensimmäiseen ja viimeiseen positioon
        for (int i = 0; i < lkm; i++) {
            if (i == 0 || i == lkm-1) {
                System.out.print("*");
            } else {
                System.out.print(" ");
            }
        }
    }

    private static void tulostaTyhjaa(int lkm) {
        for (int i = 0; i < lkm; i++) {
            System.out.print(" ");
        }
    }
    
    /*

    public void piirraSalmiakki() {
        String merkki;
        int i, korkeus;
        int blankkoLkm, lkm;

        do {
            System.out.print("Anna salmiakin korkeus (vähintään 5, enintään 41): ");
            korkeus = input.nextInt();
        } while (korkeus <= 4 || korkeus > 41);

        input.nextLine();
        merkki = pyydaMerkki();

        if (korkeus % 2 == 0) {
            korkeus = korkeus + 1; // korkeus pitää olla pariton luku
        }
        // ensin yläkolmio
        blankkoLkm = korkeus / 2 + 1;
        lkm = 1;
        i = 0;
        while (i < korkeus / 2 + 1) {
            piirra(" ", blankkoLkm);
            piirra(merkki, lkm);
            System.out.println(); // rivin vaihto

            blankkoLkm = blankkoLkm - 1;
            lkm = lkm + 2;
            i++;
        }
        // sitten alakolmio
        lkm = lkm - 4;
        blankkoLkm = blankkoLkm + 2;
        i = 0;
        while (i < korkeus / 2) {
            piirra(" ", blankkoLkm);
            piirra(merkki, lkm);
            System.out.println();  // rivin vaihto

            blankkoLkm = blankkoLkm + 1;
            lkm = lkm - 2;
            i++;
        }
    }

    public void piirra(String merkki, int lkm) {
        int i = 0;
        while (i < lkm) {
            System.out.print(merkki);
            i++;
        }
    }
    */
}
