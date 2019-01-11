/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siirrettava;

import java.util.ArrayList;

/**
 *
 * @author einomies
 */
public class Lauma implements Siirrettava {

    private ArrayList<Siirrettava> siirrettavat = new ArrayList<>();

    public Lauma() {
        this.siirrettavat = new ArrayList<>();
    }

    @Override
    public void siirra(int dx, int dy) {
        for (Siirrettava siirrettava : this.siirrettavat) {
            siirrettava.siirra(dx, dy);
        }
    }

    public void lisaaLaumaan(Siirrettava siirrettava) {
        this.siirrettavat.add(siirrettava);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Siirrettava siirrettava : this.siirrettavat) {
            sb.append(siirrettava.toString()).append("\n");
        }
        return sb.toString();
    }

}

/*
package siirrettava;
import java.util.ArrayList;

import java.util.List;
public class Lauma implements Siirrettava {

    private List<Siirrettava> lauma;

    public Lauma() {
        this.lauma = new ArrayList<>();
    }

    public void lisaaLaumaan(Siirrettava s) {
        this.lauma.add(s);
    }

    @Override
    public void siirra(int dx, int dy) {
        for (Siirrettava siirrettava : lauma) {
            siirrettava.siirra(dx, dy);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Siirrettava siirrettava : lauma) {
            sb.append(siirrettava.toString()).append("\n");
        }
        return sb.toString();
    }
}
*/