package makihyppy;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        Kilpailu kilpailu = new Kilpailu();
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(lukija, kilpailu);
        kayttoliittyma.kaynnista();
    }

}
