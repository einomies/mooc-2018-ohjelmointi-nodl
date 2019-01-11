
import java.util.Scanner;

public class JuupasEipas {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        System.out.print("Anna lukuja, nolla lopettaa: ");
        while (true) {
            int luku = Integer.parseInt(lukija.nextLine());
            if (luku == 0) {
                break;
            }
            if (luku > 0) {
                System.out.print("Juupas\n");
            } else {
                System.out.print("Eipäs\n");
            }
        }
    }
}
