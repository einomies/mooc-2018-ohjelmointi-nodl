/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sovellus;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author einomies
 */
public class Keskiarvosensori implements Sensori {

    private ArrayList<Sensori> sensorit;
    private List<Integer> mittaustulokset = new ArrayList<>();

    public Keskiarvosensori() {
        this.sensorit = new ArrayList<>();
        this.mittaustulokset = new ArrayList<>();
    }

    public void lisaaSensori(Sensori lisattava) {
        this.sensorit.add(lisattava);
    }

    @Override
    public boolean onPaalla() {
        for (Sensori sensori : this.sensorit) {
            if (!sensori.onPaalla()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void paalle() {
        for (Sensori sensori : this.sensorit) {
            if (!sensori.onPaalla()) {
                sensori.paalle();
            }
        }
    }

    @Override
    public void poisPaalta() {
        for (Sensori sensori : this.sensorit) {
            if (sensori.onPaalla()) {
                sensori.poisPaalta();
            }
        }
    }

    @Override
    public int mittaa() {
        int summa = 0;

        if (this.sensorit == null || this.sensorit.size() == 0) {
            throw new IllegalStateException("Ei sensoreita");
        }

        for (Sensori sensori : this.sensorit) {
            if (!sensori.onPaalla()) {
                throw new IllegalStateException("Sensori pois päältä");
            }
            summa = summa + sensori.mittaa();
        }

        this.mittaustulokset.add(summa / this.sensorit.size());

        return summa / this.sensorit.size();
    }

    public List<Integer> mittaukset() {
        return this.mittaustulokset;
    }

}

/*
package sovellus;
import java.util.ArrayList;

import java.util.List;
public class Keskiarvosensori implements Sensori {

    private List<Sensori> sensorit;
    private List<Integer> mittaukset;

    public Keskiarvosensori() {
        sensorit = new ArrayList<>();
        mittaukset = new ArrayList<>();
    }

    public void lisaaSensori(Sensori lisattava) {
        sensorit.add(lisattava);
    }

    public List<Integer> mittaukset() {
        return mittaukset;
    }

    @Override
    public boolean onPaalla() {
        for (Sensori sensori : sensorit) {
            if (sensori.onPaalla()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void paalle() {
        for (Sensori sensori : sensorit) {
            sensori.paalle();
        }
    }

    @Override
    public void poisPaalta() {
        for (Sensori sensori : sensorit) {
            sensori.poisPaalta();
        }
    }

    @Override
    public int mittaa() {
        if (!onPaalla()) {
            throw new IllegalStateException();
        }
        int summa = 0;
        for (Sensori sensori : sensorit) {
            summa += sensori.mittaa();
        }
        int mittaus = summa / sensorit.size();
        mittaukset.add(mittaus);
        return mittaus;
    }
}
*/