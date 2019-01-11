package esimerkki;

public class Henkilo {

    private int syntymavuosi;
    private String nimi;

    public Henkilo(String nimi, int syntymavuosi) {
        this.nimi = nimi;
        this.syntymavuosi = syntymavuosi;
    }

    public String getNimi() {
        return nimi;
    }

    public int getSyntymavuosi() {
        return syntymavuosi;
    }

}
/*
public class Henkilo implements Tunnistettava, Comparable<Henkilo> {

    private String nimi;
    private String henkilotunnus;

    public Henkilo(String nimi, String henkilotunnus) {
        this.nimi = nimi;
        this.henkilotunnus = henkilotunnus;
    }

    public String getNimi() {
        return this.nimi;
    }

    public String getHenkilotunnus() {
        return this.henkilotunnus;
    }

    @Override
    public String getTunnus() {
        return getHenkilotunnus();
    }

    @Override
    public int compareTo(Henkilo toinen) {
        return this.getTunnus().compareTo(toinen.getTunnus());
    }
}
*/
