package henkilosto;

public class Paaohjelma {

    public static void main(String[] args) {
//        testi01();
//        testi02();
        testi03();
    }

    private static void testi01() {
        Henkilo vilma = new Henkilo("Vilma", Koulutus.FT);
        System.out.println(vilma);
        /*
        Vilma, FT
         */
    }

    private static void testi02() {
        Tyontekijat yliopisto = new Tyontekijat();
        yliopisto.lisaa(new Henkilo("Petrus", Koulutus.FT));
        yliopisto.lisaa(new Henkilo("Arto", Koulutus.FilYO));
        yliopisto.lisaa(new Henkilo("Elina", Koulutus.FT));

        yliopisto.tulosta();

        yliopisto.irtisano(Koulutus.FilYO);

        System.out.println("==");

        yliopisto.tulosta();

        /*
        Tulostuu:

        Petrus, FT
        Arto, FilYO
        Elina, FT
        ==
        Petrus, FT
        Elina, FT
         */
    }

    private static void testi03() {
        Tyontekijat yliopisto = new Tyontekijat();
        yliopisto.lisaa(new Henkilo("Petrus", Koulutus.FT));
        yliopisto.lisaa(new Henkilo("Arto", Koulutus.FilYO));
        yliopisto.lisaa(new Henkilo("Elina", Koulutus.FT));
        
        yliopisto.tulosta();

        System.out.println("==");

        yliopisto.tulosta(Koulutus.FT);
    }

}
