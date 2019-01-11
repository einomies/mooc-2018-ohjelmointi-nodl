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
public class Opiskelija extends Henkilo {

    private int opintopisteet;

    public Opiskelija(String nimi, String osoite) {
        super(nimi, osoite);
        this.opintopisteet = 0;
    }

    public int opintopisteita() {
        return this.opintopisteet;
    }

    public void opiskele() {
        this.opintopisteet++;
    }

    @Override
    public String toString() {
        return super.toString() + "\n  opintopisteitä " + opintopisteet;
    }

}

/*
package henkilot;
public class Opiskelija extends Henkilo {

    private int op;

    public Opiskelija(String nimi, String osoite) {
        super(nimi, osoite);
    }

    public int opintopisteita() {
        return op;
    }

    public void opiskele() {
        op++;
    }

    @Override
    public String toString() {
        return super.toString() + "\n  opintopisteitä " + op;
    }
}
*/