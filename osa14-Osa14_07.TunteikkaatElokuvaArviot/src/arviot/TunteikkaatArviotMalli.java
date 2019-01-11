/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arviot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author einomies
 */
public class TunteikkaatArviotMalli {

    private Map<String, Double> sanaTunteet;
    private Map<String, Integer> sanaLukumaarat;

    // Huom! Älä muuta konstruktorin parametrien määrää -- konstruktoria
    // saa toki muuten muuttaa
    public TunteikkaatArviotMalli(List<String> rivit) {
        Map<String, List<Integer>> sanaArviot = haeSanakohtaisetArviot(rivit);
        alustaOliomuuttujat(sanaArviot);
    }

    private Map<String, List<Integer>> haeSanakohtaisetArviot(List<String> rivit) {
        Map<String, List<Integer>> sanaArviot = new HashMap<>();
        rivit.stream().forEach(rivi -> {
            String[] palat = rivi.split(" ");
            int arvio = Integer.parseInt(palat[0]);
            for (int i = 1; i < palat.length; i++) {
                String sana = palat[i].toLowerCase();
                if (!sanaArviot.containsKey(sana)) {
                    sanaArviot.put(sana, new ArrayList<>());
                }
                sanaArviot.get(sana).add(arvio);
            }
        });
        return sanaArviot;
    }

    private void alustaOliomuuttujat(Map<String, List<Integer>> sanaArviot) {
        this.sanaLukumaarat = new HashMap<>();
        this.sanaTunteet = new HashMap<>();
        sanaArviot.keySet().stream().forEach(sana -> {
            int sanoja = sanaArviot.get(sana).size();
            int arvioSumma = sanaArviot.get(sana).stream().mapToInt(i -> i).sum();
            this.sanaLukumaarat.put(sana, sanoja);
            this.sanaTunteet.put(sana, 1.0 * arvioSumma / sanoja);
        });
    }

    public int sanojenLukumaara(String sana) {
        sana = sana.toLowerCase();
        if (!this.sanaLukumaarat.containsKey(sana)) {
            return 0;
        }
        return this.sanaLukumaarat.get(sana);
    }

    public double sananTunne(String sana) {
        sana = sana.toLowerCase();
        if (this.sanojenLukumaara(sana) == 0) {
            return 2.0; // neutraali
        }
        return this.sanaTunteet.get(sana);
    }

    public String sananTunneMerkkijonona(String sana) {
        return tunneMerkkijonona(sananTunne(sana));
    }

    public double lauseenTunne(String lause) {
        lause = lause.toLowerCase();
        double summa = 0;
        int sanoja = 0;
        String[] palat = lause.split(" ");
        for (int i = 0; i < palat.length; i++) {
            String sana = palat[i];
            summa += sananTunne(sana);
            sanoja++;
        }
        if (sanoja == 0) {
            return 2.0;
        }
        return summa / sanoja;
    }

    public String lauseenTunneMerkkijonona(String lause) {
        return tunneMerkkijonona(lauseenTunne(lause));
    }

    private String tunneMerkkijonona(double luku) {
        if (luku <= 1.9) {
            return "negatiivinen";
        } else if (luku <= 2.1) {
            return "neutraali";
        } else {
            return "positiivinen";
        }
    }

}
