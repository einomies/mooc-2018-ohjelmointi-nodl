package summa;

public class Summaaja {

    public int laskeTaulukonLukujenSumma(int[] taulukko) {
        int summa = 0;
        for (int i = 0; i < taulukko.length; i++) {
            summa += taulukko[i];
        }
        return summa;
    }
}
