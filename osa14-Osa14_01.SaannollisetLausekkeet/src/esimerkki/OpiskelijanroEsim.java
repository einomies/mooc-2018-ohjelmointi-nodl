/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esimerkki;

import java.util.Scanner;

/**
 *
 * @author einomies
 */
public class OpiskelijanroEsim {

    public static void main(String[] args) {

        Scanner lukija = new Scanner(System.in);

        System.out.print("Anna opiskelijanumero: ");
        String numero = lukija.nextLine();

        if (numero.matches("01[0-9]{7}")) {
            System.out.println("Muoto on oikea.");
        } else {
            System.out.println("Muoto ei ole oikea.");
        }
    }

}
