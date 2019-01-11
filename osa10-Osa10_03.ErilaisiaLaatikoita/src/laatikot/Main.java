package laatikot;

public class Main {

    public static void main(String[] args) {
//        testi01();
//        testi02();
        testi03();
//        testi04();
//        testi05();
    }

    private static void testi01() {
        MaksimipainollinenLaatikko kahviLaatikko = new MaksimipainollinenLaatikko(14);
        kahviLaatikko.lisaa(new Tavara("Saludo", 5));
        kahviLaatikko.lisaa(new Tavara("Pirkka", 5));
        kahviLaatikko.lisaa(new Tavara("Pirkka", 4));
        kahviLaatikko.lisaa(new Tavara("Kopi Luwak", 5));

        System.out.println(kahviLaatikko.onkoLaatikossa(new Tavara("Saludo")));
        System.out.println(kahviLaatikko.onkoLaatikossa(new Tavara("Pirkka")));
        System.out.println(kahviLaatikko.onkoLaatikossa(new Tavara("Pirkka")));
        System.out.println(kahviLaatikko.onkoLaatikossa(new Tavara("Kopi Luwak")));
        /*
        true
        true
        false
         */
    }

    private static void testi02() {
        YhdenTavaranLaatikko laatikko = new YhdenTavaranLaatikko();

        System.out.println(laatikko.onkoLaatikossa(new Tavara("Saludo")));

        laatikko.lisaa(new Tavara("Saludo", 5));
        laatikko.lisaa(new Tavara("Pirkka", 5));

        System.out.println(laatikko.onkoLaatikossa(new Tavara("Saludo")));
        System.out.println(laatikko.onkoLaatikossa(new Tavara("Pirkka")));
        /*
        false
        true
        false
         */
    }

    private static void testi03() {
        HukkaavaLaatikko laatikko = new HukkaavaLaatikko();
        laatikko.lisaa(new Tavara("Saludo", 5));
        laatikko.lisaa(new Tavara("Pirkka", 5));

        System.out.println(laatikko.onkoLaatikossa(new Tavara("Saludo")));
        System.out.println(laatikko.onkoLaatikossa(new Tavara("Pirkka")));
        /*
        false
        false
         */
    }

    private static void testi04() {
    }

    private static void testi05() {
    }

}
