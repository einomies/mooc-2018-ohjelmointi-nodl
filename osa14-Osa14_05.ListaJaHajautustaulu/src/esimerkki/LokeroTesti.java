package esimerkki;

public class LokeroTesti {

    public static void main(String[] args) {
        // testi01();
        testi02();
        testi03();
    }

    private static void testi01() {
        Lokero<String> merkkijono = new Lokero<>();
        merkkijono.asetaArvo(":)");
        System.out.println(merkkijono.haeArvo());
    }

    private static void testi02() {
        Lokero<Integer> luku = new Lokero<>();
        luku.asetaArvo(5);
        System.out.println(luku.haeArvo());
    }

    private static void testi03() {
    }

}
