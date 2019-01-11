package tarkastaja;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Ennustaja {

    private ArrayList<EhdokkaanVastaus> vastaukset;
    private Map<String, Integer> valitut;
    private Map<String, Integer> eiValitut;

    public Ennustaja() {
        this.valitut = new HashMap<>();
        this.eiValitut = new HashMap<>();
        this.vastaukset = new ArrayList<>();
    }

    public void taydennaTaustadata() {
        ArrayList<EhdokkaanVastaus> lista = lueVastaukset();
        for (EhdokkaanVastaus ehdokkaanVastaus : lista) {
            lisaa(ehdokkaanVastaus.isValittu(), ehdokkaanVastaus.getMiksiKannattaisiValita());
        }
    }

    public void lisaa(boolean valitaan, String lause) {
        EhdokkaanVastaus ehdokkaanVastaus = new EhdokkaanVastaus(valitaan, lause, "");
        this.vastaukset.add(ehdokkaanVastaus);

        String[] sanat = lause.split("\\s+");

        for (int i = 0; i < sanat.length; i++) {
            sanat[i].trim();
            if (valitaan) {
                if (this.valitut.containsKey(sanat[i])) {
                    this.valitut.put(sanat[i], this.valitut.get(sanat[i]) + 1);
                } else {
                    this.valitut.put(sanat[i], 1);
                }
            } else {
                if (this.eiValitut.containsKey(sanat[i])) {
                    this.eiValitut.put(sanat[i], this.eiValitut.get(sanat[i]) + 1);
                } else {
                    this.eiValitut.put(sanat[i], 1);
                }
            }
        }
    }

    public int valitaanSanojenLukumaariinPerustuen(String lause) {
        String[] sanat = lause.trim().split("\\s+");
        int valittuLkm = 0, eiValittuLkm = 0;
        for (int i = 0; i < sanat.length; i++) {
            valittuLkm += this.valitut.getOrDefault(sanat[i], 0);
            eiValittuLkm += this.eiValitut.getOrDefault(sanat[i], 0);
        }
        if (valittuLkm > eiValittuLkm) {
            return 1;
        } else if (valittuLkm < eiValittuLkm) {
            return -1;
        } else {
            return 0;
        }
    }

    public int valitaanMystisellaEnnustajalla(String lause) {

        if (lause.isEmpty()) {
            return -1;
        }

        double valitutLauseetLkm = this.vastaukset.stream()
                .filter((ehdokkaanVastaus) -> (ehdokkaanVastaus.isValittu()))
                .map((item) -> 1.0)
                .reduce(0.0, (accumulator, item) -> accumulator + 1);
        double hylatytLauseetLkm = this.vastaukset.stream()
                .filter((ehdokkaanVastaus) -> (!ehdokkaanVastaus.isValittu()))
                .map((item) -> 1.0)
                .reduce(0.0, (accumulator, item) -> accumulator + 1);

        double kaikkiLauseetLkm = valitutLauseetLkm + hylatytLauseetLkm;

        double osuusValittu = 0;
        double osuusHylatty = 0;
        if (kaikkiLauseetLkm > 0) {
            osuusValittu = valitutLauseetLkm / kaikkiLauseetLkm;
            osuusHylatty = hylatytLauseetLkm / kaikkiLauseetLkm;
        }

        double sanaLkmValittu = 0;
        double sanaLkmHylatty = 0;
        double sanaLkmKaikki = 0;
        double osuusSanaValittu = 0;
        double osuusSanaHylatty = 0;
        String[] sanat = lause.trim().split("\\s+");
        for (int i = 0; i < sanat.length; i++) {
            sanaLkmValittu = this.valitut.getOrDefault(sanat[i], 0);
            sanaLkmHylatty = this.eiValitut.getOrDefault(sanat[i], 0);
            sanaLkmKaikki = sanaLkmValittu + sanaLkmHylatty;
            if (sanaLkmKaikki > 0) {
                osuusValittu = osuusValittu * sanaLkmValittu / sanaLkmKaikki;
                osuusHylatty = osuusHylatty * sanaLkmHylatty / sanaLkmKaikki;
            }
        }

        if (osuusValittu > osuusHylatty) {
            return 1;
        } else if (osuusValittu < osuusHylatty) {
            return -1;
        } else {
            return 0;
        }
        /*
double valitaan = valintaan johtaneiden lauseiden lukumäärä / lauseita yhteensä;
double hylataan = valintaan johtamattomien lauseiden lukumäärä / lauseita yhteensä;

jokaiselle sanalle sana annetussa lauseessa:

    jos sanan esiintymiä on alle 5, jätä sana huomiotta

    valitaan = valitaan * sanan sana esiintymiskerrat valituissa lauseissa / sanan esiintymiskerrat yhteensä

    hylataan = hylataan * sanan sana esiintymiskerrat ei valituissa lauseissa / sanan esiintymiskerrat yhteensä

jos valitaan on suurempi kuin hylataan, palauta arvo 1
jos valitaan on pienempi kuin hylataan, palauta arvo -1
muulloin, palauta arvo 0
         */
    }

    private ArrayList<EhdokkaanVastaus> lueVastaukset() {
        ArrayList<EhdokkaanVastaus> lista = new ArrayList<>();
        String tiedostonNimi = "vaalidata.csv";

        try {
            Files.lines(Paths.get(tiedostonNimi))
                    .map(rivi -> rivi.split(";"))
                    .filter(palat -> palat.length > 2)
                    .forEach(palat -> lista.add(new EhdokkaanVastaus(muunnaValinta(palat[0]), palat[1].trim(), palat[2].trim())));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Virhe: " + e.getMessage());
            e.printStackTrace();
        }

        return lista;
    }

    private boolean muunnaValinta(String arvo) {
        if (arvo.equals("1")) {
            return true;
        }
        return false;
    }

    public ArrayList<EhdokkaanVastaus> haeVastauksia(int lkm) {
        ArrayList<EhdokkaanVastaus> vastaukset = new ArrayList<>();
        for (int i = 0; i < lkm && i < this.vastaukset.size(); i++) {
            vastaukset.add(this.vastaukset.get(i));
        }
        return vastaukset;
    }

    public ArrayList<String> haeVoittavatSanat() {
        ArrayList<String> sanat = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : this.valitut.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (value > this.eiValitut.getOrDefault(key, 0)) {
                sanat.add(key + ", " + value + " vs " + this.eiValitut.getOrDefault(key, 0));
            }
        }
        return sanat;
    }

    public ArrayList<String> haeHaviavatSanat() {
        ArrayList<String> sanat = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : this.eiValitut.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (value > this.valitut.getOrDefault(key, 0)) {
                sanat.add(key + ", " + value + " vs " + this.valitut.getOrDefault(key, 0));
            }
        }
        return sanat;
    }

    public ArrayList<String> haeTasurit() {
        ArrayList<String> sanat = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : this.valitut.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (value == this.eiValitut.getOrDefault(key, 0)) {
                sanat.add(key + ", " + value + " vs " + this.eiValitut.getOrDefault(key, 0));
            }
        }
        return sanat;
    }

    public HashMap<String, Sanatilasto> haeKaikki() {
        HashMap<String, Sanatilasto> sanat = new HashMap<>();
        for (Map.Entry<String, Integer> entry : this.valitut.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            sanat.putIfAbsent(key, new Sanatilasto(key, value, 0));
        }
        for (Map.Entry<String, Integer> entry : this.eiValitut.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (sanat.containsKey(key)) {
                Sanatilasto st = sanat.get(key);
                st.setEiValittu(value);
                sanat.put(key, st);
            } else {
                sanat.putIfAbsent(key, new Sanatilasto(key, 0, value));
            }
        }
        return sanat;
    }
}
/*
package tarkastaja;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Ennustaja {

    private Map<String, Integer> sanojenLukumaarat = new HashMap<>();
    private Map<String, Integer> valituksiJohtaneidenSanojenLukumaarat = new HashMap<>();
    private Map<String, Integer> eiValituksiJohtaneidenSanojenLukumaarat = new HashMap<>();
    private int valittuja = 0;
    private int valitsemattaJaaneita = 0;

    public Ennustaja() {
        this.sanojenLukumaarat = new HashMap<>();
        this.valituksiJohtaneidenSanojenLukumaarat = new HashMap<>();
        this.eiValituksiJohtaneidenSanojenLukumaarat = new HashMap<>();
    }

    public void lisaa(boolean valitaan, String lause) {
        if (valitaan) {
            valittuja++;
        } else {
            valitsemattaJaaneita++;
        }
        Arrays.asList(lause.split("\\s+"))
                .stream()
                .filter(sana -> !sana.trim().isEmpty())
                .forEach(sana -> {
                    sanojenLukumaarat.put(sana, sanojenLukumaarat.getOrDefault(sana, 0) + 1);
                    if (valitaan) {
                        valituksiJohtaneidenSanojenLukumaarat.put(sana, valituksiJohtaneidenSanojenLukumaarat.getOrDefault(sana, 0) + 1);
                    } else {
                        eiValituksiJohtaneidenSanojenLukumaarat.put(sana, eiValituksiJohtaneidenSanojenLukumaarat.getOrDefault(sana, 0) + 1);
                    }
                });
    }

    public int valitaanSanojenLukumaariinPerustuen(String lause) {
        int summaJoo = Arrays.asList(lause.split("\\s+"))
                .stream()
                .mapToInt(sana -> valituksiJohtaneidenSanojenLukumaarat.getOrDefault(sana, 0))
                .sum();
        int summaEi = Arrays.asList(lause.split("\\s+"))
                .stream()
                .mapToInt(sana -> eiValituksiJohtaneidenSanojenLukumaarat.getOrDefault(sana, 0))
                .sum();
        if (summaJoo > summaEi) {
            return 1;
        } else if (summaJoo == summaEi) {
            return 0;
        } else {
            return -1;
        }
    }

    public int valitaanMystisellaEnnustajalla(String lause) {
        double valitaan = 1.0 * valittuja / (valittuja + valitsemattaJaaneita);
        double hylataan = 1.0 * valitsemattaJaaneita / (valittuja + valitsemattaJaaneita);
        for (String sana : lause.split("\\s+")) {
            if (sanojenLukumaarat.getOrDefault(sana, 0) < 4) {
                continue;
            }
            valitaan *= 1.0 * valituksiJohtaneidenSanojenLukumaarat.getOrDefault(sana, 0) / sanojenLukumaarat.getOrDefault(sana, 0);
            hylataan *= 1.0 * eiValituksiJohtaneidenSanojenLukumaarat.getOrDefault(sana, 0) / sanojenLukumaarat.getOrDefault(sana, 0);
        }
        if (valitaan > hylataan) {
            return 1;
        } else if (valitaan < hylataan) {
            return -1;
        } else {
            return 0;
        }
    }
}
*/