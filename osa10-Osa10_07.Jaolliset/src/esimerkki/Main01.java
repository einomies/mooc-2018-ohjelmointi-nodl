package esimerkki;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author einomies
 */
public class Main01 {

    public static void main(String[] args) {
        List<Integer> lista = new ArrayList<>();
        lista.add(3);
        lista.add(7);
        lista.add(4);
        lista.add(2);
        lista.add(6);

        System.out.println("ArrayList lista:" + lista);
        
        /*
        Valitaan listasta luvut, jotka ovat suurempia kuin 5, tässä tapauksessa
        siis 7 ja 6. Kerrotaan em. luvut kahdella ja viedään tulokset uuteen
        ArrayListiin.
         */
        ArrayList<Integer> luvut = lista.stream()
                .filter(luku -> luku > 5)
                .map(luku -> luku * 2)
                .collect(Collectors.toCollection(ArrayList::new));

        System.out.println("ArrayList luvut :" + luvut);
    }

}
