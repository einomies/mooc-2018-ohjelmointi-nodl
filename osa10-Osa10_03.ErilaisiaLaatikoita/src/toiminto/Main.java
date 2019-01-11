package toiminto;


import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author einomies
 */
public class Main {

    public static void main(String[] args) {
        Kayttoliittyma kayttolittyma = new Kayttoliittyma(new Scanner(System.in));
        kayttolittyma.lisaaToiminto(new Pluslasku());

        kayttolittyma.kaynnista();
        /*
Toiminnot:
        0: Lopeta
        1: Pluslasku
Valinta: 1
Anna ensimmäinen luku: 8
Anna toinen luku: 12
Lukujen summa on 20

Toiminnot:
        0: Lopeta
        1: Pluslasku
Valinta: 0
         */
    }

}
