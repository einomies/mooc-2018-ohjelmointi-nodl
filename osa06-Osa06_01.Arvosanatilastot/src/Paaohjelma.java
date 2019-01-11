import java.util.Scanner;

public class Paaohjelma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        // Tee sovelluksesi tänne -- kannattaa harkita sovelluksen pilkkomista
        // useampaan luokkaan.
        Arvosana arvosana = new Arvosana();
        System.out.println("Syötä yhteispisteet, -1 lopettaa:");
        while (true) {
            int luku = Integer.parseInt(lukija.nextLine());
            if (luku == -1) {
                break;
            }
            arvosana.setPisteet(luku);
        }
        System.out.println("Pisteiden keskiarvo (kaikki): " +arvosana.keskiarvo());
        if (arvosana.lkmHyv() > 0) {
            System.out.println("Pisteiden keskiarvo (hyväksytyt): " +arvosana.keskiarvoHyv());
        } else {
            System.out.println("Pisteiden keskiarvo (hyväksytyt): -");
        }
        System.out.println("Hyväksymisprosentti: " +arvosana.prosenttiHyv());
        System.out.println("Arvosanajakauma:");
        System.out.println("5: " +tulostaTahdet(arvosana.lkmA5()));
        System.out.println("4: " +tulostaTahdet(arvosana.lkmA4()));
        System.out.println("3: " +tulostaTahdet(arvosana.lkmA3()));
        System.out.println("2: " +tulostaTahdet(arvosana.lkmA2()));
        System.out.println("1: " +tulostaTahdet(arvosana.lkmA1()));
        System.out.println("0: " +tulostaTahdet(arvosana.lkmA0()));
    }
    
    public static String tulostaTahdet(int tahtia) {
        String tahdet = "";
        for (int i = 0; i < tahtia; i++) {
            tahdet = tahdet+"*";
        }
        return tahdet;
    }

}
