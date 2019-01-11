
import java.util.Scanner;

public class Kayttoliittyma {
    // tekstikäyttöliittymän tarvitsemat oliomuuttujat
    private Scanner lukija;

    // konstruktori, jolle annetaan parametrina tarvitut oliomuuttujat
    public Kayttoliittyma(Scanner scanner) {
        this.lukija = scanner;
    }

    // käyttöliittymän käynnistysmetodi
    public void kaynnista() {
        
        String komento = "";
        String nimiSuomi = "";
        String nimiLatina = "";

        Lintutilasto lintutilasto = new Lintutilasto();
        muodostaAlkutilanne(lintutilasto);
//        lintutilasto.tulostaLinnut();
        
        // tervehdysviesti
        System.out.println("Terveppä terve, eli teretulemast voimlemise ringi!");
        System.out.println("...tai siis lintutietokannan ylläpitoon.");

        System.out.println();

        System.out.println("Komennot:");
        System.out.println("Lisaa      (lisää linnun tietokantaan)");
        System.out.println("Havainto   (lisää yhden havainnon)");
        System.out.println("Tilasto    (tulostaa kaikki linnut)");
        System.out.println("Nayta      (tulostaa yhden linnun tiedot)");
        System.out.println("Lopeta     (lopettaa ohjelman)");
        System.out.println();

        while (true) {
            System.out.print("? ");
            komento = lukija.nextLine();

            if (komento.equalsIgnoreCase("Lopeta")) {
                break;
            }

            if (komento.equalsIgnoreCase("Lisaa")) {
                System.out.print("Nimi: ");
                nimiSuomi = lukija.nextLine();
                System.out.print("Latinankielinen nimi: ");
                nimiLatina = lukija.nextLine();
                lintutilasto.lisaaLintu(nimiSuomi, nimiLatina);
            }

            if (komento.equalsIgnoreCase("Havainto")) {
                System.out.print("Mikä havaittu? ");
                nimiSuomi = lukija.nextLine();
                lintutilasto.lisaaBongaus(nimiSuomi);
            }

            if (komento.equalsIgnoreCase("Tilasto")) {
                lintutilasto.tulostaLinnut();
            }

            if (komento.equalsIgnoreCase("Nayta")) {
                System.out.print("Mikä? ");
                nimiSuomi = lukija.nextLine();
                lintutilasto.tulostaLintu(nimiSuomi);
            }
        }

        System.out.println();
        System.out.println("Heippa, kaikki yhes koos!");
    }

    private static void muodostaAlkutilanne(Lintutilasto lintutilasto) {
        lintutilasto.lisaaLintu("Korppi", "Corvus corax");
        lintutilasto.lisaaLintu("Laulujoutsen", "Cygnus cygnus");
        lintutilasto.lisaaLintu("Kanadanhanhi", "Branta canadensis");
        lintutilasto.lisaaLintu("Tavi", "Anas crecca");
        lintutilasto.lisaaLintu("Sinisorsa", "Anas platyrhynchos");
        lintutilasto.lisaaLintu("Tukkasotka", "Aythya fuligula");
        lintutilasto.lisaaLintu("Haahka", "Somateria mollissima");
        lintutilasto.lisaaLintu("Telkkä", "Bucephala clangula");
        lintutilasto.lisaaLintu("Uivelo", "Mergellus albellus");
        lintutilasto.lisaaLintu("Isokoskelo", "Mergus merganser");
        lintutilasto.lisaaLintu("Pyy", "Bonasa bonasia");
        lintutilasto.lisaaLintu("Riekko", "Lagopus lagopus");
        lintutilasto.lisaaLintu("Teeri", "Tetrao tetrix");
        lintutilasto.lisaaLintu("Metso", "Tetrao urogallus");
        lintutilasto.lisaaLintu("Fasaani", "Phasianus colchicus");
        lintutilasto.lisaaLintu("Silkkiuikku", "Podiceps cristatus");
        lintutilasto.lisaaLintu("Kanahaukka", "Accipiter gentilis");
        lintutilasto.lisaaLintu("Sääksi", "Pandion haliaetus");
        lintutilasto.lisaaLintu("Kuovi", "Numenius arquata");
    }

}

/*
import java.util.Scanner;

public class Kayttoliittyma {

    private Scanner lukija;
    private LintuTietokanta ltk;

    public Kayttoliittyma(Scanner lukija, LintuTietokanta ltk) {
        this.lukija = lukija;
        this.ltk = ltk;
    }

    public void kaynnista() {
        while (true) {
            String komento = kysy("?");
            if (komento.equals("Lopeta")) {
                break;
            } else if (komento.equals("Lisaa")) {
                lisaa();
            } else if (komento.equals("Havainto")) {
                havainto();
            } else if (komento.equals("Nayta")) {
                nayta();
            } else if (komento.equals("Tilasto")) {
                tilasto();
            } else {
                System.out.println("Tuntematon komento!");
            }
        }
    }

    public String kysy(String kysymys) {
        System.out.print(kysymys + " ");
        return lukija.nextLine();
    }

    public void lisaa() {
        String nimi = kysy("Nimi:");
        String latNimi = kysy("Latinankielinen nimi:");
        ltk.lisaa(nimi, latNimi);
    }

    public void havainto() {
        String nimi = kysy("Nimi:");
        boolean onnistuiko = ltk.havainto(nimi);
        if (!onnistuiko) {
            System.out.println(nimi + " ei ole lintu!");
        }
    }

    public void nayta() {
        String nimi = kysy("Nimi:");
        String mjono = ltk.nayta(nimi);
        if (mjono == null) {
            System.out.println(nimi + " ei ole lintu!");
        } else {
            System.out.println(mjono);
        }
    }

    public void tilasto() {
        System.out.print(ltk.tilasto());
    }
}
*/