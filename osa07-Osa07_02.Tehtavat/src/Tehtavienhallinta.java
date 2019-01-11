import java.util.ArrayList;

public class Tehtavienhallinta {

    private ArrayList<Tehtava> tehtavat;

    public Tehtavienhallinta() {
        this.tehtavat = new ArrayList<>();
    }

//    public ArrayList<Tehtava> tehtavalista() {
//        return this.tehtavat;
//    }
    public ArrayList<String> tehtavalista() {
        ArrayList<String> palautettavat = new ArrayList<>();
        for (Tehtava tehtava: tehtavat) {
            palautettavat.add(tehtava.getNimi());
        }
        return palautettavat;
    }

    public void lisaa(String nimi) {
        this.tehtavat.add(new Tehtava(nimi));
    }
    
    public void poista(String tehtavaNimi) {
        for (int i = 0; i < this.tehtavat.size(); i++) {
            if (this.tehtavat.get(i).getNimi().equals(tehtavaNimi)) {
                this.tehtavat.remove(i);
            }
        }
    }

    public void merkkaaTehdyksi(String tehtavaNimi) {
        for (Tehtava tehtava : tehtavat) {
            if (tehtava.getNimi().equals(tehtavaNimi)) {
                tehtava.setTehty(true);
            }
        }
    }

    public boolean onTehty(String tehtavaNimi) {
        for (Tehtava tehtava : tehtavat) {
            if (tehtava.getNimi().equals(tehtavaNimi)
                    && tehtava.onTehty()) {
                return true;
            }
        }
        return false;
    }

}