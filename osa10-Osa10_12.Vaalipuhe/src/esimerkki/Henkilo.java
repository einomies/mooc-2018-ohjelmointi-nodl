package esimerkki;

import java.util.Objects;

public class Henkilo {

    private String nimi;
//    private String etunimi;
//    private String sukunimi;
    private int syntymavuosi;

    public Henkilo(String nimi, int syntymavuosi) {
        this.nimi = nimi;
        this.syntymavuosi = syntymavuosi;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public int getSyntymavuosi() {
        return syntymavuosi;
    }

    public void setSyntymavuosi(int syntymavuosi) {
        this.syntymavuosi = syntymavuosi;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.nimi);
        hash = 59 * hash + this.syntymavuosi;
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
        final Henkilo other = (Henkilo) obj;
        if (this.syntymavuosi != other.syntymavuosi) {
            return false;
        }
        if (!Objects.equals(this.nimi, other.nimi)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Henkilo{" + "nimi=" + nimi + ", syntymavuosi=" + syntymavuosi + '}';
    }

}
