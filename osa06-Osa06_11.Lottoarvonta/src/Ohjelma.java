
import java.util.ArrayList;
import java.util.Collections;

public class Ohjelma {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            Lottorivi rivi = new Lottorivi();
            ArrayList<Integer> lottonumerot = rivi.numerot();
            Collections.sort(lottonumerot);

            int riviNro = i+1;
            System.out.print("Lottorivi " +riviNro +":  ");
            for (Integer numero : lottonumerot) {
                System.out.print(numero + " ");
            }
            System.out.println("");
        }
    }
}
