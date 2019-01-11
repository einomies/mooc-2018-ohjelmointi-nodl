
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Lehma implements Eleleva, Lypsava {

    /*
Lehmällä on nimi ja utareet. Utareiden tilavuus on satunnainen luku väliltä 15 ja 40,
luokkaa Random voi käyttäää satunnaislukujen arpomiseen, esimerkiksi
int luku = 15 + new Random().nextInt(26);
     */
    private String nimi;
    private double tilavuus;
    private double maidonMaara;
    private DecimalFormat df = new DecimalFormat("#.##");

    private static final String[] NIMIA = new String[]{
        "Anu", "Arpa", "Essi", "Heluna", "Hely",
        "Hento", "Hilke", "Hilsu", "Hymy", "Matti", "Ilme", "Ilo",
        "Jaana", "Jami", "Jatta", "Laku", "Liekki",
        "Mainikki", "Mella", "Mimmi", "Naatti",
        "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
        "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};

    public Lehma() {
        this.nimi = satunnainenNimi();
        this.tilavuus = satunnainenTilavuus();
        this.maidonMaara = 0;
    }

    public Lehma(String nimi) {
        this.nimi = nimi;
        this.tilavuus = satunnainenTilavuus();
        this.maidonMaara = 0;
    }

    public String getNimi() {
        return this.nimi;
    }

    public double getTilavuus() {
        return this.tilavuus;
    }

    public double getMaara() {
        return this.maidonMaara;
    }

    @Override
    public String toString() {
//        return nimi
//                + " "
//                + roundOffTo2DecPlaces(this.maidonMaara)
//                + "/"
//                + roundOffTo2DecPlaces(this.tilavuus);
        return nimi
                + " "
                + Math.ceil(this.maidonMaara)
                + "/"
                + Math.ceil(this.tilavuus);
    }

    private String satunnainenNimi() {
        return NIMIA[new Random().nextInt(NIMIA.length)];
    }

    private double satunnainenTilavuus() {
//        Utareiden tilavuus on satunnainen luku väliltä 15 ja 40
        return 15 + new Random().nextInt(26);
    }

    @Override
    public void eleleTunti() {
//  Suomessa maidontuotannossa käytetyt lehmät tuottavat keskimäärin noin 25-30
//  litraa maitoa päivässä. Simuloidaan tätä tuotantoa tuottamalla noin
//  0.7 - 2 litraa tunnissa.
//        double lisays = new Random().nextDouble() * 1.3 + 0.7;
        double lisays = ThreadLocalRandom.current().nextDouble(0.7, 2.0);
        if (this.maidonMaara + lisays > this.tilavuus) {
            this.maidonMaara = this.tilavuus;
        } else {
            this.maidonMaara = this.maidonMaara + lisays;
        }
    }

    @Override
    public double lypsa() {
        double lypsyMaara = this.maidonMaara;
        this.maidonMaara = 0;
        return lypsyMaara;
    }

    private String roundOffTo2DecPlaces(double val) {
        return String.format("%.2f", val);
    }

}

/*
import java.util.Random;
public class Lehma implements Lypsava, Eleleva {

    private static final String[] NIMIA = new String[]{
        "Anu", "Arpa", "Essi", "Heluna", "Hely",
        "Hento", "Hilke", "Hilsu", "Hymy", "Joni", "Ilme", "Ilo",
        "Jaana", "Jami", "Jatta", "Laku", "Liekki",
        "Mainikki", "Mella", "Mimmi", "Naatti",
        "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
        "Rima", "Soma", "Sylkki", "Valpu", "Virpi"
    };
    private Random random = new Random();
    private String nimi;
    private double tilavuus;
    private double maara;

    public Lehma() {
        this(NIMIA[new Random().nextInt(NIMIA.length)]);
    }

    public Lehma(String nimi) {
        this.nimi = nimi;
        this.tilavuus = 15 + random.nextInt(26);
        this.maara = 0;
    }

    public String getNimi() {
        return nimi;
    }

    public double getTilavuus() {
        return tilavuus;
    }

    public double getMaara() {
        return maara;
    }

    @Override
    public double lypsa() {
        double lypsettyMaara = maara;
        maara = 0;
        return lypsettyMaara;
    }

    @Override
    public void eleleTunti() {
        double kehitettyMaara = 0.7 + random.nextDouble() * 1.3;
        if (maara + kehitettyMaara > tilavuus) {
            maara = tilavuus;
        } else {
            maara += kehitettyMaara;
        }
    }

    @Override
    public String toString() {
        return nimi + " " + Math.ceil(maara) + "/" + Math.ceil(tilavuus);
    }
}
*/