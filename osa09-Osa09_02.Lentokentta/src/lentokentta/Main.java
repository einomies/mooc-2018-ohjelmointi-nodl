package lentokentta;

import java.util.Scanner;
import lentokentta.logiikka.Lentohallinta;
import lentokentta.ui.Tekstikayttoliittyma;

public class Main {

    public static void main(String[] args) {
        testi01();
//        testi02();
//        testi03();
    }

    private static void testi01() {
        Lentohallinta lentohallinta = new Lentohallinta();
        Scanner scanner = new Scanner(System.in);
        Tekstikayttoliittyma ui = new Tekstikayttoliittyma(lentohallinta, scanner);
        ui.kaynnista();
        /*
        public Tekstikayttoliittyma(Lentohallinta lentohallinta, Scanner lukija) {
        this.lentohallinta = lentohallinta;
        this.lukija = lukija;
         */
    }

    private static void testi02() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void testi03() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
