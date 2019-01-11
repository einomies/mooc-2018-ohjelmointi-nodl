
public class TulosteluaLikeABoss {

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
            System.out.print("\n");
            i++;
        }
    }

    public static void tulostaKolmio(int koko) {
        int i = koko;
        while (i>0) {
            tulostaTyhjaa(i-1);
            tulostaTahtia(koko+1-i);
            i--;
        }
    }

    public static void tulostaTyhjaa(int maara) {
        int i = 1;
        while (i<=maara) {
            System.out.print(" ");
            i++;
        }
    }

    public static void jouluKuusi(int korkeus) {
        int max = 2*korkeus-1;
        int i = 1;
        int tahdet;
        int tyhjat;

        while (i <= korkeus) {
            tahdet = 2 * i - 1;
            tyhjat = (max - tahdet) / 2;
            tulostaTyhjaa(tyhjat);
            tulostaTahtia(tahdet);
            i++;
        }
        tyhjat = (max-3)/2;
        tulostaTyhjaa(tyhjat);
        tulostaTahtia(3);
        tulostaTyhjaa(tyhjat);
        tulostaTahtia(3);
    }

    public static void main(String[] args) {
        // Testit eivät katso main-metodia, voit muutella tätä vapaasti.

//        tulostaKolmio(3);
//        System.out.println("---");
        jouluKuusi(22);
//        System.out.println("---");
//        jouluKuusi(10);
    }
}
