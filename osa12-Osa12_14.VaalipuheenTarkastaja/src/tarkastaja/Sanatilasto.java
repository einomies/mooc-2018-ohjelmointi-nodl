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
public class Sanatilasto {

    private String sana;
    private Integer valittu;
    private Integer eiValittu;

    public Sanatilasto() {
    }

    public Sanatilasto(String sana, Integer valittu, Integer eiValittu) {
        this.sana = sana;
        this.valittu = valittu;
        this.eiValittu = eiValittu;
    }

    public String getSana() {
        return sana;
    }

    public void setSana(String sana) {
        this.sana = sana;
    }

    public Integer getValittu() {
        return valittu;
    }

    public void setValittu(Integer valittu) {
        this.valittu = valittu;
    }

    public Integer getEiValittu() {
        return eiValittu;
    }

    public void setEiValittu(Integer eiValittu) {
        this.eiValittu = eiValittu;
    }

    @Override
    public String toString() {
//        return "Sanatilasto{" + "sana=" + sana + ", valittu=" + valittu + ", eiValittu=" + eiValittu + '}';
        return sana + ", " + valittu + " vs " + eiValittu;
    }

}
