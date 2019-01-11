/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hiekkaranta;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author einomies
 */
public class Simulaatio {

    private int leveys;
    private int korkeus;
    private Tyyppi[][] taulukko;

    public Simulaatio(int leveys, int korkeus) {
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.taulukko = new Tyyppi[leveys][korkeus];
        for (int i = 0; i < this.taulukko.length; i++) {
            for (int j = 0; j < this.taulukko[0].length; j++) {
                this.taulukko[i][j] = Tyyppi.TYHJA;
            }
        }
        /*
		 * Konstruktori public Simulaatio(int leveys, int korkeus) luo annetun levyisen
		 * ja korkuisen simulaation. Jokaisen kohdan arvon tulee olla aluksi
		 * Tyyppi.TYHJA.
         */
    }

    public void lisaa(int x, int y, Tyyppi tyyppi) {
        if (x >= 0 && x < this.leveys && y >= 0 && y < this.korkeus) {
            this.taulukko[x][y] = tyyppi;
        }
        /*
		 * Metodi public void lisaa(int x, int y, Tyyppi tyyppi) asettaa annettuun
		 * kohtaan annetun tyyppisen elementin. Tyyppi on joko Tyyppi.TYHJA,
		 * Tyyppi.METALLI, Tyyppi.HIEKKA tai Tyyppi.VESI.
         */
    }

    public Tyyppi sisalto(int x, int y) {
        if (x < 0 || x >= this.leveys || y < 0 || y >= this.korkeus) {
            return Tyyppi.METALLI;
        }
        if (this.taulukko[x][y] == null) {
            return Tyyppi.TYHJA;
        }
        return this.taulukko[x][y];
        /*
		 * Metodi public Tyyppi sisalto(int x, int y) palauttaa annetussa kohdassa
		 * olevan sisällön. Vastaus on joko Tyyppi.TYHJA, Tyyppi.METALLI, Tyyppi.HIEKKA
		 * tai Tyyppi.VESI. Jos kohtaan ei ole lisätty mitään arvoa, tyyppi on
		 * Tyyppi.TYHJA. Jos käyttäjä kysyy tietoa alueen ulkopuolelta, palauta
		 * Tyyppi.METALLI.
         */
    }

    public void paivita() {
//        Metodi päivittää simulaatiota yhden askeleen.
        for (int y = this.korkeus - 1; y >= 0; y--) {
            for (int x = 0; x < this.leveys; x++) {
                Tyyppi tyyppi = this.taulukko[x][y];
                int[] siirtyma = laskeSiirtyma(x, y, tyyppi);
                if (siirtyma[0] != 0 || siirtyma[1] != 0) {

                    if (tyyppi == Tyyppi.HIEKKA) {
                        if (this.sisalto(x + siirtyma[0], y + siirtyma[1]) == Tyyppi.VESI) {
                            this.lisaa(x, y, Tyyppi.VESI);
                        } else {
                            this.lisaa(x, y, Tyyppi.TYHJA);
                        }
                        this.lisaa(x + siirtyma[0], y + siirtyma[1], tyyppi);
                    } else {
                        this.lisaa(x + siirtyma[0], y + siirtyma[1], tyyppi);
                        this.lisaa(x, y, Tyyppi.TYHJA);
                    }

                }
            }
        }
    }

    private int[] laskeSiirtyma(int x, int y, Tyyppi tyyppi) {
        // siirtyma[0] = X-koordinaatin siirtymä
        // siirtyma[1] = Y-koordinaatin siirtymä
        int[] siirtyma = new int[2];
        int siirtymaX = 0, siirtymaY = 0;
        Tyyppi[] allaOlevat = new Tyyppi[3];
        ArrayList<Integer> tyhjat = new ArrayList<>();
        int tyhjatLkm = 0;

        if (tyyppi == Tyyppi.HIEKKA) {
            if (y + 1 < this.korkeus) {
                for (int i = -1; i < 2; i++) {
                    allaOlevat[i + 1] = this.sisalto(x + i, y + 1);
                    if (this.sisalto(x + i, y + 1) == Tyyppi.TYHJA
                            || this.sisalto(x + i, y + 1) == Tyyppi.VESI) {
                        tyhjat.add(i);
                        tyhjatLkm++;
                    }
                }
                switch (tyhjatLkm) {
                    case 0:
                        siirtymaY = 0;
                        break;
                    case 1:
                        siirtymaX = tyhjat.get(0);
                        siirtymaY = 1;
                        break;
                    case 2:
                        siirtymaX = arvoSiirtyma(allaOlevat, tyhjat, tyyppi);
                        siirtymaY = 1;
                        break;
                    case 3:
                        siirtymaX = arvoSiirtyma(allaOlevat, tyhjat, tyyppi);
                        siirtymaY = 1;
                        break;
                    default:
                        break;
                }
            }
        } else if (tyyppi == Tyyppi.VESI) {
            if (y + 1 < this.korkeus) {
                for (int i = -1; i < 2; i++) {
                    allaOlevat[i + 1] = this.sisalto(x + i, y + 1);
                    if (this.sisalto(x + i, y + 1) == Tyyppi.TYHJA) {
                        tyhjat.add(i);
                        tyhjatLkm++;
                    }
                }
                switch (tyhjatLkm) {
                    case 0:
                        siirtymaY = 0;
                        break;
                    case 1:
                        siirtymaX = tyhjat.get(0);
                        siirtymaY = 1;
                        break;
                    case 2:
                        siirtymaX = arvoSiirtyma(allaOlevat, tyhjat, tyyppi);
                        siirtymaY = 1;
                        break;
                    case 3:
                        siirtymaX = arvoSiirtyma(allaOlevat, tyhjat, tyyppi);
                        siirtymaY = 1;
                        break;
                    default:
                        break;
                }
                if (siirtymaY == 0) {
                    // Jos alemmalta riviltä ei löytynyt tyhjää, etsitään samalta riviltä lähin
                    // tyhjä piste
                    if (this.sisalto(x - 1, y) == Tyyppi.TYHJA) {
                        siirtymaX = -1;
                    }
                    if (this.sisalto(x + 1, y) == Tyyppi.TYHJA) {
                        siirtymaX = 1;
                    }
                }
            }
        }

        siirtyma[0] = siirtymaX;
        siirtyma[1] = siirtymaY;
        return siirtyma;
    }

    private int arvoLuku(int min, int max) {
        return min + new Random().nextInt(max - min + 1);
    }

    private int arvoSiirtyma(Tyyppi[] allaOlevat, ArrayList<Integer> tyhjat, Tyyppi tyyppi) {
        int indeksi = new Random().nextInt(tyhjat.size());
        return tyhjat.get(indeksi);
    }

    public int getLeveys() {
        return this.leveys;
    }

    public void setLeveys(int leveys) {
        this.leveys = leveys;
    }

    public int getKorkeus() {
        return this.korkeus;
    }

    public void setKorkeus(int korkeus) {
        this.korkeus = korkeus;
    }

    public Tyyppi[][] getTaulukko() {
        return taulukko;
    }

    public void setTaulukko(Tyyppi[][] taulukko) {
        this.taulukko = taulukko;
    }

}
