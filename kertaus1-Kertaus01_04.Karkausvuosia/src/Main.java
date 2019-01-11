
import java.util.Arrays;
import java.util.Scanner;


public class Main {

/*
    Kirjoita ohjelma, joka kysyy käyttäjältä vuosilukua, ja tulostaa sen jälkeen vuosilukua seuraavat 5 karkausvuotta.
    Karkausvuoden laskemiseen löytyy ohjeita Wikipediasta.
    
    Juliaanisessa kalenterissa karkausvuosi on poikkeuksetta joka neljäs vuosi, vuosiluvun ollessa jaollinen neljällä.
    Gregoriaanisessa kalenterissa tästä on se poikkeus, että täydet vuosisadat (eli sadalla jaolliset vuodet) eivät ole karkausvuosia muulloin kuin joka 400. vuosi (eli vuosi on jaollinen 400:lla).
    Esimerkiksi vuodet 1700, 1800 ja 1900 eivät olleet karkausvuosia, mutta 1600 ja 2000 olivat.
    
    Syötä vuosiluku: 1999
    Karkausvuodet: 2000, 2004, 2008, 2012, 2016
*/
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        int kysyttyVuosi = 0;
        System.out.print("Syötä vuosiluku: ");
        kysyttyVuosi = Integer.parseInt(scanner.nextLine());
        
        int karkausvuodetLkm = 5;
        int[] karkausvuodet = new int[karkausvuodetLkm];

        int lkm = 0;
        int vuosi = kysyttyVuosi;
        
        while (true) {
            if (lkm >= karkausvuodetLkm) {
                break;
            }
            vuosi++;
            if (onKarkausvuosi(vuosi)) {
                karkausvuodet[lkm] = vuosi;
                lkm++;
            }
        }
        
        String karkausvuodetString = "";
        for (int i = 0; i < karkausvuodet.length; i++) {
            if (i == karkausvuodet.length - 1) {
                karkausvuodetString = karkausvuodetString +karkausvuodet[i];
            } else {
                karkausvuodetString = karkausvuodetString +karkausvuodet[i] +", ";
            }
        }
        
//        System.out.println("Karkausvuodet: " +Arrays.toString(karkausvuodet));
        System.out.println("Karkausvuodet: " +karkausvuodetString);
        
//        String[] greeting = {"Hey", "there", "amigo!"};
//        String delimiter = " ";
//        String.join(delimiter, greeting);
    }

    private static boolean onKarkausvuosi(int vuosi) {
        if (vuosi % 4 == 0) {
            if (vuosi % 100 == 0) {
                if (vuosi % 400 == 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        }
        return false;
    }

}
