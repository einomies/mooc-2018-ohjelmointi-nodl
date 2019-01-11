package opiskelijat;

public class Paaohjelma {

    public static void main(String[] args) {
//        testi01();
        testi02();
    }

    private static void testi01() {
        Opiskelija eka = new Opiskelija("jamo");
        Opiskelija toka = new Opiskelija("jamo1");
        tulostaVertailu(eka, toka);
    }

    private static void testi02() {
        Opiskelija otso = new Opiskelija("Otso");
        Opiskelija arttu = new Opiskelija("Arttu");
        tulostaVertailu(otso, arttu);
        tulostaVertailu(arttu, otso);
    }

    private static void tulostaVertailu(Opiskelija eka, Opiskelija toka) {
        System.out.println(eka + " compareTo " + toka + ": " + eka.compareTo(toka));
    }

}
