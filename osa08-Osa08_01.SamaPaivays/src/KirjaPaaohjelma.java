
import java.util.ArrayList;

public class KirjaPaaohjelma {

    public static void main(String[] args) {
        /*
    	Kirja olioKirja01 = new Kirja("Oliokirja", 2000);
//    	Kirja olioKirja02 = olioKirja01;
    	Kirja olioKirja02 = new Kirja("Oliokirja", 2000);

    	System.out.println("olioKirja01: " +olioKirja01);
    	System.out.println("olioKirja02: " +olioKirja02);

    	if (olioKirja01.equals(olioKirja02)) {
    	    System.out.println("Kirjat olivat samat");
    	} else {
    	    System.out.println("Kirjat eivät olleet samat");
    	}
         */
        ArrayList<Kirja> kirjat = new ArrayList<>();
        Kirja olioKirja = new Kirja("Oliokirja", 2000);
        kirjat.add(olioKirja);

        if (kirjat.contains(olioKirja)) {
            System.out.println("Oliokirja löytyi.");
        }

        olioKirja = new Kirja("Oliokirja", 2000);

        if (!kirjat.contains(olioKirja)) {
            System.out.println("Oliokirjaa ei löytynyt.");
        }
    }

}
