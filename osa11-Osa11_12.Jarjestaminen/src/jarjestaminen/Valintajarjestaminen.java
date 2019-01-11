package jarjestaminen;

import java.util.Arrays;

public class Valintajarjestaminen {

    public int pienin(int[] taulukko) {
        int min = taulukko[0];
        for (int i = 0; i < taulukko.length; i++) {
            if (taulukko[i] < min) {
                min = taulukko[i];
            }
        }
        return min;
    }

    public int pienimmanIndeksi(int[] luvut) {
        int minInd = 0;
        for (int i = 0; i < luvut.length; i++) {
            if (luvut[i] < luvut[minInd]) {
                minInd = i;
            }
        }
        return minInd;
    }

    public int pienimmanIndeksiAlkaen(int[] taulukko, int aloitusIndeksi) {
        int ind = aloitusIndeksi;
        for (int i = aloitusIndeksi; i < taulukko.length; i++) {
            if (taulukko[i] < taulukko[ind]) {
                ind = i;
            }
        }
        return ind;
    }

    public void vaihda(int[] taulukko, int indeksi1, int indeksi2) {
        int apu = taulukko[indeksi1];
        taulukko[indeksi1] = taulukko[indeksi2];
        taulukko[indeksi2] = apu;
    }

    public void jarjesta(int[] taulukko) {
//        System.out.println(Arrays.toString(taulukko));
        for (int i = 0; i < taulukko.length; i++) {
            vaihda(taulukko, i, pienimmanIndeksiAlkaen(taulukko, i));
//            System.out.println(Arrays.toString(taulukko));
        }
    }

}
