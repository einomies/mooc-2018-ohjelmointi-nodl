package toiminto;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kayttoliittyma {

    private Scanner lukija;
    private List<Toiminto> toiminnot;

    public Kayttoliittyma(Scanner lukija) {
        this.lukija = lukija;
        this.toiminnot = new ArrayList<>();
    }

    public void lisaaToiminto(Toiminto toiminto) {
        this.toiminnot.add(toiminto);
    }

    public void kaynnista() {
        while (true) {
            tulostaToiminnot();
            System.out.println("Valinta: ");

            String valinta = this.lukija.nextLine();
            if (valinta.equals("0")) {
                break;
            }

            suoritaToiminto(valinta);
            System.out.println();
        }
    }

    private void tulostaToiminnot() {
        System.out.println("\t0: Lopeta");
        for (int i = 0; i < this.toiminnot.size(); i++) {
            String toiminnonNimi = this.toiminnot.get(i).getNimi();
            System.out.println("\t" + (i + 1) + ": " + toiminnonNimi);
        }
    }

    private void suoritaToiminto(String valinta) {
        int toiminto = Integer.parseInt(valinta);

        Toiminto valittu = this.toiminnot.get(toiminto - 1);
        valittu.suorita(lukija);
    }

}
