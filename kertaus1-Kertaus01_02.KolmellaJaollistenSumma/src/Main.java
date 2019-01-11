
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        int luku = 0;
        ArrayList<Integer> lista = new ArrayList<>();
        
        while (true) {
            System.out.print("Luku: ");
            String syote = scanner.nextLine();
            if (syote.isEmpty()) {
                break;
            }
            lista.add(Integer.parseInt(syote));
        }
        
        System.out.println();
        int summa = 0;
        
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i) % 3 == 0) {
                summa = summa + lista.get(i);
            }
        }
        
        if (summa > 0) {
            System.out.println("Kolmella jaollisten lukujen summa: " +summa);
        } else {
            System.out.println("Ei kolmella jaollisia lukuja");
        }
        
    }

}
