/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makihyppy;

import java.util.ArrayList;

/**
 *
 * @author einomies
 */
public class Hyppaaja implements Comparable<Hyppaaja> {

    private String nimi;
    private int pisteet;
    private ArrayList<Integer> hypyt;

    public Hyppaaja() {
    }

    public Hyppaaja(String nimi) {
        this.nimi = nimi;
        this.pisteet = 0;
        this.hypyt = new ArrayList<>();
    }

    public void paivita(int pisteet, int hypynPituus) {
        this.pisteet += pisteet;
        hypyt.add(hypynPituus);
    }

    public String getNimi() {
        return this.nimi;
    }

    public int getPisteet() {
        return this.pisteet;
    }

    public ArrayList<Integer> getHypyt() {
        return this.hypyt;
    }

    @Override
    public int compareTo(Hyppaaja o) {
        if (this.pisteet != o.getPisteet()) {
            return this.pisteet - o.getPisteet();
        } else {
            return this.getNimi().compareTo(o.getNimi());
        }
    }

    @Override
    public String toString() {
        return this.nimi + " (" + this.pisteet + " pistettä)";
    }

}
