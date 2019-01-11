
import java.util.HashSet;
import java.util.Set;

/*
Toteuta luokkaan JoukonTarkistin metodi palautaKoko, joka saa parametrina Set-olion
ja palauttaa sen koon kokonaislukuna.

Metodin tulee toimia esimerkiksi seuraavasti:

Set<String> nimet = new HashSet<>();
nimet.add("eka");
nimet.add("eka");
nimet.add("toka");
nimet.add("toka");
nimet.add("toka");

System.out.println(new JoukonTarkistin().palautaKoko(nimet));

Tulostaa:
2
 */
public class Paaohjelma {

    public static void main(String[] args) {
        Set<String> nimet = new HashSet<>();
        nimet.add("eka");
        nimet.add("eka");
        nimet.add("toka");
        nimet.add("toka");
        nimet.add("toka");

        System.out.println(new JoukonTarkistin().palautaKoko(nimet));
    }

}
