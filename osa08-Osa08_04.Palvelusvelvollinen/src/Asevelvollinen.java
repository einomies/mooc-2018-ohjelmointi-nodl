/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author einomies
 */
public class Asevelvollinen implements Palvelusvelvollinen {
    
    private int paivia;

    public Asevelvollinen(int paivia) {
        this.paivia = paivia;
    }

    @Override
    public int paiviaJaljella() {
        return this.paivia;
    }

    @Override
    public void palvele() {
        if (this.paivia > 0) {
            this.paivia--;
        }
    }

}

/*
public class Asevelvollinen implements Palvelusvelvollinen {
    private int paivia;
    public Asevelvollinen(int paivia) {
        this.paivia = paivia;
    }
    @Override
    public int paiviaJaljella() {
        return paivia;
    }
    @Override
    public void palvele() {
        if (paivia <= 0) {
            return;
        }
        paivia--;
    }
}
*/