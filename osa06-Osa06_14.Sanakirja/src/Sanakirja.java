
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
public class Sanakirja {
    
    private HashMap<String, String> mappi;
    
    public Sanakirja() {
        this.mappi = new HashMap<>();
    }
    
//  Metodi palauttaa parametrinsa käännöksen. Jos sanaa ei tunneta, palautetaan null.
    public String kaanna(String sana) {
        return mappi.get(sana);
    }

//  Metodi lisää sanakirjaan uuden käännöksen
    public void lisaa(String sana, String kaannos) {
        this.mappi.put(sana, kaannos);
    }
    
    public int sanojenLukumaara() {
        return this.mappi.size();
    }
    
    public ArrayList<String> kaannoksetListana() {
        ArrayList<String> lista = new ArrayList<>();
        for (Map.Entry<String, String> entry : mappi.entrySet()) {
            lista.add(entry.getKey() +" = " +entry.getValue());
        }
        return lista;
    }
    
}

/*
import java.util.ArrayList;
import java.util.HashMap;

public class Sanakirja {

    private HashMap<String, String> kaannokset;

    public Sanakirja() {
        this.kaannokset = new HashMap<>();
    }

    public String kaanna(String sana) {
        return this.kaannokset.get(sana);
    }

    public void lisaa(String sana, String kaannos) {
        this.kaannokset.put(sana, kaannos);
    }

    public ArrayList<String> kaannoksetListana() {
        ArrayList<String> lista = new ArrayList<>();
        for (String avain : this.kaannokset.keySet()) {
            lista.add(avain + " = " + this.kaannokset.get(avain));
        }
        return lista;
    }

    public int sanojenLukumaara() {
        return this.kaannokset.size();
    }
}
*/