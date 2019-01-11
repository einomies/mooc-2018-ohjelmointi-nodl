
import java.util.ArrayList;
import java.util.HashMap;

public class KirjaHashMapPaaohjelma {

    public static void main(String[] args) {
        HashMap<Kirja, String> lainaajat = new HashMap<>();

        Kirja oliokirja = new Kirja("Oliokirja", 2000);
        lainaajat.put(oliokirja, "Pekka");
        lainaajat.put(new Kirja("Test Driven Development", 1999), "Arto");

        System.out.println(lainaajat.get(oliokirja));
        System.out.println(lainaajat.get(new Kirja("Oliokirja", 2000)));
        System.out.println(lainaajat.get(new Kirja("Test Driven Development", 1999)));
    }

}
