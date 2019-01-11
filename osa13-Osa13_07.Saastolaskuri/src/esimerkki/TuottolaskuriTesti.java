/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esimerkki;

/**
 *
 * @author einomies
 */
public class TuottolaskuriTesti {

    public static void main(String[] args) {

        double korkoPros = 10;
        int vuodet = 30;
        double kkSijoitus = 25;
        double alkuPaaoma = 0;
        
        double sijoitettuPaaoma = 0;
        double tuottoYht = 0;
        double loppuPaaoma = 0;

        System.out.println("alkupääoma: " + alkuPaaoma);
        System.out.println("sijoitusaika vuosissa: " + vuodet);
        System.out.println("sijoitusaika kuukausissa: " + vuodet * 12);
        System.out.println("sijoitus per kk: " + kkSijoitus);
        System.out.println("korkoprosentti: " + korkoPros);

        sijoitettuPaaoma = alkuPaaoma + vuodet * 12 * kkSijoitus;
        System.out.println("sijoitettu pääoma koko ajalta: " + sijoitettuPaaoma);

        double korkoaKorolle = Math.pow((1 + korkoPros / 100), vuodet);
        System.out.println("korkoa korolle -kerroin: " + korkoaKorolle);

        loppuPaaoma = (alkuPaaoma + vuodet * 12 * kkSijoitus) * (1 + korkoPros / 100);
        System.out.println("pääoma sijoitusajan lopussa: " + loppuPaaoma);

        tuottoYht = loppuPaaoma - sijoitettuPaaoma;
        System.out.println("tuotto koko ajalta yhteensä: " + tuottoYht);

        System.out.println();
        System.out.println("Vuositilastot:");
        tulostaViiva();
        tulostaVuosittain(alkuPaaoma, korkoPros, vuodet, kkSijoitus);
    }

    private static void tulostaVuosittain(double alkuPaaoma, double korkoPros, int vuodet, double kkSijoitus) {
        double paaomaVuodenAlussa = 0;
        double paaomaVuodenLopussa = 0;
        double edPaaomaVuodenLopussa = 0;
        double vuodenSijoitukset = 0;
        double vuodenTuotto = 0;
        for (int i = 1; i <= vuodet; i++) {
            if (i == 1) {
                paaomaVuodenAlussa = alkuPaaoma;
            } else {
                paaomaVuodenAlussa = edPaaomaVuodenLopussa;
            }
            vuodenSijoitukset = 12 * kkSijoitus;
            paaomaVuodenLopussa = (paaomaVuodenAlussa + vuodenSijoitukset) * (1 + korkoPros / 100);
            vuodenTuotto = (korkoPros / 100) * (paaomaVuodenAlussa + vuodenSijoitukset);

            System.out.println("vuosi " + i
                    + "\n" + "alkupääoma " + paaomaVuodenAlussa
                    + "\n" + "sijoitus " + vuodenSijoitukset
                    + "\n" + "tuotto " + vuodenTuotto
                    + "\n" + "loppupääoma " + paaomaVuodenLopussa);
            
            tulostaViiva();

            edPaaomaVuodenLopussa = paaomaVuodenLopussa;
        }
        // System.out.println("Math.pow((1 + korkoPros / 100), vuodet): " + Math.pow((1
        // + korkoPros / 100), vuodet));
    }

    private static void tulostaViiva() {
        System.out.println("-----------------------------------------");
    }

}
