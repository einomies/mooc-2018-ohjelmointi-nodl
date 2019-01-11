/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makihyppy;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author einomies
 */
public class Kierros {

    private int nro;
    private String nimi;
    private ArrayList<Hyppy> hypyt;

    Kierros(int nro, ArrayList<Hyppaaja> hyppaajat) {
        this.nro = nro;
        this.nimi = this.nro + ". kierros";
        this.hypyt = new ArrayList<>();
        for (Hyppaaja hyppaaja : hyppaajat) {
            this.hypyt.add(new Hyppy(hyppaaja));
        }
    }

    public int getNro() {
        return nro;
    }

    public String getNimi() {
        return nimi;
    }

    public List<Hyppy> getHypyt() {
        return hypyt;
    }

    @Override
    public String toString() {
        String tulos = "Kierroksen " + this.nro + " tulokset\n";
        for (Hyppy hyppy : hypyt) {
            tulos += hyppy + "\n";
        }
        return tulos;
    }

}
