import java.util.ArrayList;
import java.util.Scanner;
import javafx.beans.binding.When;

public class Varasto {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        ArrayList<String> lista = teeLista();
//        ArrayList<String> lista = new ArrayList<>();
        
        System.out.println("Varastonhallinta.");
        System.out.println("");

        String komento = "";
        String esine = "";
        
        while (!komento.equals("lopeta")) {
            System.out.println("Syötä komento (lisaa, poista, hae, lopeta):");
            komento = lukija.nextLine();
            
            if (komento.equals("hae")) {
                System.out.println("Syötä esine: ");
                esine = lukija.nextLine();
                haeEsine(esine, lista);
            }

            if (komento.equals("lisaa")) {
                System.out.println("Syötä esine: ");
                esine = lukija.nextLine();
                lisaaEsine(esine, lista);
            }

            if (komento.equals("poista")) {
                System.out.println("Syötä esine: ");
                esine = lukija.nextLine();
                poistaEsine(esine, lista);
            }
        }
    }

    private static ArrayList<String> teeLista() {
        ArrayList<String> lista = new ArrayList<>();
        
        lista.add("viritin");
        lista.add("kompressori");
        lista.add("phaser");
        lista.add("wah");
        lista.add("fuzz");
        lista.add("OD 1");
        lista.add("OD 2");
        lista.add("distortion 1");
        lista.add("distortion 2");
        lista.add("chorus");
        lista.add("tremolo");
        lista.add("vibe");
        lista.add("whammy");
        lista.add("syna");
        lista.add("delay");
        lista.add("reverb");
        
        System.out.println("Lista luotu, listan koko: " +lista.size());

//        for (String s : lista) {
//            System.out.println(s);
//        }

        return lista;
    }

    private static void haeEsine(String esine, ArrayList<String> lista) {
        if (lista.contains(esine)) {
            System.out.println("Esine " +esine +" löytyy varastosta.");
        } else {
            System.out.println("Esinettä " +esine +" ei löydy varastosta.");
        }
    }

    private static void lisaaEsine(String esine, ArrayList<String> lista) {
        if (!esine.isEmpty()) {
            if (lista.contains(esine)) {
                System.out.println("Esine " +esine +" on jo varastossa.");
            } else {
                lista.add(esine);
            }
        }
    }

    private static void poistaEsine(String esine, ArrayList<String> lista) {
        if (!esine.isEmpty()) {
            if (lista.contains(esine)) {
                lista.remove(esine);
            }
        }
    }

}
