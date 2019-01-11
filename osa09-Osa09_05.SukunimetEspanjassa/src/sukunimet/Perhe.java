/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sukunimet;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author einomies
 */
public class Perhe {

    private List<Henkilo> henkilot = new ArrayList<>();

    public Perhe() {
        this.henkilot = new ArrayList<>();
    }

    public void lisaa(Henkilo henkilo) {
        this.henkilot.add(henkilo);
    }

    public void poista(Henkilo henkilo) {
        this.henkilot.remove(this.henkilot.indexOf(henkilo));
    }

    @Override
    public String toString() {
        String tulos = "";
        int i = 1;
        for (Henkilo henkilo : this.henkilot) {
            if (i < this.henkilot.size()) {
                tulos = tulos + henkilo.toString() + "\n";
            } else {
                tulos = tulos + henkilo.toString();
            }
            i++;
        }
        return tulos;
    }

}

/*
package sukunimet;

import java.util.ArrayList;
import java.util.List;

public class Perhe {

    private List<Henkilo> henkilot;

    public Perhe() {
        this.henkilot = new ArrayList<>();
    }

    public void lisaa(Henkilo henkilo) {
        this.henkilot.add(henkilo);
    }

    public void poista(Henkilo henkilo) {
        this.henkilot.remove(henkilo);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Henkilo henkilo : henkilot) {
            sb.append(henkilo.toString()).append("\n");
        }
        return sb.toString();
    }

}
*/