package sanakirja;

public class Main {

    public static void main(String[] args) {
//        testi01();
//        testi02();
        testi03();
//        testi04();
//        testi05();
    }

    private static void testi01() {
        Tehtavakirjanpito kirjanpito = new Tehtavakirjanpito();
        kirjanpito.lisaa("Ada", 3);
        kirjanpito.lisaa("Ada", 4);
        kirjanpito.lisaa("Ada", 3);
        kirjanpito.lisaa("Ada", 3);

        kirjanpito.lisaa("Pekka", 4);
        kirjanpito.lisaa("Pekka", 4);

        kirjanpito.lisaa("Matti", 1);
        kirjanpito.lisaa("Matti", 2);

        kirjanpito.tulosta();
        /*
        Matti: [1, 2]
        Pekka: [4]
        Ada: [3, 4]
         */
    }

    private static void testi02() {
        UseanKaannoksenSanakirja sanakirja = new OmaUseanKaannoksenSanakirja();
        sanakirja.lisaa("kuusi", "six");
        sanakirja.lisaa("kuusi", "spruce");

        sanakirja.lisaa("pii", "silicon");
        sanakirja.lisaa("pii", "pi");

        System.out.println(sanakirja);

        System.out.println(sanakirja.kaanna("kuusi"));
        sanakirja.poista("pii");
        System.out.println(sanakirja.kaanna("pii"));
        /*
        [six, spruce]
        []
         */
    }

    private static void testi03() {
        UseanKaannoksenSanakirja s = new OmaUseanKaannoksenSanakirja();
        s.lisaa("apina", "monkey");
        s.lisaa("apina", "apfe");
        System.out.println(s.kaanna("apina"));
        s.lisaa("juusto", "cheese");
        s.poista("apina");
        s.lisaa("maito", "milk");
        System.out.println(s.kaanna("apina"));
    }

    private static void testi04() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void testi05() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
