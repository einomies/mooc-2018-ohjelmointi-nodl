
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Main {
    
    /*
    Kirjoita ohjelma, joka kysyy käyttäjältä merkkijonoa, ja tulostaa sen jälkeen
    merkkijonon morsekoodina.
    
    Morseaakkoset löytyvät wikipediasta: https://fi.wikipedia.org/wiki/S%C3%A4hk%C3%B6tys

    Sana: hei
    ....
    .
    ..

    Sana: hah
    ....
    .-
    ....

    */

    public static void main(String[] args) throws FileNotFoundException {
        MorseMap morseMap = new MorseMap();
        morseMap.tulostakaikki();
        
        System.out.println();
        String sana = "Kämäräinen";

        String morse = morseMap.kaannaMorseksiString(sana);
        System.out.println();
        System.out.println("sana: " +sana);
        System.out.println("morse: " +morse);
        
        ArrayList<String> merkit = morseMap.kaannaMorseksiList(sana);
        System.out.println();
        System.out.println("sana: " +sana);
        tulostaLista(merkit);
    }

    private static void tulostaLista(ArrayList<String> merkit) {
        for (String merkki : merkit) {
            System.out.println(merkki);
        }
    }

}
