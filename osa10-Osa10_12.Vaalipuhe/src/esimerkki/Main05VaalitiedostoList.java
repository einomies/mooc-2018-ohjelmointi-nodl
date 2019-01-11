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
import java.util.List;
import java.util.stream.Collectors;
import vaalit.Tekstimalli;

/**
 *
 * @author einomies
 */
public class Main05VaalitiedostoList {

    public static void main(String[] args) {

        List<String> kommentit = new ArrayList<>();
        String tiedostoLukuNimi = "./esimerkkidata/vaalidata01.txt";

        try {
            Files.lines(Paths.get(tiedostoLukuNimi))
                    .map(rivi -> rivi.split(";"))
                    .filter(palat -> palat.length >= 2)
                    .map(palat -> palat[1].trim())
                    .forEach(kommentti -> kommentit.add(kommentti));
        } catch (Exception e) {
            System.out.println("Virhe: " + e.getMessage());
        }

//        System.out.println("--------------------------------------------------");
//        System.out.println("tulos:");
//        kommentit.stream().forEach(r -> System.out.println(r));
        String tiedostoKirjoitusNimi = "./esimerkkidata/vaalidata01tulos.txt";

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(tiedostoKirjoitusNimi));
            kommentit.stream().forEach(r -> {
                try {
                    writer.write(r + "\n");
                    writer.flush();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                } catch (Exception e) {
                }
            });
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (Exception e) {
            System.out.println("Virhe: " + e.getMessage());
        }
    }

}
