
import java.io.InputStream;
import java.util.Scanner;

public class Main {

    /*
McDonaldsissa voi ostaa nugetteja neljän, kuuden, yhdeksän ja kahdenkymmenen nugetin pakkauksissa.
Kirjoita ohjelma, jolle annetaan luku, ja joka kertoo käyttäjälle onko annettua määrää mahdollista ostaa.

Nugetteja: 3
Ostaminen ei ole mahdollista

Nugetteja: 8
Ostaminen on mahdollista

Nugetteja: 9
Ostaminen on mahdollista

Nugetteja: 11
Ostaminen ei ole mahdollista

Nugetteja: 24
Ostaminen on mahdollista
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Nugetteja: ");
        int kpl = Integer.parseInt(scanner.nextLine());

        if (kpl % 4 == 0
                || kpl % 6 == 0
                || kpl % 9 == 0
                || kpl % 20 == 0) {
            System.out.println("Ostaminen on mahdollista");
        } else {
            System.out.println("Ostaminen ei ole mahdollista");
        }

    }

}
