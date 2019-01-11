import java.util.ArrayList;

public class Pakkaus {
    
    private ArrayList<Lahja> lista;
    
    public Pakkaus() {
        this.lista = new ArrayList<>();
    }
    
    public void lisaaLahja(Lahja lahja) {
        this.lista.add(lahja);
    }
    
    public int getPaino() {
        int paino = 0;
        for (int i = 0; i < this.lista.size(); i++) {
            paino += this.lista.get(i).getPaino();
        }
        return paino;
    }
}
