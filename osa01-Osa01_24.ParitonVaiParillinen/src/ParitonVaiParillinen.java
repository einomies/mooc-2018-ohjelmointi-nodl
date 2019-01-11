
import java.util.Scanner;

public class ParitonVaiParillinen {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        // Toteuta ohjelmasi tähän. 
        
        // VIHJE:
        // parillisuuden voi selvittää helposti jakojäännösoperaattorilla %
        // kokeile mitä seuraavat komennot tulostavat
//        System.out.println("jakojäännös 1/2= " +1%2);
//        System.out.println("jakojäännös 2/2= " +2%2);
//        System.out.println("jakojäännös 3/2= " +3%2);
//        System.out.println("jakojäännös 4/2= " +4%2);
//        System.out.println("jakojäännös 5/2= " +5%2);4

//        System.out.println("jakojäännös 6/2= " +6%2);
//        System.out.println("jakojäännös 7/2= " +7%2);
//        int luku = 8;
//        System.out.println("jakojäännös "+luku+"/2= " +luku%2);
        // eli ottamalla luvusta kahden jakojäännöksen, selviää parillisuus!
        
        System.out.print("Anna luku: ");
        int luku = Integer.parseInt(lukija.nextLine());
        int jakojaannos = luku % 2;
        
        if (jakojaannos == 0) {
            System.out.println("Luku " + luku + " on parillinen.");
        } else {
            System.out.println("Luku " + luku + " on pariton.");
        }
    }
}
