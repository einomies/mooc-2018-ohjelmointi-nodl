
public class Main {

    /*
    Toteuta ensin luokka Suorakulmio, joka saa konstruktorin parametrina x-koordinaatin,
    y-koordinaatin, leveyden ja korkeuden. Tee tämän jälkeen luokka Ruudukko, johon
    suorakulmioita voi lisätä, ja joka piirtää kaikki suorakulmiot ruudukossa.
    
    Ohjelman tulee toimia seuraavasti:

    Ruudukko r = new Ruudukko();
    r.lisaa(new Suorakulmio(0, 0, 2, 3));
    System.out.println(r);

    xx
    xx
    xx

    Ruudukko r = new Ruudukko();
    r.lisaa(new Suorakulmio(0, 0, 2, 3));
    r.lisaa(new Suorakulmio(3, 2, 4, 2));
    System.out.println(r);

    xx
    xx
    xx xxxx
       xxxx

    Ruudukko r = new Ruudukko();
    r.lisaa(new Suorakulmio(0, 0, 2, 3));
    r.lisaa(new Suorakulmio(3, 2, 4, 2));
    r.lisaa(new Suorakulmio(5, 0, 1, 1));
    System.out.println(r);

    xx   x
    xx
    xx xxxx
       xxxx
     */
    public static void main(String[] args) {
        Ruudukko r = new Ruudukko();
        r.lisaa(new Suorakulmio(0, 0, 2, 3));
        r.lisaa(new Suorakulmio(3, 2, 4, 2));
        r.lisaa(new Suorakulmio(5, 0, 1, 1));
        System.out.println(r);
    }

}
