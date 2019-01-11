
import jdk.nashorn.internal.ir.ContinueNode;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author einomies
 */
public class YlhaaltaRajoitettuLaskuri {
    private int arvo;
    private int ylaraja;

    public YlhaaltaRajoitettuLaskuri(int ylarajanAlkuarvo) {
        this.arvo = 0;
        this.ylaraja = ylarajanAlkuarvo;
    }

    public void seuraava() {
        if (this.arvo >= this.ylaraja) {
            this.arvo = 0;
        } else {
            this.arvo++;
        }
    }

    public String toString() {
        if (this.arvo > 9) {
            return "" +this.arvo;
        } else {
            return "0" +this.arvo;
        }
    }

    public int arvo() {
        return this.arvo;
    }
    
    public void asetaArvo(int arvo) {
        if (arvo >= 0 && arvo <= this.ylaraja) {
            this.arvo = arvo;
        }
    }
}

/*
public class YlhaaltaRajoitettuLaskuri {
    private int arvo;
    private int ylaraja;
    public YlhaaltaRajoitettuLaskuri(int ylarajanAlkuarvo) {
        this.ylaraja = ylarajanAlkuarvo;
        this.arvo = 0;
    }
    public void seuraava() {
        if (this.arvo == this.ylaraja) {
            this.arvo = 0;
        } else {
            this.arvo++;
        }
    }
    public int arvo() {
        return this.arvo;
    }
    public void asetaArvo(int uusiArvo) {
        if (uusiArvo < 0 || uusiArvo > this.ylaraja) {
            return;
        }
        this.arvo = uusiArvo;
    }
    @Override
    public String toString() {
        String etunolla = "0";
        if (this.arvo > 9) {
            etunolla = "";
        }
        return etunolla + this.arvo;
    }
}
*/