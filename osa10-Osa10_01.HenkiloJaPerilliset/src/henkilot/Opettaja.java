/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package henkilot;

/**
 *
 * @author einomies
 */
public class Opettaja extends Henkilo {

    private int kkPalkka;

    public Opettaja(String nimi, String osoite, int kkPalkka) {
        super(nimi, osoite);
        this.kkPalkka = kkPalkka;
    }

    @Override
    public String toString() {
        return super.toString() + "\n  palkka " + kkPalkka + " euroa/kk";
    }

}
/*
package henkilot;
public class Opettaja extends Henkilo {

    private int palkka;

    public Opettaja(String nimi, String osoite, int palkka) {
        super(nimi, osoite);
        this.palkka = palkka;
    }

    @Override
    public String toString() {
        return super.toString() + "\n  palkka " + palkka + " euroa";
    }
}
*/