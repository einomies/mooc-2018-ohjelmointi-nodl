package esimerkki;

import java.util.ArrayList;

public class ListaTesti {

    public static void main(String[] args) {
//        testi01();
//        testi02();
//        testi03();
//        testi04();
//        testi05();
//        testi06();
        testi07();
    }

    private static void testi01() {
        ArrayList<String> merkkijonot = new ArrayList<>();
        System.out.println(merkkijonot.contains("Hei!"));
        merkkijonot.add("Hei!");
        System.out.println(merkkijonot.contains("Hei!"));
        merkkijonot.remove("Hei!");
        System.out.println(merkkijonot.contains("Hei!"));

        // false
        // true
        // false
    }

    private static void testi02() {
        Lista<String> lista = new Lista<>();
        lista.lisaa("hei");
        lista.lisaa("maailma");
    }

    private static void testi03() {
        Lista<String> lista = new Lista<>();
        for (int i = 0; i < 11; i++) {
            lista.lisaa("hei");
        }
//        Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 10
    }

    private static void testi04() {
        Lista<String> lista = new Lista<>();
        System.out.println(lista.sisaltaa("hei"));
        lista.lisaa("hei");
        System.out.println(lista.sisaltaa("hei"));
        /*
        false
        true
         */
    }

    private static void testi05() {
        Lista<String> lista = new Lista<>();
        System.out.println(lista.sisaltaa("hei"));
        lista.lisaa("hei");
        System.out.println(lista.sisaltaa("hei"));
        lista.poista("hei");
        System.out.println(lista.sisaltaa("hei"));
        /*
        false
        true
        false
         */
    }

    private static void testi06() {
        Lista<String> lista = new Lista<>();
        System.out.println(lista.sisaltaa("hei"));
        lista.lisaa("hei");
        System.out.println(lista.sisaltaa("hei"));
        int indeksi = lista.arvonIndeksi("hei");
        System.out.println(indeksi);
        System.out.println(lista.arvo(indeksi));
        lista.poista("hei");
        System.out.println(lista.sisaltaa("hei"));
        /*
        false
        true
        0
        hei
        false
         */
    }

    private static void testi07() {
        Lista<String> lista = new Lista<>();
        lista.lisaa("hei");
        lista.lisaa("maailma");

        for (int i = 0; i < lista.koko(); i++) {
            System.out.println(lista.arvo(i));
        }
        /*
        hei
        maailma
         */
    }

}
