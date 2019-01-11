/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanakirja;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author einomies
 */
public class Tehtavakirjanpito {

    private Map<String, Set<Integer>> tehdytTehtavat;

    public Tehtavakirjanpito() {
        this.tehdytTehtavat = new HashMap<>();
    }

    public void lisaa(String kayttaja, int tehtava) {
        // uudelle käyttäjälle on lisättävä HashMapiin tyhjä tehtäväjoukko jos sitä
        // ei ole jo lisätty
        this.tehdytTehtavat.putIfAbsent(kayttaja, new HashSet<>());

        // haetaan ensin käyttäjän tehtävät sisältävä joukko ja tehdään siihen lisäys
        Set<Integer> tehdyt = this.tehdytTehtavat.get(kayttaja);
        tehdyt.add(tehtava);
        // edellinen olisi onnitunut myös ilman apumuuttujaa seuraavasti
        // this.tehdytTehtavat.get(kayttaja).add(tehtava);
    }

    public void tulosta() {
        //        this.tehdytTehtavat.entrySet().stream(entry -> {
        //            System.out.println(entry.getKey() + ": " + entry.getValue());
        //        });
        for (Map.Entry<String, Set<Integer>> entry : tehdytTehtavat.entrySet()) {
            String key = entry.getKey();
            Set<Integer> value = entry.getValue();
            System.out.println(key + ": " + value);
        }
    }
}
