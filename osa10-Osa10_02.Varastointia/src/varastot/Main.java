package varastot;

public class Main {

    public static void main(String[] args) {
//        testi01();
//        testi02();
//        testi03();
//        testi04();
//        testi05();
        testi06();
//        testi07();
//        testi08();
    }

    private static void testi01() {
        Tuotevarasto mehu = new Tuotevarasto("Juice", 1000.0);
        mehu.lisaaVarastoon(1000.0);
        mehu.otaVarastosta(11.3);
        System.out.println(mehu);           // saldo = 988.7, tilaa 11.3
        /*
        Juice
        saldo = 988.7, vielä tilaa 11.3
         */
    }

    private static void testi02() {
        Tuotevarasto mehu = new Tuotevarasto("Juice", 1000.0);
        mehu.lisaaVarastoon(1000.0);
        mehu.otaVarastosta(11.3);
        System.out.println(mehu.getNimi()); // Juice
        mehu.lisaaVarastoon(1.0);
        System.out.println(mehu);           // Juice: saldo = 989.7, tilaa 10.299999999999955
        /*
        Juice
        Juice: saldo = 989.7, tilaa 10.299999999999955
         */
    }

    private static void testi03() {
        Muutoshistoria muutoshistoria = new Muutoshistoria();
        muutoshistoria.lisaa(3);
        muutoshistoria.lisaa(2);
        muutoshistoria.lisaa(7);
        muutoshistoria.lisaa(2);
        System.out.println("muutoshistoria:");
        System.out.println(muutoshistoria);
        System.out.println();
        System.out.println("max: " + muutoshistoria.maxArvo());
        System.out.println("min: " + muutoshistoria.minArvo());
        System.out.println("keskiarvo: " + muutoshistoria.keskiarvo());
        System.out.println("summa: " + muutoshistoria.summaYht());
        System.out.println("suurin muutos: " + muutoshistoria.suurinMuutos());
        System.out.println("otosvarianssi: " + muutoshistoria.varianssi());
    }

    private static void testi04() {
        MuistavaTuotevarasto mehu = new MuistavaTuotevarasto("Juice", 1000.0, 1000.0);

        mehu.lisaaVarastoon(500);
        System.out.println(mehu);

        mehu.otaVarastosta(100);
        System.out.println(mehu);

        mehu.lisaaVarastoon(50);
        System.out.println(mehu);

        mehu.lisaaVarastoon(10);
        System.out.println(mehu);

        mehu.lisaaVarastoon(5);
        System.out.println(mehu);

        mehu.otaVarastosta(1000);
        System.out.println(mehu);

        System.out.println(mehu.historia());
    }

    private static void testi05() {
        MuistavaTuotevarasto mehu = new MuistavaTuotevarasto("Juice", 1000.0, 1000.0);
        mehu.otaVarastosta(11.3);
        mehu.lisaaVarastoon(1.0);
        //System.out.println(mehu.historia()); // [1000.0, 988.7, 989.7]
        mehu.tulostaAnalyysi();
        /*
        Tuote: Juice
        Historia: [1000.0, 988.7, 989.7]
        Suurin tuotemäärä: 1000.0
        Pienin tuotemäärä: 988.7
        Keskiarvo: 992.8
         */
    }

    private static void testi06() {
        MuistavaTuotevarasto mehu = new MuistavaTuotevarasto("OmppuPomppu", 1000.0, 1000.0);

        mehu.otaVarastosta(160);
        mehu.otaVarastosta(40);

        mehu.lisaaVarastoon(50);

        mehu.otaVarastosta(240);
        mehu.otaVarastosta(700);

        mehu.lisaaVarastoon(150);
        mehu.lisaaVarastoon(70);

        mehu.otaVarastosta(40);
        mehu.otaVarastosta(140);

        mehu.lisaaVarastoon(720);

        mehu.tulostaAnalyysi();
    }

    private static void testi07() {
    }

    private static void testi08() {
    }

    private static void testi09() {
    }

    private static void testi10() {
    }

}
