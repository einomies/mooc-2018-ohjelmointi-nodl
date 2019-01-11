
import java.util.Scanner;

public class SilmukatLopetusMuistaminen {

    public static void main(String[] args) {
        final int lukuLopetus = -1;
        int lukuLkm = 0;
        int summa = 0;
        int parilliset = 0;
        int parittomat = 0;
        Scanner lukija = new Scanner(System.in);
        
        System.out.print("Syötä luvut:");
        
        while (true) {
            int luku = Integer.parseInt(lukija.nextLine());
            if (luku == lukuLopetus) {
                break;
            }
            summa += luku;
            lukuLkm++;
            
            if (luku % 2 == 0) {
                parilliset++;
            } else {
                parittomat++;
            }
        }
        
        System.out.println("Kiitos ja näkemiin!");
        System.out.println("Summa: " +summa);
        System.out.println("Lukuja: " +lukuLkm);
        
        double keskiarvo = (double)summa / (double)lukuLkm;
        System.out.println("Keskiarvo: " +keskiarvo);
        
        System.out.println("Parillisia: " +parilliset);
        System.out.println("Parittomia: " +parittomat);
    }
}
