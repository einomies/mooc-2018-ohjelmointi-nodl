package esimerkki;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class TiedostoonKirjoittaminen {

    public static void main(String[] args) {
        PrintWriter kirjoittaja;
        try {
            kirjoittaja = new PrintWriter("tiedosto.txt");
            kirjoittaja.println("Hei tiedosto!"); // kirjoittaa tiedostoon merkkijonon "Hei tiedosto!" sekä rivinvaihdon
            kirjoittaja.println("Lisää tekstiä");
            kirjoittaja.print("Ja vielä lisää"); // kirjoittaa tiedostoon merkkijonon "ja vielä lisää" ilman rivinvaihtoa
            kirjoittaja.close(); // sulkee tiedoston ja varmistaa että kirjoitettu teksti menee tiedostoon
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
