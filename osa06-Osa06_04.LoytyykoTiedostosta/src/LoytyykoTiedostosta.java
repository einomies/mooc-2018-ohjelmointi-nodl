
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LoytyykoTiedostosta {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        System.out.println("Minkä niminen tiedosto luetaan? ");
        String tiedosto = lukija.nextLine();

        System.out.println("Mitä etsitään?");
        String etsittava = lukija.nextLine();

        boolean kaikkiOk = true;

        ArrayList<String> lista = new ArrayList<>();
        // toteuta tiedoston lukeminen tässä.

        // luodaan lukija tiedoston lukemista varten
        try (Scanner tiedostolukija = new Scanner(new File(tiedosto))) {

            // luetaan kaikki tiedoston rivit
            while (tiedostolukija.hasNextLine()) {
                lista.add(tiedostolukija.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Tiedoston " + tiedosto + " lukeminen epäonnistui.");
            System.out.println("Virhe: " + e.getMessage());
            kaikkiOk = false;
        }

        if (kaikkiOk) {
            if (lista.contains(etsittava)) {
                System.out.println("Löytyi!");
            } else {
                System.out.println("Ei löytynyt.");
            }
        }
    }
}

/*
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LoytyykoTiedostosta {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        System.out.println("Minkä niminen tiedosto luetaan? ");
        String tiedosto = lukija.nextLine();

        System.out.println("Mitä etsitään?");
        String etsittava = lukija.nextLine();

        int riveja = 0;

        try (Scanner tiedostonLukija = new Scanner(new File(tiedosto))) {
            while (tiedostonLukija.hasNextLine()) {
                String rivi = tiedostonLukija.nextLine();
                if (!rivi.contains(etsittava)) {
                    continue;
                }
                riveja++;
            }
        } catch (IOException ex) {
            System.out.println("Tiedoston " + tiedosto + " lukeminen epäonnistui.");
        }

        if (riveja == 0) {
            System.out.println("Ei löytynyt.");
        } else {
            System.out.println("Löytyi!");
        }
    }
}
*/