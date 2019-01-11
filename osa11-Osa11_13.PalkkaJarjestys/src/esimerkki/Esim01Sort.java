/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esimerkki;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author einomies
 */
public class Esim01Sort {

    public static void main(String[] args) {
//        testi01();
        testi02();
    }

    private static void testi01() {
        int[] luvut = {8, 3, 7, 9, 1, 2, 4};
        System.out.println(Arrays.toString(luvut));
        Arrays.sort(luvut);
        System.out.println(Arrays.toString(luvut));
        /*
        [8, 3, 7, 9, 1, 2, 4]
        [1, 2, 3, 4, 7, 8, 9]
         */
    }

    private static void testi02() {
        ArrayList<Integer> luvut = new ArrayList<>();
        luvut.add(8);
        luvut.add(3);
        luvut.add(7);
        System.out.println(luvut);
        Collections.sort(luvut);
        System.out.println(luvut);
        /*
        [8, 3, 7]
        [3, 7, 8]
         */
    }

}
