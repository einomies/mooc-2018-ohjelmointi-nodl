
import java.util.Scanner;

public class Main {
    /*
    Parittoman pituisissa palindromeissa on jakajamerkki.
    Toteuta ohjelma, joka selvittää palindromin jakajamerkin.
    
    Syöte: saippuakauppias
    Palindromin jakajamerkki on k
    
    Syöte: saippuakivikauppias
    Palindromin jakajamerkki on v
    
    Syöte: aa
    Ei jakajamerkkiä
    
    Syöte: nauris
    Ei palindromi
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Syöte: ");
        String merkkijono = scanner.nextLine();
        
        String jakajamerkki;

        System.out.println();

        if (onPalindromi(merkkijono)) {
            System.out.println("Syöte on palindromi");
            if (pituusPariton(merkkijono)) {
                System.out.println("Palindromin pituus on pariton");
                jakajamerkki = haeJakajamerkki(merkkijono);
                System.out.println("Palindromin jakajamerkki on " +jakajamerkki);
            } else {
                System.out.println("Palindromin pituus on parillinen");
                System.out.println("Ei jakajamerkkiä");
            }
        } else {
            System.out.println("Syöte ei ole palindromi");
        }
    }

    private static boolean onPalindromi(String merkkijono) {
        int j = merkkijono.length() - 1;
        for (int i = 0; i < merkkijono.length(); i++) {
            if (!merkkijono.substring(i, i + 1).equals(merkkijono.substring(j, j + 1))) {
                return false;
            }
            j--;
        }
        return true;
    }

    private static boolean pituusPariton(String merkkijono) {
        if (merkkijono.length() % 2 == 0) {
            return false;
        }
        return true;
    }

    private static String haeJakajamerkki(String merkkijono) {
        int alku = merkkijono.length() / 2;
        int loppu = merkkijono.length() / 2 + 1;
        System.out.println(alku +" - " +loppu);
        return merkkijono.substring(alku, loppu);
    }

}
