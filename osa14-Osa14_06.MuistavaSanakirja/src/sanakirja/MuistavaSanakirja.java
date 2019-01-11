package sanakirja;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class MuistavaSanakirja {

    private ArrayList<Sanapari> sanaparit;
    private String tiedostoNimi;

    public MuistavaSanakirja() {
        this.sanaparit = new ArrayList<>();
    }

    public MuistavaSanakirja(String tiedosto) {
        this.sanaparit = new ArrayList<>();
        this.tiedostoNimi = tiedosto;
    }

    public boolean lataa() {
        try {
//            BufferedReader brInputStream = new BufferedReader(new InputStreamReader(new FileInputStream(tiedostoNimi), "Cp1252"));
//            while (brInputStream.readLine() != null) {
//                String rivi = brInputStream.readLine();
//                String[] osat = rivi.split(":");
//                this.sanaparit.add(new Sanapari(osat[0], osat[1]));
//            }
            Scanner scanner = new Scanner(new File(this.tiedostoNimi));
            while (scanner.hasNextLine()) {
                String rivi = scanner.nextLine();
                String[] osat = rivi.split(":");
                this.sanaparit.add(new Sanapari(osat[0], osat[1]));
            }
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean tallenna() {
        try {
            FileWriter fw = new FileWriter(this.tiedostoNimi, false);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Sanapari sanapari : this.sanaparit) {
                bw.write(sanapari.getSana() + ":" + sanapari.getKaannos() + "\n");
            }
            bw.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void lisaa(String sana, String kaannos) {
        boolean saaLisata = true;
        for (Sanapari sp : this.sanaparit) {
            if (sp.getSana().equals(sana) || sp.getKaannos().equals(sana)) {
                saaLisata = false;
            }
            if (sp.getSana().equals(kaannos) || sp.getKaannos().equals(kaannos)) {
                saaLisata = false;
            }
        }
        if (saaLisata) {
            Sanapari sanapari = new Sanapari(sana, kaannos);
            this.sanaparit.add(sanapari);
        }
    }

    public String kaanna(String sana) {
        for (Sanapari sp : this.sanaparit) {
            if (sp.getSana().equals(sana)) {
                return sp.getKaannos();
            } else if (sp.getKaannos().equals(sana)) {
                return sp.getSana();
            }
        }
        return null;
    }

    public void poista(String sana) {
        Iterator<Sanapari> iterator = this.sanaparit.iterator();
        while (iterator.hasNext()) {
            Sanapari sp = iterator.next();
            if (sp.getSana().equals(sana) || sp.getKaannos().equals(sana)) {
                iterator.remove();
            }
        }
    }

    public void tulostaKaikki() {
        for (Sanapari sanapari : sanaparit) {
            System.out.println(sanapari);
        }
    }

}

/*
package sanakirja;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class MuistavaSanakirja {

    private Map<String, String> sanat;
    private String tiedosto;

    public MuistavaSanakirja(String tiedosto) {
        this();
        this.tiedosto = tiedosto;
    }

    public MuistavaSanakirja() {
        this.sanat = new HashMap<>();
    }

    public boolean lataa() {
        try {
            Scanner lukija = new Scanner(new File(tiedosto));
            lueTiedostoSanakirjaan(lukija);
            lukija.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean tallenna() {
        try {
            PrintWriter kirjoittaja = new PrintWriter(new File(tiedosto));
            tallennaSanat(kirjoittaja);
            kirjoittaja.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public void lisaa(String sana, String kaannos) {
        if (sanat.containsKey(sana)) {
            return;
        }
        sanat.put(sana, kaannos);
        sanat.put(kaannos, sana);
    }

    public String kaanna(String sana) {
        return sanat.get(sana);
    }

    public void poista(String sana) {
        String kaannos = kaanna(sana);
        sanat.remove(sana);
        sanat.remove(kaannos);
    }

    private void lueTiedostoSanakirjaan(Scanner lukija) {
        while (lukija.hasNextLine()) {
            String rivi = lukija.nextLine();
            String[] osat = rivi.split(":");
            sanat.put(osat[0], osat[1]);
            sanat.put(osat[1], osat[0]);
        }
    }

    private void tallennaSanat(PrintWriter kirjoittaja) throws IOException {
        List<String> joTiedostossa = new ArrayList<>();
        Iterator<String> sanaIteraattori = sanat.keySet().iterator();
        while (sanaIteraattori.hasNext()) {
            String sana = sanaIteraattori.next();
            String kaannos = sanat.get(sana);
            if (!joTiedostossa.contains(sana)) {
                String pari = sana + ":" + sanat.get(sana);
                kirjoittaja.println(pari);
                joTiedostossa.add(kaannos);
            }
        }
    }
}
*/