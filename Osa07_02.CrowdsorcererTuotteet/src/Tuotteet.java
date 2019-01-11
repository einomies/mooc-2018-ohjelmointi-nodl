
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Tuotteet {

    private HashMap<Integer, String> map;

    public Tuotteet() {
        this.map = new HashMap<>();
    }

    public void lisaa(Integer tuotekoodi, String tuotenimi) {
        if (this.map.containsKey(tuotekoodi)) {
            System.out.println("Tuotekoodi " +tuotekoodi +" on jo olemassa.");
        } else {
            this.map.put(tuotekoodi, tuotenimi);
        }
    }

    public String hae(Integer tuotekoodi) {
        if (this.map.containsKey(tuotekoodi)) {
            return this.map.get(tuotekoodi);
        } else {
            return "Tuotekoodia " +tuotekoodi +" ei löydy.";
        }
    }

    public void paivita(int koodi, String nimi) {
        if (this.map.containsKey(koodi)) {
            this.map.put(koodi, nimi);
        } else {
            System.out.println("Tuotekoodia " +koodi +" ei löydy.");
        }
    }

    public void listaa() {
        System.out.println("tuotekoodi\tnimi");
        System.out.println("----------\t-------------------------");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key +"\t\t" +value);
        }
    }

    public void poista(Integer tuotekoodi) {
        if (this.map.containsKey(tuotekoodi)) {
            this.map.remove(tuotekoodi);
            System.out.println("Poistettu.");
        } else {
            System.out.println("Tuotekoodia " +tuotekoodi +" ei löydy.");
        }
    }

}
