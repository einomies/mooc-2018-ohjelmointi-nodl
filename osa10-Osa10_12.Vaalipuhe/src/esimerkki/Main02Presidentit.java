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
public class Main02Presidentit {

    public static void main(String[] args) {

        List<Henkilo> presidentit = new ArrayList<>();
        String tiedostoNimi = "./esimerkkidata/presidentit.txt";

        try {
            // luetaan tiedosto "presidentit.txt" riveittäin
            Files.lines(Paths.get(tiedostoNimi))
                    // pilkotaan rivi osiin ";"-merkin kohdalta 
                    .map(rivi -> rivi.split(";"))
                    // poistetaan ne pilkotut rivit, joissa alle 2 osaa
                    // (haluamme että rivillä on aina nimi ja syntymävuosi)
                    .filter(palat -> palat.length >= 2)
                    // luodaan palojen perusteella henkilöitä
                    .map(palat -> new Henkilo(palat[0], Integer.parseInt(palat[1].trim())))
                    // ja lisätään henkilöt lopulta listalle
                    .forEach(henkilo -> presidentit.add(henkilo));
        } catch (Exception e) {
            System.out.println("Virhe: " + e.getMessage());
        }

        System.out.println("--------------------------------------------------");
        System.out.println("tulos:");
        presidentit.stream().forEach(r -> System.out.println(r));
    }

}
