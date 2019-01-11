package laskentaa;

public class Main {

    public static void main(String[] args) {
        testi01();
//        testi02();
    }

    private static void testi01() {
        Laskin laskin = new Laskin();
        Laskin superLaskin = new SuperLaskin();
        int luku = 3;
        luku = superLaskin.vahennaLuvusta(luku);
        luku = superLaskin.lisaaLukuun(luku);
        luku = laskin.lisaaLukuun(luku);
        System.out.println(luku);
    }

    private static void testi02() {
    }
}
