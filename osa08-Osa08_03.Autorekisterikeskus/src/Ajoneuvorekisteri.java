
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author einomies
 */
public class Ajoneuvorekisteri {

    private HashMap<Rekisterinumero, String> omistajat = new HashMap<>();

    public Ajoneuvorekisteri() {
        this.omistajat = new HashMap<>();
    }

//  Lisää parametrina olevaa rekisterinumeroa vastaavalle autolle parametrina olevan
//  omistajan. Palauttaa true, jos omistajaa ei ollut ennestään. Jos rekisterinumeroa
//  vastaavalla autolla oli jo omistaja, metodi palauttaa false ja ei tee mitään.
    public boolean lisaa(Rekisterinumero rekkari, String omistaja) {
        if (!this.omistajat.containsKey(rekkari)) {
            this.omistajat.put(rekkari, omistaja);
            return true;
        }
        return false;
    }

//  Palauttaa parametrina olevaa rekisterinumeroa vastaavan auton omistajan.
//  Jos auto ei ole rekisterissä, palautetaan null.
    public String hae(Rekisterinumero rekkari) {
        if (this.omistajat.containsKey(rekkari)) {
            return this.omistajat.get(rekkari);
        }
        return null;
    }

//  Poistaa parametrina olevaa rekisterinumeroa vastaavat tiedot. Metodi palauttaa
//  true, jos tiedot poistetiin, ja false jos parametria vastaavia tietoja ei
//  ollut rekisterissä
    public boolean poista(Rekisterinumero rekkari) {
        if (this.omistajat.containsKey(rekkari)) {
            this.omistajat.remove(rekkari);
            return true;
        }
        return false;
    }

//  Tulostaa rekisterissä olevat rekisterinumerot
    public void tulostaRekisterinumerot() {
        for (Map.Entry<Rekisterinumero, String> entry : this.omistajat.entrySet()) {
//            Rekisterinumero key = entry.getKey();
//            String value = entry.getValue();
            System.out.println(entry.getKey());
        }
    }

//  Tulostaa rekisterissä olevien autojen omistajat. Kukin nimi tulee tulostaa
//  vain kertaalleen vaikka omistajalla olisikin useampi auto.
    public void tulostaOmistajat() {
        ArrayList<String> nimet = new ArrayList<>();
        for (Map.Entry<Rekisterinumero, String> entry : this.omistajat.entrySet()) {
            if (!nimet.contains(entry.getValue())) {
                nimet.add(entry.getValue());
            }
        }
        for (String nimi : nimet) {
            System.out.println(nimi);
        }
    }

}

/*
import java.util.HashMap;
import java.util.HashSet;
public class Ajoneuvorekisteri {
    private HashMap<Rekisterinumero, String> omistajat;
    public Ajoneuvorekisteri() {
        omistajat = new HashMap<>();
    }
    public boolean lisaa(Rekisterinumero rekkari, String omistaja) {
        if (omistajat.containsKey(rekkari)) {
            return false;
        }
        omistajat.put(rekkari, omistaja);
        return true;
    }
    public String hae(Rekisterinumero rekkari) {
        return omistajat.get(rekkari);
    }
    public boolean poista(Rekisterinumero rekkari) {
        if (!omistajat.containsKey(rekkari)) {
            return false;
        }
        omistajat.remove(rekkari);
        return true;
    }
    public void tulostaRekisterinumerot() {
        for (Rekisterinumero rekisterinumero : omistajat.keySet()) {
            System.out.println(rekisterinumero);
        }
    }
    public void tulostaOmistajat() {
        for (String omistaja : new HashSet<>(omistajat.values())) {
            System.out.println(omistaja);
        }
    }
}
*/