/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lentokentta.logiikka;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import lentokentta.domain.Lento;
import lentokentta.domain.Lentokone;
import lentokentta.domain.Paikka;

/**
 *
 * @author einomies
 */
public class Lentohallinta {

    private Map<String, Lentokone> lentokoneet;
    private Map<String, Lento> lennot;
    private Map<String, Paikka> paikat;

    public Lentohallinta() {
        this.lennot = new HashMap<>();
        this.lentokoneet = new HashMap<>();
        this.paikat = new HashMap<>();
    }

    public void lisaaLentokone(String tunnus, int kapasiteetti) {
        Lentokone lentokone = new Lentokone(tunnus, kapasiteetti);
        this.lentokoneet.put(tunnus, lentokone);
    }

    public void lisaaLento(Lentokone lentokone, String lahtotunnus, String kohdetunnus) {
        this.paikat.putIfAbsent(lahtotunnus, new Paikka(lahtotunnus));
        this.paikat.putIfAbsent(kohdetunnus, new Paikka(kohdetunnus));

        Lento lento = new Lento(lentokone, this.paikat.get(lahtotunnus), this.paikat.get(kohdetunnus));
        this.lennot.put(lento.toString(), lento);
    }

    public Collection<Lentokone> getLentokoneet() {
        return this.lentokoneet.values();
    }

    public Collection<Lento> getLennot() {
        return this.lennot.values();
    }

    public Lentokone haeLentokone(String tunnus) {
        return this.lentokoneet.get(tunnus);
    }

}
