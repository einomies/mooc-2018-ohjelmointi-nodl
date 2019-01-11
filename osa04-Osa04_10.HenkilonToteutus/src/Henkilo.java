/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author einomies
 */
public class Henkilo {
    
    private String nimi;
    private int ika;
    
    public Henkilo(String nimi) {
        this.nimi = nimi;
    }
    
    public void tulostaHenkilo() {
        System.out.println(this.nimi +", ikä " +this.ika +" vuotta");
    }
    
    public void vanhene() {
        this.ika++;
    }
    
    public int palautaIka() {
        return this.ika;
    }

}
