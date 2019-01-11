
public class Main {

    /*
    Tehtavalista tl = new Tehtavalista();
    tl.lisaa("Käy kaupassa");
    System.out.println(tl);
    tl.asetaTehdyksi("Käy kaupassa");
    System.out.println(tl);
    Tehtava t = tl.annaTehtava("Käy kaupassa");
    t.asetaTekemattomaksi();
    tl.lisaa("Imuroi");
    System.out.println(tl);

    Tehtävät
    * Käy kaupassa (ei tehty)

    Tehtävät
    * Käy kaupassa (tehty)

    Tehtävät
    * Käy kaupassa (ei tehty)
    * Imuroi (ei tehty)
     */
    public static void main(String[] args) {

        Tehtavalista tl = new Tehtavalista();
        tl.lisaa("Käy kaupassa");
        System.out.println(tl);
        tl.asetaTehdyksi("Käy kaupassa");
        System.out.println(tl);
        Tehtava t = tl.annaTehtava("Käy kaupassa");
        t.asetaTekemattomaksi();
        System.out.println(tl);
        tl.lisaa("Imuroi");
        System.out.println(tl);
    }

}
