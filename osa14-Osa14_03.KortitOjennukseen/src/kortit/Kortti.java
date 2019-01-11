package kortit;

import java.util.Objects;

public class Kortti implements Comparable<Kortti> {

    private int arvo;
    private Maa maa;

    public Kortti(int arvo, Maa maa) {
        this.arvo = arvo;
        this.maa = maa;
    }

    @Override
    public String toString() {
        String arvoTekstina = "" + this.arvo;
        if (arvo == 11) {
            arvoTekstina = "J";
        } else if (arvo == 12) {
            arvoTekstina = "Q";
        } else if (arvo == 13) {
            arvoTekstina = "K";
        } else if (arvo == 14) {
            arvoTekstina = "A";
        }
        return maa + " " + arvoTekstina;
    }

    public int getArvo() {
        return arvo;
    }

    public Maa getMaa() {
        return maa;
    }

    @Override
    public int compareTo(Kortti verrattava) {
        if (this.arvo == verrattava.arvo) {
            return this.getMaa().ordinal() - verrattava.getMaa().ordinal();
        } else {
            return this.arvo - verrattava.arvo;
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + this.arvo;
        hash = 31 * hash + Objects.hashCode(this.maa);
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
        final Kortti other = (Kortti) obj;
        if (this.arvo != other.arvo) {
            return false;
        }
        if (this.maa != other.maa) {
            return false;
        }
        return true;
    }

}

/*
package kortit;

public class Kortti implements Comparable<Kortti> {

    private int arvo;
    private Maa maa;

    public Kortti(int arvo, Maa maa) {
        this.arvo = arvo;
        this.maa = maa;
    }

    @Override
    public String toString() {
        String arvoTekstina = "" + this.arvo;
        if (arvo == 11) {
            arvoTekstina = "J";
        } else if (arvo == 12) {
            arvoTekstina = "Q";
        } else if (arvo == 13) {
            arvoTekstina = "K";
        } else if (arvo == 14) {
            arvoTekstina = "A";
        }
        return maa + " " + arvoTekstina;
    }

    public int getArvo() {
        return arvo;
    }

    public Maa getMaa() {
        return maa;
    }

    @Override
    public int compareTo(Kortti toinen) {
        if (arvo == toinen.arvo) {
            return maa.ordinal() - toinen.maa.ordinal();
        }
        return arvo - toinen.arvo;
    }
}
*/