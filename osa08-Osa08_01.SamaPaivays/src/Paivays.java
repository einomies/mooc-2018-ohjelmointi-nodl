
public class Paivays {

    private int paiva;
    private int kuukausi;
    private int vuosi;

    public Paivays(int paiva, int kuukausi, int vuosi) {
        this.paiva = paiva;
        this.kuukausi = kuukausi;
        this.vuosi = vuosi;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }

        if (getClass() != object.getClass()) {
            return false;
        }

        Paivays verrattava = (Paivays) object;

        if (this.paiva != verrattava.paiva
                || this.kuukausi != verrattava.kuukausi
                || this.vuosi != verrattava.vuosi) {
            return false;
        }

        return true;
    }

    /*
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
     */
    @Override
    public String toString() {
        return this.paiva + "." + this.kuukausi + "." + this.vuosi;
    }

    public boolean aiemmin(Paivays verrattava) {
        if (this.vuosi < verrattava.vuosi) {
            return true;
        }

        if (this.vuosi == verrattava.vuosi
                && this.kuukausi < verrattava.kuukausi) {
            return true;
        }

        if (this.vuosi == verrattava.vuosi
                && this.kuukausi == verrattava.kuukausi
                && this.paiva < verrattava.paiva) {
            return true;
        }

        return false;
    }

    public int erotusVuosissa(Paivays verrattava) {
        if (aiemmin(verrattava)) {
            return verrattava.erotusVuosissa(this);
        }

        int vuosiPois = 0;

        if (this.kuukausi < verrattava.kuukausi) {
            vuosiPois = 1;
        } else if (this.kuukausi == verrattava.kuukausi && this.paiva < verrattava.paiva) {
            vuosiPois = 1;
        }

        return this.vuosi - verrattava.vuosi - vuosiPois;
    }

}

/*
public class Paivays {

    private int paiva;
    private int kuukausi;
    private int vuosi;

    public Paivays(int paiva, int kuukausi, int vuosi) {
        this.paiva = paiva;
        this.kuukausi = kuukausi;
        this.vuosi = vuosi;
    }

    @Override
    public String toString() {
        return this.paiva + "." + this.kuukausi + "." + this.vuosi;
    }

    public boolean aiemmin(Paivays verrattava) {
        if (this.vuosi < verrattava.vuosi) {
            return true;
        }
        if (this.vuosi == verrattava.vuosi
                && this.kuukausi < verrattava.kuukausi) {
            return true;
        }
        if (this.vuosi == verrattava.vuosi
                && this.kuukausi == verrattava.kuukausi
                && this.paiva < verrattava.paiva) {
            return true;
        }
        return false;
    }

    public int erotusVuosissa(Paivays verrattava) {
        if (aiemmin(verrattava)) {
            return verrattava.erotusVuosissa(this);
        }
        int vuosiPois = 0;
        if (this.kuukausi < verrattava.kuukausi) {
            vuosiPois = 1;
        } else if (this.kuukausi == verrattava.kuukausi && this.paiva < verrattava.paiva) {
            vuosiPois = 1;
        }
        return this.vuosi - verrattava.vuosi - vuosiPois;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Paivays other = (Paivays) obj;
        if (this.paiva != other.paiva) {
            return false;
        }
        if (this.kuukausi != other.kuukausi) {
            return false;
        }
        if (this.vuosi != other.vuosi) {
            return false;
        }
        return true;
    }
}
*/