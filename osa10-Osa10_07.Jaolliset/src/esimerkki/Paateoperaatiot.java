package esimerkki;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
Tarkastellaan tässä neljää pääteoperaatiota: listan arvojen lukumäärän selvittämistä
count-metodin avulla, listan arvojen läpikäyntiä forEach-metodin avulla sekä listan
arvojen keräämistä tietorakenteeseen collect-metodin avulla, sekä listan alkioiden
yhdistämistä reduce-metodin avulla.
 */
/**
 *
 * @author einomies
 */
public class Paateoperaatiot {

    public static void main(String[] args) {
//        testi01();
//        testi02();
        testi03();
    }

    private static void testi01() {
//      Metodi count kertoo virran alkioiden lukumäärän long-tyyppisenä muuttujana.
        List<Integer> luvut = new ArrayList<>();
        luvut.add(3);
        luvut.add(2);
        luvut.add(17);
        luvut.add(6);
        luvut.add(8);

        System.out.println("Lukuja: " + luvut.stream().count());

        /*Lukuja: 5*/
    }

    private static void testi02() {
        /*
        Metodi forEach kertoo mitä kullekin listan arvolle tulee tehdä ja samalla
        päättää virran käsittelyn. Alla olevassa esimerkissä luodaan ensin numeroita
        sisältävä lista, jonka jälkeen tulostetaan vain kahdella jaolliset luvut.
         */
        List<Integer> luvut = new ArrayList<>();
        luvut.add(3);
        luvut.add(2);
        luvut.add(17);
        luvut.add(6);
        luvut.add(8);

        luvut.stream()
                .filter(luku -> luku % 2 == 0)
                .forEach(luku -> System.out.println(luku));
        /*
        2
        6
        8
         */
    }

    private static void testi03() {
        /*
        Virran arvojen kerääminen toiseen kokoelmaan onnistuu metodin collect avulla.
        Alla olevassa esimerkissä luodaan uusi lista annetun positiivisista arvoista.
        Metodille collect annetaan parametrina Collectors-luokan avulla luotu olio,
        johon virran arvot kerätään -- esimerkiksi kutsu
        Collectors.toCollection(ArrayList::new) luo uuden ArrayList-olion, johon
        arvot kerätään.
         */
        List<Integer> luvut = new ArrayList<>();
        luvut.add(3);
        luvut.add(2);
        luvut.add(-17);
        luvut.add(-6);
        luvut.add(8);

        ArrayList<Integer> positiiviset = luvut.stream()
                .filter(luku -> luku > 0)
                .collect(Collectors.toCollection(ArrayList::new));

        positiiviset.stream()
                .forEach(luku -> System.out.println(luku));
        /*
        3
        2
        8
         */
    }

}
