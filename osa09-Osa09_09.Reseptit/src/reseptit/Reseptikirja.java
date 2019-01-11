package reseptit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Reseptikirja {

    // lisää tänne oliomuuttujia
    private Map<String, Resepti> listaNimenMukaan;
    private Map<String, Set<Resepti>> listaRaakaAineenMukaan;

    public Reseptikirja() {
        // täydennä konstruktoria sopivasti -- pidä konstruktori
        // parametrittomana
        this.listaNimenMukaan = new HashMap<>();
        this.listaRaakaAineenMukaan = new HashMap<>();
    }

    public void lisaaResepti(Resepti resepti) {
        this.listaNimenMukaan.put(resepti.getNimi(), resepti);
        for (String aine : resepti.getRaakaAineet()) {
            this.listaRaakaAineenMukaan.putIfAbsent(aine, new HashSet<>());
            this.listaRaakaAineenMukaan.get(aine).add(resepti);
        }
    }

    public Resepti haeNimella(String nimi) {
        // toteuta tänne toiminnallisuus, joka palauttaa reseptin, jonka
        // nimi on täsmälleen haluttu. muulloin metodi palauttaa arvon null
        if (this.listaNimenMukaan.containsKey(nimi)) {
            return this.listaNimenMukaan.get(nimi);
        }
        return null;
    }

    public List<Resepti> haeRaakaAineella(String raakaAine) {
        // toteuta tänne toiminnallisuus, joka palauttaa kaikki reseptit, joissa
        // esiintyy haettu raaka-aine. Mikäli reseptejä ei ole lainkaan, palauta
        // tyhjä lista.
        List<Resepti> reseptit = new ArrayList<>();
        if (this.listaRaakaAineenMukaan.containsKey(raakaAine)) {
            Set<Resepti> res = this.listaRaakaAineenMukaan.get(raakaAine);
            for (Resepti re : res) {
                reseptit.add(re);
            }
        }
        return reseptit;
    }

    @Override
    public String toString() {
        return "Reseptikirja{" + "\nlistaNimenMukaan=\n" + listaNimenMukaan + "\nlistaRaakaAineenMukaan=\n" + listaRaakaAineenMukaan + '}';
    }

}

/*
package reseptit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Reseptikirja {

    private Map<String, Resepti> reseptitNimenPerusteella;
    private Map<String, List<Resepti>> reseptitRaakaAineenPerusteella;

    // lisää tänne oliomuuttujia
    public Reseptikirja() {
        // täydennä konstruktoria sopivasti -- pidä konstruktori
        // parametrittomana
        this.reseptitNimenPerusteella = new HashMap<>();
        this.reseptitRaakaAineenPerusteella = new HashMap<>();
    }

    public void lisaaResepti(Resepti resepti) {
        // tee täällä jotain sopivaa
        this.reseptitNimenPerusteella.put(resepti.getNimi(), resepti);
        for (String raakaAine : resepti.getRaakaAineet()) {
            this.reseptitRaakaAineenPerusteella.putIfAbsent(raakaAine, new ArrayList<>());
            this.reseptitRaakaAineenPerusteella.get(raakaAine).add(resepti);
        }
    }

    public Resepti haeNimella(String nimi) {
        // toteuta tänne toiminnallisuus, joka palauttaa reseptin, jonka
        // nimi on täsmälleen haluttu. muulloin metodi palauttaa arvon null
        return this.reseptitNimenPerusteella.get(nimi);
    }

    public List<Resepti> haeRaakaAineella(String raakaAine) {
        // toteuta tänne toiminnallisuus, joka palauttaa kaikki reseptit, joissa
        // esiintyy haettu raaka-aine. Mikäli reseptejä ei ole lainkaan, palauta
        // tyhjä lista.
        return this.reseptitRaakaAineenPerusteella.getOrDefault(raakaAine, new ArrayList<>());
    }
}
*/