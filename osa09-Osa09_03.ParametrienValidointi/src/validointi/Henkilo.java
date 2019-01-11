package validointi;

public class Henkilo {

    private String nimi;
    private int ika;

    /*
    Luokan Henkilo konstruktorin tulee varmistaa että parametrina annettu nimi
    ei ole null, tyhjä tai yli 40 merkkiä pitkä. Myös iän tulee olla väliltä 0-120.
    Jos joku edelläolevista ehdoista ei päde, tulee konstruktorin heittää
    IllegalArgumentException-poikkeus.
     */
    public Henkilo(String nimi, int ika) {
        if (nimi == null || nimi.isEmpty() || nimi.length() > 40) {
            throw new IllegalArgumentException("Henkilön nimi ei saa olla tyhjä "
                    + "ja sen tulee olla korkeintaan 40 merkkiä pitkä.");
        }
        if (ika < 0 || ika > 120) {
            throw new IllegalArgumentException("Henkilön iän pitäisi olla välillä [0-120].");
        }
        this.nimi = nimi;
        this.ika = ika;
    }

    public String getNimi() {
        return nimi;
    }

    public int getIka() {
        return ika;
    }

    @Override
    public String toString() {
        return "Henkilo{" + "nimi=" + nimi + ", ika=" + ika + '}';
    }

}
