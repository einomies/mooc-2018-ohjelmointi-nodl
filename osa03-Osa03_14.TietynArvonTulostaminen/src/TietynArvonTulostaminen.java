import java.util.ArrayList;
import java.util.Scanner;

public class TietynArvonTulostaminen {

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
        lista.add("xxxxxxxx01");
        lista.add("xxxxxxxx02");
        lista.add("xxxxxxxx03");
        lista.add("xxxxxxxx04");
        lista.add("xxxxxxxx05");
        lista.add("xxxxxxxx06");
        lista.add("xxxxxxxx07");
        lista.add("xxxxxxxx08");
        lista.add("xxxxxxxx09");
        lista.add("xxxxxxxx10");
        */
        
        System.out.println(lista.get(2));
    }
}
