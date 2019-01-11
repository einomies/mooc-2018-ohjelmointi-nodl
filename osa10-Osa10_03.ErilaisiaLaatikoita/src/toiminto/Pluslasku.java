package toiminto;


import java.util.Scanner;

public class Pluslasku extends Toiminto {

    public Pluslasku() {
        super("Pluslasku");
    }

    @Override
    public void suorita(Scanner lukija) {
        System.out.print("Anna ensimmäinen luku: ");
        int eka = Integer.parseInt(lukija.nextLine());
        System.out.print("Anna toinen luku: ");
        int toka = Integer.parseInt(lukija.nextLine());

        System.out.println("Lukujen summa on " + (eka + toka));
    }

}
