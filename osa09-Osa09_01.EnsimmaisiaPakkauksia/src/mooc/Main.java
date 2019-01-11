package mooc;

import mooc.logiikka.Sovelluslogiikka;
import mooc.ui.Kayttoliittyma;
import mooc.ui.Tekstikayttoliittyma;

public class Main {

    public static void main(String[] args) {
        testi01();
    }

    private static void testi01() {
        Kayttoliittyma kayttoliittyma = new Tekstikayttoliittyma();
        new Sovelluslogiikka(kayttoliittyma).suorita(3);
        /*
        Sovelluslogiikka toimii
        Päivitetään käyttöliittymää
        Sovelluslogiikka toimii
        Päivitetään käyttöliittymää
        Sovelluslogiikka toimii
        Päivitetään käyttöliittymää
         */
    }
}
