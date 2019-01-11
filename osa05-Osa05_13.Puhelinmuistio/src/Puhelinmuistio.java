import java.util.ArrayList;

public class Puhelinmuistio {
    
    private ArrayList<Henkilo> lista;
    
    public Puhelinmuistio() {
        this.lista = new ArrayList<>();
    }
    
    public void lisaa(String nimi, String numero) {
        lista.add(new Henkilo(nimi, numero));
    }

    public void tulostaKaikki() {
        for (Henkilo h : lista) {
            System.out.println(h);
        }
    }

    public String haeNumero(String nimi) {
        for (Henkilo h : lista) {
            if (h.getNimi().equals(nimi)) {
                return h.getNumero();
            }
        }
        return "numero ei tiedossa";
    }
}
