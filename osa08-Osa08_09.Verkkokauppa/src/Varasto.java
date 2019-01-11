
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author einomies
 */
public class Varasto {

    private Map<String, Integer> mapHinta;
    private Map<String, Integer> mapSaldo;

    public Varasto() {
        this.mapHinta = new HashMap<>();
        this.mapSaldo = new HashMap<>();
    }

//  Lisää varastoon tuotteen jonka hinta ja varastosaldo ovat parametrina annetut luvut
    public void lisaaTuote(String tuote, int hinta, int saldo) {
        this.mapHinta.put(tuote, hinta);
        this.mapSaldo.put(tuote, saldo);
    }

//  Palauttaa parametrina olevan tuotteen hinnan. Jos tuotetta ei ole varastossa,
//  palauttaa metodi -99
    public int hinta(String tuote) {
        if (this.mapHinta.containsKey(tuote)) {
            return this.mapHinta.get(tuote);
        }
        return -99;
    }

    public int saldo(String tuote) {
        if (this.mapSaldo.containsKey(tuote)) {
            return this.mapSaldo.get(tuote);
        }
        return 0;
    }

//  Vähentää parametrina olevan tuotteen saldoa yhdellä ja palauuttaa true jos
//  tuotetta oli varastossa. Jos tuotetta ei ole varastossa, palauttaa metodi false,
//  tuotteen saldo ei saa laskea alle nollan.
    public boolean ota(String tuote) {
        if (this.mapSaldo.containsKey(tuote)) {
            if (this.mapSaldo.get(tuote) > 0) {
                this.mapSaldo.put(tuote, this.mapSaldo.get(tuote) - 1);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public Set<String> tuotteet() {
        Set<String> tuotteet = new HashSet<>();
        for (String avain : this.mapHinta.keySet()) {
            tuotteet.add(avain);
        }
        for (String avain : this.mapSaldo.keySet()) {
            tuotteet.add(avain);
        }
        return tuotteet;
    }

}

/*
import java.util.HashMap;
import java.util.Map;


import java.util.Set;
public class Varasto {

    private Map<String, Integer> hinnat;
    private Map<String, Integer> saldot;

    public Varasto() {
        this.hinnat = new HashMap<>();
        this.saldot = new HashMap<>();
    }

    public void lisaaTuote(String tuote, int hinta, int saldo) {
        this.hinnat.put(tuote, hinta);
        this.saldot.put(tuote, saldo);
    }

    public int hinta(String tuote) {
        return this.hinnat.getOrDefault(tuote, -99);
    }

    public int saldo(String tuote) {
        return this.saldot.getOrDefault(tuote, 0);
    }

    public boolean ota(String tuote) {
        if (!this.saldot.containsKey(tuote)) {
            return false;
        }
        int saldo = this.saldot.get(tuote);
        if (saldo == 0) {
            return false;
        }
        this.saldot.put(tuote, saldo - 1);
        return true;
    }

    public Set<String> tuotteet() {
        return this.saldot.keySet();
    }
}
*/
