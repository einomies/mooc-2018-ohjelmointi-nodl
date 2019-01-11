
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Luku: ");
        int luku = Integer.parseInt(scanner.nextLine());
        
        System.out.println();
        
        for (int i = 1; i < 11; i++) {
            System.out.println(i +" * " +luku +" = " +i*luku);
        }
    }

}
