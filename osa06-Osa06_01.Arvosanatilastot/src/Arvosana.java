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
    
    private int pisteetKaikki;
    private int summaKaikki;
    private int lkmKaikki;
    private double keskiarvoKaikki;
    
    private int pisteetHyv;
    private int summaHyv;
    private int lkmHyv;
    private double keskiarvoHyv;
    private double prosenttiHyv;

    private static final int ALARAJA = 0;
    private static final int YLARAJA = 100;

    private static final int HYV_RAJA = 70;

    private static final int A1_ALARAJA = 70;
    private static final int A2_ALARAJA = 76;
    private static final int A3_ALARAJA = 81;
    private static final int A4_ALARAJA = 86;
    private static final int A5_ALARAJA = 91;
    
    private int a0Lkm;
    private int a1Lkm;
    private int a2Lkm;
    private int a3Lkm;
    private int a4Lkm;
    private int a5Lkm;

    public int getPisteet() {
        return this.pisteetKaikki;
    }

    public void setPisteet(int pisteet) {
        if (pisteet >= ALARAJA && pisteet <= YLARAJA) {
            this.pisteetKaikki = pisteet;
            this.lkmKaikki++;
            this.summaKaikki += this.pisteetKaikki;
            this.keskiarvoKaikki = (double)this.summaKaikki/(double)this.lkmKaikki;
            
            if (pisteet >= HYV_RAJA) {
                this.pisteetHyv = pisteet;
                this.lkmHyv++;
                this.summaHyv += this.pisteetHyv;
                this.keskiarvoHyv = (double)this.summaHyv/(double)this.lkmHyv;
            }
            this.prosenttiHyv = (double)this.lkmHyv/(double)this.lkmKaikki*100;
            arvosana(pisteet);
        }
    }
    
    private void arvosana(int pisteet) {
        if (pisteet >= A5_ALARAJA) {
            this.a5Lkm++;
        } else if (pisteet >= A4_ALARAJA) {
            this.a4Lkm++;
        } else if (pisteet >= A3_ALARAJA) {
            this.a3Lkm++;
        } else if (pisteet >= A2_ALARAJA) {
            this.a2Lkm++;
        } else if (pisteet >= A1_ALARAJA) {
            this.a1Lkm++;
        } else {
            this.a0Lkm++;
        }
//pistemäärä 	arvosana
//< 70 	hylätty eli 0
//< 76 	1
//< 81 	2
//< 86 	3
//< 91 	4
//>= 91 	5
    }
    
    public int lkmKaikki() {
        return this.lkmKaikki;
    }

    public int lkmA0() {
        return this.a0Lkm;
    }
    public int lkmA1() {
        return this.a1Lkm;
    }
    public int lkmA2() {
        return this.a2Lkm;
    }
    public int lkmA3() {
        return this.a3Lkm;
    }
    public int lkmA4() {
        return this.a4Lkm;
    }
    public int lkmA5() {
        return this.a5Lkm;
    }

    public int lkmHyv() {
        return this.lkmHyv;
    }
    
    public double keskiarvo() {
        return this.keskiarvoKaikki;
    }

    public double keskiarvoHyv() {
        return this.keskiarvoHyv;
    }

    public double prosenttiHyv() {
        return this.prosenttiHyv;
    }
}
