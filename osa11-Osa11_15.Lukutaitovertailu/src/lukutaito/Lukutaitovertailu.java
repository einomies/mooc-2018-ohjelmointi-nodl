package lukutaito;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/*
Adult literacy rate, population 15+ years, female (%),Trinidad and Tobago,2014,98.62493
Adult literacy rate, population 15+ years, female (%),Trinidad and Tobago,2015,98.70233
Adult literacy rate, population 15+ years, female (%),Eritrea,2014,64.25323
Adult literacy rate, population 15+ years, female (%),Eritrea,2015,65.60877
Adult literacy rate, population 15+ years, male (%),Malaysia,2015,96.19606
Adult literacy rate, population 15+ years, female (%),Kuwait,2015,95.23039
Adult literacy rate, population 15+ years, female (%),Uruguay,2014,98.80905
Adult literacy rate, population 15+ years, female (%),Uruguay,2015,98.80391
Adult literacy rate, population 15+ years, male (%),Belarus,2015,99.78625
Adult literacy rate, population 15+ years, male (%),Guyana,2015,85.84388
Adult literacy rate, population 15+ years, male (%),El Salvador,2015,90.10247
Adult literacy rate, population 15+ years, female (%),Togo,2015,55.30268
Adult literacy rate, population 15+ years, female (%),India,2015,62.98472
Adult literacy rate, population 15+ years, male (%),Mozambique,2015,73.42743
Adult literacy rate, population 15+ years, female (%),Palestine,2014,94.4073
Adult literacy rate, population 15+ years, female (%),Palestine,2015,94.80767
Adult literacy rate, population 15+ years, male (%),Yemen,2014,84.17932
Adult literacy rate, population 15+ years, male (%),Yemen,2015,84.97328

Tiedoston lukutaito.csv yksittäisen rivin muoto on seuraava:
teema
ikäryhmä
sukupuoli
maa
vuosi
lukutaitoprosentti

 */
public class Lukutaitovertailu {

    public static void main(String[] args) {

        List<Lukutaito> rivit = lueRivit();

//        Collections.sort(rivit);
        rivit.stream().sorted().forEach(r -> System.out.println(r));

//        tulostaRivit(rivit);
/*
Niger (2015), female, 11.01572
Mali (2015), female, 22.19578
Guinea (2015), female, 22.87104
Afghanistan (2015), female, 23.87385
Central African Republic (2015), female, 24.35549
*/
    }

    private static List<Lukutaito> lueRivit() {
        List<Lukutaito> rivit = new ArrayList<>();
        String tiedostoLukuNimi = "lukutaito.csv";
        try {
            Files.lines(Paths.get(tiedostoLukuNimi))
                    .map(rivi -> rivi.split(","))
                    .filter(palat -> palat.length >= 6)
                    .map(palat -> new Lukutaito(
                    palat[0],
                    palat[1],
                    palat[2],
                    palat[3],
                    Integer.parseInt(palat[4]),
                    Double.parseDouble(palat[5])))
                    .forEach(rivi -> rivit.add(rivi));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Virhe: " + e.getMessage());
        }
        return rivit;
    }

    private static void tulostaRivit(List<Lukutaito> rivit) {
        rivit.stream().forEach(rivi -> System.out.println(rivi));
    }

}

/*
package lukutaito;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Lukutaitovertailu {

    public static void main(String[] args) {
        ArrayList<Tulos> tulokset = new ArrayList<>();
        try {
            Files.lines(Paths.get("lukutaito.csv"))
                    .map(l -> l.split(","))
                    .map(a -> new Tulos(a[2].replace("(%)", "").trim(), a[3], Integer.parseInt(a[4]), Double.parseDouble(a[5])))
                    .forEach(t -> tulokset.add(t));
        } catch (IOException ex) {
            System.out.println("Virhe tiedoston käsittelyssä.");
        }
        tulokset.stream().sorted((t1, t2) -> {
            if (t1.getLukutaitoprosentti() > t2.getLukutaitoprosentti()) {
                return 1;
            }
            if (t1.getLukutaitoprosentti() < t2.getLukutaitoprosentti()) {
                return -1;
            }
            return 0;
        }).forEach(t -> System.out.println(t));
    }
}
*/