package esimerkki;

public class Lista<T> {

    private T[] arvot;
    private int arvoja;

    public Lista() {
        this.arvot = (T[]) new Object[10];
        this.arvoja = 0;
    }

    public void lisaa(T arvo) {
        if (this.arvoja == this.arvot.length) {
            kasvata();
        }
        this.arvot[this.arvoja] = arvo;
        this.arvoja++;
    }

    /**
     * Toteutus luo uuden taulukon, jonka koko on noin 1.5-kertainen vanhaan
     * taulukkoon verrattuna. Tämän jälkeen kaikki vanhan taulukon alkiot
     * kopioidaan uuteen taulukkoon ja lopulta olion arvot-muuttujan -- eli
     * taulukon -- arvoksi asetetaan uusi taulukko.
     */
    private void kasvata() {
        T[] uusi = (T[]) new Object[this.arvot.length * 3 / 2 + 1];
        for (int i = 0; i < this.arvot.length; i++) {
            uusi[i] = this.arvot[i];
        }
        this.arvot = uusi;
    }

    public boolean sisaltaa(T arvo) {
        return arvonIndeksi(arvo) >= 0;
    }

    public void poista(T arvo) {
        int arvonIndeksi = arvonIndeksi(arvo);
        if (arvonIndeksi < 0) {
            return; // ei löydy
        }
        siirraVasemmalle(arvonIndeksi);
        this.arvoja--;
    }

    public int arvonIndeksi(T arvo) {
        for (int i = 0; i < this.arvoja; i++) {
            if (arvo == this.arvot[i] || this.arvot[i].equals(arvo)) {
                return i;
            }
        }
        return -1;
    }

    private void siirraVasemmalle(int indeksistaLahtien) {
        for (int i = indeksistaLahtien; i < this.arvoja - 1; i++) {
            this.arvot[i] = this.arvot[i + 1];
        }
    }

    public T arvo(int indeksi) {
        if (indeksi < 0 || indeksi >= this.arvoja) {
            throw new ArrayIndexOutOfBoundsException("Indeksi " + indeksi + " alueen [0, " + this.arvoja + "[ ulkopuolella.");
        }
        return this.arvot[indeksi];
    }

    public int koko() {
        return this.arvoja;
    }

}
