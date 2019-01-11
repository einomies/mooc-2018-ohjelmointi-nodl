import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Puhelinmuistio {

    private ArrayList<Henkilo> henkilot;

    public Puhelinmuistio() {
        this.henkilot = new ArrayList<>();
    }

    public void listaa() {
        this.henkilot.stream().forEach(System.out::println);
    }

    public void lisaa(String etunimi, String sukunimi, String puhelinnumero) {
        Henkilo lisattava = new Henkilo(etunimi, sukunimi, puhelinnumero);
        if(this.henkilot.contains(lisattava)) {
            return;
        }

        this.henkilot.add(lisattava);
        this.henkilot.sort(Comparator.comparing(Henkilo::getSukunimi).thenComparing(Henkilo::getEtunimi));
    }

    public void poista(String etunimi, String sukunimi) {
        ArrayList<Henkilo> poistettavat = this.henkilot.stream().filter(henkilo -> henkilo.getEtunimi().equals(etunimi) && henkilo.getSukunimi().equals(sukunimi)).collect(Collectors.toCollection(ArrayList::new));
        this.henkilot.removeAll(poistettavat);
    }

    public void etsiEtunimella(String etunimi) {
        etsi(henkilo -> henkilo.getEtunimi().contains(etunimi));
    }

    public void etsiSukunimella(String sukunimi) {
        etsi(henkilo -> henkilo.getSukunimi().contains(sukunimi));
    }

    public void etsiPuhelinnumerolla(String numero) {
        etsi(henkilo -> henkilo.getPuhelinnumero().contains(numero));
    }

    private void etsi(Predicate<Henkilo> p) {
        ArrayList<Henkilo> loydetyt = henkilot.stream().filter(p).collect(Collectors.toCollection(ArrayList::new));
        if (loydetyt.isEmpty()) {
            System.out.println("Ei tuloksia.");
        } else {
            System.out.println("Tuloksia yhteensä: " + loydetyt.size());
            loydetyt.stream().forEach(System.out::println);
        }
    }

    public void lataa(String tiedostosta) {
        if(!new File(tiedostosta).exists()) {
            System.out.println("Tiedostoa " + tiedostosta + " ei ole olemassa.");
            return;
        }

        try {
            Files.lines(Paths.get(tiedostosta))
                    .filter(l -> !l.trim().isEmpty())
                    .map(l -> l.split("\t"))
                    .filter(osat -> osat.length == 3)
                    .forEach(osat -> lisaa(osat[0], osat[1], osat[2]));
        } catch (Exception e) {
            System.out.println("Puhelinmuistion lataaminen tiedostosta " + tiedostosta + " epäonnistui.");
            System.out.println("Virhe: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void tallenna(String tiedostoon) {
        try {
            PrintWriter kirjoittaja = new PrintWriter(tiedostoon);

            this.henkilot.stream().forEach(henkilo -> {
                kirjoittaja.println(henkilo);
            });

            kirjoittaja.flush();
            kirjoittaja.close();

        } catch (Exception e) {
            System.out.println("Puhelinmuistion kirjoittaminen tiedostoon " + tiedostoon + " epäonnistui.");
            System.out.println("Virhe: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
