
import java.util.Scanner;

public class ArvosanatJaPisteet {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        System.out.print("Anna pisteet [0-100]: ");
        int pisteet = Integer.parseInt(lukija.nextLine());

        if (pisteet < 0) {
            System.out.println("Arvosana: mahdotonta!");
        } else if (pisteet < 70) {
            System.out.println("Arvosana: hylätty");
        } else if (pisteet < 76) {
            System.out.println("Arvosana: 1");
        } else if (pisteet < 81) {
            System.out.println("Arvosana: 2");
        } else if (pisteet < 86) {
            System.out.println("Arvosana: 3");
        } else if (pisteet < 91) {
            System.out.println("Arvosana: 4");
        } else if (pisteet < 101) {
            System.out.println("Arvosana: 5");
        } else {
            System.out.println("Arvosana: uskomatonta!");
        }
    }
}
