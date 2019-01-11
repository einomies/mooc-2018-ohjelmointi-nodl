/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sovellus;

/**
 *
 * @author einomies
 */
public class Vakiosensori implements Sensori {

    private int luku;

    public Vakiosensori(int luku) {
        this.luku = luku;
    }

    @Override
    public boolean onPaalla() {
        return true;
    }

    @Override
    public void paalle() {
    }

    @Override
    public void poisPaalta() {
    }

    @Override
    public int mittaa() {
        return this.luku;
    }

}

/*
package sovellus;
public class Vakiosensori implements Sensori {

    private int arvo;

    public Vakiosensori(int arvo) {
        this.arvo = arvo;
    }

    @Override
    public boolean onPaalla() {
        return true;
    }

    @Override
    public void paalle() {
    }

    @Override
    public void poisPaalta() {
    }

    @Override
    public int mittaa() {
        return arvo;
    }
}
*/