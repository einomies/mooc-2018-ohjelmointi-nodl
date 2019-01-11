/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polymorfismi;

/**
 *
 * @author einomies
 */
public class Opiskelija extends Henkilo {

    private int opintopisteet;

    public Opiskelija(String nimi, int ika, int opintopisteet) {
        super(nimi, ika);
        this.opintopisteet = opintopisteet;
    }

    @Override
    public String toString() {
        return super.toString() + opintopisteet + " op";
    }

}
