package kortit;

import java.util.ArrayList;
import java.util.Collections;

public class Paaohjelma {

    public static void main(String[] args) {
//        testi01();
//        testi02();
//        testi03();
//        testi04();
        testi05();
//        testi06();
//        testi07();
    }

    private static void testi01() {
        Kortti eka = new Kortti(2, Maa.RUUTU);
        Kortti toka = new Kortti(14, Maa.PATA);
        Kortti kolmas = new Kortti(12, Maa.HERTTA);

        System.out.println(eka);
        System.out.println(toka);
        System.out.println(kolmas);

        /*
        RUUTU 2
        PATA A
        HERTTA Q
         */
    }

    private static void testi02() {
        Kasi kasi = new Kasi();

        kasi.lisaa(new Kortti(2, Maa.RUUTU));
        kasi.lisaa(new Kortti(14, Maa.PATA));
        kasi.lisaa(new Kortti(12, Maa.HERTTA));
        kasi.lisaa(new Kortti(2, Maa.PATA));

        kasi.tulosta();

        /*
        RUUTU 2
        PATA A
        HERTTA Q
        PATA 2
         */
    }

    private static void testi03() {
        Kasi kasi = new Kasi();

        kasi.lisaa(new Kortti(2, Maa.RUUTU));
        kasi.lisaa(new Kortti(14, Maa.PATA));
        kasi.lisaa(new Kortti(12, Maa.HERTTA));
        kasi.lisaa(new Kortti(2, Maa.PATA));

        kasi.jarjesta();

        kasi.tulosta();

        /*
        RUUTU 2
        PATA 2
        HERTTA Q
        PATA A
         */
    }

    private static void testi04() {
        Kasi kasi1 = new Kasi();
        kasi1.lisaa(new Kortti(2, Maa.RUUTU));
        kasi1.lisaa(new Kortti(14, Maa.PATA));
        kasi1.lisaa(new Kortti(12, Maa.HERTTA));
        kasi1.lisaa(new Kortti(2, Maa.PATA));

        Kasi kasi2 = new Kasi();
        kasi2.lisaa(new Kortti(11, Maa.RUUTU));
        kasi2.lisaa(new Kortti(11, Maa.PATA));
        kasi2.lisaa(new Kortti(11, Maa.HERTTA));

        int vertailu = kasi1.compareTo(kasi2);

        if (vertailu < 0) {
            System.out.println("arvokkaampi käsi sisältää kortit");
            kasi2.tulosta();
        } else if (vertailu > 0) {
            System.out.println("arvokkaampi käsi sisältää kortit");
            kasi1.tulosta();
        } else {
            System.out.println("kädet yhtä arvokkaat");
        }

        /*
        arvokkaampi käsi sisältää kortit
        RUUTU J
        PATA J
        HERTTA J
         */
    }

    private static void testi05() {
        ArrayList<Kortti> kortit = new ArrayList<>();

        kortit.add(new Kortti(3, Maa.PATA));
        kortit.add(new Kortti(2, Maa.RUUTU));
        kortit.add(new Kortti(14, Maa.PATA));
        kortit.add(new Kortti(12, Maa.HERTTA));
        kortit.add(new Kortti(2, Maa.PATA));

//tapa 1:
//      SamatMaatVierekkain samatMaatVierekkainJarjestaja = new SamatMaatVierekkain();
//      Collections.sort(kortit, samatMaatVierekkainJarjestaja);
//tapa 2:
//      Collections.sort(kortit, new SamatMaatVierekkain());
//tapa3:
        Collections.sort(kortit, (k1, k2) -> k1.getMaa().ordinal() - k2.getMaa().ordinal());

        kortit.stream().forEach(k -> System.out.println(k));

        /*
        RUUTU 2
        HERTTA Q
        PATA 3
        PATA A
        PATA 2
         */
    }

    private static void testi06() {
        Kasi kasi = new Kasi();

        kasi.lisaa(new Kortti(12, Maa.HERTTA));
        kasi.lisaa(new Kortti(4, Maa.PATA));
        kasi.lisaa(new Kortti(2, Maa.RUUTU));
        kasi.lisaa(new Kortti(14, Maa.PATA));
        kasi.lisaa(new Kortti(7, Maa.HERTTA));
        kasi.lisaa(new Kortti(2, Maa.PATA));

        kasi.jarjestaMaittain();

        kasi.tulosta();

        /*
        RUUTU 2
        HERTTA 7
        HERTTA Q
        PATA 2
        PATA 4
        PATA A
         */
    }

    private static void testi07() {
    }

}
