package vaalit;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class Paaohjelma {

    public static void main(String[] args) throws Exception {
//        testi01();
//        testi02();
//        testi03();
//        testi04();
        testi05();
//        testi06();
//        testi07();
//        testi08();
//        testi09();
    }

    private static void testi01() {
        Sanajakauma jakauma = new Sanajakauma();
        jakauma.lisaaSana("yo");
        jakauma.lisaaSana("yo");
        jakauma.lisaaSana("ski-bi");

        System.out.println(jakauma.esiintymiskertoja("yo"));
        System.out.println(jakauma.esiintymiskertoja("ski-bi"));
        System.out.println(jakauma.esiintymiskertoja("dub"));

        System.out.println(jakauma.annaSana());
        /*
        2
        1
        0
        yo
         */
    }

    private static void testi02() {
        List<String> sanat = new ArrayList<>();
        sanat.add("nolla");
        sanat.add("yksi");
        sanat.add("kaksi");
        sanat.add("kolme");
        sanat.add("neljä");
        sanat.add("viisi");
        sanat.add("kuusi");
        sanat.add("seitsemän");
        sanat.add("kahdeksan");
        sanat.add("yhdeksän");

        Sanajakauma jakauma = luoSatunnainenSanajakauma(sanat, 10);

        for (String sana : sanat) {
            System.out.println("sana: " + sana + ", esiintymiskertoja: " + jakauma.esiintymiskertoja(sana));
        }

        System.out.println("jakauma.annaSana(): " + jakauma.annaSana());
    }

    private static Sanajakauma luoSatunnainenSanajakauma(List<String> sanat, int maxLkm) {
        Sanajakauma jakauma = new Sanajakauma();
        int arvottuLkm = 0;
        Random random = new Random();

        for (String sana : sanat) {
            arvottuLkm = random.nextInt(maxLkm + 1);
            for (int i = 0; i < arvottuLkm; i++) {
                jakauma.lisaaSana(sana);
            }
        }

        return jakauma;
    }

    private static void testi03() {
        Tekstimalli malli = new Tekstimalli();
        malli.lisaaAineisto("olen kyvykäs ottamaan asioista selvää");
        malli.lisaaAineisto("olen aktiivinen ja urheilullinen");
        malli.lisaaAineisto("olen rauhallinen ja iloinen");

        for (String sana : malli.sanat()) {
            System.out.println(sana);
        }
        /*
        olen
        kyvykäs
        ottamaan
        asioista
        selvää
        aktiivinen
        ja
        urheilullinen
        rauhallinen
        iloinen
         */
    }

    private static void testi04() {
        Tekstimalli malli = new Tekstimalli();
        malli.lisaaAineisto("");
        malli.lisaaAineisto(null);
        malli.lisaaAineisto("olen kyvykäs ottamaan asioista selvää");
        malli.lisaaAineisto("olen aktiivinen ja urheilullinen blaa blaa");

        System.out.println("tekstimallin sanat: \n" + malli.sanat());
        System.out.println();

        tulostaEdeltavaJaSeuraava("ottamaan", malli);
        tulostaEdeltavaJaSeuraava("aktiivinen", malli);
        tulostaEdeltavaJaSeuraava("ja", malli);
        tulostaEdeltavaJaSeuraava("olen", malli);
        tulostaEdeltavaJaSeuraava("olen", malli);
        tulostaEdeltavaJaSeuraava("olen", malli);
        tulostaEdeltavaJaSeuraava("kumiankka", malli);
        tulostaEdeltavaJaSeuraava("selvää", malli);
        /*
        asioista
        ja
        urheilullinen
        aktiivinen
        aktiivinen
        kyvykäs
        null
        null
         */
    }

    private static void tulostaEdeltavaJaSeuraava(String edeltava, Tekstimalli malli) {
        System.out.println("edeltävä -> seuraava: " + edeltava + " -> " + malli.annaSana(edeltava));
    }

    private static void testi05() {
        Puhegeneraattori generaattori = new Puhegeneraattori();
        generaattori.lue("vaalidata.csv");
        System.out.println(generaattori.tuotaPuhetta(10));
    }

    private static void testi06() {
//        lukeeTiedostonJaTuottaaPuhetta
        String tiedostonNimi = luoTiedosto("0;a b c d e a;a b c a");
        Puhegeneraattori puhegeneraattori = new Puhegeneraattori();
        puhegeneraattori.lue(tiedostonNimi);

        String tuotettuPuhe = puhegeneraattori.tuotaPuhetta(12);
        String[] puheenPalat = tuotettuPuhe.split(" ");
        
        for (int i = 0; i < puheenPalat.length; i++) {
            System.out.println(puheenPalat[i]);
        }

//        assertEquals(12, puheenPalat.length);
//        assertTrue(tuotettuPuhe.contains("a b c d e a b c"));
//        assertFalse(tuotettuPuhe.contains("a b c a"));
    }

    private static void testi07() {
    }

    private static void testi08() {
    }

    private static void testi09() {
    }

    private static String luoTiedosto(String sisalto) {
//        String nimi = "tmp-" + UUID.randomUUID().toString().substring(0, 6);
        String nimi = "tmp-Paaohjelma.txt";

        try {
            Files.write(Paths.get(nimi), rivit(sisalto));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return nimi;
    }

    private static List<String> rivit(String sisalto) {
        return Arrays.asList(sisalto.split("\n"));
    }

}
