package malli.domain;

import java.util.ArrayList;
import java.util.List;

public class Hyppaaja implements Comparable<Hyppaaja> {

    private String nimi;
    private List<Hyppy> hypyt;

    public Hyppaaja(String nimi) {
        this.nimi = nimi;
        this.hypyt = new ArrayList<>();
    }

    public String getNimi() {
        return this.nimi;
    }

    public void lisaaHyppy(Hyppy hyppy) {
        this.hypyt.add(hyppy);
    }

    public int yhteispisteet() {
        return this.hypyt.stream().mapToInt(h -> h.yhteisPisteet()).sum();
    }

    public List<Hyppy> getHypyt() {
        return hypyt;
    }

    @Override
    public boolean equals(Object olio) {
        if (olio == null) {
            return false;
        }
        if (getClass() != olio.getClass()) {
            return false;
        }
        Hyppaaja verrattava = (Hyppaaja) olio;
        if (this.nimi == null || !this.nimi.equals(verrattava.getNimi())) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        if (this.nimi == null) {
            return 7;
        }
        return this.nimi.hashCode();
    }

    @Override
    public int compareTo(Hyppaaja t) {
        return this.yhteispisteet() - t.yhteispisteet();
    }

    @Override
    public String toString() {
        int yhteispisteet = this.yhteispisteet();
        if (yhteispisteet == 1) {
            return this.nimi + " (" + yhteispisteet + " piste)";
        }
        return this.nimi + " (" + yhteispisteet + " pistettä)";
    }

}
