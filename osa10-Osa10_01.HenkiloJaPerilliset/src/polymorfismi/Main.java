package polymorfismi;

import laskentaa.*;
import pisteet.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        testi01();
//        testi02();
    }

    private static void testi01() {
        Opiskelija opiskelija = new Opiskelija("Kenny", 23, 140);

        Henkilo henkilo = opiskelija;
        Object object = opiskelija;

        System.out.print(opiskelija + ", ");
        System.out.print(henkilo + ", ");
        System.out.println(object);
    }

    private static void testi02() {
    }
}
