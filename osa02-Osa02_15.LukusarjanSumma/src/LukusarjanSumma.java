
import java.util.Scanner;

public class LukusarjanSumma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        int luku = 1;
        int lukuMax;
        int tulos = 0;

        System.out.println("Mihin asti? ");
        lukuMax = Integer.parseInt(lukija.nextLine());

//        System.out.println("Mistä lähtien? ");
//        luku = Integer.parseInt(lukija.nextLine());

        while (luku <= lukuMax) {
            tulos += luku;
            luku++;
        }
        
        System.out.println("Summa on " +tulos);
    }
}
