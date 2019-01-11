package otsikko;

import java.util.Scanner;
import javafx.application.Application;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Anna otsikko: ");
        String otsikko = scanner.nextLine();

        Application.launch(KayttajanOtsikko.class,
                "--otsikko=" + otsikko,
                "--organisaatio=Olipa kerran",
                "--kurssi=Otsikko");
    }

}
/*
package otsikko;

import java.util.Scanner;
import javafx.application.Application;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        Scanner lukija = new Scanner(System.in);
        System.out.println("Mikä otsikko laitetaan?");
        String otsikko = lukija.nextLine();
        Application.launch(KayttajanOtsikko.class, "--otsikko=" + otsikko);
    }
}
*/