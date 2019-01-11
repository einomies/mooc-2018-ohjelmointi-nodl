
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MittauksetTiedostosta {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        System.out.print("Tiedosto? ");
        String tiedosto = lukija.nextLine();
        
        System.out.print("Alaraja? ");
        int alaraja = Integer.parseInt(lukija.nextLine());
        
        System.out.print("Yläraja? ");
        int ylaraja = Integer.parseInt(lukija.nextLine());
        
        int lukuja = 0;

        try (Scanner tiedostonLukija = new Scanner(new File(tiedosto))) {
            while (tiedostonLukija.hasNextLine()) {
                int luku = Integer.parseInt(tiedostonLukija.nextLine());
                if (luku>=alaraja && luku<=ylaraja) {
                    lukuja++;
                }
            }
            System.out.println("Lukuja: " +lukuja);
        } catch (IOException ex) {
            System.out.println("Tiedoston " + tiedosto + " lukeminen epäonnistui.");
        }
    }

}
