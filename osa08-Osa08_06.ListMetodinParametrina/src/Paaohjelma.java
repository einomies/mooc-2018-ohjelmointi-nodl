
import java.util.ArrayList;
import java.util.List;

/*
Toteuta luokkaan ListanTarkistin metodi palautaKoko, joka saa parametrina List-olion
ja palauttaa sen koon kokonaislukuna.

Metodin tulee toimia esimerkiksi seuraavasti:

List<String> nimet = new ArrayList<>();
nimet.add("eka");
nimet.add("toka");
nimet.add("kolmas");

System.out.println(new ListanTarkistin().palautaKoko(nimet));
3
 */
public class Paaohjelma {

    public static void main(String[] args) {
        List<String> nimet = new ArrayList<>();
        nimet.add("eka");
        nimet.add("toka");
        nimet.add("kolmas");

        System.out.println(new ListanTarkistin().palautaKoko(nimet));
    }

}
