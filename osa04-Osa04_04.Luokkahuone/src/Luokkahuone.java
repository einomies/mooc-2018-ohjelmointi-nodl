/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author einomies
 */
public class Luokkahuone {
    private String koodi;
    private int istumapaikat;
    
    public Luokkahuone(String luokanKoodi, int istumapaikkojenMaara) {
        this.koodi = luokanKoodi;
        this.istumapaikat = istumapaikkojenMaara;
    }
    /*
    Luo luokka nimeltä Luokkahuone.
    Luokkahuoneella on oliomuuttujina private String koodi, esimerkiksi "B221", ja private int istumapaikat, esimerkiksi 30.
    Luo tämän jälkeen konstruktori public Luokkahuone(String luokanKoodi, int istumapaikkojenMaara), minkä avulla oliomuuttujiin asetetaan arvot. 
    */

    /**
     * @return the koodi
     */
    public String getKoodi() {
        return koodi;
    }

    /**
     * @param koodi the koodi to set
     */
    public void setKoodi(String koodi) {
        this.koodi = koodi;
    }

    /**
     * @return the istumapaikat
     */
    public int getIstumapaikat() {
        return istumapaikat;
    }

    /**
     * @param istumapaikat the istumapaikat to set
     */
    public void setIstumapaikat(int istumapaikat) {
        this.istumapaikat = istumapaikat;
    }
}
