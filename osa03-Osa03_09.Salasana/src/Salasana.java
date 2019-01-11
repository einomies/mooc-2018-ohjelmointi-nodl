
import java.util.Scanner;

public class Salasana {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        String salasana = "porkkana"; // käytä porkkanaa salasananatestejä ajaessasi!
        String merkkijono = "";
        
        while (!merkkijono.equals(salasana)) {
            System.out.print("Anna salasana: ");
            merkkijono = lukija.nextLine();
        
            if (merkkijono.equals(salasana)) {
                break;
            } else {
                System.out.println("Väärin!");
            }
        }
        System.out.println("Oikein!");
        System.out.println("");
        System.out.println("Salaisuus on: znvavbfgv grugl!");
    }
    /*
    Vaihtoehtoinen while-rakenne:
    
    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        String salasana = "porkkana"; // käytä porkkanaa salasanana testejä ajaessasi!

        while (true) {
            System.out.print("Anna salasana: ");
            String luettuSalasana = lukija.nextLine();

            if (luettuSalasana.equals(salasana)) {
                break;
            }
            System.out.println("Väärin!");
        }

        System.out.println("Oikein!");
        System.out.println(""); // rivinvaihto
        System.out.println("Salaisuus on: znvavbfgv grugl!");
    }
    */
}
