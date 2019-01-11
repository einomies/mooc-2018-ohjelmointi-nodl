
import java.util.Scanner;

public class Jakolasku {

    public static void main(String[] args) {
        // Kun olet toteuttanut metodin jakolasku, voit testata
        // sen toimintaa täällä. Esimerkiksi kutsun jakolasku(3,5);
        // pitäisi tulostaa "0.6"

        jakolasku(3, 5);
        jakolasku(3, 0);
        jakolasku(3, 197);
    }

    public static void jakolasku(int osoittaja, int nimittaja) {
        System.out.println("Osoittaja: " +osoittaja);
        System.out.println("Nimittäjä: " +nimittaja);
        System.out.println("Jakolaskun tulos: " +(double)osoittaja/(double)nimittaja);
    }
}
