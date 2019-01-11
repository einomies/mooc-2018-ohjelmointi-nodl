package validointi;

public class Laskin {

    /*
    Metodin kertoma tulee toimia vain jos parametrina annetaan ei-negatiivinen
    luku (0 tai suurempi).
     */
    public int kertoma(int luvusta) {

        if (luvusta < 0) {
            throw new IllegalArgumentException("Luku ei saa olla negatiivinen");
        }
        int kertoma = 1;
        for (int i = 1; i <= luvusta; i++) {
            kertoma *= i;
        }

        return kertoma;
    }

    /*
    Metodin binomikerroin tulee toimia vain jos parametrit ovat ei-negatiivisia
    ja osajoukon koko on pienempi kuin joukon koko.
     */
    public int binomikerroin(int joukonKoko, int osaJoukonKoko) {

        if (joukonKoko < 0 || osaJoukonKoko < 0) {
            throw new IllegalArgumentException("Luku ei saa olla negatiivinen");
        }
        if (osaJoukonKoko >= joukonKoko) {
            throw new IllegalArgumentException("Osajoukon koko oltava pienempi kuin koko joukon koko");
        }

        int osoittaja = kertoma(joukonKoko);
        int nimittaja = kertoma(osaJoukonKoko) * kertoma(joukonKoko - osaJoukonKoko);

        return osoittaja / nimittaja;
    }
}
