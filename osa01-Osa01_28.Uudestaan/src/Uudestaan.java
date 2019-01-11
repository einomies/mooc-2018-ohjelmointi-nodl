
import java.util.Scanner;

public class Uudestaan {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        while (true) {
//            System.out.println("osaan ohjelmoida!");

            System.out.print("Syötä luku ");
            int komento = Integer.parseInt(lukija.nextLine());
            if (komento == 4) {
                break;
            }
        } // lohko päättyy

        // toistolauseen lohkoa seuraava komento
        System.out.println("kiitos ja kuulemiin.");
    }
}
