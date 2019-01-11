import java.util.Scanner;

public class PaaohjelmaIkuinenKello {
    public static void main(String[] args) throws Exception {
        YlhaaltaRajoitettuLaskuri sekunnit = new YlhaaltaRajoitettuLaskuri(59);
        YlhaaltaRajoitettuLaskuri minuutit = new YlhaaltaRajoitettuLaskuri(59);
        YlhaaltaRajoitettuLaskuri tunnit = new YlhaaltaRajoitettuLaskuri(23);

        sekunnit.asetaArvo(50);
        minuutit.asetaArvo(59);
        tunnit.asetaArvo(23);

        while (true) {
            System.out.println(tunnit + ":" + minuutit + ":" + sekunnit);
            Thread.sleep(1000);
            sekunnit.seuraava();
            if (sekunnit.arvo() == 0) {
                minuutit.seuraava();
                if (minuutit.arvo() == 0) {
                    tunnit.seuraava();
                }
            }
        }
    }
}
