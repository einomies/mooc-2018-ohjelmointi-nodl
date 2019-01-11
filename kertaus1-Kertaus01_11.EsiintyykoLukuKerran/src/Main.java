
import java.util.ArrayList;

public class Main {

    /*
    Tee metodi public static boolean esiintyykoListallaKerran(ArrayList<Integer> luvut, int luku),
    joka palauttaa arvon true jos luku esiintyy listalla kerran, muuten arvon false.
     */
    public static void main(String[] args) {

        ArrayList<Integer> lista = new ArrayList<>();
        for (int i = 0; i < 101; i++) {
            lista.add(i);
        }

        tulostaLista(lista);

        System.out.println();

        int luku = 99;
        System.out.println("Haettava luku: " + luku);
        if (esiintyykoListallaKerran(lista, luku)) {
            System.out.println("Luku " + luku + " löytyy listalta");
        } else {
            System.out.println("Lukua " + luku + " ei löydy listalta");
        }
    }

    public static boolean esiintyykoListallaKerran(ArrayList<Integer> luvut, int luku) {
        for (Integer lukuListalla : luvut) {
            if (luku == lukuListalla) {
                return true;
            }
        }
        return false;
    }

    private static void tulostaLista(ArrayList<Integer> lista) {
        for (Integer integer : lista) {
            System.out.println("luku: " + integer);
        }
    }

}
