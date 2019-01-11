import java.util.Objects;

public class Henkilo {

    private String etunimi;
    private String sukunimi;
    private String puhelinnumero;

    public Henkilo(String etunimi, String sukunimi, String puhelinnumero) {
        this.etunimi = etunimi;
        this.sukunimi = sukunimi;
        this.puhelinnumero = puhelinnumero;
    }

    public String getEtunimi() {
        return etunimi;
    }

    public void setEtunimi(String etunimi) {
        this.etunimi = etunimi;
    }

    public String getSukunimi() {
        return sukunimi;
    }

    public void setSukunimi(String sukunimi) {
        this.sukunimi = sukunimi;
    }

    public String getPuhelinnumero() {
        return puhelinnumero;
    }

    public void setPuhelinnumero(String puhelinnumero) {
        this.puhelinnumero = puhelinnumero;
    }

    @Override
    public String toString() {
        return this.etunimi + "\t" + this.sukunimi + "\t" + this.puhelinnumero;
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
        if (!Objects.equals(this.etunimi, other.etunimi)) {
            return false;
        }
        if (!Objects.equals(this.sukunimi, other.sukunimi)) {
            return false;
        }
        if (!Objects.equals(this.puhelinnumero, other.puhelinnumero)) {
            return false;
        }
        return true;
    }

}
