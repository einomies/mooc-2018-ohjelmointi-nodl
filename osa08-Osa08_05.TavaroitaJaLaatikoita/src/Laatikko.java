
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author einomies
 */
public class Laatikko implements Talletettava {

    private final double maxPaino;
    private double paino;
    private int talletettavatLkm;

    private ArrayList<Talletettava> lista;

    public Laatikko(double maxPaino) {
        this.lista = new ArrayList<>();
        this.maxPaino = maxPaino;
        this.paino = 0;
    }

    public void lisaa(Talletettava talletettava) {
        if (voiLisata(talletettava)) {
            this.lista.add(talletettava);
            this.paino = this.paino + talletettava.paino();
            this.talletettavatLkm++;
        }
    }

    private boolean voiLisata(Talletettava talletettava) {
        if (this.paino + talletettava.paino() > this.maxPaino) {
            return false;
        }
        return true;
    }

    @Override
    public double paino() {
        double painoYht = 0;
        for (Talletettava talletettava : this.lista) {
            painoYht = painoYht + talletettava.paino();
        }
        return painoYht;
//        return this.paino;
    }

    @Override
    public String toString() {
        return "Laatikko: " + this.talletettavatLkm + " esinettä, paino yhteensä " + this.paino + " kiloa";
    }

}

/*
import java.util.ArrayList;

public class Laatikko implements Talletettava {

    private ArrayList<Talletettava> esineet;
    private double maxPaino;

    public Laatikko(double paino) {
        this.maxPaino = paino;
        this.esineet = new ArrayList<>();
    }

    @Override
    public double paino() {
        double paino = 0;
        for (Talletettava talletettava : esineet) {
            paino += talletettava.paino();
        }
        return paino;
    }

    public void lisaa(Talletettava esine) {
        if (this.paino() + esine.paino() <= this.maxPaino) {
            this.esineet.add(esine);
        }
    }

    @Override
    public String toString() {
        return "Laatikko: " + this.esineet.size() + " esinettä, paino yhteensä " + this.paino() + " kiloa";
    }
}
*/