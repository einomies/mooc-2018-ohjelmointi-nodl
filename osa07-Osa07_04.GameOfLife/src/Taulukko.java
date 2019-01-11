
import java.util.HashMap;

public class Taulukko {

    private HashMap<Integer, HashMap<Integer, Boolean>> taulukko;
    private int leveys;
    private int korkeus;

    public Taulukko(int leveys, int korkeus) {
        this.taulukko = new HashMap<>();
        this.leveys = leveys;
        this.korkeus = korkeus;
    }

    public int getLeveys() {
        return leveys;
    }

    public int getKorkeus() {
        return korkeus;
    }

    public void aseta(int x, int y, boolean arvo) {
        this.taulukko.putIfAbsent(x, new HashMap<>());
        this.taulukko.get(x).put(y, arvo);
    }

    public boolean hae(int x, int y) {
        if (!this.taulukko.containsKey(x)) {
            return false;
        }

        if (!this.taulukko.get(x).containsKey(y)) {
            return false;
        }

        return this.taulukko.get(x).get(y);
    }

}
