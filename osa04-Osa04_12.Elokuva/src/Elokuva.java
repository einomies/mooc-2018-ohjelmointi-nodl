/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author einomies
 */
public class Elokuva {
    
    private String nimi;
    private int ikaraja;
    
    public Elokuva(String elokuvanNimi, int elokuvanIkaraja) {
        this.nimi = elokuvanNimi;
        this.ikaraja = elokuvanIkaraja;
    }

    public String nimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public int ikaraja() {
        return ikaraja;
    }

    public void setIkaraja(int ikaraja) {
        this.ikaraja = ikaraja;
    }
    
    
}
