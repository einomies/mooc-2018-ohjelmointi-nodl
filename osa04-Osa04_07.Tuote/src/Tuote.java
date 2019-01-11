/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author einomies
 */
public class Tuote {
    private String nimi;
    private double hinta;
    private int lkm;
    
    public Tuote(String nimiAlussa, double hintaAlussa, int maaraAlussa) {
        this.nimi = nimiAlussa;
        this.hinta = hintaAlussa;
        this.lkm = maaraAlussa;
    }
    
    public void tulostaTuote() {
        System.out.println(this.nimi +", hinta " +this.hinta +", " +this.lkm +" kpl");
    }
    
    /**
     * @return the nimi
     */
    public String getNimi() {
        return nimi;
    }

    /**
     * @param nimi the nimi to set
     */
    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    /**
     * @return the hinta
     */
    public double getHinta() {
        return hinta;
    }

    /**
     * @param hinta the hinta to set
     */
    public void setHinta(double hinta) {
        this.hinta = hinta;
    }

    /**
     * @return the lkm
     */
    public int getLkm() {
        return lkm;
    }

    /**
     * @param lkm the lkm to set
     */
    public void setLkm(int lkm) {
        this.lkm = lkm;
    }

}
