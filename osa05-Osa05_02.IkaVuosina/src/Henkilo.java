import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class Henkilo {

    private String nimi;
    private Paivays syntymaPaiva;
    private int paino = 0;
    private int pituus = 0;

    public Henkilo(String nimi, int paiva, int kuukausi, int vuosi) {
        this.nimi = nimi;
        this.syntymaPaiva = new Paivays(paiva, kuukausi, vuosi);
        this.paino = 0;
        this.pituus = 0;
    }

    // muita konstruktoreja ja metodeja
    public String getNimi() {
        return this.nimi;
    }

    public int ikaVuosina() {
        LocalDate nyt = LocalDate.now();
        int vuosiNyt = nyt.getYear();
        int kuukausiNyt = nyt.getMonthValue();
        int paivaNyt = nyt.getDayOfMonth();
        
        LocalDate syntymaPvm = LocalDate.of(
                this.syntymaPaiva.getVuosi(), 
                this.syntymaPaiva.getKuukausi(), 
                this.syntymaPaiva.getPaiva());
        
        long paivat = ChronoUnit.DAYS.between(syntymaPvm, nyt);
        int paivatLkm = Long.valueOf(paivat).intValue();

        return paivatLkm / 360;
    }
    /*
    Vaihthtoinen tapa:
    public int ikaVuosina() {
        LocalDate nyt = LocalDate.now();
        int vuosiNyt = nyt.getYear();
        int kuukausiNyt = nyt.getMonthValue();
        int paivaNyt = nyt.getDayOfMonth();

        int paiviaNyt = vuosiNyt * 12 * 30 + kuukausiNyt * 30 + paivaNyt;
        int paiviaSyntyma = this.syntymaPaiva.getVuosi() * 12 * 30 + this.syntymaPaiva.getKuukausi() * 30 + this.syntymaPaiva.getPaiva();
        int paiviaSyntymasta = paiviaNyt - paiviaSyntyma;

        return paiviaSyntymasta / 360;
    }
    */

    public void setPituus(int uusiPituus) {
        this.pituus = uusiPituus;
    }

    public void setPaino(int uusiPaino) {
        this.paino = uusiPaino;
    }

    public double painoIndeksi() {
        double pituusPerSata = this.pituus / 100.0;
        return this.paino / (pituusPerSata * pituusPerSata);
    }

    @Override
    public String toString() {
        return this.nimi + ", syntynyt " + this.syntymaPaiva;
    }
}
