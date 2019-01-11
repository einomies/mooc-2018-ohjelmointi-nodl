package esimerkki;

public class PariTesti {

    public static void main(String[] args) {
        testi01();
    }

    private static void testi01() {
        Pari<String, Integer> pari = new Pari<>("yksi", 1);
        System.out.println(pari.getAvain() + " -> " + pari.getArvo());
        //yksi -> 1
    }

}
