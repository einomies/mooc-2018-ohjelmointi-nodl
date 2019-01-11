/*
Toteuta luokkaan HajautustaulunTarkistin metodi palautaKoko, joka saa parametrina
Map-olion ja palauttaa sen koon kokonaislukuna.

Metodin tulee toimia esimerkiksi seuraavasti:

Map<String, String> nimet = new HashMap<>();
nimet.put("eka", "first");
nimet.put("toka", "second");

System.out.println(new HajautustaulunTarkistin().palautaKoko(nimet));
2
 */

import java.util.HashMap;
import java.util.Map;

public class Paaohjelma {

    public static void main(String[] args) {
        testi01();
        testi02();
    }

    private static void testi01() {
        Map<String, String> kaannokset = new HashMap<>();
        kaannokset.put("gambatte", "tsemppiä");
        kaannokset.put("hai", "kyllä");

        for (String avain : kaannokset.keySet()) {
            System.out.println(avain + ": " + kaannokset.get(avain));
        }
    }

    private static void testi02() {
        Map<String, String> nimet = new HashMap<>();
        nimet.put("eka", "first");
        nimet.put("toka", "second");
        System.out.println(new HajautustaulunTarkistin().palautaKoko(nimet));
    }

}
