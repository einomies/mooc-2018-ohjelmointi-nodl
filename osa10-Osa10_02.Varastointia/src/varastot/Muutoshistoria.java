/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package varastot;

import java.util.ArrayList;

/**
 *
 * @author einomies
 */
public class Muutoshistoria {

    private ArrayList<Double> maaraHistoria;

    public Muutoshistoria() {
        this.maaraHistoria = new ArrayList<>();
    }

    public void lisaa(double tilanne) {
        this.maaraHistoria.add(tilanne);
    }

    public void nollaa() {
        this.maaraHistoria.clear();
    }

    public double maxArvo() {
        Double max = 0.0;
        for (Double maara : this.maaraHistoria) {
            if (maara > max) {
                max = maara;
            }
        }
        return max;
    }

    public double minArvo() {
        Double min = 0.0;
        for (int i = 0; i < this.maaraHistoria.size(); i++) {
            if (i == 0) {
                min = this.maaraHistoria.get(i);
            } else {
                if (this.maaraHistoria.get(i) < min) {
                    min = this.maaraHistoria.get(i);
                }
            }
        }
        return min;
    }

    public double keskiarvo() {
        if (this.maaraHistoria.size() > 0) {
            return this.summaYht() / this.maaraHistoria.size();
        }
        return 0;
    }

    public double summaYht() {
        if (this.maaraHistoria.size() > 0) {
            Double summa = 0.0;
            for (Double maara : maaraHistoria) {
                summa += maara;
            }
            return summa;
        }
        return 0;
    }

    public double suurinMuutos() {
        if (this.maaraHistoria.size() > 1) {
            double maxMuutos = 0;
            for (int i = 1; i < this.maaraHistoria.size(); i++) {
                double nykyinen = this.maaraHistoria.get(i);
                double edellinen = this.maaraHistoria.get(i - 1);
                if (muutos(edellinen, nykyinen) > maxMuutos) {
                    maxMuutos = muutos(edellinen, nykyinen);
                }
            }
            return maxMuutos;
        }
        return 0;
    }

    public double varianssi() {
        /*
        Esimerkiksi lukujen 3, 2, 7, 2 keskiarvo on 3.5, joten otosvarianssi on
        ((3 - 3.5)² + (2 - 3.5)² + (7 - 3.5)² + (2 - 3.5)²)/(4 - 1) ≈ 5,666667.)
         */
        if (this.maaraHistoria.size() > 1) {
            double summa = 0, otosVarianssi = 0;
            for (Double maara : maaraHistoria) {
                summa = summa + Math.pow(maara - this.keskiarvo(), 2);
            }
            double jakaja = this.maaraHistoria.size() - 1;
            otosVarianssi = summa / jakaja;
            return otosVarianssi;
        }
        return 0;
    }

    private double muutos(double ennen, double jalkeen) {
        return Math.abs(ennen - jalkeen);
    }

    @Override
    public String toString() {
        String tulos = "[";
        int i = 0;
        for (Double maara : this.maaraHistoria) {
            if (i == 0) {
                tulos = tulos + maara.toString();
            } else if (i == this.maaraHistoria.size() - 1) {
                tulos = tulos + ", " + maara.toString();
            } else {
                tulos = tulos + ", " + maara.toString();
            }
            i++;
        }
        tulos = tulos + "]";
        return tulos;
    }

}

/*
package varastot;
import java.util.ArrayList;
import java.util.Collections;


import java.util.List;
public class Muutoshistoria {

    private List<Double> tilanteet;

    public Muutoshistoria() {
        tilanteet = new ArrayList<>();
    }

    public void lisaa(double tilanne) {
        tilanteet.add(tilanne);
    }

    public void nollaa() {
        tilanteet.clear();
    }

    public double minArvo() {
        return Collections.min(tilanteet);
    }

    public double maxArvo() {
        return Collections.max(tilanteet);
    }

    public double keskiarvo() {
        if (tilanteet.isEmpty()) {
            return 0;
        }
        return tilanteet.stream().mapToDouble(d -> d).average().getAsDouble();
    }

    public double suurinMuutos() {
        if (tilanteet.isEmpty()) {
            return 0;
        }
        double suurinTunnettu = 0;
        for (int i = 0; i < tilanteet.size() - 1; i++) {
            double edellinenMuutos = Math.abs(tilanteet.get(i) - tilanteet.get(i + 1));
            if (edellinenMuutos > suurinTunnettu) {
                suurinTunnettu = edellinenMuutos;
            }
        }
        return suurinTunnettu;
    }

    public double varianssi() {
        double ka = keskiarvo();
        double erotustenNelioidenSummat = 0;
        for (int i = 0; i < tilanteet.size(); i++) {
            double luku = tilanteet.get(i);
            double erotus = luku - ka;
            double erotusteNelio = erotus * erotus;
            erotustenNelioidenSummat += erotusteNelio;
        }
        return erotustenNelioidenSummat / (tilanteet.size() - 1);
    }

    @Override
    public String toString() {
        return tilanteet.toString();
    }
}
*/