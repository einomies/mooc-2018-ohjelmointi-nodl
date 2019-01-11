
import java.util.ArrayList;

public class Paaohjelma {

    public static void main(String[] args) {
        ArrayList<Paivays> lista = new ArrayList<>();
        for (int i = 1; i < 33; i++) {
            lista.add(new Paivays(i, 1, 2018));
        }
        tulostaLista(lista);
    }

    private static void tulostaLista(ArrayList<Paivays> lista) {
        int i = 0;
        for (Paivays paivays : lista) {
            System.out.println("------------------------");
            System.out.println("paivays " +i);
            System.out.println("toString(): " +paivays);
            System.out.println("hashCode(): " +paivays.hashCode());
            i++;
        }
    }
}
