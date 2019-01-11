/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esimerkki;

import java.util.Collection;

/**
 *
 * @author einomies
 */
public interface Henkilovarasto {

    void talleta(Henkilo henkilo);

    Henkilo hae(String henkilotunnus);

    void poista(Henkilo henkilo);

    void poista(String henkilotunnus);

    void poistaKaikki();

    Collection<Henkilo> haeKaikki();
}
