package malli.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hyppy {

    private int pituus;
    private List<Integer> tyylipisteet;

    public Hyppy(int pituus, List<Integer> tyylipisteet) {
        this.pituus = pituus;
        this.tyylipisteet = tyylipisteet;
    }

    public int getPituus() {
        return pituus;
    }

    public List<Integer> getTyylipisteet() {
        return this.tyylipisteet;
    }

    public int yhteisPisteet() {
        int tyylipisteet = karsitutTyylipisteet().stream().mapToInt(i -> i).sum();
        return tyylipisteet + pituus;
    }

    private List<Integer> karsitutTyylipisteet() {
        List<Integer> karsitut = new ArrayList(this.tyylipisteet);
        karsitut.remove(Collections.max(this.tyylipisteet));
        karsitut.remove(Collections.min(this.tyylipisteet));
        return karsitut;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("    pituus: ").append(this.pituus).append("\n");
        sb.append("    tuomaripisteet: ").append(this.tyylipisteet);
        return sb.toString();
    }

}
