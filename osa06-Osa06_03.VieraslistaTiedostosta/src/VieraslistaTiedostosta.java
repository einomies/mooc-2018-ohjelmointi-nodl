
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class VieraslistaTiedostosta {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        boolean kaikkiOk = true;

        System.out.println("Minkä niminen tiedosto luetaan? ");
        String tiedosto = lukija.nextLine();

        ArrayList<String> lista = new ArrayList<>();
        // toteuta tiedoston lukeminen tässä.
        System.out.println("");

        // luodaan lukija tiedoston lukemista varten
        try (Scanner tiedostolukija = new Scanner(new File(tiedosto))) {

            // luetaan kaikki tiedoston rivit
            while (tiedostolukija.hasNextLine()) {
                lista.add(tiedostolukija.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Virhe: " + e.getMessage());
            kaikkiOk = false;
        }

        if (kaikkiOk) {
            System.out.println("Syötä nimiä, tyhjä rivi lopettaa.");

            while (true) {
                String nimi = lukija.nextLine();
                if (nimi.isEmpty()) {
                    break;
                }
                if (lista.contains(nimi)) {
                    System.out.println("Nimi on listalla.");
                } else {
                    System.out.println("Nimi ei ole listalla.");
                }
            }

            System.out.println("Kiitos!");
        }
    }

}
