/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sukunimet;

/**
 *
 * @author einomies
 */
public class Henkilo {

    private String etunimi;
    private String ensimmainenSukunimi;
    private String toinenSukunimi;
    private Henkilo isa;
    private Henkilo aiti;

    public Henkilo(String etunimi, String ensimmainenSukunimi, String toinenSukunimi) {
        this.etunimi = etunimi;
        this.ensimmainenSukunimi = ensimmainenSukunimi;
        this.toinenSukunimi = toinenSukunimi;
    }

    public Henkilo(String etunimi, Henkilo isa, Henkilo aiti) {
        this.etunimi = etunimi;
        this.isa = isa;
        this.aiti = aiti;
        this.ensimmainenSukunimi = isa.getEnsimmainenSukunimi();
        this.toinenSukunimi = aiti.getEnsimmainenSukunimi();
    }

    @Override
    public String toString() {
        return etunimi + " " + ensimmainenSukunimi + " " + toinenSukunimi;
    }

    public String getEtunimi() {
        return etunimi;
    }

    public String getEnsimmainenSukunimi() {
        return ensimmainenSukunimi;
    }

    public String getToinenSukunimi() {
        return toinenSukunimi;
    }

    public Henkilo getIsa() {
        return isa;
    }

    public Henkilo getAiti() {
        return aiti;
    }

}
