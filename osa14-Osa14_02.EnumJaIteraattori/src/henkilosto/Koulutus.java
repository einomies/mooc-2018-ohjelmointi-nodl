/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package henkilosto;

/**
 *
 * @author einomies
 */
public enum Koulutus {
    FT("tohtori"),
    FM("maisteri"),
    LuK("kandidaatti"),
    FilYO("ylioppilas");

    private String nimike;

    private Koulutus(String nimi) {
        this.nimike = nimike;
    }

    public String getNimike() {
        return nimike;
    }

    public void setNimike(String nimike) {
        this.nimike = nimike;
    }

}
