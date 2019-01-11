/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esimerkki;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author einomies
 */
class Henkilo implements Henkilovarasto {
    
    private String nimi;
    private String hetu;

    public Henkilo() {
    }

    public Henkilo(String nimi, String hetu) {
        this.nimi = nimi;
        this.hetu = hetu;
    }

    public Henkilo(Henkilo lisattava) {
    }

    @Override
    public void talleta(Henkilo henkilo) {
    }

    @Override
    public Henkilo hae(String henkilotunnus) {
        return new Henkilo("", "");
    }

    @Override
    public void poista(Henkilo henkilo) {
    }

    @Override
    public void poista(String henkilotunnus) {
    }

    @Override
    public void poistaKaikki() {
    }

    @Override
    public Collection<Henkilo> haeKaikki() {
//        Collection<Henkilo> henkilot = new Collection<>();
        ArrayList<Henkilo> henkilot = new ArrayList<>();
        return henkilot;
    }
    
}
