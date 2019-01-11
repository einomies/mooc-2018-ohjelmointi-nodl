package reseptit;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Resepti {

    private String nimi;
    private List<String> raakaAineet;

    public Resepti(String nimi) {
        this.nimi = nimi;
        this.raakaAineet = new ArrayList<>();
    }

    public String getNimi() {
        return nimi;
    }

    public List<String> getRaakaAineet() {
        return raakaAineet;
    }

    public void lisaaRaakaAine(String raakaAine) {
        this.raakaAineet.add(raakaAine);
    }

    @Override
    public String toString() {
        String s = this.nimi;

        for (String raakaAine : raakaAineet) {
            s += "\n  " + raakaAine;
        }

        return s;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.nimi);
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
        final Resepti other = (Resepti) obj;
        if (!Objects.equals(this.nimi, other.nimi)) {
            return false;
        }
        return true;
    }

}
