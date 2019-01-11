
import java.util.ArrayList;

public class Main {

    /*
    Tee metodi public static boolean loytyykoLuvutValilta(ArrayList<Integer> luvut, int alku, int loppu),
    joka palauttaa arvon true jos listalla löytyy kaikki luvut lukujen alku ja loppu väliltä, muuten metodi palauttaa arvon false.
     */

    public static void main(String[] args) {

        ArrayList<Integer> lista = new ArrayList<>();
        for (int i = 0; i < 21; i++) {
            lista.add(i);
        }
        lista.add(99);
        lista.add(99);
        lista.add(99);

        tulostaLista(lista);

        System.out.println();

        int lukuAlku = 15;
        int lukuLoppu = 19;
        System.out.println("Lukuväli alku: " + lukuAlku);
        System.out.println("Lukuväli loppu: " + lukuLoppu);
        if (loytyykoLuvutValilta(lista, lukuAlku, lukuLoppu)) {
            System.out.println("Kaikki luvut väliltä " +lukuAlku +"-" +lukuLoppu +" löytyvät listalta");
        } else {
            System.out.println("Kaikkia lukuja väliltä " +lukuAlku +"-" +lukuLoppu +" ei löydy listalta");
        }
    }

    public static boolean loytyykoLuvutValilta(ArrayList<Integer> luvut, int alku, int loppu) {
        
        for (int i = alku; i <= loppu; i++) {
            if (!luvut.contains(i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean esiintyykoListallaKolmesti(ArrayList<Integer> luvut, int luku) {
        if (montakoKertaaListalla(luvut, luku) == 3) {
            return true;
        } else {
            return false;
        }
    }

    public static int montakoKertaaListalla(ArrayList<Integer> luvut, int luku) {
        int lkm = 0;
        for (Integer lukuListalla : luvut) {
            if (luku == lukuListalla) {
                lkm++;
            }
        }
        return lkm;
    }
    
    private static void tulostaLista(ArrayList<Integer> lista) {
        for (Integer integer : lista) {
            System.out.println("luku: " + integer);
        }
    }

}
