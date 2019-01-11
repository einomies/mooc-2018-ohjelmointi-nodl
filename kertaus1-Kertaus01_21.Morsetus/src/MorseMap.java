
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template tiedosto, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author einomies
 */
public class MorseMap {

    private HashMap<String, String> taulukko;

    final String tiedosto = "./data/morse.txt";

    public MorseMap() throws FileNotFoundException {
        this.taulukko = new HashMap<>();
        try {
            BufferedReader luku = new BufferedReader(new FileReader(tiedosto));
            String rivi = "";

            while ((rivi = luku.readLine()) != null) {
                String[] columns = rivi.split(" ");
                String merkki = columns[0];
                String morsekoodi = columns[1];
                this.taulukko.put(merkki, morsekoodi);
            }

            luku.close();
        } catch (Exception ex) {
            System.out.println("Virhe datan luvussa:");
            System.out.println(ex.getMessage());
        }
    }

    public ArrayList<String> kaannaMorseksiList(String merkkijono) {
        ArrayList<String> lista = new ArrayList<>();
        for (int i = 0; i < merkkijono.length(); i++) {
            lista.add(kaannaMerkki(merkkijono.substring(i, i + 1), "morse"));
        }
        return lista;
    }

    public String kaannaMorseksiString(String merkkijono) {
        String morsekoodi = "";
        for (int i = 0; i < merkkijono.length(); i++) {
            morsekoodi = morsekoodi + kaannaMerkki(merkkijono.substring(i, i + 1), "morse");
        }
        return morsekoodi;
    }

    private String kaannaMerkki(String merkkijono, String valinta) {
        String tulos = "";
        String merkkijonoUpperCase = merkkijono.toUpperCase();
        switch (valinta) {
            case "morse":
                tulos = this.taulukko.get(merkkijonoUpperCase);
                break;
            default:
                break;
        }
        return tulos;
    }

    void tulostakaikki() {
        for (Map.Entry<String, String> entry : this.taulukko.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("key=" + key + " value=" + value);
        }
    }

}
