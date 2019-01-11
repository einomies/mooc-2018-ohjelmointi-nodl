
import java.util.Collection;
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
public class Ostoskori {

    private Map<String, Ostos> kori;

    public Ostoskori() {
        this.kori = new HashMap<>();
    }

//  Lisää ostoskoriin ostoksen joka vastaa parametrina olevaa tuotetta ja jolla
//  on parametrina annettu hinta.
    public void lisaa(String tuote, int hinta) {
        if (this.kori.containsKey(tuote)) {
            this.kori.get(tuote).kasvataMaaraa();
        } else {
            Ostos ostos = new Ostos(tuote, 1, hinta);
            this.kori.put(tuote, ostos);
        }
    }

    public int hinta() {
        int hinta = 0;
        Collection<Ostos> ostokset = this.kori.values();
        for (Ostos ostos : ostokset) {
            hinta = hinta + ostos.hinta();
        }
        return hinta;
    }

    public void tulosta() {
        for (Map.Entry<String, Ostos> entry : this.kori.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

}

/*
import java.util.*;
public class Ostoskori {

    private Map<String, Ostos> ostokset;

    public Ostoskori() {
        this.ostokset = new HashMap<>();
    }

    public int hinta() {
        int hinta = 0;
        for (Ostos ostos : ostokset.values()) {
            hinta += ostos.hinta();
        }
        return hinta;
    }

    public void lisaa(String tuote, int hinta) {
        this.ostokset.putIfAbsent(tuote, new Ostos(tuote, 0, hinta));
        this.ostokset.get(tuote).kasvataMaaraa();
    }

    public void tulosta() {
        for (Ostos ostos : ostokset.values()) {
            System.out.println(ostos);
        }
    }
}
*/