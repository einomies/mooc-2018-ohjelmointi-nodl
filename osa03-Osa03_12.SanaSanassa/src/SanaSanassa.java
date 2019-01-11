
import java.util.Scanner;

public class SanaSanassa {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        
        System.out.print("Anna 1. sana: ");
        String merkkijono = lukija.nextLine();

        System.out.print("Anna 2. sana: ");
        String etsittava = lukija.nextLine();
        
        int indeksi = merkkijono.indexOf(etsittava);

        if (indeksi > -1) {
            System.out.println("Sana '" +etsittava +"' on sanan '" +merkkijono +"' osana");
        } else {
            System.out.println("Sana '" +etsittava +"' ei ole sanan '" +merkkijono +"' osana");
        }
    }
}
