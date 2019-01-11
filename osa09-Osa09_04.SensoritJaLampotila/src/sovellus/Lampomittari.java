/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sovellus;

import java.util.Random;

/**
 *
 * @author einomies
 */
public class Lampomittari implements Sensori {

    private int luku;
    private boolean onPaalla;

    public Lampomittari() {
        this.luku = 0;
        this.onPaalla = false;
    }

    @Override
    public boolean onPaalla() {
        return this.onPaalla;
    }

    @Override
    public void paalle() {
        this.onPaalla = true;
    }

    @Override
    public void poisPaalta() {
        this.onPaalla = false;
    }

    @Override
    public int mittaa() {
        if (!this.onPaalla) {
            throw new IllegalStateException("Mittari pois päältä");
        }
        this.luku = arvoLuku(-30, 30);
        return this.luku;
    }

    private static int arvoLuku(int min, int max) {
        return min + new Random().nextInt(max - min + 1);
    }

}

/*
package sovellus;

import java.util.Random;
public class Lampomittari implements Sensori {

    private boolean paalla;

    @Override
    public boolean onPaalla() {
        return paalla;
    }

    @Override
    public void paalle() {
        paalla = true;
    }

    @Override
    public void poisPaalta() {
        paalla = false;
    }

    @Override
    public int mittaa() {
        if (!onPaalla()) {
            throw new IllegalStateException();
        }
        Random arpa = new Random();
        return arpa.nextInt(61) - 30;
    }
}
*/