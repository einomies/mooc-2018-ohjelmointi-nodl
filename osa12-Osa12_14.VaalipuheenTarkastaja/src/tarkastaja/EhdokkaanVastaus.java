/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarkastaja;

/**
 *
 * @author einomies
 */
public class EhdokkaanVastaus {

    private boolean valittu;
    private String miksiKannattaisiValita;
    private String mitaAsioitaPyrkiiEdistamaan;

    public EhdokkaanVastaus() {
    }

    public EhdokkaanVastaus(boolean valittu, String miksiKannattaisiValita,
            String mitaAsioitaPyrkiiEdistamaan) {
        this.valittu = valittu;
        this.miksiKannattaisiValita = miksiKannattaisiValita;
        this.mitaAsioitaPyrkiiEdistamaan = mitaAsioitaPyrkiiEdistamaan;
    }

    public boolean isValittu() {
        return valittu;
    }

    public void setValittu(boolean valittu) {
        this.valittu = valittu;
    }

    public String getMiksiKannattaisiValita() {
        return miksiKannattaisiValita;
    }

    public void setMiksiKannattaisiValita(String miksiKannattaisiValita) {
        this.miksiKannattaisiValita = miksiKannattaisiValita;
    }

    public String getMitaAsioitaPyrkiiEdistamaan() {
        return mitaAsioitaPyrkiiEdistamaan;
    }

    public void setMitaAsioitaPyrkiiEdistamaan(String mitaAsioitaPyrkiiEdistamaan) {
        this.mitaAsioitaPyrkiiEdistamaan = mitaAsioitaPyrkiiEdistamaan;
    }

    @Override
    public String toString() {
        return "EhdokkaanVastaus{" + "valittu=" + valittu + ", miksiKannattaisiValita=" + miksiKannattaisiValita + ", mitaAsioitaPyrkiiEdistamaan=" + mitaAsioitaPyrkiiEdistamaan + '}';
    }

}
