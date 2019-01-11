package malli.logiikka;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import malli.domain.Hyppaaja;
import malli.domain.Hyppykierros;

public class Kilpailu {

    private String nimi;
    private List<Hyppaaja> hyppaajat;
    private List<Hyppykierros> kierrokset;

    public Kilpailu(String nimi) {
        this.nimi = nimi;
        this.hyppaajat = new ArrayList<>();
        this.kierrokset = new ArrayList<>();
    }

    public void lisaaHyppaaja(Hyppaaja lisattava) {
        if (this.hyppaajat.contains(lisattava)) {
            return;
        }
        this.hyppaajat.add(lisattava);
    }

    public Hyppykierros luoSeuraavaHyppykierros() {
        List<Hyppaaja> kierroksenHyppyjarjestys = new ArrayList<>(getHyppaajat());
        Collections.sort(kierroksenHyppyjarjestys);
        Hyppykierros kierros = new Hyppykierros(this.kierrokset.size() + 1, kierroksenHyppyjarjestys);
        this.kierrokset.add(kierros);
        return kierros;
    }

    public List<Hyppaaja> getHyppaajat() {
        return hyppaajat;
    }

    public String getNimi() {
        return this.nimi;
    }

    @Override
    public String toString() {
        return this.nimi;
    }
}
