
import java.util.ArrayList;
import java.util.Scanner;

public class PienimmanLuvunIndeksi {

    // toteuta tänne ohjelma, joka lukee käyttäjältä lukuja kunnes
    // käyttäjä syöttää luvun 9999

    // tämän jälkeen ohjelma tulostaa pienimmän luvun sekä sen indeksin
    // -- pienin luku voi esiintyä useammassa indeksissä
    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        ArrayList<Integer> lista = new ArrayList<>();
        while (true) {
            int luettu = Integer.parseInt(lukija.nextLine());
            if (luettu == 9999) {
                break;
            }
            lista.add(luettu);
        }
        int pienin = lista.get(0);
        int indeksi = 0;

        while (indeksi < lista.size()) {
            if (lista.get(indeksi) < pienin) {
                pienin = lista.get(indeksi);
            }
            indeksi++;
        }
        System.out.println("Pienin luku on " +pienin);
        
        indeksi = 0;
        while (indeksi < lista.size()) {
            if (lista.get(indeksi) == pienin) {
                System.out.println("Pienin luku löytyy indeksistä " +indeksi);
            }
            indeksi++;
        }
    }

}
