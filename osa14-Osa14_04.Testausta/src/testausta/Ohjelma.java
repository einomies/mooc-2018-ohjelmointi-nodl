package testausta;

import java.util.ArrayList;
import java.util.Scanner;

public class Ohjelma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        // suorita(lukija);
        System.out.println(suorita(new Scanner("4\nx\n2\n1\n-1\n")));
        // System.out.println(suorita(lukija));
    }

    public static String mitasMitas(String kysely) {
        return "No mitäs mitäs?";
    }

    public static String suorita(Scanner lukija) {

        String merkkijono = "";
        ArrayList<Integer> rivit = new ArrayList<>();

        while (lukija.hasNext()) {
            String rivi = lukija.next();
            if (rivi.equals("-1")) {
                break;
            }
            if (onKokonaisluku(rivi)) {
                rivit.add(Integer.parseInt(rivi));
            }
        }

        String keskiarvoTulos = "";
        int pullotLkm = 0, oppilaatLkm = 0;
        double keskiarvo = 0;
        int luku = 0;

        for (int i = 0; i < rivit.size(); i++) {
            luku = rivit.get(i);
            if (luku >= 0) {
                pullotLkm += luku;
                oppilaatLkm++;
            }
        }

        if (pullotLkm > 0) {
            keskiarvo = (double) pullotLkm / (double) oppilaatLkm;
            keskiarvoTulos = "Keskiarvo: " + keskiarvo;
        } else {
            keskiarvoTulos = "Keskiarvoa ei voida laskea";
        }
        return "Pulloja: " + pullotLkm + "\nOppilaita: " + oppilaatLkm + "\n" + keskiarvoTulos;
    }

    private static boolean onKokonaisluku(String str) {
        return str.matches("-?\\d+");
    }

}
