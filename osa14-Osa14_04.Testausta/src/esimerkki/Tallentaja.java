package esimerkki;

import java.io.PrintWriter;

public class Tallentaja {

    public void kirjoitaTiedostoon(String tiedostonNimi, String teksti) throws Exception {
        PrintWriter kirjoittaja = new PrintWriter(tiedostonNimi);
        kirjoittaja.println(teksti);
        kirjoittaja.close();
    }

}
