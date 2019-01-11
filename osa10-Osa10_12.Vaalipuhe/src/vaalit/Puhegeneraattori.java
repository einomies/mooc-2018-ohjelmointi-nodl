package vaalit;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class Puhegeneraattori {

    private Tekstimalli tekstimalli;

    public Puhegeneraattori() {
        this.tekstimalli = new Tekstimalli();
    }

    public void lue(String tiedosto) {
        try {
            Files.lines(Paths.get(tiedosto))
                    .map(rivi -> rivi.split(";"))
                    .filter(palat -> palat.length >= 2)
                    .map(palat -> palat[1].trim())
                    .forEach(rivi -> this.tekstimalli.lisaaAineisto(rivi));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Virhe: " + e.getMessage());
        }
    }

    public String tuotaPuhetta(int sanojaEnintaan) {
        if (sanojaEnintaan <= 0) {
            return null;
        }

        String puhe = this.tekstimalli.sanat()
                .get(new Random().nextInt(this.tekstimalli.sanat().size()));
        String viimeinenSana = puhe;

        for (int i = 1; i < sanojaEnintaan; i++) {
            String seuraavaSana = this.tekstimalli.annaSana(viimeinenSana);
            if (seuraavaSana == null || i >= sanojaEnintaan) {
                return puhe;
            } else {
                puhe = puhe + " " + seuraavaSana;
                viimeinenSana = seuraavaSana;
            }
        }
        return puhe;
    }

}

/*
package vaalit;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;


import java.util.List;
public class Puhegeneraattori {

    private Tekstimalli tekstimalli;

    public Puhegeneraattori() {
        this.tekstimalli = new Tekstimalli();
    }

    public void lue(String tiedosto) {
        try {
            Files.lines(Paths.get(tiedosto))
                    .map(line -> line.split(";"))
                    .forEach(line -> tekstimalli.lisaaAineisto(line[1]));
        } catch (IOException ex) {
            System.out.println("Tiedoston " + tiedosto + " lukeminen epäonnistui.");
        }
    }

    public String tuotaPuhetta(int sanojaEnintaan) {
        List<String> sanat = tekstimalli.sanat();
        Collections.shuffle(sanat);
        String sana = sanat.get(0);
        String puhe = sana;
        for (int i = 0; i < sanojaEnintaan - 1; i++) {
            String seuraava = tekstimalli.annaSana(sana);
            if (seuraava == null) {
                return puhe;
            }
            puhe += " " + seuraava;
            sana = seuraava;
        }
        return puhe;
    }
}
*/