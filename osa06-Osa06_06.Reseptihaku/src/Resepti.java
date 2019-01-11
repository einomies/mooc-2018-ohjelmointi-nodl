
import java.util.ArrayList;

public class Resepti {
    private String nimi;
    private int kokkausaika;
    private ArrayList<String> raakaAineet;
    
    public Resepti(String nimi, int kokkausaika) {
        this.nimi = nimi;
        this.kokkausaika = kokkausaika;
        this.raakaAineet = new ArrayList<>();
    }

    public Resepti(String nimi) {
        this.nimi = nimi;
        this.kokkausaika = 0;
        this.raakaAineet = new ArrayList<>();
    }

    public void lisaaRaakaAine(String raakaAine) {
        this.getRaakaAineet().add(raakaAine);
    }

    public String tulostaOtsikko() {
        return this.getNimi() +", keittoaika: " +this.getKokkausaika();
    }

    public String toString() {
        String palautettava = this.getNimi() + "\n" + this.getKokkausaika() +" min";
        for (String raakaAine: this.getRaakaAineet()) {
            palautettava += "\n  " + raakaAine;
        }
        return palautettava;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public int getKokkausaika() {
        return kokkausaika;
    }

    public void setKokkausaika(int kokkausaika) {
        this.kokkausaika = kokkausaika;
    }

    public ArrayList<String> getRaakaAineet() {
        return raakaAineet;
    }

    public void setRaakaAineet(ArrayList<String> raakaAineet) {
        this.raakaAineet = raakaAineet;
    }

}

/*
import java.util.ArrayList;

public class Resepti {

    private String nimi;
    private int keittoaika;
    private ArrayList<String> raakaAineet;

    public Resepti(String nimi, int keittoaika) {
        this.nimi = nimi;
        this.keittoaika = keittoaika;
        this.raakaAineet = new ArrayList<>();
    }

    public boolean keittoaikaKorkeintaan(int ylaraja) {
        return this.keittoaika <= ylaraja;
    }

    public boolean nimiSisaltaa(String haettu) {
        return this.nimi.contains(haettu);
    }

    public boolean sisaltaaRaakaAineen(String aine) {
        return this.raakaAineet.contains(aine);
    }

    public void lisaaRaakaAine(String aine) {
        this.raakaAineet.add(aine);
    }

    @Override
    public String toString() {
        return this.nimi + ", keittoaika: " + keittoaika;
    }
}
*/