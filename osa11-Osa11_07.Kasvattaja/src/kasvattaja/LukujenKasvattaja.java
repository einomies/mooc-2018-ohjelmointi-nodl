package kasvattaja;

public class LukujenKasvattaja {

    public void kasvata(int[] taulukko, int paljonko) {
        for (int i = 0; i < taulukko.length; i++) {
            taulukko[i] = taulukko[i] + paljonko;
        }
    }
}
