package sovellus;

public class Tilasto {

    private Sanakirja sanakirja;
    private int arvauksia;
    private int oikein;

    public Tilasto(Sanakirja sanakirja) {
        this.sanakirja = sanakirja;
        this.arvauksia = 0;
        this.oikein = 0;
    }

    public int getArvauksia() {
        return arvauksia;
    }

    public int getOikein() {
        return oikein;
    }

    public void kasvataArvauksia() {
        this.arvauksia++;
    }

    public void kasvataOikeinMenneita() {
        this.oikein++;
    }

    public int getSanoja() {
        return this.sanakirja.listaaKaikki().size();
    }

}
