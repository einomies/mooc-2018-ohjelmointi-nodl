import java.util.Scanner;

public class Loppuosa {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        
        System.out.print("Anna sana: ");
        String merkkijono = lukija.nextLine();
        
        System.out.print("Loppuosan pituus: ");
        int loppuosaPituus = Integer.parseInt(lukija.nextLine());
        
        System.out.println("Tulos: " +merkkijono.substring(merkkijono.length()-loppuosaPituus));
    }
    /*
    Vaihtoehtoinen tapa:
    
    public static void main(String[] args) {

        Scanner lukija = new Scanner(System.in);

        System.out.print("Anna sana: ");
        String sana = lukija.nextLine();

        System.out.print("Loppuosan pituus: ");
        int lopunPituus = Integer.parseInt(lukija.nextLine());

        int alkukohta = sana.length() - lopunPituus;

        System.out.print("Tulos: " + sana.substring(alkukohta, sana.length()));
    }
    */

}
