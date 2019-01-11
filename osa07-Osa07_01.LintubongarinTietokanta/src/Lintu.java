/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author einomies
 */
public class Lintu {
    
    private String nimiSuomi;
    private String nimiLatina;
    private int bongausLkm;
    
    public Lintu(String nimiSuomi, String nimiLatina) {
        this.nimiSuomi = nimiSuomi;
        this.nimiLatina = nimiLatina;
        this.bongausLkm = 0;
    }
    
    public void lisaaBongaus() {
        this.bongausLkm++;
    }

    public String getNimiSuomi() {
        return nimiSuomi;
    }

    public void setNimiSuomi(String nimiSuomi) {
        this.nimiSuomi = nimiSuomi;
    }

    public String getNimiLatina() {
        return nimiLatina;
    }

    public void setNimiLatina(String nimiLatina) {
        this.nimiLatina = nimiLatina;
    }

    public int getBongausLkm() {
        return bongausLkm;
    }

    public void setBongausLkm(int bongausLkm) {
        this.bongausLkm = bongausLkm;
    }

    @Override
    public String toString() {
        return nimiSuomi +" (" +nimiLatina +"): " +bongausLkm +" havaintoa";
    }
    
}

/*
public class Lintu {
    private String nimi;
    private String latNimi;
    private int havainnot;

    public Lintu(String nimi, String latNimi) {
        this.nimi = nimi;
        this.latNimi = latNimi;
        this.havainnot = 0;
    }

    public String nimi() {
        return this.nimi;
    }

    public void havainto() {
        this.havainnot++;
    }

    public String toString() {
        return this.nimi + " (" + this.latNimi + "): " + this.havainnot + " havaintoa";
    }
}
*/