import java.util.Scanner;

public class Alkuosa {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        
        System.out.print("Anna sana: ");
        String merkkijono = lukija.nextLine();
        
        System.out.print("Alkuosan pituus: ");
        int alkuosaPituus = Integer.parseInt(lukija.nextLine());
        
        System.out.println("Tulos: " +merkkijono.substring(0, alkuosaPituus));
    }
}
