
import java.util.Objects;

public class Rekisterinumero {
    // älä muuta luokan jo valmiina olevia osia

    // oliomuuttujille on lisätty määre final, jolloin niiden arvoa ei asetuksen
    // jälkeen voi enää muuttaa
    private final String rekNro;
    private final String maa;

    public Rekisterinumero(String maa, String rekNro) {
        this.maa = maa;
        this.rekNro = rekNro;
    }

    @Override
    public String toString() {
        return maa + " " + rekNro;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.rekNro);
        hash = 19 * hash + Objects.hashCode(this.maa);
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
        final Rekisterinumero other = (Rekisterinumero) obj;
        if (!Objects.equals(this.rekNro, other.rekNro)) {
            return false;
        }
        if (!Objects.equals(this.maa, other.maa)) {
            return false;
        }
        return true;
    }

}

/*
public class Rekisterinumero {
    // älä muuta luokan jo valmiina olevia osia
    // oliomuuttujille on lisätty määre final, jolloin niiden arvoa ei asetuksen
    // jälkeen voi enää muuttaa
    private final String rekNro;
    private final String maa;
    public Rekisterinumero(String maa, String rekNro) {
        this.rekNro = rekNro;
        this.maa = maa;
    }
    @Override
    public String toString() {
        return maa + " " + rekNro;
    }
    @Override
    public boolean equals(Object o) {
        Rekisterinumero verrattava = (Rekisterinumero) o;
        // olisi kenties oikea-oppista tarkastaa että this.rekNro ja this.maa eivät ole null
        // oletetaan kuitenkin, että rekisterinumerot ovat aina kunnollisia ja rekNro ja maa on alustettu
        // kunnollisuus olisi järkevintä tarkastaa konstruktorissa, tulemme tekemään kunnollisuustarkastuksen
        // kun opimme ns. poikkeukset (engl. exception)
        return rekNro.equals(verrattava.rekNro) && this.maa.equals(verrattava.maa);
    }
    @Override
    public int hashCode() {
        // myös tässä metodissa luotetaan että rekisterinumero on "kunnollinen", eli että
        // maa ja rekNro eivät ole null
        return this.maa.hashCode() + this.rekNro.hashCode();
    }
}
*/