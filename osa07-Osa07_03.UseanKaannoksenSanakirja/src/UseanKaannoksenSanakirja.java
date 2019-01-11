
import java.util.ArrayList;
import java.util.HashMap;

public class UseanKaannoksenSanakirja {

    private HashMap<String, ArrayList<String>> sanakirja;

    public UseanKaannoksenSanakirja() {
        this.sanakirja = new HashMap<>();
    }

//  Lisää käännöksen sanalle säilyttäen vanhat käännökset
    public void lisaa(String sana, String kaannos) {
        ArrayList<String> kaannokset = new ArrayList<>();
        if (this.sanakirja.containsKey(sana)) {
            kaannokset = this.sanakirja.get(sana);
            kaannokset.add(kaannos);
            this.sanakirja.putIfAbsent(sana, kaannokset);
        } else {
            kaannokset.add(kaannos);
            this.sanakirja.putIfAbsent(sana, kaannokset);
        }
    }

//  Palauttaa listan, joka sisältää sanojen käännökset. Jos sanalle ei ole yhtäkään käännöstä,
//  metodin tulee palauttaa tyhjä lista.
    public ArrayList<String> kaanna(String sana) {
        ArrayList<String> kaannokset = new ArrayList<>();
        if (this.sanakirja.get(sana) != null) {
            kaannokset = this.sanakirja.get(sana);
        }
        return kaannokset;
    }

//  Poistaa sanan ja sen kaikki käännökset sanakirjasta
    public void poista(String sana) {
        if (this.sanakirja.containsKey(sana)) {
            ArrayList<String> kaannokset = kaannokset = this.sanakirja.get(sana);
            this.sanakirja.get(sana).removeAll(kaannokset);
            this.sanakirja.remove(sana);
        }
    }

}

/*
import java.util.ArrayList;
import java.util.HashMap;

public class UseanKaannoksenSanakirja {

    private HashMap<String, ArrayList<String>> sanakirja;

    public UseanKaannoksenSanakirja() {
        this.sanakirja = new HashMap<>();
    }

    public void lisaa(String sana, String kaannos) {
        this.sanakirja.putIfAbsent(sana, new ArrayList<>());
        this.sanakirja.get(sana).add(kaannos);
    }

    public ArrayList<String> kaanna(String sana) {
        return sanakirja.getOrDefault(sana, new ArrayList<>());
    }

    public void poista(String sana) {
        sanakirja.remove(sana);
    }
}
*/