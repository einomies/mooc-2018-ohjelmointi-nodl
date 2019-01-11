
import java.util.Scanner;

public class Summaaja {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        int summa = 0;
        int luettujaLukuja = 0;

        System.out.print("Anna summattavia lukuja: ");

        while (true) {
            int luettu = Integer.parseInt(lukija.nextLine());
            luettujaLukuja = luettujaLukuja + 1;
            if (luettu == 0) {
                break;
            }
            summa += luettu;
        }

        System.out.println("Summa lopussa: " + summa);
    }
}
