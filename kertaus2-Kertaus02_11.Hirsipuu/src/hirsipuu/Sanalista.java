package hirsipuu;

import java.util.List;

public class Sanalista {

    private List<String> sanat;

    public Sanalista(List<String> sanat) {
        this.sanat = sanat;
    }

    public List<String> sanat() {
        return this.sanat;
    }

    public Sanalista sanatJoidenPituusOn(int pituus) {
        return null;
    }

    public Sanalista sanatJoissaEiEsiinnyKirjainta(char kirjain) {
        return null;
    }

    public Sanalista sanatJoissaMerkit(String merkkijono) {
        return null;
    }

    public int koko() {
        return 0;
    }
}
