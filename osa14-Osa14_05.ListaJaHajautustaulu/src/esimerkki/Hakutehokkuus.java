package esimerkki;

import java.util.Random;

/**
 * Tarkastellaan vielä hakemisen tehokkuutta listasta ja hajautustaulusta.
 * Tehokkuusmittauksia voi tehdä metodin System.nanotime() palauttaman
 * nanosekunteja kuvaavan arvon avulla. Ohjelma luo ensin miljoona alkiota
 * hajautustauluun ja listaan, jonka jälkeen hajautustaulusta ja listasta
 * etsitään tuhatta satunnaista arvoa. Noin 50% arvoista löytyy listalta ja
 * hajautustaulusta.
 */
public class Hakutehokkuus {

    public static void main(String[] args) {
        Lista<String> lista = new Lista<>();
        Hajautustaulu<String, String> taulu = new Hajautustaulu<>();

        for (int i = 0; i < 1000000; i++) {
            System.out.println("i=" + i);
            lista.lisaa("" + i);
            taulu.lisaa("" + i, "" + i);
        }

        Lista<String> haettavat = new Lista<>();
        Random arpoja = new Random();
        for (int i = 0; i < 1000; i++) {
            haettavat.lisaa("" + arpoja.nextInt(2000000));
        }

        long listanHakuAloitus = System.nanoTime();
        for (int i = 0; i < haettavat.koko(); i++) {
            lista.sisaltaa(haettavat.arvo(i));
        }
        long listanHakuLopetus = System.nanoTime();

        long hajautustaulunHakuAloitus = System.nanoTime();
        for (int i = 0; i < haettavat.koko(); i++) {
            taulu.hae(haettavat.arvo(i));
        }
        long hajautustaulunHakuLopetus = System.nanoTime();

        long listanHaku = listanHakuLopetus - listanHakuAloitus;
        System.out.println("Lista: haku kesti noin " + listanHaku / 1000000 + " millisekuntia ("
                + listanHaku + " nanosekuntia.)");

        long hajautustaulunHaku = hajautustaulunHakuLopetus - hajautustaulunHakuAloitus;
        System.out.println("Hajautustaulu: haku kesti noin " + hajautustaulunHaku / 1000000
                + " millisekuntia (" + hajautustaulunHaku + " nanosekuntia.)");
    }

}
