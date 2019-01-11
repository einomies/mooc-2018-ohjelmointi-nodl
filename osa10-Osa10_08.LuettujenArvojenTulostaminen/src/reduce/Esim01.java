/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reduce;

import java.util.ArrayList;

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
        /*
        Kokonaislukuja sisältävän listan summan saa luotua reduce-metodin avulla
        seuraavasti.
         */
        ArrayList<Integer> luvut = new ArrayList<>();
        luvut.add(7);
        luvut.add(3);
        luvut.add(2);
        luvut.add(1);

        int summa = luvut.stream()
                .reduce(0, (edellinenSumma, luku) -> edellinenSumma + luku);
        System.out.println(summa);

        //13
    }

    private static void testi02() {
        /*
        Vastaavasti merkkijonoista koostuvasta listasta saa luotua rivitetyn merkkijonon seuraavasti.
         */
        ArrayList<String> sanat = new ArrayList<>();
        sanat.add("Eka");
        sanat.add("Toka");
        sanat.add("Kolmas");
        sanat.add("Neljäs");

        String yhdistetty = sanat.stream()
                .reduce("", (edellinenMjono, sana) -> edellinenMjono + sana + "\n");
        System.out.println(yhdistetty);
        /*
        Eka
        Toka
        Kolmas
        Neljäs
         */
    }

}
