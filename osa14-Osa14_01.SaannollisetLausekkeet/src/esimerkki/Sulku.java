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
public class Sulku {

    public static void main(String[] args) {

        Scanner lukija = new Scanner(System.in);

        System.out.print("Kirjoita joku sanan auto yksikön taivutusmuoto: ");
        String sana = lukija.nextLine();

        if (sana.matches("auto(|n|a|ssa|sta|on|lla|lta|lle|na|ksi|tta)")) {
            System.out.println("Oikein meni! RRrakastan tätä kieltä!");
        } else {
            System.out.println("Taivutusmuoto ei ole oikea.");
        }
    }

}
