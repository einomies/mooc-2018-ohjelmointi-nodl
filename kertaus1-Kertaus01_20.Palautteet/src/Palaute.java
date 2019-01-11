/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author einomies
 */
public class Palaute {

    private String kuvaus;
    private int arvosana;

    final int arvosanaMin = 1;
    final int arvosanaMax = 5;

    public Palaute(String kuvaus, int arvosana) throws Exception {
        this.kuvaus = kuvaus;
        if (arvosanaOk(arvosana)) {
            this.arvosana = arvosana;
        } else {
            throw new Exception("Arvosana virheellinen, oltava välillä " +arvosanaMin +"-" +arvosanaMax);
        }
    }

    public int getArvosanaMin() {
        return arvosanaMin;
    }

    public int getArvosanaMax() {
        return arvosanaMax;
    }
    private boolean arvosanaOk(int arvosana) {
        if (arvosana >= arvosanaMin && arvosana <= arvosanaMax) {
            return true;
        }
        return false;
    }

    public String getKuvaus() {
        return kuvaus;
    }

    public void setKuvaus(String kuvaus) {
        this.kuvaus = kuvaus;
    }

    public int getArvosana() {
        return arvosana;
    }

    public void setArvosana(int arvosana) {
        this.arvosana = arvosana;
    }

    @Override
    public String toString() {
        return "(" + "kuvaus=" + kuvaus + ", arvosana=" + arvosana + '}';
    }

}
