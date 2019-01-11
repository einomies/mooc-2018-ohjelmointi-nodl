/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author einomies
 */
public class Ostos {

    private String tuote;
    private int kpl;
    private int yksikkohinta;

//  Konstruktori joka luo ostoksen joka vastaa parametrina annettua tuotetta.
//  Tuotteita ostoksessa on kpl kappaletta ja yhden tuotteen hinta on kolmantena
//  parametrina annettu yksikkohinta
    public Ostos(String tuote, int kpl, int yksikkohinta) {
        this.tuote = tuote;
        this.kpl = kpl;
        this.yksikkohinta = yksikkohinta;
    }

//  Palauttaa ostoksen hinnan. Hinta saadaan kertomalla kappalemäärä yksikköhinnalla
    public int hinta() {
        return this.kpl * this.yksikkohinta;
    }

//  kasvattaa ostoksen kappalemäärää yhdellä
    public void kasvataMaaraa() {
        this.kpl++;
    }

//  palauttaa ostoksen merkkijonomuodossa, joka on alla olevan esimerkin mukainen
//  maito: 4
//  maito: 5
    @Override
    public String toString() {
        return this.tuote + ": " + this.kpl;
    }

}
/*
public class Ostos {

    private String tuote;
    private int kpl;
    private int yksikkohinta;

    public Ostos(String tuote, int kpl, int yksikkohinta) {
        this.tuote = tuote;
        this.kpl = kpl;
        this.yksikkohinta = yksikkohinta;
    }

    public int hinta() {
        return this.kpl * this.yksikkohinta;
    }

    public void kasvataMaaraa() {
        this.kpl++;
    }

    @Override
    public String toString() {
        return this.tuote + ": " + this.kpl;
    }
}
*/