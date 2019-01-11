package laatikot;

import java.util.Objects;

public class Tavara {

    private String nimi;
    private int paino;

    public Tavara(String nimi, int paino) {
        this.nimi = nimi;
        if (paino >= 0) {
            this.paino = paino;
        } else {
            throw new IllegalArgumentException("Tavaran paino ei saa olla negatiivinen");
        }
    }

    public Tavara(String nimi) {
        this(nimi, 0);
    }

    public String getNimi() {
        return nimi;
    }

    public int getPaino() {
        return paino;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.nimi);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tavara other = (Tavara) obj;
        if (!Objects.equals(this.nimi, other.nimi)) {
            return false;
        }
        return true;
    }

}

/*
package laatikot;

public class Tavara {

    private String nimi;
    private int paino;

    public Tavara(String nimi, int paino) {
        if (paino < 0) {
            throw new IllegalArgumentException("Tavaran painon tulee olla 0 tai suurempi.");
        }
        this.nimi = nimi;
        this.paino = paino;
    }

    public Tavara(String nimi) {
        this(nimi, 0);
    }

    public String getNimi() {
        return nimi;
    }

    public int getPaino() {
        return paino;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tavara other = (Tavara) obj;
        if ((this.nimi == null) ? (other.nimi != null) : !this.nimi.equals(other.nimi)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (this.nimi != null ? this.nimi.hashCode() : 0);
        return hash;
    }
}
*/