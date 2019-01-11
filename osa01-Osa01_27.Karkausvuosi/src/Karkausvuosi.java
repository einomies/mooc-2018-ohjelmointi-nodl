
import java.util.Scanner;

public class Karkausvuosi {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        int vuosi;
        boolean karkausvuosiko;

        System.out.print("Anna vuosi: ");
        vuosi = Integer.parseInt(lukija.nextLine());
        
        karkausvuosiko = onkoKarkausvuosi(vuosi);
        
        if (karkausvuosiko == true) {
            System.out.println("Vuosi on karkausvuosi.");
        } else {
            System.out.println("Vuosi ei ole karkausvuosi.");
        }
    }

    private static boolean onkoKarkausvuosi(int vuosi) {
        if (vuosi % 4 == 0) {
            if (vuosi % 100 == 0) {
                if (vuosi % 400 == 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

}
