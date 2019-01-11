package vaalit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class Sanajakauma {

    private Map<String, Integer> sanat;

    public Sanajakauma() {
        this.sanat = new HashMap<>();
    }

    public void lisaaSana(String sana) {
        if (this.sanat.containsKey(sana)) {
            this.sanat.put(sana, this.sanat.get(sana) + 1);
        } else {
            this.sanat.put(sana, 1);
        }
    }

    public int esiintymiskertoja(String sana) {
        return this.sanat.getOrDefault(sana, 0);
    }

    public String annaSana() {
        Random random = new Random();
        if (this.sanat.size() > 0) {
            int arvottuNro = random.nextInt(ilmentymienSumma(this.sanat)) + 1;
//            System.out.println("ilmentymienSumma: " + ilmentymienSumma(this.sanat));
//            System.out.println("arvottuNro: " + arvottuNro);
            int summa = 0, alaraja = 1, ylaraja = 0;
            for (Map.Entry<String, Integer> entry : this.sanat.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                alaraja = summa + 1;
                summa += value;
                ylaraja = alaraja + value - 1;
//                tulostaNrot(key, value, alaraja, ylaraja, summa);
                if (arvottuNro >= alaraja && arvottuNro <= ylaraja) {
                    return key;
                }
            }
//            int summa1 = this.sanat.entrySet().stream()
//                    .xxxxxxxxxxxxxxxxxxx
        }
        return null;
    }

    private int ilmentymienSumma(Map<String, Integer> sanat) {
        return sanat.values().stream().reduce(0, Integer::sum);
    }

    public List<String> uniikitSanat() {
        List<String> lista = this.sanat.entrySet().stream()
                .map(e -> e.getKey())
                .distinct()
                .sorted()
                .collect(Collectors.toCollection(ArrayList::new));
        return lista;
    }

    private void tulostaNrot(String key, Integer value, int alaraja, int ylaraja, int summa) {
        System.out.println("key=" + key + "\tvalue=" + value + "\talaraja=" + alaraja + "\tylaraja=" + ylaraja + "\tsumma=" + summa);
    }

    @Override
    public String toString() {
        return "Sanajakauma{" + "sanat=" + sanat + '}';
    }

}

/*
package vaalit;
import java.util.HashMap;
import java.util.Map;


import java.util.Random;
public class Sanajakauma {

    private Map<String, Integer> sanatJaEsiintymiset;

    public Sanajakauma() {
        this.sanatJaEsiintymiset = new HashMap<>();
    }

    public void lisaaSana(String sana) {
        this.sanatJaEsiintymiset.put(sana, esiintymiskertoja(sana) + 1);
    }

    public int esiintymiskertoja(String sana) {
        return this.sanatJaEsiintymiset.getOrDefault(sana, 0);
    }

    private int esiintymisia() {
        return sanatJaEsiintymiset.values().stream().mapToInt(i -> i).sum();
    }

    public String annaSana() {
        int yht = esiintymisia();
        if (yht == 0) {
            return null;
        }
        Random rnd = new Random();
        int valittu = rnd.nextInt(yht);
        int summa = 0;
        for (String sana : sanatJaEsiintymiset.keySet()) {
            summa += sanatJaEsiintymiset.get(sana);
            if (summa > valittu) {
                return sana;
            }
        }
        return null;
    }
}
*/