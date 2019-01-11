
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    /*
    Fibonaccin luvut ovat lukuja, jotka ovat aina kahden edeltävän luvun summa.
    Ensimmäiset kaksi lukua ovat 1 ja 1, jota seuraa luvut 2, 3, 5, 8 jne.
    Toteuta ohjelma, joka tulostaa halutun määrän Fibonaccin lukuja.
    
    Montako lukua tulostetaan: 11
    1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89
    */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int luvutLkm = 0;
        System.out.print("Montako lukua tulostetaan: ");
        luvutLkm = Integer.parseInt(scanner.nextLine());
        
        int edLuku = 1;
        int uusiLuku = 1;
        
        ArrayList<Integer> fibonacci = new ArrayList<>();
        
        for (int i = 0; i < luvutLkm; i++) {
            if (i < 2) {
                fibonacci.add(edLuku);
            } else {
                uusiLuku = fibonacci.get(i-1) + fibonacci.get(i-2);
                fibonacci.add(uusiLuku);
            }
        }

        String fibonacciString = "";
        for (int i = 0; i < fibonacci.size(); i++) {
            if (i == fibonacci.size() - 1) {
                fibonacciString = fibonacciString +fibonacci.get(i);
            } else {
                fibonacciString = fibonacciString +fibonacci.get(i) +", ";
            }
        }
        System.out.println(fibonacciString);
    }

}
