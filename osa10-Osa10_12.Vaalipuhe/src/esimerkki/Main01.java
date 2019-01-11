/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esimerkki;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author einomies
 */
public class Main01 {

    public static void main(String[] args) {

        List<String> rivit = new ArrayList<>();
        
        String tiedostoNimi = "./esimerkkidata/tiedosto.txt";

        try {
            Files.lines(Paths.get(tiedostoNimi)).forEach(rivi -> rivit.add(rivi));
        } catch (Exception e) {
            System.out.println("Virhe: " + e.getMessage());
        }

        System.out.println("--------------------------------------------------");
        System.out.println("rivit (alkuperäinen):");
        
        rivit.stream().forEach(r -> System.out.println(r));
        
        List<String> tulos = 
                rivit.stream()
//                .filter(rivi -> !rivi.isEmpty())
                .filter(rivi -> rivi.length() > 0)
                .map(rivi -> rivi.replace("\t", " "))
                .map(rivi -> rivi.replace("  ", " "))
//                .filter(rivi -> rivi.startsWith("1"))
                .filter(rivi -> Character.isDigit(rivi.charAt(0)))
                .collect(Collectors.toList());
        
        System.out.println("--------------------------------------------------");
        System.out.println("tulos:");
        tulos.stream().forEach(r -> System.out.println(r));
    }

}
