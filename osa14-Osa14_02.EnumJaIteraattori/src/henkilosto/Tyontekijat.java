/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package henkilosto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author einomies
 */
public class Tyontekijat {

    private List<Henkilo> lista;

    public Tyontekijat() {
        this.lista = new ArrayList<>();
    }

    public void lisaa(Henkilo lisattava) {
        this.lista.add(lisattava);
    }

    public void lisaa(List<Henkilo> lisattavat) {
        lisattavat.forEach((henkilo) -> {
            this.lista.add(henkilo);
        });
    }

    public void tulosta() {
        this.lista.forEach(henkilo -> System.out.println(henkilo));
    }

    public void tulosta(Koulutus koulutus) {
        Iterator<Henkilo> iterator = this.lista.iterator();
        while (iterator.hasNext()) {
            Henkilo henkilo = iterator.next();
            if (henkilo.getKoulutus() == koulutus) {
                System.out.println(henkilo);
            }
        }
//        for (Henkilo henkilo : this.lista) {
//            if (henkilo.getKoulutus().equals(koulutus)) {
//                System.out.println(henkilo);
//            }
//        }
    }

    public void irtisano(Koulutus koulutus) {
        Iterator<Henkilo> iterator = this.lista.iterator();
        while (iterator.hasNext()) {
            Henkilo henkilo = iterator.next();
            if (henkilo.getKoulutus() == koulutus) {
                iterator.remove();
            }
        }
//        for (Henkilo henkilo : this.lista) {
//            if (henkilo.getKoulutus().equals(koulutus)) {
//                this.lista.remove(henkilo);
//            }
//        }
    }

}
/*
package henkilosto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Tyontekijat {

    private List<Henkilo> henkilot;

    public Tyontekijat() {
        henkilot = new ArrayList<>();
    }

    public void lisaa(Henkilo lisattava) {
        henkilot.add(lisattava);
    }

    public void lisaa(List<Henkilo> lisattavat) {
        lisattavat.stream().forEach(lisattava -> lisaa(lisattava));
    }

    public void tulosta() {
        Iterator<Henkilo> iteraattori = henkilot.iterator();
        while (iteraattori.hasNext()) {
            System.out.println(iteraattori.next());
        }
    }

    public void tulosta(Koulutus koulutus) {
        Iterator<Henkilo> iteraattori = henkilot.iterator();
        while (iteraattori.hasNext()) {
            Henkilo hlo = iteraattori.next();
            if (hlo.getKoulutus() == koulutus) {
                System.out.println(hlo);
            }
        }
    }

    public void irtisano(Koulutus koulutus) {
        Iterator<Henkilo> iteraattori = henkilot.iterator();
        while (iteraattori.hasNext()) {
            Henkilo hlo = iteraattori.next();
            if (hlo.getKoulutus() == koulutus) {
                iteraattori.remove();
            }
        }
    }
}
*/