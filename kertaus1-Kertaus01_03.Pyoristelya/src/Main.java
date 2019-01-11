
import java.util.ArrayList;
import java.util.Scanner;

/*
 Tee ohjelma, joka lukee käyttäjältä luvun, ja pyöristää pyöristää sen ylöspäin lähimpään viidellä jaolliseen lukuun.
*/

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        int luku = 0;
        System.out.print("Luku: ");
        luku = Integer.parseInt(scanner.nextLine());
        
        int pyoristys = luku;
        
        while (pyoristys % 5 != 0) {
            pyoristys++;
        }
        
        System.out.println("Pyöristys: " +pyoristys);
    }

}
