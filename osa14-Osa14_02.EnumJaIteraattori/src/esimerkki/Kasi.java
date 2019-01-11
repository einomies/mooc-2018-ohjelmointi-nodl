/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esimerkki;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author einomies
 */
public class Kasi {

    private List<Kortti> kortit;

    public Kasi() {
        this.kortit = new ArrayList<>();
    }

    public void lisaa(Kortti kortti) {
        this.kortit.add(kortti);
    }

//    public void tulosta() {
//        this.kortit.stream().forEach(kortti -> {
//            System.out.println(kortti);
//        });
//    }
    public void tulosta() {
        Iterator<Kortti> iteraattori = kortit.iterator();

        while (iteraattori.hasNext()) {
            System.out.println(iteraattori.next());
        }
    }

}
