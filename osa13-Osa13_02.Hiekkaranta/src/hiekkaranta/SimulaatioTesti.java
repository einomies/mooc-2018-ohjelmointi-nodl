/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hiekkaranta;

/**
 *
 * @author einomies
 */
public class SimulaatioTesti {

    public static void main(String[] args) {
//        testi01();
//        testi02();
//        testi03();
//        testi04Hiekka();
        testi05HiekkaVesi();
//        testi06();
//        testi07();
    }

    private static void testi01() {
        Simulaatio simulaatio = new Simulaatio(5, 4);
        Tyyppi[][] taulukko = simulaatio.getTaulukko();
        tulostaSisalto(taulukko);
    }

    private static void testi02() {
        Simulaatio simulaatio = new Simulaatio(10, 10);

        Tyyppi[][] taulukko = simulaatio.getTaulukko();
        tulostaSisalto(taulukko);

        System.out.println();

        for (int y = 0; y < simulaatio.getKorkeus(); y++) {
            Tyyppi tyyppi = valitseTyyppi(y);
            for (int x = 0; x < simulaatio.getLeveys(); x++) {
                simulaatio.lisaa(x, y, tyyppi);
            }
        }

        tulostaSisalto(taulukko);
    }

    private static void testi03() {
        Simulaatio simulaatio = new Simulaatio(10, 10);

        for (int y = 0; y < simulaatio.getKorkeus(); y++) {
            Tyyppi tyyppi = valitseTyyppi(y);
            for (int x = 0; x < simulaatio.getLeveys(); x++) {
                simulaatio.lisaa(x, y, tyyppi);
            }
        }

        for (int x = 0; x < simulaatio.getLeveys(); x++) {
            for (int y = 0; y < simulaatio.getKorkeus(); y++) {
                System.out.println("sisalto(" + x + "," + y + "): " + simulaatio.sisalto(x, y));
            }
        }
    }

    private static void testi04Hiekka() {
        Simulaatio simulaatio = new Simulaatio(10, 10);
//        for (int x = 0; x < simulaatio.getLeveys(); x++) {
//            for (int y = 0; y < simulaatio.getKorkeus(); y++) {
//                if (y == 1) {
//                    simulaatio.lisaa(x, y, Tyyppi.HIEKKA);
//                }
//            }
//        }
        simulaatio.lisaa(5, 8, Tyyppi.HIEKKA);

        simulaatio.lisaa(3, 9, Tyyppi.HIEKKA);
        simulaatio.lisaa(4, 9, Tyyppi.HIEKKA);
//        simulaatio.lisaa(5, 9, Tyyppi.HIEKKA);
        simulaatio.lisaa(6, 9, Tyyppi.HIEKKA);
        simulaatio.lisaa(7, 9, Tyyppi.HIEKKA);

        tulostaSisalto(simulaatio.getTaulukko());
        System.out.println();

        for (int i = 0; i < 100; i++) {
            simulaatio.paivita();
        }
        tulostaSisalto(simulaatio.getTaulukko());
    }

    private static void testi05HiekkaVesi() {
        Simulaatio simulaatio = new Simulaatio(10, 10);

//        for (int x = 2; x < simulaatio.getLeveys() - 2; x++) {
//            for (int y = 2; y < 4; y++) {
//                simulaatio.lisaa(x, y, Tyyppi.HIEKKA);
//            }
//        }
//        simulaatio.lisaa(3, 5, Tyyppi.HIEKKA);
//        simulaatio.lisaa(4, 5, Tyyppi.HIEKKA);
//        simulaatio.lisaa(5, 5, Tyyppi.HIEKKA);
        simulaatio.lisaa(3, 6, Tyyppi.HIEKKA);
        simulaatio.lisaa(4, 6, Tyyppi.HIEKKA);
        simulaatio.lisaa(5, 6, Tyyppi.HIEKKA);

        for (int x = 0; x < simulaatio.getLeveys(); x++) {
            for (int y = 8; y < 10; y++) {
                simulaatio.lisaa(x, y, Tyyppi.VESI);
            }
        }

        System.out.println("Alkutilanne");
        tulostaSisalto(simulaatio.getTaulukko());
        System.out.println();

        for (int i = 0; i < 10; i++) {
            simulaatio.paivita();
//            tulostaSisalto(simulaatio.getTaulukko());
//            System.out.println();
        }
        System.out.println("Lopputilanne");
        tulostaSisalto(simulaatio.getTaulukko());
        System.out.println();
    }

    private static void testi06() {
    }

    private static void testi07() {
    }

    private static void testi08() {
    }

    private static void tulostaSisalto(Tyyppi[][] sisalto) {
        final String rajaMerkki = "*";

        String rivi = "";
        for (int i = 0; i < sisalto[0].length + 2; i++) {
            rivi += rajaMerkki;
        }
        System.out.println(rivi);

        for (int y = 0; y < sisalto[0].length; y++) {
            rivi = rajaMerkki;
            for (int x = 0; x < sisalto.length; x++) {
                rivi = rivi + tyypilleKirjain(sisalto[x][y]);
            }
            rivi += rajaMerkki;
            System.out.println(rivi);
        }
        rivi = "";
        for (int i = 0; i < sisalto[0].length + 2; i++) {
            rivi += rajaMerkki;
        }
        System.out.println(rivi);
    }

    private static Tyyppi valitseTyyppi(int nro) {
        if (nro < 0) {
            throw new IllegalArgumentException("nro oltava >= nolla");
        }
        int max = 4;
        int ind = nro - max;
        int kerroin = 1;

        while (ind >= max) {
            ind = ind - kerroin * max;
            kerroin++;
        }

        if (ind < 0) {
            ind = nro;
        }

        switch (ind) {
            case 0:
                return Tyyppi.TYHJA;
            case 1:
                return Tyyppi.METALLI;
            case 2:
                return Tyyppi.HIEKKA;
            case 3:
                return Tyyppi.VESI;
            default:
                return Tyyppi.TYHJA;
        }
    }

    private static String tyypilleKirjain(Tyyppi tyyppi) {
        String kirjain = "";
        switch (tyyppi) {
            case HIEKKA:
                kirjain = "H";
                break;
            case METALLI:
                kirjain = "M";
                break;
            case TYHJA:
                kirjain = " ";
                break;
            case VESI:
                kirjain = "V";
                break;
            default:
                kirjain = " ";
                break;
        }
        return kirjain;
    }

}
