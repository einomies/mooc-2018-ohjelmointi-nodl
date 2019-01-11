package tulostus;

public class TaulukonTulostaja {

    public void tulostaTyylikkaasti(int[] taulukko) {
        String tulos = "";
        for (int i = 0; i < taulukko.length; i++) {
            if (i < taulukko.length - 1) {
                tulos += taulukko[i] + ", ";
            } else {
                tulos += taulukko[i];
            }
        }
        System.out.println(tulos);
    }
/*
    Vaihtoehtoinen tapa:
    
    public void tulostaTyylikkaasti(int[] taulukko) {
        int i = 0;

        while (i < taulukko.length) {
            System.out.print(taulukko[i]);
            if (i < taulukko.length - 1) {
                System.out.print(", ");
            }
            i++;
        }
        System.out.println();
    }
*/
}
