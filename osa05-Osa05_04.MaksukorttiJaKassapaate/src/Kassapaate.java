public class Kassapaate {

    private double rahaa;  // kassassa olevan käteisen määrä
    private int edulliset; // myytyjen edullisten lounaiden määrä
    private int maukkaat;  // myytyjen maukkaiden lounaiden määrä
    private final static double EDULLINEN = 2.50;
    private final static double MAUKAS = 4.30;

    public Kassapaate() {
        // kassassa on aluksi 1000 euroa rahaa
        this.rahaa = 1000;
        this.edulliset = 0;
        this.maukkaat = 0;
    }

    public double syoEdullisesti(double maksu) {
        // edullinen lounas maksaa 2.50 euroa.
        // päivitetään kassan rahamäärää lounaan hinnalla ja palautetaan vaihtorahat
        // jos parametrina annettu maksu ei ole riittävän suuri, ei lounasta myydä ja metodi palauttaa koko summan
        if (maksu >= EDULLINEN) {
            edulliset++;
            this.rahaa += EDULLINEN;
            return maksu - EDULLINEN;
        } else {
            return maksu;
        }
    }

    public double syoMaukkaasti(double maksu) {
        // edullinen lounas maksaa 4.30 euroa.
        // päivitetään kassan rahamäärää lounaan hinnalla ja palautetaan vaihtorahat
        // jos parametrina annettu maksu ei ole riittävän suuri, ei lounasta myydä ja metodi palauttaa koko summan
        if (maksu >= MAUKAS) {
            maukkaat++;
            this.rahaa += MAUKAS;
            return maksu - MAUKAS;
        } else {
            return maksu;
        }
    }

    public boolean syoEdullisesti(Maksukortti kortti) {
        // edullinen lounas maksaa 2.50 euroa.
        // jos kortilla on tarpeeksi rahaa, vähennetään hinta kortilta ja palautetaan true
        // muuten palautetaan false
        if (kortti.otaRahaa(EDULLINEN)) {
            edulliset++;
            return true;
        } else {
            return false;
        }
    }

    public boolean syoMaukkaasti(Maksukortti kortti) {
        // maukas lounas maksaa 4.30 euroa.
        // jos kortilla on tarpeeksi rahaa, vähennetään hinta kortilta ja palautetaan true
        // muuten palautetaan false
        if (kortti.otaRahaa(MAUKAS)) {
            maukkaat++;
            return true;
        } else {
            return false;
        }
    }

    public void lataaRahaaKortille(Maksukortti kortti, double summa) {
        if (summa > 0) {
            this.rahaa += summa;
            kortti.lataaRahaa(summa);
        }
    }

    @Override
    public String toString() {
        return "kassassa rahaa " + rahaa + " edullisia lounaita myyty " +
               edulliset + " maukkaita lounaita myyty " + maukkaat;
    }

}
