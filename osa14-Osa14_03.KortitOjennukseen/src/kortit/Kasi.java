/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kortit;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author einomies
 */
public class Kasi implements Comparable<Kasi> {

    private ArrayList<Kortti> kortit;

    public Kasi() {
        this.kortit = new ArrayList<>();
    }

    public void lisaa(Kortti kortti) {
        this.kortit.add(kortti);
    }

    public void tulosta() {
        this.kortit.stream().forEach(kortti -> System.out.println(kortti));
    }

    public void jarjesta() {
        Collections.sort(this.kortit);
    }

    public void jarjestaMaittain() {
        SamatMaatVierekkainArvojarjestykseen smva = new SamatMaatVierekkainArvojarjestykseen();
        Collections.sort(this.kortit, smva);
    }

    @Override
    public int compareTo(Kasi vertailtava) {
        int summaThis = this.kortit.stream()
                .map(kortti -> kortti.getArvo())
                .reduce(0, Integer::sum);
        int summaVertailtava = vertailtava.kortit.stream()
                .map(kortti -> kortti.getArvo())
                .reduce(0, Integer::sum);
        return summaThis - summaVertailtava;
    }

}

/*
package kortit;

import java.util.ArrayList;
import java.util.Collections;

public class Kasi implements Comparable<Kasi> {

    private ArrayList<Kortti> kortit;

    public Kasi() {
        this.kortit = new ArrayList<>();
    }

    public void lisaa(Kortti kortti) {
        kortit.add(kortti);
    }

    public void tulosta() {
        for (Kortti kortti : kortit) {
            System.out.println(kortti);
        }
    }

    public void jarjesta() {
        Collections.sort(kortit);
    }

    public void jarjestaMaittain() {
        Collections.sort(kortit, new SamatMaatVierekkainArvojarjestykseen());
    }

    private int arvojenSumma() {
        int summa = 0;
        for (Kortti kortti : kortit) {
            summa += kortti.getArvo();
        }
        return summa;
    }

    @Override
    public int compareTo(Kasi kasi) {
        return this.arvojenSumma() - kasi.arvojenSumma();
    }
}
*/