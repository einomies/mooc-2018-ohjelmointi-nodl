package tyokalut;

public class Main {

    public static void main(String[] args) {
        testi01();
//        testi02();
//        testi03();
    }

    private static void testi01() {
        DuplikaattienPoistaja poistaja = new OmaDuplikaattienPoistaja();
        poistaja.lisaa("eka");
        poistaja.lisaa("toka");
        poistaja.lisaa("eka");

        System.out.println(poistaja);

        System.out.println("Duplikaattien määrä nyt: "
                + poistaja.getHavaittujenDuplikaattienMaara());

        poistaja.lisaa("vika");
        poistaja.lisaa("vika");
        poistaja.lisaa("uusi");

        System.out.println("Duplikaattien määrä nyt: "
                + poistaja.getHavaittujenDuplikaattienMaara());

        System.out.println("Uniikit merkkijonot: "
                + poistaja.getUniikitMerkkijonot());

        poistaja.tyhjenna();

        System.out.println("Duplikaattien määrä nyt: "
                + poistaja.getHavaittujenDuplikaattienMaara());

        System.out.println("Uniikit merkkijonot: "
                + poistaja.getUniikitMerkkijonot());
        /*
        Yllä oleva ohjelma tulostaisi esimerkiksi seuraavaa:
        (merkkijonojen järjestys saa vaihdella, sillä ei ole merkitystä)

        Duplikaattien määrä nyt: 1
        Duplikaattien määrä nyt: 2
        Uniikit merkkijonot: [eka, toka, vika, uusi]
        Duplikaattien määrä nyt: 0
        Uniikit merkkijonot: []
         */
    }

    private static void testi02() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void testi03() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
