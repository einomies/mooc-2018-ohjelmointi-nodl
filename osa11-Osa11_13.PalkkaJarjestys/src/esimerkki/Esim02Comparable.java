/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esimerkki;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author einomies
 */
public class Esim02Comparable {

    public static void main(String[] args) {
        testi01();
//        testi02();
//        testi03();
    }

    private static void testi01() {
        List<Kerholainen> kerholaiset = new ArrayList<>();
        kerholaiset.add(new Kerholainen("mikael", 182));
        kerholaiset.add(new Kerholainen("matti", 187));
        kerholaiset.add(new Kerholainen("ada", 184));

        kerholaiset.stream().forEach(k -> System.out.println(k));
        System.out.println();

// tulostettavan virran järjestäminen (listaa ei järjestetä)
        kerholaiset.stream().sorted().forEach(k -> System.out.println(k));
        System.out.println();
        kerholaiset.stream().forEach(k -> System.out.println(k));
        System.out.println();

// listan järjestäminen
        Collections.sort(kerholaiset);
        kerholaiset.stream().forEach(k -> System.out.println(k));
        System.out.println();

        /*
        mikael (182)
        matti (187)
        ada (184)

        mikael (182)
        ada (184)
        matti (187)

        mikael (182)
        matti (187)
        ada (184)

        mikael (182)
        ada (184)
        matti (187)
         */
    }

    private static void testi02() {
    }

    private static void testi03() {
    }

}
