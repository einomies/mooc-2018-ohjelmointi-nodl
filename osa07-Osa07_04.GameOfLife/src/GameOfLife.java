
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GameOfLife {

    private Taulukko taulukko;

    public GameOfLife(int leveys, int korkeus) {
        this.taulukko = new Taulukko(leveys, korkeus);
    }

    public void alustaSatunnaisesti() {
        Random satunnaistaja = new Random();

        for (int x = 0; x < taulukko.getLeveys(); x++) {
            for (int y = 0; y < taulukko.getKorkeus(); y++) {
                if (satunnaistaja.nextDouble() < 0.2) {
                    this.taulukko.aseta(x, y, true);
                }
            }
        }
    }

    public void kehity() {
        // säännöt kehittymiselle:

        // 1. jokainen elossa oleva alkio, jolla on alle 2 elossa olevaa naapuria kuolee
        // 2. jokainen elossa oleva alkio, jolla on 2 tai 3 elossa olevaa naapuria pysyy hengissä
        // 3. jokainen elossa oleva alkio, jolla on 4 tai enemmän naapureita kuolee
        // 4. jokainen kuollut alkio, jolla on tasan 3 naapuria muuttuu eläväksi
        // taulukossa arvo 1 kuvaa elävää alkiota, arvo 0 kuollutta alkiota
        Taulukko kopio = new Taulukko(taulukko.getLeveys(), taulukko.getKorkeus());

        for (int x = 0; x < this.taulukko.getLeveys(); x++) {
            for (int y = 0; y < this.taulukko.getKorkeus(); y++) {
                if (this.taulukko.hae(x, y)) {
                    if (elossaOleviaNaapureita(this.taulukko, x, y) < 2) {
                        kopio.aseta(x, y, false);
                    } else if (elossaOleviaNaapureita(this.taulukko, x, y) < 4) {
                        kopio.aseta(x, y, true);
                    } else {
                        kopio.aseta(x, y, false);
                    }
                }
                if (!this.taulukko.hae(x, y)) {
                    if (elossaOleviaNaapureita(this.taulukko, x, y) == 3) {
                        kopio.aseta(x, y, true);
                    }
                }
            }
        }
        /*
        for (int x = 0; x < taulukko.getLeveys(); x++) {
            for (int y = 0; y < taulukko.getKorkeus(); y++) {
                int naapureita = elossaOleviaNaapureita(taulukko, x, y);
                boolean elossa = taulukko.hae(x, y);

                if (elossa && (naapureita == 2 || naapureita == 3)) {
                    kopio.aseta(x, y, true);
                }

                if (!elossa && naapureita == 3) {
                    kopio.aseta(x, y, true);
                }
            }
        }
        */

        this.taulukko = kopio;
    }

    public Taulukko getTaulukko() {
        return this.taulukko;
    }

    public void setTaulukko(Taulukko taulukko) {
        this.taulukko = taulukko;
    }

    public int elossaOleviaNaapureita(Taulukko taulukko, int x, int y) {
        int lkm = 0;

        if (x > taulukko.getLeveys() || y > taulukko.getKorkeus()) {
            return 0;
        }
        if (x < 0 || y < 0) {
            return 0;
        }

//      x-1, y-1
//      x-1, y
//      x-1, y+1
        if (x - 1 >= 0) {
            if (y - 1 >= 0 && taulukko.hae(x - 1, y - 1)) {
                lkm++;
            }
            if (taulukko.hae(x - 1, y)) {
                lkm++;
            }
            if (y + 1 <= taulukko.getKorkeus() && taulukko.hae(x - 1, y + 1)) {
                lkm++;
            }
        }

//      x, y-1
//      x, y+1
        if (y - 1 >= 0 && taulukko.hae(x, y - 1)) {
            lkm++;
        }
        if (y + 1 <= taulukko.getKorkeus() && taulukko.hae(x, y + 1)) {
            lkm++;
        }

//      x+1, y-1
//      x+1, y
//      x+1, y+1
        if (x + 1 <= taulukko.getLeveys()) {
            if (y - 1 >= 0 && taulukko.hae(x + 1, y - 1)) {
                lkm++;
            }
            if (taulukko.hae(x + 1, y)) {
                lkm++;
            }
            if (y + 1 <= taulukko.getKorkeus() && taulukko.hae(x + 1, y + 1)) {
                lkm++;
            }
        }

        return lkm;
    }
    
    /*
    public int elossaOleviaNaapureita(Taulukko taulukko, int x, int y) {
        
        int naapureita = 0;
        for (int xMuunnos = -1; xMuunnos <= 1; xMuunnos++) {
            for (int yMuunnos = -1; yMuunnos <= 1; yMuunnos++) {
                if (xMuunnos == 0 && yMuunnos == 0) {
                    continue;
                }
                if (taulukko.hae(x + xMuunnos, y + yMuunnos)) {
                    naapureita++;
                }
            }
        }
        return naapureita;
    }
    */
}
