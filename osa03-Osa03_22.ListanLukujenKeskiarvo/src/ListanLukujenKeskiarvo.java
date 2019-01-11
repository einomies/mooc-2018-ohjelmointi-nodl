
import java.util.ArrayList;
import java.util.Scanner;

public class ListanLukujenKeskiarvo {

    // toteuta tänne ohjelma, joka ensin lukee käyttäjältä
    // lukuja listalle kunnes käyttäjä syöttää luvun -1.
    // ohjelma laskee tämän jälkeen listalla olevien lukujen
    // keskiarvon, ja tulostaa sen käyttäjän näkyville

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        ArrayList<Integer> lista = new ArrayList<>();
        while (true) {
            int luettu = Integer.parseInt(lukija.nextLine());
            if (luettu == -1) {
                break;
            }
            lista.add(luettu);
        }

        System.out.println("");

        int summa=0;
        int lkm=0;
        double keskiarvo=0;
        for (Integer i : lista) {
            summa += i;
            lkm++;
        }
        keskiarvo = (double)summa/(double)lkm;
        System.out.println("Keskiarvo: " +keskiarvo);
        
        /*
        Vaihtoehtoinen tapa:
        int summa = 0;
        int indeksi = 0;

        while (indeksi < lista.size()) {
            summa += lista.get(indeksi);
            indeksi++;
        }
        System.out.println("Keskiarvo: " + (1.0 * summa / lista.size()));
        */
    }
}
