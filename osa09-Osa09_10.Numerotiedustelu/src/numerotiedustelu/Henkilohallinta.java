/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numerotiedustelu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author einomies
 */
public class Henkilohallinta {

    private Map<String, Henkilo> henkilotNimenMukaan;
    private Map<String, String> nimetNumeronMukaan;

    public Henkilohallinta() {
        this.henkilotNimenMukaan = new HashMap<>();
        this.nimetNumeronMukaan = new HashMap<>();
    }

    public void lisaaNumero(String nimi, String numero) {
        if (this.henkilotNimenMukaan.containsKey(nimi)) {
            Henkilo h = this.henkilotNimenMukaan.get(nimi);
            h.lisaaPuhNumero(numero);
            this.henkilotNimenMukaan.put(nimi, h);
        } else {
            Henkilo henkilo = new Henkilo(nimi, "", "", numero);
            this.henkilotNimenMukaan.put(nimi, henkilo);
        }

        this.nimetNumeronMukaan.putIfAbsent(numero, nimi);
    }

    public ArrayList<String> haeTiedot(String hakusana) {
        ArrayList<String> hakutulos = new ArrayList<>();
        if (hakusana.isEmpty()) {
            hakutulos = haeKaikki();
        } else {
            hakutulos = haeHakusananMukaan(hakusana);
        }
        return hakutulos;
    }

    private ArrayList<String> haeKaikki() {
        ArrayList<String> hakutulos = new ArrayList<>();
        for (Map.Entry<String, Henkilo> entry : this.henkilotNimenMukaan.entrySet()) {
            String nimi = entry.getKey();
            Henkilo henkilo = entry.getValue();
            hakutulos.add(henkilo.toString());
            hakutulos.add("");
        }
        return hakutulos;
    }

    private ArrayList<String> haeHakusananMukaan(String hakusana) {
        ArrayList<String> hakutulos = new ArrayList<>();
        for (Map.Entry<String, Henkilo> entry : this.henkilotNimenMukaan.entrySet()) {
            String key = entry.getKey();
            Henkilo hlo = entry.getValue();
            boolean loytyi = false;
            if (key.contains(hakusana)) {
                hakutulos.add(hlo.toString());
                loytyi = true;
            }
            if (!loytyi && hlo.getOsoiteKatu() != null && hlo.getOsoiteKatu().contains(hakusana)) {
                hakutulos.add(hlo.toString());
                loytyi = true;
            }
            if (!loytyi && hlo.getOsoiteKaupunki() != null && hlo.getOsoiteKaupunki().contains(hakusana)) {
                hakutulos.add(hlo.toString());
                loytyi = true;
            }
        }
        if (hakutulos.size() == 0) {
            hakutulos.add("  ei löytynyt");
        }
        return hakutulos;
        /*
        komento: 7
        hakusana (jos tyhjä, listataan kaikki): kk

          jukka
            osoite: korsontie vantaa
            ei puhelinta

          pekka
            osoite: ida ekmanintie helsinki
            puhelinnumerot:
              040-123456
              09-222333

        komento: 7
        hakusana (jos tyhjä, listataan kaikki): vantaa

          jukka
            osoite: korsontie vantaa
            ei puhelinta

        komento: 7
        hakusana (jos tyhjä, listataan kaikki): seppo
          ei löytynyt
         */
    }

    public ArrayList<String> haeNumerotNimella(String nimi) {
        ArrayList<String> hakutulos = new ArrayList<>();
        hakutulos.add("  ei löytynyt");
        for (Map.Entry<String, Henkilo> entry : this.henkilotNimenMukaan.entrySet()) {
            if (entry.getKey().equals(nimi)) {
                hakutulos.clear();
                Henkilo henkilo = entry.getValue();
                for (String nro : henkilo.getPuhNumerot()) {
                    hakutulos.add("  " + nro);
                }
            }
        }
        return hakutulos;
    }

    public void lisaaOsoite(String nimi, String osoiteKatu, String osoiteKaupunki) {
        if (this.henkilotNimenMukaan.containsKey(nimi)) {
            Henkilo h = this.henkilotNimenMukaan.get(nimi);
            h.setOsoiteKatu(osoiteKatu);
            h.setOsoiteKaupunki(osoiteKaupunki);
            this.henkilotNimenMukaan.put(nimi, h);
        } else {
            Henkilo henkilo = new Henkilo(nimi, osoiteKatu, osoiteKaupunki, "");
            this.henkilotNimenMukaan.put(nimi, henkilo);
        }
    }

    public ArrayList<String> haeTiedotNimella(String nimi) {
        ArrayList<String> hakutulos = new ArrayList<>();
        hakutulos.add("  ei löytynyt");
        for (Map.Entry<String, Henkilo> entry : this.henkilotNimenMukaan.entrySet()) {
            if (entry.getKey().equals(nimi)) {
                hakutulos.clear();
                Henkilo henkilo = entry.getValue();
                hakutulos.add(henkilo.toStringIlmanNimea());
            }
        }
        return hakutulos;
    }

    public ArrayList<String> haeTiedotNumerolla(String numero) {
        ArrayList<String> hakutulos = new ArrayList<>();
        hakutulos.add(this.nimetNumeronMukaan.getOrDefault(numero, "  ei löytynyt"));
        return hakutulos;
    }

    public void poistaHenkilonTiedotNimella(String nimi) {
        this.henkilotNimenMukaan.remove(nimi);
//        for (Map.Entry<String, String> entry : this.nimetNumeronMukaan.entrySet()) {
//            String key = entry.getKey();
//            String value = entry.getValue();
//            if (value.equals(nimi)) {
//                this.nimetNumeronMukaan.remove(key);
//            }
//        }

//        Iterator<String> iterator = this.nimetNumeronMukaan.keySet().iterator();
//        Iterator<String> iterator = this.nimetNumeronMukaan.values().iterator();

        for (Iterator<Map.Entry<String, String>> it = this.nimetNumeronMukaan.entrySet().iterator(); it.hasNext();) {
            Map.Entry<String, String> entry = it.next();
            if (entry.getValue().equals(nimi)) {
                it.remove();
            }
        }
    }

}
