package luetut;

import java.util.ArrayList;
import java.util.Scanner;

/*
Kirjoita ohjelma, joka lukee käyttäjältä merkkijonoja. Lukeminen tulee lopettaa,
kun käyttäjä syöttää tyhjän merkkijonon. Tulosta tämän jälkeen käyttäjän syöttämät
merkkijonot.

eka
toka
kolmas

eka
toka
kolmas
 */
public class LuettujenArvojenTulostaminen {

    public static void main(String[] args) {

        Scanner lukija = new Scanner(System.in);
        ArrayList<String> lista = new ArrayList<>();
        String merkkijono = "";

        while (true) {
            System.out.print("merkkijono: ");
            merkkijono = lukija.nextLine();
            if (merkkijono.isEmpty()) {
                break;
            }
            lista.add(merkkijono);
        }

        System.out.println("\nSyötetyt merkkijonot:");

        lista.stream().forEach(s -> System.out.println(s));
    }

}
