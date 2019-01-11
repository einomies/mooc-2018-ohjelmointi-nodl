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
public class OmaUseanKaannoksenSanakirja implements UseanKaannoksenSanakirja {

    private Map<String, Set<String>> mappi;

    public OmaUseanKaannoksenSanakirja() {
        this.mappi = new HashMap<>();
    }

    @Override
    public void lisaa(String sana, String kaannos) {
        this.mappi.putIfAbsent(sana, new HashSet<>());
        this.mappi.get(sana).add(kaannos);
    }

    @Override
    public Set<String> kaanna(String sana) {
//        Set<String> kaannokset = new HashSet<>();
//        if (this.mappi.containsKey(sana)) {
//            kaannokset.addAll(this.mappi.get(sana));
//        }
//        return kaannokset;
        return mappi.getOrDefault(sana, new HashSet<>());
    }

    @Override
    public void poista(String sana) {
        this.mappi.remove(sana);
    }

    @Override
    public String toString() {
        return "OmaUseanKaannoksenSanakirja{" + "mappi=" + mappi + '}';
    }

}
