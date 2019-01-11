/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validointi;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author einomies
 */
public class Main01 {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        testi01(scanner);

        System.out.println("Ohjelma ajettu");
    }

    private static int testi01(Scanner scanner) {
//        int luku = scanner.nextInt();
        int luku = 0;
        while (true) {
            System.out.print("Anna kokonaisluku: ");
            try {
                luku = Integer.parseInt(scanner.nextLine());
                return luku;
            } catch (Exception e) {
                System.out.println("Et syöttänyt kokonaislukua");
            }
        }
    }

}
