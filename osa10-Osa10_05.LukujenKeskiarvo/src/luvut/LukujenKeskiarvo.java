package luvut;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LukujenKeskiarvo {

    public static void main(String[] args) {
// alustetaan lukija ja lista, johon syotteet luetaan
        Scanner lukija = new Scanner(System.in);
        List<String> syotteet = new ArrayList<>(); // luetaan syotteet

        while (true) {
            String rivi = lukija.nextLine();
            if (rivi.equals("loppu")) {
                break;
            }
            syotteet.add(rivi);
        }

// selvitetään keskiarvo
        double keskiarvo = syotteet.stream()
                .mapToInt(s -> Integer.parseInt(s))
                .average()
                .getAsDouble();

// tulostetaan tilastot
        System.out.println("Lukujen keskiarvo: " + keskiarvo);
    }

}
