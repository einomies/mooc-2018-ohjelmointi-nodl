
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author einomies
 */
class Tehtavalista {

    private ArrayList<Tehtava> lista = new ArrayList<>();

    public Tehtavalista() {
        this.lista = new ArrayList<>();
    }

    public void lisaa(String kuvaus) {
        Tehtava t = new Tehtava(kuvaus);
        this.lista.add(t);
    }

    public void asetaTehdyksi(String kuvaus) {
        for (Tehtava tehtava : lista) {
            if (tehtava.getKuvaus().equals(kuvaus)) {
                tehtava.asetaTehdyksi();
            }
        }
    }

    public Tehtava annaTehtava(String kuvaus) {
        for (Tehtava tehtava : lista) {
            if (tehtava.getKuvaus().equals(kuvaus)) {
                return tehtava;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String tehtavatMerkkijonona = "Tehtävät:\n";
        for (Tehtava tehtava : this.lista) {
            tehtavatMerkkijonona
                    = tehtavatMerkkijonona
                    + "* "
                    + tehtava
                    + "\n";
        }
        return tehtavatMerkkijonona;
    }

}
