
import java.util.Random;
import java.util.Scanner;

public class Numerovisa {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        int arvottuLuku = arvoLuku();
        System.out.println("Arvottu luku: " +arvottuLuku);
        System.out.println("");

        int arvaus = -1;
        int arvausLkm = 0;
        final int alaraja = 0;
        final int ylaraja = 100;

        while (arvaus != arvottuLuku) {
            System.out.println("Arvaa luku: ");
            arvaus = Integer.parseInt(lukija.nextLine());
            arvausLkm++;

            if (arvaus == arvottuLuku) {
                System.out.println("Onneksi olkoon, oikein arvattu!");
            } else if (arvaus > arvottuLuku) {
                System.out.println("Luku on pienempi, tehtyjä arvauksia: " +arvausLkm);
            } else {
                System.out.println("Luku on suurempi, tehtyjä arvauksia: " +arvausLkm);
            }
        }
    }

    // ÄLÄ MUOKKAA METODIA arvoLuku
    private static int arvoLuku() {
        return new Random().nextInt(101);
    }
}
