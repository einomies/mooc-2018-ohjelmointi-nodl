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

/**
 *
 * @author einomies
 */
public class Testi01 {

    public static void main(String[] args) {
//        testi01Hypyt();
//        testi02Kierrokset();
        testi03Kilpailu();
//        testi04();
//        testi05();
    }

    private static void testi01Hypyt() {
        ArrayList<Hyppaaja> hyppaajat = luoHyppaajat01();

        ArrayList<Hyppy> hypyt = new ArrayList<>();
        for (Hyppaaja hyppaaja : hyppaajat) {
            hypyt.add(new Hyppy(hyppaaja));
        }
        hypyt.stream().forEach(h -> System.out.println(h));

        System.out.println();
        Collections.sort(hypyt);
        hypyt.stream().forEach(h -> System.out.println(h));

        System.out.println();
        Collections.reverse(hypyt);
        hypyt.stream().forEach(h -> System.out.println(h));
//        hypyt.stream().sorted().forEach(h -> System.out.println(h));
    }

    private static void testi02Kierrokset() {
        ArrayList<Hyppaaja> hyppaajat = luoHyppaajat01();

        ArrayList<Kierros> kierrokset = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            System.out.println();
            System.out.println(i + 1 + ". kierros");
            System.out.println();
            System.out.println("Hyppyjärjestys:");
            System.out.println();
            tulostaHyppyjarjestys(hyppaajat);
            kierrokset.add(new Kierros(i + 1, hyppaajat));
            System.out.println();
            System.out.println(kierrokset.get(kierrokset.size() - 1));
        }
    }

    private static void testi03Kilpailu() {
        ArrayList<Hyppaaja> hyppaajat = luoHyppaajat01();
        Kilpailu kilpailu = new Kilpailu(hyppaajat);

        for (int i = 0; i < 3; i++) {
            System.out.println();
            System.out.println(i + 1 + ". kierros");
            System.out.println();
            System.out.println("Hyppyjärjestys:");
            ArrayList<Hyppaaja> jarjestys = kilpailu.haeHyppyjarjestys();
            for (int j = 0; j < jarjestys.size(); j++) {
                System.out.println(j + 1 + ". " + jarjestys.get(j).toString());
            }
            kilpailu.hyppaaKierros();
            System.out.println();
            System.out.println(kilpailu.haeViimeisimmanKierroksenTulokset());
        }
        System.out.println();
        System.out.println("Kilpailun lopputulokset:\n" +"Sija    Nimi");
        tulostaLopputulokset(kilpailu);
    }

    private static void testi04() {
    }

    private static void testi05() {
    }

    private static ArrayList<String> luoNimet01() {
        ArrayList<String> nimet = new ArrayList<>();
        nimet.add("Matti");
        nimet.add("Jens");
        nimet.add("Richard");
        nimet.add("Adam");
        nimet.add("Noriaki");
        nimet.add("Andreas");
        return nimet;
    }

    private static ArrayList<Hyppaaja> luoHyppaajat01() {
        ArrayList<Hyppaaja> hyppaajat = new ArrayList<>();
        hyppaajat.add(new Hyppaaja("Matti"));
        hyppaajat.add(new Hyppaaja("Jens"));
        hyppaajat.add(new Hyppaaja("Richard"));
        hyppaajat.add(new Hyppaaja("Adam"));
        hyppaajat.add(new Hyppaaja("Noriaki"));
        hyppaajat.add(new Hyppaaja("Andreas"));
        return hyppaajat;
    }

    private static void tulostaLopputulokset(Kilpailu kilpailu) {
        ArrayList<Hyppaaja> hyppaajat = kilpailu.haeLopputulokset();
        int i = 1;
        for (Hyppaaja hyppaaja : hyppaajat) {
            System.out.println(i + "       " + hyppaaja);
            System.out.println("          hyppyjen pituudet: " + hyppaaja.getHypyt());
            i++;
        }
    }

    private static void tulostaHyppyjarjestys(ArrayList<Hyppaaja> hyppaajat) {
        int i = 1;
        for (Hyppaaja hyppaaja : hyppaajat) {
            System.out.println(i + ". " + hyppaaja);
            i++;
        }
    }

}
