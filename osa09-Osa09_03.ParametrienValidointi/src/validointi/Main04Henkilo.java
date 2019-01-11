/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validointi;

import java.util.Scanner;

/**
 *
 * @author einomies
 */
public class Main04Henkilo {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Anna henkilön nimi: ");
        String nimi = scanner.nextLine();
        System.out.print("Anna henkilön ikä: ");
        int ika = Integer.parseInt(scanner.nextLine());
        Henkilo henkilo = new Henkilo(nimi, ika);
        
        System.out.println(henkilo);
    }

}
