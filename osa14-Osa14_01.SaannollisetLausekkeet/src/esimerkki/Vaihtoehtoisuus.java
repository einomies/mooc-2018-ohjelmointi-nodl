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
public class Vaihtoehtoisuus {

    public static void main(String[] args) {

        String merkkijono = "00";

        if (merkkijono.matches("00|111|0000")) {
            System.out.println("Merkkijonosta löytyi joku kolmesta vaihtoehdosta");
        } else {
            System.out.println("Merkkijonosta ei löytynyt yhtäkään vaihtoehdoista");
        }
    }

}
