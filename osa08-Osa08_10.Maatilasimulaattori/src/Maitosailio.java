
public class Maitosailio {

    private double tilavuus;
    private double saldo;

    public Maitosailio() {
        this.tilavuus = 2000;
        this.saldo = 0;
    }

    public Maitosailio(double tilavuus) {
        this.tilavuus = tilavuus;
        this.saldo = 0;
    }

    public double getTilavuus() {
        return this.tilavuus;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public double paljonkoTilaaJaljella() {
        return this.tilavuus - this.saldo;
    }

    public void lisaaSailioon(double maara) {
        // lisää säiliöön vain niin paljon maitoa kuin sinne mahtuu, ylimääräiset jäävät
        // lisäämättä, maitosäiliön ei siis tarvitse huolehtia tilanteesta jossa maitoa
        // valuu yli
        double vapaana = this.tilavuus - this.saldo;

        if (maara > vapaana) {
            this.saldo = this.tilavuus;
        } else {
            this.saldo = this.saldo + maara;
        }
    }

    public double otaSailiosta(double maara) {
        // ottaa säiliöstä pyydetyn määrän, tai niin paljon kuin siellä on jäljellä
        double otetaan = 0;
        if (maara > this.saldo) {
            otetaan = this.saldo;
            this.saldo = 0;
        } else {
            otetaan = maara;
            this.saldo = this.saldo - otetaan;
        }

        return otetaan;
    }

    @Override
    public String toString() {
        return Math.ceil(saldo) + "/" + Math.ceil(tilavuus);
    }

}

/*
public class Maitosailio {

    private double tilavuus;
    private double saldo;

    public Maitosailio() {
        this(2000);
    }

    public Maitosailio(double tilavuus) {
        this.tilavuus = tilavuus;
    }

    public double getTilavuus() {
        return tilavuus;
    }

    public double getSaldo() {
        return saldo;
    }

    public double paljonkoTilaaJaljella() {
        return tilavuus - saldo;
    }

    public void lisaaSailioon(double maara) {
        double uusiSaldo = saldo + maara;
        if (uusiSaldo > tilavuus) {
            uusiSaldo = tilavuus;
        }
        saldo = uusiSaldo;
    }

    public double otaSailiosta(double maara) {
        double otettuMaara = maara;
        if (otettuMaara > saldo) {
            otettuMaara = saldo;
        }
        saldo -= otettuMaara;
        return otettuMaara;
    }

    @Override
    public String toString() {
        return Math.ceil(saldo) + "/" + Math.ceil(tilavuus);
    }
}
*/