package kopiokaannin;

// HUOM! Älä lisää luokalle Taulukot oliomuuttujia
public class Taulukot {

    public int[] kopioi(int[] alkuperainen) {
        int[] taulukko = new int[alkuperainen.length];
        for (int i = 0; i < alkuperainen.length; i++) {
            taulukko[i] = alkuperainen[i];
        }
        return taulukko;
    }

    public int[] kaanna(int[] taulukko) {
        int[] kaannetty = new int[taulukko.length];
        int k = 0;
        for (int i = taulukko.length - 1; i >= 0; i--) {
            kaannetty[k] = taulukko[i];
            k++;
        }
        return kaannetty;
    }
    /*
    Vaihtoehto:
    public int[] kaanna(int[] taulukko) {
        int[] kaannetty = new int[taulukko.length];
        for (int i = 0; i < kaannetty.length; i++) {
            kaannetty[i] = taulukko[taulukko.length - 1 - i];
        }
        return kaannetty;
    }
     */
}
