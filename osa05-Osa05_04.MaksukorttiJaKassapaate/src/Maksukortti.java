public class Maksukortti {

    private double saldo;

    public Maksukortti(double saldo) {
        this.saldo = saldo;
    }

    public double saldo() {
        return this.saldo;
    }

    public void lataaRahaa(double lisays) {
        this.saldo += lisays;
    }

    public boolean otaRahaa(double maara) {
        // toteuta metodi siten että se ottaa kortilta rahaa vain jos saldo on vähintään maara
        // onnistuessaan metodi palauttaa true ja muuten false
        if( this.saldo >= maara) {
            this.saldo -= maara;
            return true;
        } else {
            return false;
        }
    }

}

/*
vaihtoehto:

public class Kassapaate {

    // Javassa vakio määritellään näin
    private static final double EDULLISEN_HINTA = 2.5;
    private static final double MAUKKAAN_HINTA = 4.3;

    private double rahaa;  // kassassa olevan käteisen määrä
    private int edulliset; // myytyjen edullisten lounaiden määrä
    private int maukkaat;  // myytyjen maukkaiden lounaiden määrä

    public Kassapaate() {
        // kassassa on aluksi 1000 euroa rahaa
        this.rahaa = 1000;
    }

    public double syoEdullisesti(double maksu) {
        // edullinen lounas maksaa 2.50 euroa.
        // päivitetään kassan rahamäärää lounaan hinnalla ja palautetaan vaihtorahat
        // jos parametrina annettu maksu ei ole riittävän suuri, ei lounasta myydä ja metodi palauttaa koko summan
        if (maksu < EDULLISEN_HINTA) {
            return maksu;
        }
        this.rahaa += EDULLISEN_HINTA;
        this.edulliset++;
        return maksu - EDULLISEN_HINTA;
    }

    public double syoMaukkaasti(double maksu) {
        // edullinen lounas maksaa 4.30 euroa.
        // päivitetään kassan rahamäärää lounaan hinnalla ja palautetaan vaihtorahat
        // jos parametrina annettu maksu ei ole riittävän suuri, ei lounasta myydä ja metodi palauttaa koko summan
        if (maksu < MAUKKAAN_HINTA) {
            return maksu;
        }
        this.rahaa += MAUKKAAN_HINTA;
        this.maukkaat++;
        return maksu - MAUKKAAN_HINTA;
    }

    public boolean syoEdullisesti(Maksukortti kortti) {
        if (kortti.saldo() < EDULLISEN_HINTA) {
            return false;
        }
        kortti.otaRahaa(EDULLISEN_HINTA);
        this.edulliset++;
        return true;
    }

    public boolean syoMaukkaasti(Maksukortti kortti) {
        if (kortti.saldo() < MAUKKAAN_HINTA) {
            return false;
        }
        kortti.otaRahaa(MAUKKAAN_HINTA);
        this.maukkaat++;
        return true;
    }

    public void lataaRahaaKortille(Maksukortti kortti, double summa) {
        if (summa < 0) {
            return;
        }
        kortti.lataaRahaa(summa);
        this.rahaa += summa;
    }

    @Override
    public String toString() {
        return "kassassa rahaa " + rahaa + " edullisia lounaita myyty " +
               edulliset + " maukkaita lounaita myyty " + maukkaat;
    }
}
*/