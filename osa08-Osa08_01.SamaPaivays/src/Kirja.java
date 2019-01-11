
public class Kirja {

    private String nimi;
    private int julkaisuvuosi;

    public Kirja(String nimi, int julkaisuvuosi) {
        this.nimi = nimi;
        this.julkaisuvuosi = julkaisuvuosi;
    }

    public String getNimi() {
        return this.nimi;
    }

    public int getJulkaisuvuosi() {
        return this.julkaisuvuosi;
    }

    @Override
    public String toString() {
        return this.nimi + " (" + this.julkaisuvuosi + ")";
    }

    @Override
    public boolean equals(Object olio) {
        if (olio == null) {
            return false;
        }

        if (getClass() != olio.getClass()) {
            return false;
        }

        Kirja verrattava = (Kirja) olio;

        if (this.julkaisuvuosi != verrattava.getJulkaisuvuosi()) {
            return false;
        }

        if (this.nimi == null || !this.nimi.equals(verrattava.getNimi())) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        if (this.nimi == null) {
            return this.julkaisuvuosi;
        }

        return this.julkaisuvuosi + this.nimi.hashCode();
    }
}
