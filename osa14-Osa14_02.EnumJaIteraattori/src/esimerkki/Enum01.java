/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esimerkki;

/**
 *
 * @author einomies
 */
public class Enum01 {

    public static void main(String[] args) {
        testi01();
        testi02();
        testi03();
    }

    private static void testi01() {
        Kortti eka = new Kortti(10, Maa.HERTTA);

        System.out.println(eka);

        if (eka.getMaa() == Maa.PATA) {
            System.out.println("on pata");
        } else {
            System.out.println("ei ole pata");
        }
        /*
        HERTTA 10
        ei ole pata
         */
    }

    private static void testi02() {
        System.out.println("Maa.RUUTU.ordinal(): " + Maa.RUUTU.ordinal());
        System.out.println("Maa.HERTTA.ordinal(): " + Maa.HERTTA.ordinal());
        System.out.println("Maa.RISTI.ordinal(): " + Maa.RISTI.ordinal());
        System.out.println("Maa.PATA.ordinal(): " + Maa.PATA.ordinal());
        /*
        0
        3
         */
    }

    private static void testi03() {
        System.out.println(Vari.VIHREA.getKoodi());
//        #00FF00
    }

}
