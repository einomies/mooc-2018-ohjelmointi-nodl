package rajatut;

import java.util.ArrayList;
import java.util.Scanner;

public class RajatutLuvut {

    public static void main(String[] args) {

        Scanner lukija = new Scanner(System.in);
//        ArrayList<Integer> lista = new ArrayList<>();
        ArrayList<Integer> lista = luoLista();
        int luku = 0;

//        while (true) {
//            System.out.print("luku: ");
//            luku = Integer.parseInt(lukija.nextLine());
//            if (luku < 0) {
//                break;
//            }
//            lista.add(luku);
//        }
//        System.out.println("\nSyötetyt luvut:");
//        lista.stream().forEach(s -> System.out.println(s));
        final int min = 1;
        final int max = 5;

        System.out.println("\nLuvut väliltä " + min + " - " + max + ":");
        lista.stream()
                .filter(i -> i >= min)
                .filter(i -> i <= max)
                .forEach(s -> System.out.println(s));
    }

    private static ArrayList<Integer> luoLista() {
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(0);
        lista.add(1);
        lista.add(2);
        lista.add(4);
        lista.add(5);
        lista.add(6);
        lista.add(77);
        lista.add(-1);
        return lista;
    }
}
/*
package rajatut;

import java.util.ArrayList;
import java.util.Scanner;

public class RajatutLuvut {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        ArrayList<Integer> luetut = new ArrayList<>();
        while (true) {
            int luettu = Integer.parseInt(lukija.nextLine());
            if (luettu < 0) {
                break;
            }
            luetut.add(luettu);
        }
        luetut.stream().filter(luku -> luku >= 1 && luku <= 5).forEach(luku -> System.out.println(luku));
    }
}
*/