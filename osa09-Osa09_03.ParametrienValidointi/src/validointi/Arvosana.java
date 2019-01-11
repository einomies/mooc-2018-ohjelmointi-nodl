package validointi;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author einomies
 */
public class Arvosana {

    private int arvosana;

    public Arvosana(int arvosana) {
        if (arvosana < 0 || arvosana > 5) {
            throw new IllegalArgumentException("Arvosanan tulee olla välillä 0-5");
        }

        this.arvosana = arvosana;
    }

    public int getArvosana() {
        return this.arvosana;
    }

}
