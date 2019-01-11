/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validointi;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author einomies
 */
public class Main02 {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        List<String> rivit = new ArrayList<>();

        try {
            Files.lines(Paths.get("tiedosto.txt")).forEach(rivi -> rivit.add(rivi));
        } catch (Exception e) {
            System.out.println("Virhe: " + e.getMessage());
        }
        
        for (String rivi : rivit) {
            System.out.println(rivi);
        }

        System.out.println("Ohjelma ajettu");
    }

    private static int testi01(Scanner scanner) {
//        int luku = scanner.nextInt();
        int luku = 0;
        while (true) {
            System.out.print("Anna kokonaisluku: ");
            try {
                luku = Integer.parseInt(scanner.nextLine());
                return luku;
            } catch (Exception e) {
                System.out.println("Et syöttänyt kokonaislukua");
            }
        }
    }

    private void testi02() {
        List<String> rivit01 = lue01("tiedosto.txt");
        tulostaLista(rivit01);
    }

    private void testi03() throws Exception {
        List<String> rivit02 = lue02("tiedosto.txt");
    }

    private List<String> lue01(String tiedosto) {
        List<String> rivit = new ArrayList<>();

        try {
            Files.lines(Paths.get("tiedosto.txt")).forEach(rivi -> rivit.add(rivi));
        } catch (Exception e) {
            System.out.println("Virhe: " + e.getMessage());
        }

        return rivit;
    }

    private List<String> lue02(String tiedosto) throws Exception {
        ArrayList<String> rivit = new ArrayList<>();
        Files.lines(Paths.get(tiedosto)).forEach(rivi -> rivit.add(rivi));
        return rivit;
    }

    private void tulostaLista(List<String> rivit) {
        for (String rivi : rivit) {
            System.out.println(rivi);
        }
    }
    
}
