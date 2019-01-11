
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    /*
    Kirjoita ohjelma, joka kysyy käyttäjältä syötettä ja kertoo sen jälkeen
    onko syöte palindromi.
    
    Syöte: saippuakauppias
    Syöte on palindromi
    
    Syöte: nakkikauppias
    Syöte ei ole palindromi
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Syöte: ");
        String merkkijono = scanner.nextLine();

        System.out.println();

        if (onPalindromi(merkkijono)) {
            System.out.println("Syöte on palindromi");
        } else {
            System.out.println("Syöte ei ole palindromi");
        }
    }

    private static boolean onPalindromi(String merkkijono) {
        int j = merkkijono.length() - 1;
        for (int i = 0; i < merkkijono.length(); i++) {
            if (!merkkijono.substring(i, i+1).equals(merkkijono.substring(j, j+1))) {
                return false;
            }
            j--;
        }
        return true;
    }

}
