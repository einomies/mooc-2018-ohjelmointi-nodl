import java.util.Objects;

public class Henkilo {

    private String nimi;
    private Paivays syntymaPaiva;
    private int pituus;
    private int paino;

    public Henkilo(String nimi, Paivays syntymaPaiva, int pituus, int paino) {
        this.nimi = nimi;
        this.syntymaPaiva = syntymaPaiva;
        this.pituus = pituus;
        this.paino = paino;
    }

    // toteuta tänne equals-metodi, jolla tarkastellaan olioiden samanlaisuutta
    public boolean equals(Object verrattava) {
        // jos muuttujat sijaitsevat samassa paikassa, ovat ne samat
        if (this == verrattava) {
            return true;
        }

        // jos verrattava olio ei ole Kappale-tyyppinen, oliot eivät ole samat
        if (!(verrattava instanceof Henkilo)) {
            return false;
        }

        // muunnetaan olio Kappale-olioksi
        Henkilo verrattavaHenkilo = (Henkilo) verrattava;

        // jos olioiden oliomuuttujien arvot ovat samat, ovat oliot samat
        if (this.nimi.equals(verrattavaHenkilo.nimi) &&
            this.syntymaPaiva.equals(verrattavaHenkilo.syntymaPaiva)&&
            this.pituus == verrattavaHenkilo.pituus &&
            this.paino == verrattavaHenkilo.paino) {
            return true;
        }

        // muulloin oliot eivät ole samat
        return false;
    }
    /*
    // Tämä on luotu NetBeansin avulla automaattisesti
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
        if (this.pituus != other.pituus) {
            return false;
        }
        if (this.paino != other.paino) {
            return false;
        }
        if (!Objects.equals(this.nimi, other.nimi)) {
            return false;
        }
        if (!Objects.equals(this.syntymaPaiva, other.syntymaPaiva)) {
            return false;
        }
        return true;
    }
    */
}
