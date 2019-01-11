
public class Tulostelua {

    public static void tulostaTahtia(int maara) {
        int i = 1;
        while (i<=maara) {            
            System.out.print("*");
            i++;
        }
        System.out.print("\n");
    }

    public static void tulostaNelio(int sivunpituus) {
        int i = 1;
        while (i<=sivunpituus) {            
            tulostaTahtia(sivunpituus);
            i++;
        }
    }

    public static void tulostaSuorakulmio(int leveys, int korkeus) {
        int i = 1;
        while (i<=korkeus) {            
            tulostaTahtia(leveys);
            i++;
        }
    }

    public static void tulostaKolmio(int koko) {
        int i = 1;
        while (i<=koko) {            
            tulostaTahtia(i);
            i++;
        }
    }

    public static void main(String[] args) {

        // Testit eivät katso main-metodia, voit muutella tätä vapaasti.
        // HUOM: jos testit eivät meinaa mennä läpi, kokeile pääohjelmaa ajamalla,
        // että metodit toimivat niinkuin niiden on tarkoitus toimia!

        tulostaTahtia(3);

        tulostaTahtia(9);

        tulostaNelio(8);

        tulostaSuorakulmio(12, 6);

        tulostaKolmio(7);
    }

}
