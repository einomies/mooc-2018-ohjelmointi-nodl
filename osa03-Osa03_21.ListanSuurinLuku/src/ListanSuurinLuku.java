import java.util.ArrayList;
import java.util.Scanner;

public class ListanSuurinLuku {

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
        int suurin=0;
        for (Integer i : lista) {
            if (i>suurin) {
                suurin = i;
            }
        }
        System.out.println("Listan suurin luku: " +suurin);
        
        /*
        Vaihtoehtoinen tapa:
        int suurin = lista.get(0);
        int indeksi = 0;

        while (indeksi < lista.size()) {
            if(suurin < lista.get(indeksi)) {
                suurin = lista.get(indeksi);
            }
            indeksi++;
        }
        System.out.println("Listan suurin luku: " + suurin);
        */
    }
}
