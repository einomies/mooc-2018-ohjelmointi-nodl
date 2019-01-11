
import java.util.ArrayList;
import java.util.Random;

public class Lottorivi {

    private ArrayList<Integer> numerot;
    private final int numerotLkm = 7;
    private final int minNro = 1;
    private final int maxNro = 40;

    public Lottorivi() {
        // Arvo numerot heti LottoRivin luomisen yhteydessä
        this.arvoNumerot();
    }

    public ArrayList<Integer> numerot() {
        return this.numerot;
    }

    public void arvoNumerot() {
        // Alustetaan lista numeroille
        this.numerot = new ArrayList<>();
        // Kirjoita numeroiden arvonta tänne käyttämällä metodia sisaltaaNumeron()
        for (int i = 0; this.numerot.size() < numerotLkm; i++) {
            Random random = new Random();
            int uusiNro = random.nextInt(maxNro) + 1;
            if (!sisaltaaNumeron(uusiNro)) {
                this.numerot.add(uusiNro);
            }
        }
    }

    public boolean sisaltaaNumeron(int numero) {
        // Testaa tässä onko numero jo arvottujen numeroiden joukossa
        if (this.numerot.contains(numero)) {
            return true;
        }
        return false;
    }
    /*
    public void arvoNumerot() {
        // Alustetaan lista numeroille
        this.numerot = new ArrayList<>();
        // Kirjoita numeroiden arvonta tänne käyttämällä metodia sisaltaaNumeron()
        Random random = new Random();
        while (this.numerot.size() < 7) {
            int uusiNumero = random.nextInt(40) + 1;
            boolean numeroOliJoArvottu = this.sisaltaaNumeron(uusiNumero);
            // Lisätään uusi numero vain, jos se ei ole jo arvottujen joukossa
            if (!numeroOliJoArvottu) {
                this.numerot.add(uusiNumero);
            }
        }
    }
    public boolean sisaltaaNumeron(int numero) {
        // Testaa tässä onko numero jo arvottujen numeroiden joukossa
        return this.numerot.contains(numero);
    }
    */
}
