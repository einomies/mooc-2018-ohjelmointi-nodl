import java.util.ArrayList;
import java.util.Scanner;

public class LoytyykoListalta {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        ArrayList<String> lista = new ArrayList<>();
        
        while (true) {
            String luettu = lukija.nextLine();
            if (luettu.equals("")) {
                break;
            }

            lista.add(luettu);
        }

        /*
        lista.add("Eikka");
        lista.add("Terhi");
        lista.add("Arttu");
        lista.add("Otso");
        lista.add("Sachi");
        lista.add("Nemo");
        lista.add("Hertta");
        lista.add("aaaaa08");
        lista.add("aaaaa09");
        lista.add("aaaaa10");
        lista.add("aaaaa11");
        lista.add("aaaaa12");
        
        for (String s : lista) {
            System.out.println(s);
        }
        */
        
        System.out.println("Ketä etsitään? ");
        String haettava = lukija.nextLine();
        
        if (lista.contains(haettava)) {
            System.out.println(haettava +" löytyi!");
        } else {
            System.out.println(haettava +" ei löytynýt!");
        }
    }

}
