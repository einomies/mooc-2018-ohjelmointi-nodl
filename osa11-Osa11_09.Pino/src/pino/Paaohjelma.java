package pino;

public class Paaohjelma {

    public static void main(String[] args) {
        testi(01);
    }

    private static void testi(int i) {
        Pino p = new Pino();
        p.lisaa("    *");
        p.lisaa("*********");
        p.lisaa(" *******");
        p.lisaa("  *****");
        p.lisaa("   ***");
        p.lisaa("    *");

        while (p.koko() > 0) {
            System.out.println(p.poista());
        }
    }
}
