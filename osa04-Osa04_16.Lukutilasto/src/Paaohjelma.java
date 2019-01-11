
import java.util.Scanner;

public class Paaohjelma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        // voit tehdä testikoodia tänne
        // poista kaikki ylimääräinen koodi kuitenkin tehtävän viimeisiä osia tehdessäsi

        // Jotta testi toimisi, on oliot luotava pääohjelmassa oikeassa järjestyksessä 
        // eli ensin kaikkien summan laskeva olio, toisena parillisten summan laskeva 
        // ja viimeisenä parittomien summan laskeva olio)!
        /*
        Lukutilasto tilasto = new Lukutilasto();
        tilasto.lisaaLuku(1);
        tilasto.lisaaLuku(2);
        tilasto.lisaaLuku(3);
        System.out.println("tilasto.haeLukujenMaara(): " +tilasto.haeLukujenMaara());
        System.out.println("tilasto.summa(): " +tilasto.summa());
        System.out.println("tilasto.keskiarvo(): " +tilasto.keskiarvo());
        */
        final int lopetus = -1;
        int luku = 0;
        Lukutilasto tilastoKaikki = new Lukutilasto();
        Lukutilasto tilastoParilliset = new Lukutilasto();
        Lukutilasto tilastoParittomat = new Lukutilasto();
        System.out.println("Anna lukuja: ");

        while (true) {
            luku = Integer.parseInt(lukija.nextLine());
            if (luku == lopetus) {
                break;
            }
            tilastoKaikki.lisaaLuku(luku);
            if (luku%2 == 0) {
                tilastoParilliset.lisaaLuku(luku);
            } else {
                tilastoParittomat.lisaaLuku(luku);
            }
        }
        System.out.println("Summa: " +tilastoKaikki.summa());
        System.out.println("Parillisten summa: " +tilastoParilliset.summa());
        System.out.println("Parittomien summa: " +tilastoParittomat.summa());
    }
}
