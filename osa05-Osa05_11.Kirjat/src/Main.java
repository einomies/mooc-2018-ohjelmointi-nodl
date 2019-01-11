import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // toteuta tänne toiminnallisuus, jonka avulla käyttäjä voi syöttää
        // kirjoja sekä tarkastella niitä
    	Scanner lukija = new Scanner(System.in);
    	String komento="";
    	
    	ArrayList<Kirja> kirjat = new ArrayList<>();
//    	kirjat.add(new Kirja("Minä en sitten muutu", 201, 2010));
//    	kirjat.add(new Kirja("Nalle Puh ja elämisen taito", 100, 2005));
//    	kirjat.add(new Kirja("Beautiful Code", 593, 2007));
//    	kirjat.add(new Kirja("KonMari", 222, 2011));
//    	kirjat.add(new Kirja("Sinuhe egyptiläinen", 779, 1945));

    	String nimi = "";
    	int sivuja = 0;
    	int vuosi = 0;

    	while (true) {
            System.out.print("Nimi: ");
            nimi = lukija.nextLine();
            if (nimi.equals("")) {
            	break;
            } else {
                System.out.print("Sivuja: ");
                sivuja = Integer.parseInt(lukija.nextLine());
                System.out.print("Vuosi: ");
                vuosi = Integer.parseInt(lukija.nextLine());
                kirjat.add(new Kirja(nimi, sivuja, vuosi));
            }
        }

        System.out.println("");
        System.out.print("Mitä tulostetaan? ");
        komento = lukija.nextLine();

        for (Kirja kirja : kirjat) {
            if (komento.equalsIgnoreCase("kaikki")) {
                System.out.println(kirja);
            } else if (komento.equalsIgnoreCase("nimi")) {
                System.out.println(kirja.getNimi());
            }
    	}
    }

}
