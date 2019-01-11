
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Eriytymismalli {

    private Taulukko taulukko;

    private double prosAlueestaKaytossa;
    private int tyytyvaisyysraja;
    private int ryhmienLukumaara;

    private boolean kaynnissa;

    public Eriytymismalli(int leveys, int korkeus, int tyytyvaisyysraja, int ryhmienLukumaara, double prosAlueestaKaytossa) {
        this.taulukko = new Taulukko(leveys, korkeus);

        this.tyytyvaisyysraja = tyytyvaisyysraja;
        this.ryhmienLukumaara = ryhmienLukumaara;
        this.prosAlueestaKaytossa = prosAlueestaKaytossa;

        this.kaynnissa = false;
    }

    public void kaynnista() {
        this.kaynnissa = true;
    }

    public void sammuta() {
        this.kaynnissa = false;
    }

    public boolean onKaynnissa() {
        return this.kaynnissa;
    }

    public void asetaRyhmienLukumaara(int ryhmia) {
        this.ryhmienLukumaara = ryhmia;
    }

    public void asetaProsAlueestaKaytossa(double prosAlueestaKaytossa) {
        this.prosAlueestaKaytossa = prosAlueestaKaytossa;
    }

    public void asetaTyytyvaisyysRaja(int tyytyvaisyysraja) {
        this.tyytyvaisyysraja = tyytyvaisyysraja;

    }

    public void alusta() {
        tyhjenna();
        arvoAlkuarvot();
    }

    public void tyhjenna() {
        for (int x = 0; x < taulukko.getLeveys(); x++) {
            for (int y = 0; y < taulukko.getKorkeus(); y++) {
                taulukko.aseta(x, y, 0);
            }
        }
    }

    public void arvoAlkuarvot() {
        Random arpoja = new Random();

        for (int x = 0; x < taulukko.getLeveys(); x++) {
            for (int y = 0; y < taulukko.getKorkeus(); y++) {
                // Random-luokan metodi nextDouble palauttaa satunnaisen luvun
                // nollan ja yhden välillä
                double satunnainenLukuNollanJaYhdenValilla = arpoja.nextDouble();
                // jos 100*arvo on pienempi kuin prosAlueestaKaytossa, paikkaan
                // asetetaan arvo
                if (100 * satunnainenLukuNollanJaYhdenValilla < prosAlueestaKaytossa) {
                    int ryhma = 1 + arpoja.nextInt(ryhmienLukumaara);
                    this.taulukko.aseta(x, y, ryhma);
                }
            }
        }
    }

    public Taulukko annaData() {
        return this.taulukko;
    }

    public ArrayList<Piste> tyhjatPaikat() {
        ArrayList<Piste> tyhjat = new ArrayList<>();
        // Luo täällä lista, missä on kaikki tyhjät paikat piste-olioina.
        // Tyhjissä paikoissa on arvo 0
        for (int x = 0; x < taulukko.getLeveys(); x++) {
            for (int y = 0; y < taulukko.getKorkeus(); y++) {
                if (taulukko.hae(x, y) == 0) {
                    tyhjat.add(new Piste(x, y));
                }
            }
        }
        return tyhjat;
    }

    public void paivita() {
        ArrayList<Piste> tyytymattomat = haeTyytymattomat();

        if (tyytymattomat.isEmpty()) {
            return;
        }

        Collections.shuffle(tyytymattomat);

        while (!tyytymattomat.isEmpty()) {
            Piste tyytymaton = tyytymattomat.remove(0);

            ArrayList<Piste> tyhjat = tyhjatPaikat();
            Collections.shuffle(tyhjat);

            Piste tyhja = tyhjat.get(0);

            int tyytymattomanRyhma = this.taulukko.hae(tyytymaton.getX(), tyytymaton.getY());

            this.taulukko.aseta(tyhja.getX(), tyhja.getY(), tyytymattomanRyhma);
            this.taulukko.aseta(tyytymaton.getX(), tyytymaton.getY(), 0);
        }
    }

    public ArrayList<Piste> haeTyytymattomat() {
        ArrayList<Piste> tyytymattomat = new ArrayList<>();
        // Etsi täällä tyytymättömät
        for (int x = 0; x < this.taulukko.getLeveys(); x++) {
            for (int y = 0; y < this.taulukko.getKorkeus(); y++) {
                if (this.taulukko.hae(x, y) > 0) {
                    if (!onTyytyvainen(x, y)) {
                        tyytymattomat.add(new Piste(x, y));
                    }
                }
            }
        }
        return tyytymattomat;
    }

    private boolean onTyytyvainen(int x, int y) {
        int arvo = this.taulukko.hae(x, y);
        int samatLkm = 0;
        
        for (int xMuunnos = -1; xMuunnos <= 1; xMuunnos++) {
            for (int yMuunnos = -1; yMuunnos <= 1; yMuunnos++) {
                if (x + xMuunnos < 0 || x + xMuunnos > this.taulukko.getLeveys()) {
                    continue;
                }
                if (y + yMuunnos < 0 || y + yMuunnos > this.taulukko.getKorkeus()) {
                    continue;
                }
                if (xMuunnos == 0 && yMuunnos == 0) {
                    continue;
                }
                if (this.taulukko.hae(x+xMuunnos, y+yMuunnos) == 0) {
                    continue;
                }
                if (this.taulukko.hae(x+xMuunnos, y+yMuunnos) == arvo) {
                    samatLkm++;
                }
                if (samatLkm >= this.tyytyvaisyysraja) {
                    return true;
                }
            }
        }
        return false;
    }

}
