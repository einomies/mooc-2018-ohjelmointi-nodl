
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        testi01();
//        testi02();
//        testi03();
//        testi04();
//        testi05();
//        testi06();
//        testi07();
//        testi08();
        testi09();
//        testi10();
    }

    private static void testi01() {
        Maitosailio sailio = new Maitosailio();
        sailio.otaSailiosta(100);
        sailio.lisaaSailioon(25);
        sailio.otaSailiosta(5);
        System.out.println(sailio);

        sailio = new Maitosailio(50);
        sailio.lisaaSailioon(100);
        System.out.println(sailio);
    }

    private static void testi02() {
        Lehma lehma = new Lehma();
        System.out.println(lehma);

        Eleleva elelevaLehma = lehma;
        elelevaLehma.eleleTunti();
        elelevaLehma.eleleTunti();
        elelevaLehma.eleleTunti();
        elelevaLehma.eleleTunti();

        System.out.println(lehma);

        Lypsava lypsavaLehma = lehma;
        lypsavaLehma.lypsa();

        System.out.println(lehma);
        System.out.println("");

        lehma = new Lehma("Ammu");
        System.out.println(lehma);
        lehma.eleleTunti();
        lehma.eleleTunti();
        System.out.println(lehma);
        lehma.lypsa();
        System.out.println(lehma);
    }

    private static void testi03() {
        Lypsyrobotti lypsyrobotti = new Lypsyrobotti();
        Lehma lehma = new Lehma();
        lypsyrobotti.lypsa(lehma);
//        Maidot menevät hukkaan
    }

    private static void testi04() {
        Lypsyrobotti lypsyrobotti = new Lypsyrobotti();
        Lehma lehma = new Lehma();
        System.out.println("");

        Maitosailio sailio = new Maitosailio();
        lypsyrobotti.setMaitosailio(sailio);
        System.out.println("Säiliö: " + sailio);

        for (int i = 0; i < 2; i++) {
            System.out.println(lehma);
            System.out.println("Elellään..");
            for (int j = 0; j < 5; j++) {
                lehma.eleleTunti();
            }
            System.out.println(lehma);

            System.out.println("Lypsetään...");
            lypsyrobotti.lypsa(lehma);
            System.out.println("Säiliö: " + sailio);
            System.out.println("");
        }
        /*
        Ohjelman tulostus on esimerkiksi seuraavanlainen.

        Säiliö: 0.0/2000.0
        Mella 0.0/23.0
        Elellään..
        Mella 6.2/23.0
        Lypsetään...
        Säiliö: 6.2/2000.0

        Mella 0.0/23.0
        Elellään..
        Mella 7.8/23.0
        Lypsetään...
        Säiliö: 14.0/2000.0
         */
    }

    private static void testi05() {
        Navetta navetta = new Navetta(new Maitosailio());
        System.out.println("Navetta: " + navetta);

        Lypsyrobotti robo = new Lypsyrobotti();
        navetta.asennaLypsyrobotti(robo);

        Lehma ammu = new Lehma();
        ammu.eleleTunti();
        ammu.eleleTunti();

        navetta.hoida(ammu);
        System.out.println("Navetta: " + navetta);

        List<Lehma> lehmaLista = new ArrayList<>();
        lehmaLista.add(ammu);
        lehmaLista.add(new Lehma());

        for (Lehma lehma : lehmaLista) {
            lehma.eleleTunti();
            lehma.eleleTunti();
        };

        navetta.hoida(lehmaLista);
        System.out.println("Navetta: " + navetta);

        /*
        Tulostuksen tulee olla esimerkiksi seuraavanlainen:
        Navetta: 0.0/2000.0
        Navetta: 2.8/2000.0
        Navetta: 9.6/2000.0
         */
    }

    private static void testi06() {
        Maitosailio sailio = new Maitosailio();
        Navetta navetta = new Navetta(sailio);

        Maatila maatila = new Maatila("Esko", navetta);
        System.out.println(maatila);

        System.out.println(maatila.getOmistaja() + " on ahkera mies!");
        /*
Odotettu tulostus:
Maatilan omistaja: Esko
Navetan maitosäiliö: 0.0/2000.0
Ei lehmiä.
Esko on ahkera mies!
         */
    }

    private static void testi07() {
        Maatila maatila = new Maatila("Esko", new Navetta(new Maitosailio()));
        maatila.lisaaLehma(new Lehma());
        maatila.lisaaLehma(new Lehma());
        maatila.lisaaLehma(new Lehma());
        System.out.println(maatila);
        /*
Odotettu tulostus:
Maatilan omistaja: Esko
Navetan maitosäiliö: 0.0/2000.0
Lehmät:
    Naatti 0.0/19.0
    Hilke 0.0/30.0
    Sylkki 0.0/29.0
         */
    }

    private static void testi08() {
        Maatila maatila = new Maatila("Esko", new Navetta(new Maitosailio()));

        maatila.lisaaLehma(new Lehma());
        maatila.lisaaLehma(new Lehma());
        maatila.lisaaLehma(new Lehma());

        maatila.eleleTunti();
        maatila.eleleTunti();

        System.out.println(maatila);
        /*
Odotettu tulostus:
Maatilan omistaja: Esko
Navetan maitosäiliö: 0.0/2000.0
Lehmät:
    Heluna 2.0/17.0
    Rima 3.0/32.0
    Ilo 3.0/25.0
         */
    }

    private static void testi09() {
        Maatila maatila = new Maatila("Esko", new Navetta(new Maitosailio()));
        Lypsyrobotti robo = new Lypsyrobotti();
        maatila.asennaNavettaanLypsyrobotti(robo);

        maatila.lisaaLehma(new Lehma());
        maatila.lisaaLehma(new Lehma());
        maatila.lisaaLehma(new Lehma());

        maatila.eleleTunti();
        maatila.eleleTunti();

        maatila.hoidaLehmat();

        maatila.eleleTunti();
        maatila.eleleTunti();
        maatila.eleleTunti();
        maatila.eleleTunti();
        maatila.eleleTunti();
        maatila.eleleTunti();
        maatila.eleleTunti();
        maatila.eleleTunti();
        maatila.eleleTunti();
        maatila.eleleTunti();

        System.out.println(maatila);
        /*
Odotettu tulostus:

Maatilan omistaja: Esko
Navetan maitosäiliö: 18.0/2000.0
Lehmät:
    Hilke 0.0/30.0
    Sylkki 0.0/35.0
    Hento 0.0/34.0
         */
    }

    private static void testi10() {
    }

    private static void eleleTunteja(Eleleva eleleva, int tunnit) {
        for (int i = 0; i < tunnit; i++) {
            eleleva.eleleTunti();
            System.out.println(eleleva);
        }
    }

}
