/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makihyppy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author einomies
 */
public class Hyppy implements Comparable<Hyppy> {

//    private String hyppaaja;
    private Hyppaaja hyppaaja;
    private int pituus;
    private ArrayList<Integer> tuomaripisteet;
    private int yhteispisteet;

    public Hyppy(Hyppaaja hyppaaja) {
        this.hyppaaja = hyppaaja;
        this.pituus = arpoja(60, 120);
        this.tuomaripisteet = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            this.tuomaripisteet.add(arpoja(10, 20));
        }
        ArrayList<Integer> pisteet = new ArrayList<>();
        pisteet.addAll(this.tuomaripisteet);
        int keskimmainenInd = pisteet.size() / 2;
        Collections.sort(pisteet);
        this.yhteispisteet = this.pituus
                + pisteet.get(keskimmainenInd - 1)
                + pisteet.get(keskimmainenInd)
                + pisteet.get(keskimmainenInd + 1);
        this.hyppaaja.paivita(this.yhteispisteet, this.pituus);
    }

    private int arpoja(int min, int max) {
        return new Random().nextInt(min + 1) + max - min;
    }

//    public String getHyppaaja() {
//        return hyppaaja;
//    }

    public int getPituus() {
        return pituus;
    }

    public ArrayList<Integer> getTuomaripisteet() {
        return tuomaripisteet;
    }

    public int getYhteispisteet() {
        return yhteispisteet;
    }

    @Override
    public String toString() {
        String tulos = "  " + this.hyppaaja.getNimi() + "\n    pituus: " + this.pituus
                + "\n    tuomaripisteet: " + this.tuomaripisteet;
//                + "\n    yhteispisteet: " + this.yhteispisteet;
        return tulos;
    }

    @Override
    public int compareTo(Hyppy o) {
        return this.yhteispisteet - o.getYhteispisteet();
    }

}
