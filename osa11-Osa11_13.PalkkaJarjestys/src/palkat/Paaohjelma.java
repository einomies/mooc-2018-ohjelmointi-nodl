package palkat;

import java.util.ArrayList;
import java.util.Collections;

public class Paaohjelma {

    public static void main(String[] args) {
//        testi01();
        testi02();
    }

    private static void testi01() {
        ArrayList<Ihminen> ihmisia = new ArrayList<>();
        ihmisia.add(new Ihminen("Matti", 15000));
        ihmisia.add(new Ihminen("Merja", 3500));
        ihmisia.add(new Ihminen("Pertti", 4800));
        ihmisia.add(new Ihminen("Margaret", 5600));

        System.out.println(ihmisia);

        /*
        * Poista alla olevat kommentit, kun olet tehnyt compareTo metodin.
         */
        Collections.sort(ihmisia);
        System.out.println(ihmisia);
    }

    private static void testi02() {
        Ihminen matti = new Ihminen("Matti", 15000);
        Ihminen merja = new Ihminen("Merja", 3500);
        Ihminen margaret = new Ihminen("Margaret", 5600);

        tulostaVertailu(matti, merja);
        tulostaVertailu(matti, margaret);

        tulostaVertailu(merja, matti);
        tulostaVertailu(merja, margaret);

        tulostaVertailu(margaret, matti);
        tulostaVertailu(margaret, merja);
    }

    private static void tulostaVertailu(Ihminen thisOlio, Ihminen vertailtavaOlio) {
        System.out.println(thisOlio +" compareTo " +vertailtavaOlio +": "
                +thisOlio.compareTo(vertailtavaOlio));
    }

}
