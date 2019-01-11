import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // toteuta luokkaa Ohjelma käyttävä ohjelmasi tänne
        
        ArrayList<Ohjelma> ohjelmat = new ArrayList<>();
        Scanner lukija = new Scanner(System.in);
        
        String nimi = "";
        int pituus = 0;
        
        while (true) {
            System.out.print("Nimi: ");
        	nimi = lukija.nextLine();
            if (nimi.equals("")) {
            	break;
            } else {
                System.out.print("Pituus: ");
                pituus = Integer.parseInt(lukija.nextLine());
                ohjelmat.add(new Ohjelma(nimi, pituus));
            }
        }
        
//        ohjelmat.add(new Ohjelma("aaaaa", 110));
//        ohjelmat.add(new Ohjelma("bbbbb", 120));
//        ohjelmat.add(new Ohjelma("ccccc", 130));
//        ohjelmat.add(new Ohjelma("ddddd", 140));
//        ohjelmat.add(new Ohjelma("eeeee", 150));
//        ohjelmat.add(new Ohjelma("fffff", 160));
        
//        System.out.println("\nohjelmat:");
//        for (Ohjelma ohjelma : ohjelmat) {
//            System.out.println(ohjelma.toString());
//        }
        
//      Kysytään ohjelman maksimipituutta. Tulostetaan kaikki ne ohjelmat, joiden
//      pituus on pienempi tai yhtäsuuri kuin haluttu maksimipituus.
        
        System.out.println("");
        System.out.println("Ohjelman maksimipituus? ");
        int maxPituus = Integer.parseInt(lukija.nextLine());
        		
//      Salatut elämät, 30 minuuttia
//      Miehen puolikkaat, 30 minuuttia
        
        System.out.println("ohjelmat, joiden pituus max " +maxPituus +" min:");
        for (Ohjelma ohjelma : ohjelmat) {
            if (ohjelma.getPituus() <= maxPituus) {
                System.out.println(ohjelma.toString());
            }
        }
    }
}
