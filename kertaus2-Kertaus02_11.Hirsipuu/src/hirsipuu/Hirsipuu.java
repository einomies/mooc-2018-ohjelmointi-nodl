package hirsipuu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hirsipuu {

    private Sanalista sanalista;
    private int arvauksiaJaljella;
    private String arvattava;

    public Hirsipuu(Sanalista sanalista, int arvauksiaAlussa) {
        this.sanalista = sanalista;
        this.arvauksiaJaljella = arvauksiaAlussa;

        Collections.shuffle(this.sanalista.sanat());
        this.arvattava = this.sanalista.sanat().get(0);
    }

    public List<Character> arvaukset() {
        return null;
    }

    public int arvauksiaJaljella() {
        return 0;
    }

    public boolean arvaa(Character kirjain) {
        return false;
    }

    public String sana() {
        return "-----";
    }

    public String oikeaSana() {
        return "hiiri";
    }

    public boolean onLoppu() {
        return false;
    }

}
