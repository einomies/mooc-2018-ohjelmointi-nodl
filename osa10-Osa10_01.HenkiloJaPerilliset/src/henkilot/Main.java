package henkilot;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        testi01();
//        testi02();
//        testi03();
//        testi04();
//        testi05();
        testi06();
//        testi07();
//        testi08();
//        testi09();
//        testi10();
    }

    private static void testi01() {
        Henkilo ada = new Henkilo("Ada Lovelace", "Korsontie 1 03100 Vantaa");
        Henkilo esko = new Henkilo("Esko Ukkonen", "Mannerheimintie 15 00100 Helsinki");
        System.out.println(ada);
        System.out.println(esko);
        /*
        Ada Lovelace
          Korsontie 1 03100 Vantaa
        Esko Ukkonen
          Mannerheimintie 15 00100 Helsinki
         */
    }

    private static void testi02() {
        Opiskelija olli = new Opiskelija("Olli", "Ida Albergintie 1 00400 Helsinki");
        System.out.println(olli);
        System.out.println("opintopisteitä " + olli.opintopisteita());
        olli.opiskele();
        System.out.println("opintopisteitä " + olli.opintopisteita());
        /*
        Olli
          Ida Albergintie 1 00400 Helsinki
        opintopisteitä 0
        opintopisteitä 1
         */
    }

    private static void testi03() {
        Opiskelija olli = new Opiskelija("Olli", "Ida Albergintie 1 00400 Helsinki");
        System.out.println(olli);
        olli.opiskele();
        System.out.println(olli);
        /*
        Olli
          Ida Albergintie 1 00400 Helsinki
          opintopisteitä 0
        Olli
          Ida Albergintie 1 00400 Helsinki
          opintopisteitä 1
         */
    }

    private static void testi04() {
        Opettaja ada = new Opettaja("Ada Lovelace", "Korsontie 1 03100 Vantaa", 1200);
        Opettaja esko = new Opettaja("Esko Ukkonen", "Mannerheimintie 15 00100 Helsinki", 5400);
        System.out.println(ada);
        System.out.println(esko);

        Opiskelija olli = new Opiskelija("Olli", "Ida Albergintie 1 00400 Helsinki");
        for (int i = 0; i < 25; i++) {
            olli.opiskele();
        }
        System.out.println(olli);
        /*
        Ada Lovelace
          Korsontie 1 03100 Vantaa
          palkka 1200 euroa/kk
        Esko Ukkonen
          Mannerheimintie 15 00100 Helsinki
          palkka 5400 euroa/kk
        Olli
          Ida Albergintie 1 00400 Helsinki
          opintopisteitä 25
         */
    }

    private static void testi05() {

        List<Henkilo> henkilot = new ArrayList<Henkilo>();
        henkilot.add(new Opettaja("Ada Lovelace", "Korsontie 1 03100 Vantaa", 1200));
        henkilot.add(new Opiskelija("Olli", "Ida Albergintie 1 00400 Helsinki"));

        new HenkiloTulostus().tulostaLaitoksenHenkilot(henkilot);
        /*
        Ada Lovelace
          Korsontie 1 03100 Vantaa
          palkka 1200 euroa/kk
        Olli
          Ida Albergintie 1 00400 Helsinki
          opintopisteitä 0
         */
    }

    private static void testi06() {
        Opiskelija olli = new Opiskelija("Olli", "Ida Albergintie 1 00400 Helsinki");
        System.out.println(olli);
        Henkilo olliHenkilo = new Opiskelija("Olli", "Ida Albergintie 1 00400 Helsinki");
        System.out.println(olliHenkilo);
        Object olliObject = new Opiskelija("Olli", "Ida Albergintie 1 00400 Helsinki");
        System.out.println(olliObject);

        Object liisa = new Opiskelija("Liisa", "Väinö Auerin katu 20 00500 Helsinki");
        System.out.println(liisa);
        /*
        Olli
          Ida Albergintie 1 00400 Helsinki
          opintopisteitä 0
        Olli
          Ida Albergintie 1 00400 Helsinki
          opintopisteitä 0
        Olli
          Ida Albergintie 1 00400 Helsinki
          opintopisteitä 0
        Liisa
          Väinö Auerin katu 20 00500 Helsinki
          opintopisteitä 0
         */
    }

}
