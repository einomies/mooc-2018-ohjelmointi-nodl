package vaalit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Tekstimalli {

//    Mitähän Map-rakennetta tms peräkkäisten sanojen hallinnassa ja analysoinnissa
//    pitäisi/kannattaisi käyttää? Alla ehdokkaita:
//    private Map<HashMap<String, String>, Integer> perakkaisetSanat;
//    private Map<Sanajakauma, Sanajakauma> perakkaisetSanat;
//    private Map<Sanapari, Integer> perakkaisetSanat;
    private Map<String, Sanajakauma> perakkaisetSanat;

//    private Sanajakauma sanajakauma;
    public Tekstimalli() {
        this.perakkaisetSanat = new HashMap<>();
//        this.sanajakauma = new Sanajakauma();
    }

    public void lisaaAineisto(String aineisto) {

        if (aineisto == null) {
            return;
        }
        if (aineisto.isEmpty()) {
            return;
        }

        String[] sanat = aineisto.split("\\s+");

        for (int i = 0; i < sanat.length; i++) {
            if (i == sanat.length - 1) {
                if (!this.perakkaisetSanat.containsKey(sanat[i])) {
                    this.perakkaisetSanat.put(sanat[i], new Sanajakauma());
                }
            } else {
                if (this.perakkaisetSanat.containsKey(sanat[i])) {
                    Sanajakauma sj = this.perakkaisetSanat.get(sanat[i]);
                    sj.lisaaSana(sanat[i + 1]);
                    this.perakkaisetSanat.put(sanat[i], sj);
                } else {
                    Sanajakauma sj = new Sanajakauma();
                    sj.lisaaSana(sanat[i + 1]);
                    this.perakkaisetSanat.put(sanat[i], sj);
                }
            }
        }
    }

    public String annaSana(String edeltava) {
        if (this.perakkaisetSanat.containsKey(edeltava)) {
            return this.perakkaisetSanat.get(edeltava).annaSana();
        }
        return null;
    }

    public List<String> sanat() {
//        return this.sanajakauma.uniikitSanat();
        List<String> lista = this.perakkaisetSanat.entrySet().stream()
                .map(e -> e.getKey())
                .distinct()
                .sorted()
                .collect(Collectors.toCollection(ArrayList::new));
        return lista;
    }

    @Override
    public String toString() {
        return "Tekstimalli{" + "perakkaisetSanat=" + perakkaisetSanat + '}';
    }

}

/*
package vaalit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


import java.util.List;
public class Tekstimalli {

    private Map<String, Sanajakauma> sanasto;
    private Set<String> sanat;

    public Tekstimalli() {
        this.sanasto = new HashMap<>();
        this.sanat = new HashSet<>();
    }

    public void lisaaAineisto(String aineisto) {
        String[] palat = aineisto.split("\\s+");
        for (String sana : palat) {
            this.sanat.add(sana);
        }
        for (int i = 1; i < palat.length; i++) {
            sanasto.putIfAbsent(palat[i - 1], new Sanajakauma());
            sanasto.get(palat[i - 1]).lisaaSana(palat[i]);
        }
    }

    public String annaSana(String edeltava) {
        if (!sanasto.containsKey(edeltava)) {
            return null;
        }
        return sanasto.get(edeltava).annaSana();
    }

    public List<String> sanat() {
        return new ArrayList<>(sanat);
    }
}
*/