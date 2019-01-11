/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author einomies
 */
public class Maksukortti {
    
    private double saldo;
    
    private static final double EDULLINEN = 2.6;
    private static final double MAUKAS = 4.6;
    private static final double MIN_SALDO = 0;
    private static final double MAX_SALDO = 150;
    
    public Maksukortti(double saldo) {
        this.saldo = saldo;
    }
    
    public String jotain() {
        return "Kortilla on rahhaa ihan vitusti";
    }

    public String toString() {
        return "Kortilla on rahaa " +this.saldo +" euroa";
    }
    
//  Metodin syoEdullisesti tulisi vähentää kortin saldoa 2.60 eurolla
    public void syoEdullisesti() {
        if (this.saldo - EDULLINEN >= MIN_SALDO) {
            this.saldo = this.saldo - EDULLINEN;
        }
    }

//  Metodin syoMaukkaasti tulisi vähentää kortin saldoa 4.60 eurolla.
    public void syoMaukkaasti() {
        if (this.saldo - MAUKAS >= MIN_SALDO) {
            this.saldo = this.saldo - MAUKAS;
        }
    }

//  Metodin tarkoituksena on kasvattaa kortin saldoa parametrina annetulla rahamäärällä.
//  Kuitenkin kortin saldo saa olla korkeintaan 150 euroa, joten jos ladattava
//  rahamäärä ylittäisi sen, saldoksi tulisi tulla silti tasan 150 euroa.
    public void lataaRahaa(double rahamaara) {
        if (rahamaara > 0) {
            if (this.saldo + rahamaara <= MAX_SALDO) {
                this.saldo = this.saldo + rahamaara;
            } else {
                this.saldo = MAX_SALDO;
            }
        }
    }

}

/*
Vaihtoehtoinen tapa, tiiviimpi ja ehkä selkeämpi?

public class Maksukortti {
	
    private double arvo;
    
    // pidetään edullinen ja maukas muuttujina, jolloin niitä käyttävä
    // koodi on selkeämpää lukea
    // avainsana final tarkoittaa että muuttujan arvoa ei voi muuttaa sen
    // jälkeen kun se on kertaalleen asetettu
    private final double edullinen;
    private final double maukas;
    
    public Maksukortti(double arvoaAlussa) {
        this.arvo = arvoaAlussa;
        this.edullinen = 2.6;
        this.maukas = 4.6;
    }
    
    public void syoEdullisesti() {
        if (this.arvo >= edullinen) {
            this.arvo -= edullinen;
        }
    }
    
    public void syoMaukkaasti() {
        if (this.arvo >= maukas) {
            this.arvo -= maukas;
        }
    }
    
    public void lataaRahaa(double rahamaara) {
        if (rahamaara < 0) {
            return;
        }
        this.arvo += rahamaara;
        if (this.arvo > 150) {
            this.arvo = 150;
        }
    }
    
    @Override
    public String toString() {
        return "Kortilla on rahaa " + this.arvo + " euroa";
    }
	
}
*/
