/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esimerkki;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author einomies
 */
public class Esim01 {

    public static void main(String[] args) {
        testi01();
//        testi02();
//        testi03();
    }

    private static void testi01() {
        ArrayList<Henkilo> henkilot = new ArrayList<>();
        henkilot.add(new Henkilo("Ada Lovelace", 1815));
        henkilot.add(new Henkilo("Irma Wyman", 1928));
        henkilot.add(new Henkilo("Grace Hopper", 1906));
        henkilot.add(new Henkilo("Mary Coombs", 1929));

        henkilot.stream().sorted((h1, h2) -> {
            return h1.getSyntymavuosi() - h2.getSyntymavuosi();
        }).forEach(h -> System.out.println(h.getNimi()));

        System.out.println();

        henkilot.stream().forEach(h -> System.out.println(h.getNimi()));

        System.out.println();
        
//        Collections.sort(henkilot, (h1, h2) -> return h1.getSyntymavuosi() - h2.getSyntymavuosi());
//
//        henkilot.stream().forEach(h -> System.out.println(h.getNimi());
    }

    private static void testi02() {
        ArrayList<Henkilo> henkilot = new ArrayList<>();
        henkilot.add(new Henkilo("Ada Lovelace", 1815));
        henkilot.add(new Henkilo("Irma Wyman", 1928));
        henkilot.add(new Henkilo("Grace Hopper", 1906));
        henkilot.add(new Henkilo("Mary Coombs", 1929));

        henkilot.stream().sorted((h1, h2) -> {
            return h1.getNimi().compareTo(h2.getNimi());
        }).forEach(h -> System.out.println(h.getNimi()));
        /*
        Ada Lovelace
        Grace Hopper
        Irma Wyman
        Mary Coombs
         */
    }

    private static void testi03() {
    }

}
