package perintaa;

public class Main {

    public static void main(String[] args) {
//        testi01();
//        testi02();
        testi03();
    }

    private static void testi01() {
        Koira koira = new Koira();
        koira.hauku();
        koira.syo();

        Koira vuffe = new Koira("Vuffe");
        vuffe.hauku();
        /*
        Koira haukkuu
        Koira syo
        Vuffe haukkuu
         */
    }

    private static void testi02() {
        Kissa kissa = new Kissa();
        kissa.mourua();
        kissa.syo();
        kissa.nuku();

        Kissa karvinen = new Kissa("Karvinen");
        karvinen.mourua();
        /*
        Kissa mouruaa
        Kissa syo
        Kissa nukkuu
        Karvinen mouruaa
         */
    }

    private static void testi03() {
        Aanteleva koira = new Koira();
        koira.aantele();

        Aanteleva kissa = new Kissa("Karvinen");
        kissa.aantele();
        Kissa k = (Kissa) kissa;
        k.mourua();
        /*
        Koira haukkuu
        Karvinen mouruaa
        Karvinen mouruaa
         */
    }

}
