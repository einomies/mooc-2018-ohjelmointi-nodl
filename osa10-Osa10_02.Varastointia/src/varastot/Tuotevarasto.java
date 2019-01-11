/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package varastot;

/**
 *
 * @author einomies
 */
public class Tuotevarasto extends Varasto {

    private String tuotenimi;

    public Tuotevarasto(String tuotenimi, double tilavuus) {
        super(tilavuus);
        this.tuotenimi = tuotenimi;
    }

    public String getNimi() {
        return this.tuotenimi;
    }

    public void setNimi(String uusiNimi) {
        this.tuotenimi = uusiNimi;
    }

    @Override
    public String toString() {
        return tuotenimi + ": " + super.toString();
    }

}

/*
package varastot;
public class Tuotevarasto extends Varasto {

    private String nimi;

    public Tuotevarasto(String nimi, double tilavuus) {
        super(tilavuus);
        this.nimi = nimi;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    @Override
    public String toString() {
        return nimi + ": " + super.toString();
    }
}
*/