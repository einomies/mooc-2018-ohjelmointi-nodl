package sovellus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

/**
 * Sanakirja toteutetaan hajautustaulun ja listan avulla. Hajautustaulu sisältää
 * sanat ja niiden käännökset, ja listaa käytetään satunnaisesti kysyttävän
 * sanan arpomiseen. Luokalla on metodit käännösten lisäämiseen, käännöksen
 * hakemiseen sekä käännettävän sanan arpomiseen.
 *
 * @author einomies
 */
public class Sanakirja {

    private List<String> sanat;
    private Map<String, String> kaannokset;

    public Sanakirja() {
        this.sanat = new ArrayList<>();
        this.kaannokset = new HashMap<>();
        lisaaSanoja();
    }

    public String hae(String sana) {
        return this.kaannokset.get(sana);
    }

    public void lisaa(String sana, String kaannos) {
        if (!this.kaannokset.containsKey(sana)) {
            this.sanat.add(sana);
        }
        this.kaannokset.put(sana, kaannos);
    }

    public String arvoSana() {
        Random satunnainen = new Random();
        return this.sanat.get(satunnainen.nextInt(this.sanat.size()));
    }

    public HashMap<String, String> listaaKaikki() {
        HashMap<String, String> mappi = new HashMap<>();
        mappi.putAll(this.kaannokset);
        return mappi;
    }

    private void lisaaSanoja() {
        lisaa("sana", "word");
        lisaa("kynä", "pen");
        lisaa("jalkapallo", "football");
        lisaa("tietokone", "computer");
        lisaa("pelata", "play");
        lisaa("syödä", "eat");
        lisaa("juoda", "drink");
        lisaa("juosta", "run");
        lisaa("puhua", "talk");
        lisaa("nukkua", "sleep");
        lisaa("kissa", "cat");
        lisaa("koira", "dog");
        lisaa("poika", "boy");
        lisaa("tyttö", "girl");
        lisaa("auto", "car");
        lisaa("polkupyörä", "bicycle");
        lisaa("laulu", "song");
        lisaa("laulaa", "sing");
        lisaa("kitara", "guitar");
        lisaa("rummut", "drums");
        lisaa("piano", "piano");
        lisaa("tai", "or");
        lisaa("ja", "and");
        lisaa("pää", "head");
        lisaa("käsi", "hand");
        lisaa("jalka", "foot");
        lisaa("sormi", "finger");
        lisaa("varvas", "toe");
        lisaa("aamu", "morning");
        lisaa("päivä", "day");
        lisaa("ilta", "evening");
        lisaa("yö", "night");
        lisaa("kirja", "book");
        lisaa("lukea", "read");
        lisaa("huutaa", "scream");
        lisaa("xxxxxx", "xxxxxxxxx");
    }

    /**
     * Sanakirjan voisi toteuttaa myös niin, että sanan arpominen loisi aina
     * uuden listan kaannokset-hajautustaulun avaimista. Tällöin sanat-listalle
     * ei olisi erillistä tarvetta. Tämä vaikuttaisi kuitenkin sovelluksen
     * tehokkuuteen (tai, olisi ainakin vaikuttanut ennen vuosituhannen
     * vaihdetta - nykyään koneet ovat jo hieman nopeampia..).
     */
}

/*
package sovellus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Sanakirja {

    private List<String> sanat;
    private Map<String, String> kaannokset;

    public Sanakirja() {
        this.sanat = new ArrayList<>();
        this.kaannokset = new HashMap<>();
        lisaa("sana", "word");
    }

    public String hae(String sana) {
        return this.kaannokset.get(sana);
    }

    public void lisaa(String sana, String kaannos) {
        if (!this.kaannokset.containsKey(sana)) {
            this.sanat.add(sana);
        }
        this.kaannokset.put(sana, kaannos);
    }

    public String arvoSana() {
        Random satunnainen = new Random();
        return this.sanat.get(satunnainen.nextInt(this.sanat.size()));
    }

    public int sanoja() {
        return this.sanat.size();
    }
}
*/