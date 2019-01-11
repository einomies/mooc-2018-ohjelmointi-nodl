
import java.util.Scanner;

public class Kauppa {

    private Varasto varasto;
    private Scanner lukija;

    public Kauppa(Varasto varasto, Scanner lukija) {
        this.varasto = varasto;
        this.lukija = lukija;
    }

    // metodi jolla hoidetaan yhden asiakkaan asiointi kaupassa
    public void asioi(String asiakas) {
        Ostoskori kori = new Ostoskori();
        System.out.println("Tervetuloa kauppaan " + asiakas);
        System.out.println("valikoimamme:");

        for (String tuote : varasto.tuotteet()) {
            System.out.println(tuote);
        }

        while (true) {
            System.out.print("mitä laitetaan ostoskoriin (pelkkä enter vie kassalle):");
            String tuote = lukija.nextLine();
            if (tuote.isEmpty()) {
                break;
            }
            // Lisätään tuote ostoskoriin, jos sitä on varastossa.
            // Vähennetään varastosaldoa.
            if (this.varasto.ota(tuote)) {
                kori.lisaa(tuote, this.varasto.hinta(tuote));
            }
        }

        System.out.println("ostoskorissasi on:");
        kori.tulosta();
        System.out.println("korin hinta: " + kori.hinta());
    }

}

/*
import java.util.Scanner;
public class Kauppa {

    private Varasto varasto;
    private Scanner lukija;

    public Kauppa(Varasto varasto, Scanner lukija) {
        this.varasto = varasto;
        this.lukija = lukija;
    }

    public void asioi(String asiakas) {
        Ostoskori kori = new Ostoskori();
        System.out.println("Tervetuloa kauppaan " + asiakas);
        System.out.println("valikoimamme:");
        this.varasto.tuotteet().stream().forEach(t -> System.out.println(t));
        while (true) {
            System.out.print("mitä laitetaan ostoskoriin (pelkkä enter vie kassalle): ");
            String tuote = lukija.nextLine();
            if (tuote.isEmpty()) {
                break;
            }
            // tee tänne koodi joka lisää tuotteen ostoskoriin jos sitä on varastossa
            // ja vähentää varastosaldoa
            if (this.varasto.saldo(tuote) > 0) {
                this.varasto.ota(tuote);
                kori.lisaa(tuote, this.varasto.hinta(tuote));
            }
        }
        System.out.println("ostoskorissasi on:");
        kori.tulosta();
        System.out.println("korin hinta: " + kori.hinta());
    }
}
*/