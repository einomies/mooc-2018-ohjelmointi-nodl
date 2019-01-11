
import java.util.ArrayList;

public class Main {

    /*
    Tee metodi public static boolean esiintyykoListallaKolmesti(ArrayList<Integer> luvut, int luku),
    joka palauttaa arvon true jos luku esiintyy listalla tasan kolme kertaa, muuten arvon false.
     */

    public static void main(String[] args) {

        ArrayList<Integer> lista = new ArrayList<>();
        for (int i = 0; i < 101; i++) {
            lista.add(i);
        }
        lista.add(99);
        lista.add(99);
        lista.add(99);

        tulostaLista(lista);

        System.out.println();

        int luku = 99;
        System.out.println("Haettava luku: " + luku);
        if (esiintyykoListallaKolmesti(lista, luku)) {
            System.out.println("Luku " + luku + " löytyy listalta 3 kertaa");
        } else {
            System.out.println("Lukua " + luku + " ei löydy listalta 3 kertaa");
        }
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
