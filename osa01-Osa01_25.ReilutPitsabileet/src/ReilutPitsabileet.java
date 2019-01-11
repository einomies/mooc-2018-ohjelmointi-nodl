
import java.util.Scanner;

public class ReilutPitsabileet {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        int osallistujat, pitsat, palatPerPitsa, jakojaannos, palatYht;
        /*
        Montako osallistujaa? 5
        Montako pitsaa? 2
        Montako palaa per pitsa? 6

        Paloja jää yli: 2
        */
        System.out.print("Montako osallistujaa? ");
        osallistujat = Integer.parseInt(lukija.nextLine());
        
        System.out.print("Montako pitsaa? ");
        pitsat = Integer.parseInt(lukija.nextLine());

        System.out.print("Montako palaa per pitsa? ");
        palatPerPitsa = Integer.parseInt(lukija.nextLine());
        
        palatYht = pitsat * palatPerPitsa;

        jakojaannos = (pitsat * palatPerPitsa) % osallistujat;
        
        System.out.println("");
        System.out.println("Paloja jää yli: " +jakojaannos);
    }
}
