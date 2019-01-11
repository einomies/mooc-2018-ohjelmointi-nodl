package siirrettava;

public class Paaohjelma {

    public static void main(String[] args) {
//        testi01();
        testi02();
//        testi03();
    }

    private static void testi01() {
        Elio elio = new Elio(20, 30);
        System.out.println(elio);
        elio.siirra(-10, 5);
        System.out.println(elio);
        elio.siirra(50, 20);
        System.out.println(elio);
        /*
        x: 20; y: 30
        x: 10; y: 35
        x: 60; y: 55
         */
    }

    private static void testi02() {
        Lauma lauma = new Lauma();
        lauma.lisaaLaumaan(new Elio(73, 56));
        lauma.lisaaLaumaan(new Elio(57, 66));
        lauma.lisaaLaumaan(new Elio(46, 52));
        lauma.lisaaLaumaan(new Elio(19, 107));
        System.out.println(lauma);
        /*
        x: 73; y: 56
        x: 57; y: 66
        x: 46; y: 52
        x: 19; y: 107
         */
    }

    private static void testi03() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
