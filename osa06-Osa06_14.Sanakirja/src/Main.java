import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        Sanakirja sanakirja = new Sanakirja();

        Tekstikayttoliittyma kayttoliittyma = new Tekstikayttoliittyma(lukija, sanakirja);
        kayttoliittyma.kaynnista();
    }
}

/*
import java.util.Scanner;

public class Main {

public static void main(String[] args) {

    String syote = "kaanna\n" + "apina\n" +
                 "kaanna\n" + "juusto\n" +
                 "lisaa\n" + "juusto\n" + "cheese\n" +
                 "kaanna\n" + "juusto\n" +
                 "lopeta\n";
    Scanner lukija = new Scanner(syote);
    Sanakirja sanakirja = new Sanakirja();
    Tekstikayttoliittyma kayttoliittyma = new Tekstikayttoliittyma(lukija, sanakirja);
    kayttoliittyma.kaynnista();
    }
}
*/