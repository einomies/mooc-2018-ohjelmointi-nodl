/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esimerkki;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import vaalit.Tekstimalli;

/**
 *
 * @author einomies
 */
public class Main06VaalitiedostoTekstimalli {

    public static void main(String[] args) {

        String tiedostoLukuNimi = "./esimerkkidata/vaalidata01.txt";
        Tekstimalli tekstimalli = new Tekstimalli();

        try {
            Files.lines(Paths.get(tiedostoLukuNimi))
                    .map(rivi -> rivi.split(";"))
                    .filter(palat -> palat.length >= 2)
                    .map(palat -> palat[1].trim())
                    .forEach(rivi -> tekstimalli.lisaaAineisto(rivi));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Virhe: " + e.getMessage());
        }
//        System.out.println("--------------------------------------------------");
//        System.out.println("tulos:");
//        System.out.println(tekstimalli);
//        System.out.println("--------------------------------------------------");
//        System.out.println("uniikit sanat:");
//        System.out.println(tekstimalli.sanat());

        List<String> sanat = tekstimalli.sanat();
        Collections.shuffle(sanat);
        System.out.println("eka sana (shuffle): " +sanat.get(0));
    }

}
