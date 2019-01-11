
import java.util.Scanner;

public class NimenPituus {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        System.out.print("Anna nimi: ");
        String merkkijono = lukija.nextLine();
        
        int lkm = laskeKirjaimet(merkkijono);
        System.out.println("Kirjainmäärä: " +lkm);
    }
    
    public static int laskeKirjaimet(String merkkijono) {
        return merkkijono.length();
    }
}
