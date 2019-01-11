package kopiokaannin;

import java.util.Arrays;

public class Paaohjelma {

    public static void main(String[] args) {
//        testi01();
//        testi02();
        testi03();
    }

    private static void testi01() {
        int[] alkuperainen = {1, 2, 3, 4};
        int[] kopio = new Taulukot().kopioi(alkuperainen);
        // muutetaan kopioa
        kopio[0] = 99;
        tulostaTaulukot(alkuperainen, kopio);
        /*
        alkup  : [1, 2, 3, 4]
        toinen : [99, 2, 3, 4]
         */
    }

    private static void testi02() {
        int[] alkuperainen = {20, 40, 60, 80};
        int[] kopio = new Taulukot().kopioi(alkuperainen);
//        kopio[0] = 66;
//        kopio[2] = 66;
        tulostaTaulukot(alkuperainen, kopio);
    }

    private static void testi03() {
        int[] alkuperainen = {1, 2, 3, 4};
        int[] kaannetty = new Taulukot().kaanna(alkuperainen);
        tulostaTaulukot(alkuperainen, kaannetty);
        /*
        alkup  : [1, 2, 3, 4]
        toinen : [4, 3, 2, 1]
         */
    }

    private static void tulostaTaulukot(int[] alkuperainen, int[] toinen) {
        System.out.println("alkup  : " + Arrays.toString(alkuperainen));
        System.out.println("toinen : " + Arrays.toString(toinen));
    }

}
