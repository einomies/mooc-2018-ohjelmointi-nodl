package tahdet;

public class Tulostin {

    public void tulostaTaulukkoTahtina(int[] taulukko) {
        String merkki = "*";
        for (int i = 0; i < taulukko.length; i++) {
            String rivi = "";
            for (int j = 0; j < taulukko[i]; j++) {
                rivi += merkki;
            }
            System.out.println(rivi);
        }
    }
}
/*
package tahdet;

public class Tulostin {

    public void tulostaTaulukkoTahtina(int[] taulukko) {

        int i = 0;

        while (i < taulukko.length) {
            int tahtia = taulukko[i];

            while (tahtia > 0) {
                System.out.print("*");
                tahtia--;
            }
            System.out.println();
            i++;
        }
    }

}
*/