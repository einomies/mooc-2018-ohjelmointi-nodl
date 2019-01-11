/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esimerkki;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author einomies
 */
public class Esim01 {

    public static void main(String[] args) {

//        testi01();
        testi02();
    }

    private static void testi01() {
        List<Kerholainen> kerholaiset = luoLista01();
        Collections.sort(kerholaiset);

        Kerholainen haettava = new Kerholainen("Nimi", 180);
        int indeksi = Collections.binarySearch(kerholaiset, haettava);

        if (indeksi >= 0) {
            System.out.println("180 senttiä pitkä löytyi indeksistä " + indeksi);
            System.out.println("nimi: " + kerholaiset.get(indeksi).getNimi());
        }

        haettava = new Kerholainen("Nimi", 187);
        indeksi = Collections.binarySearch(kerholaiset, haettava);

        if (indeksi >= 0) {
            System.out.println("187 senttiä pitkä löytyi indeksistä " + indeksi);
            System.out.println("nimi: " + kerholaiset.get(indeksi).getNimi());
        }
        /*
        187 senttiä pitkä löytyi indeksistä 2
        nimi:
        matti
         */
    }

    private static List<Kerholainen> luoLista01() {
        List<Kerholainen> kerholaiset = new ArrayList<>();
        kerholaiset.add(new Kerholainen("mikael", 182));
        kerholaiset.add(new Kerholainen("matti", 187));
        kerholaiset.add(new Kerholainen("joel", 184));
        return kerholaiset;
    }

    private static void testi02() {
        List<Kerholainen> kerholaiset = luoLista02();
        kerholaiset.stream().forEach(k -> System.out.println(k));
        Collections.sort(kerholaiset);
        Collections.reverse(kerholaiset);

        System.out.println();

        kerholaiset.stream().forEach(k -> System.out.println(k));

        System.out.println();
        System.out.println(Collections.max(kerholaiset));
        /*
        mikael (182)
        matti (187)
        ada (184)

        matti (187)
        ada (184)
        mikael (182)

        matti (187)
         */
    }

    private static List<Kerholainen> luoLista02() {
        List<Kerholainen> kerholaiset = new ArrayList<>();
        kerholaiset.add(new Kerholainen("mikael", 182));
        kerholaiset.add(new Kerholainen("matti", 187));
        kerholaiset.add(new Kerholainen("ada", 184));
        return kerholaiset;
    }

}
