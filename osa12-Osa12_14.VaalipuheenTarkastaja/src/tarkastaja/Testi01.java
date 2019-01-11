/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarkastaja;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author einomies
 */
public class Testi01 {

    public static void main(String[] args) {
//        testi01();
//        testi02();
//        testi03();
//        testi04();
//        testi05();
        testi06();
//        testi07();
//        testi08();
    }

    private static void testi01() {
        Ennustaja ennustaja = new Ennustaja();
        ennustaja.lisaa(true, "minulla on rohkeutta");
        ennustaja.lisaa(true, "olen positiivisesti ajatteleva ja yhteistyökykyinen");
        ennustaja.lisaa(true, "olen valmis valtuustoon");
        ennustaja.lisaa(false, "olen ollut aktiivinen kuntapolitiikassa");
        ennustaja.lisaa(false, "olen ollut yhteiskunnan asioissa aina aktiivinen toimija");
        ennustaja.lisaa(false, "haluan olla valtuustossa");
        tulostaVastauksia(ennustaja, 10);
    }

    private static void testi02() {
        Ennustaja ennustaja = new Ennustaja();
        ennustaja.lisaa(true, "minulla on rohkeutta");
        ennustaja.lisaa(true, "olen positiivisesti ajatteleva ja yhteistyökykyinen");
        ennustaja.lisaa(true, "olen valmis valtuustoon");
        ennustaja.lisaa(false, "olen ollut aktiivinen kuntapolitiikassa");
        ennustaja.lisaa(false, "olen ollut yhteiskunnan asioissa aina aktiivinen toimija");
        ennustaja.lisaa(false, "haluan olla valtuustossa");

        System.out.println(ennustaja.valitaanSanojenLukumaariinPerustuen("haluan valtuustoon"));
        System.out.println(ennustaja.valitaanSanojenLukumaariinPerustuen("olen aktiivinen toimija"));
        System.out.println(ennustaja.valitaanSanojenLukumaariinPerustuen("olen yhteistyökykyinen"));

        /*
        0
        -1
        1
         */
    }

    private static void testi03() {
        Ennustaja ennustaja = new Ennustaja();
        ennustaja.taydennaTaustadata();
        String lause = "";
        /*
        laajat, 19 vs 6
        osaamiset 0
        alueellisesti, 2 vs 0
        
        olen, 2339 vs 1507
         */

        tulostaEnnustajanLukumaarista(ennustaja, "laajat osaamiset");
        tulostaEnnustajanLukumaarista(ennustaja, "laajat osaamiset alueellisesti");
        tulostaEnnustajanLukumaarista(ennustaja, "laajat osaamiset alueellisesti olen");

        ArrayList<String> voittavatSanat = ennustaja.haeVoittavatSanat();
        System.out.println("Voittavat sanat:");
        for (String sana : voittavatSanat) {
            System.out.println(sana);
        }

        ArrayList<String> haviavatSanat = ennustaja.haeHaviavatSanat();
        System.out.println("Häviävät sanat:");
        for (String sana : haviavatSanat) {
            System.out.println(sana);
        }

//        System.out.println();
//        System.out.println("Voittavat vs häviävät: " + voittavatSanat.size() + " - " + haviavatSanat.size());
//        ArrayList<String> tasurit = ennustaja.haeTasurit();
//        System.out.println();
//        System.out.println("Tasurit: " + tasurit.size());
//        for (String sana : tasurit) {
//            System.out.println(sana);
//        }
    }

    private static void testi04() {
        Ennustaja ennustaja = new Ennustaja();
//        ennustaja.taydennaTaustadata();
        ennustaja.lisaa(true, "minulla on rohkeutta");
        ennustaja.lisaa(true, "olen positiivisesti ajatteleva ja yhteistyökykyinen");
        ennustaja.lisaa(true, "olen valmis valtuustoon");
        ennustaja.lisaa(false, "olen ollut aktiivinen kuntapolitiikassa");
        ennustaja.lisaa(false, "olen ollut yhteiskunnan asioissa aina aktiivinen toimija");
        ennustaja.lisaa(false, "haluan olla valtuustossa");
        tulostaKaikki(ennustaja);
    }

    private static void testi05() {
        Ennustaja ennustaja = new Ennustaja();
        ennustaja.lisaa(true, "a b");
        ennustaja.lisaa(true, "a c d");
        ennustaja.lisaa(true, "b c");
        ennustaja.lisaa(true, "a a");
        ennustaja.lisaa(false, "c c d");
        ennustaja.lisaa(false, "a b d");
        ennustaja.lisaa(false, "a b");
        ennustaja.lisaa(false, "c d");
        ennustaja.lisaa(false, "c d d d");
        
        tulostaKaikki(ennustaja);

        tulostaEnnustajanLukumaarista(ennustaja, "olen aktiivinen toimija");
        tulostaEnnustajanLukumaarista(ennustaja, "");
        tulostaEnnustajanLukumaarista(ennustaja, "a");
        tulostaEnnustajanLukumaarista(ennustaja, "b");
        tulostaEnnustajanLukumaarista(ennustaja, "a b c");

        System.out.println();

        tulostaMystisellaEnnustajalla(ennustaja, "a");
        tulostaMystisellaEnnustajalla(ennustaja, "b");
        tulostaMystisellaEnnustajalla(ennustaja, "a b c");

        /*
        0
        0
        1
        0
        0

        1
        -1
        -1
         */
    }

    private static void testi06() {
        Ennustaja ennustaja = new Ennustaja();
        ennustaja.taydennaTaustadata();

        tulostaMystisellaEnnustajalla(ennustaja, "minulla on rohkeutta");
        tulostaMystisellaEnnustajalla(ennustaja, "olen positiivisesti ajatteleva ja yhteistyökykyinen");
        tulostaMystisellaEnnustajalla(ennustaja, "olen valmis valtuustoon");
        tulostaMystisellaEnnustajalla(ennustaja, "olen ollut aktiivinen kuntapolitiikassa");
        tulostaMystisellaEnnustajalla(ennustaja, "olen ollut yhteiskunnan asioissa aina aktiivinen toimija");
        tulostaMystisellaEnnustajalla(ennustaja, "haluan olla valtuustossa");

        tulostaMystisellaEnnustajalla(ennustaja, "laajat osaamiset");
        tulostaMystisellaEnnustajalla(ennustaja, "laajat osaamiset alueellisesti");
        tulostaMystisellaEnnustajalla(ennustaja, "laajat osaamiset alueellisesti olen");
    }

    private static void testi07() {
    }

    private static void testi08() {
    }

    private static void tulostaVastauksia(Ennustaja ennustaja, int lkm) {
        ArrayList<EhdokkaanVastaus> vastaukset = ennustaja.haeVastauksia(lkm);
        for (int i = 0; i < vastaukset.size(); i++) {
            System.out.println(vastaukset.get(i));
        }
//        for (EhdokkaanVastaus ehdokkaanVastaus : vastaukset) {
//            System.out.println(ehdokkaanVastaus);
//        }
    }

    private static void tulostaKaikki(Ennustaja ennustaja) {
        HashMap<String, Sanatilasto> sanat = ennustaja.haeKaikki();
        for (Map.Entry<String, Sanatilasto> entry : sanat.entrySet()) {
            String key = entry.getKey();
            Sanatilasto value = entry.getValue();
            System.out.println(value);
        }
    }

    private static void tulostaEnnustajanLukumaarista(Ennustaja ennustaja, String lause) {
        System.out.println(lause + ", valitaanSanojenLukumaariinPerustuen: "
                + ennustaja.valitaanSanojenLukumaariinPerustuen(lause));
    }

    private static void tulostaMystisellaEnnustajalla(Ennustaja ennustaja, String lause) {
        System.out.println(lause + ", valitaanMystisellaEnnustajalla: "
                + ennustaja.valitaanMystisellaEnnustajalla(lause));
    }

}
