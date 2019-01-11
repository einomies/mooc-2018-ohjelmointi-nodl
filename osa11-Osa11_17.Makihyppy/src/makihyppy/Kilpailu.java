/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makihyppy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author einomies
 */
public class Kilpailu {

    private ArrayList<Kierros> kierrokset;
    private ArrayList<Hyppaaja> hyppaajat;
    private int viimeisinKierros;

    public Kilpailu() {
        this.kierrokset = new ArrayList<>();
        this.hyppaajat = new ArrayList<>();
        this.viimeisinKierros = 0;
    }

    public Kilpailu(ArrayList<Hyppaaja> hyppaajat) {
        this.kierrokset = new ArrayList<>();
        this.hyppaajat = hyppaajat;
        this.viimeisinKierros = 0;
    }

    public void lisaaHyppaaja(String nimi) {
        this.hyppaajat.add(new Hyppaaja(nimi));
    }

    public void hyppaaKierros() {
        this.kierrokset.add(new Kierros(viimeisinKierros + 1, this.hyppaajat));
        this.viimeisinKierros++;
    }

    public String haeViimeisimmanKierroksenTulokset() {
        return this.kierrokset.get(this.kierrokset.size() - 1).toString();
    }

    public ArrayList<Hyppaaja> haeHyppyjarjestys() {
        this.hyppaajat.sort(Comparator.comparing(o -> o.getPisteet()));
        return this.hyppaajat;
    }

    public ArrayList<Hyppaaja> haeLopputulokset() {
        this.hyppaajat.sort(Comparator.comparing(o -> o.getPisteet()));
        Collections.reverse(this.hyppaajat);
        return this.hyppaajat;
    }

}
