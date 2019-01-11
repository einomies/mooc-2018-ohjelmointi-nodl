
import java.util.Random;

public class Noppa {

    private Random random;
    private int tahkojenMaara;

    public Noppa(int tahkojenMaara) {
        this.random = new Random();
        this.tahkojenMaara = tahkojenMaara;
    }

    public int heita() {
        // arvotaan luku väliltä 1-tahkojenMaara
        return this.random.nextInt(this.tahkojenMaara) + 1;
    }
}
