
public class Main {

    public static void main(String[] args) {

//        testi01();
//        testi02();
//        testi03();
        testi04();
    }

    private static void testi01() {
        Kirja kirja1 = new Kirja("Fedor Dostojevski", "Rikos ja Rangaistus", 2);
        Kirja kirja2 = new Kirja("Robert Martin", "Clean Code", 1);
        Kirja kirja3 = new Kirja("Kent Beck", "Test Driven Development", 0.5);

        CDLevy cd1 = new CDLevy("Pink Floyd", "Dark Side of the Moon", 1973);
        CDLevy cd2 = new CDLevy("Wigwam", "Nuclear Nightclub", 1975);
        CDLevy cd3 = new CDLevy("Rendezvous Park", "Closer to Being Here", 2012);

        System.out.println(kirja1);
        System.out.println(kirja2);
        System.out.println(kirja3);
        System.out.println(cd1);
        System.out.println(cd2);
        System.out.println(cd3);
        /*
        Tulostus:
        Fedor Dostojevski: Rikos ja Rangaistus
        Robert Martin: Clean Code
        Kent Beck: Test Driven Development
        Pink Floyd: Dark Side of the Moon (1973)
        Wigwam: Nuclear Nightclub (1975)
        Rendezvous Park: Closer to Being Here (2012)
         */
    }

    private static void testi02() {
        Laatikko laatikkoPieni = new Laatikko(10);
        laatikkoPieni.lisaa(new Kirja("Fedor Dostojevski", "Rikos ja rangaistus", 2));
        laatikkoPieni.lisaa(new Kirja("Robert Martin", "Clean Code", 1));
        laatikkoPieni.lisaa(new Kirja("Kent Beck", "Test Driven Development", 0.7));
        laatikkoPieni.lisaa(new CDLevy("Pink Floyd", "Dark Side Of The Moon", 1973));
        laatikkoPieni.lisaa(new CDLevy("Wigwam", "Nuclear Nightclub", 1975));
        laatikkoPieni.lisaa(new CDLevy("Rendezvous Park", "Closer To Being Here", 2012));
        System.out.println("laatikkoPieni: " + laatikkoPieni);
        /*
        Tulostuu
        Laatikko: 6 esinettä, paino yhteensä 4.0 kiloa
         */
    }

    private static void testi03() {

        Laatikko laatikkoPieni01 = new Laatikko(3);
        laatikkoPieni01.lisaa(new Kirja("Fedor Dostojevski", "Rikos ja rangaistus", 2));
        laatikkoPieni01.lisaa(new Kirja("Robert Martin", "Clean Code", 1));
        System.out.println("laatikkoPieni01: " + laatikkoPieni01);

        Laatikko laatikkoPieni02 = new Laatikko(5);
        laatikkoPieni02.lisaa(new Kirja("Kent Beck", "Test Driven Development", 0.7));
        laatikkoPieni02.lisaa(new Kirja("Mika Waltari", "Sinuhe egyptiläinen", 1.5));
        laatikkoPieni02.lisaa(new Kirja("Timo Tietäväinen", "Tietosanakirja", 2.3));
        laatikkoPieni02.lisaa(new Kirja("Wal Disney", "Taikaviitta", 0.4));
        laatikkoPieni02.lisaa(new CDLevy("Pink Floyd", "Dark Side Of The Moon", 1973));
        laatikkoPieni02.lisaa(new CDLevy("Wigwam", "Nuclear Nightclub", 1975));
        laatikkoPieni02.lisaa(new CDLevy("Rendezvous Park", "Closer To Being Here", 2012));
        System.out.println("laatikkoPieni02: " + laatikkoPieni02);

        Laatikko laatikkoPieni03 = new Laatikko(3);
        laatikkoPieni03.lisaa(new Kirja("Paavo Väyrynen", "Nyt on puolitotuuden aika", 2.7));

        Laatikko laatikkoSuuri01 = new Laatikko(10);
        laatikkoSuuri01.lisaa(laatikkoPieni01);
        laatikkoSuuri01.lisaa(laatikkoPieni02);
        laatikkoSuuri01.lisaa(laatikkoPieni03);
        System.out.println("laatikkoSuuri01: " + laatikkoSuuri01);
    }

    private static void testi04() {
        Laatikko isoLaatikko = new Laatikko(20);
        Laatikko pieniLaatikko01 = new Laatikko(10);
        Laatikko pieniLaatikko02 = new Laatikko(10);
        isoLaatikko.lisaa(pieniLaatikko01);
        pieniLaatikko01.lisaa(new Kirja("Horstman", "Core Java", 5));
        pieniLaatikko01.lisaa(new Kirja("Timo Forss", "Göde", 3));
        isoLaatikko.lisaa(pieniLaatikko02);
        pieniLaatikko02.lisaa(new Kirja("Arthur Griffith", "COBOL for Jonne", 2));
        isoLaatikko.paino();
        System.out.println(isoLaatikko);
        /*
        expected:
        <5.0> but was:<0.0>
        junit.framework.AssertionFailedError:
        Painon pitäisi kasvaa kun laatikon sisältämään laatikkoon lisätään esine
         */
    }
}
