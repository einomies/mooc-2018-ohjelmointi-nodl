import java.util.ArrayList;
import java.util.Scanner;

public class ListanLukujenSumma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        // älä koske tässä olevaan koodiin
        ArrayList<Integer> lista = new ArrayList<>();
//        ArrayList<Integer> lista = teeLista();
        while (true) {
            int luettu = Integer.parseInt(lukija.nextLine());
            if (luettu == -1) {
                break;
            }

            lista.add(luettu);
        }

        System.out.println("");

        // toteuta listan lukujen summan laskeminen tänne
        int summa=0;
        for (Integer i : lista) {
            summa += i;
        }
        System.out.println("Summa: " +summa);
    }

    private static ArrayList<Integer> teeLista() {
        ArrayList<Integer> lista = new ArrayList<>();
        
        lista.add(1);
        lista.add(2);
        lista.add(3);
//        lista.add(4);
//        lista.add(5);
//        lista.add(6);
//        lista.add(7);
//        lista.add(8);
//        lista.add(9);
        
        System.out.println("Lista luotu, listan koko: " +lista.size());

//        for (String s : lista) {
//            System.out.println(s);
//        }

        return lista;
    }
}
