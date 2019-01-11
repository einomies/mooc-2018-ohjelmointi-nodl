import java.util.ArrayList;

public class Lastiruuma {

    private ArrayList<Matkalaukku> lista;
    private int maxPaino;
    
    public Lastiruuma(int maxPaino) {
        this.lista = new ArrayList<>();
        this.maxPaino = maxPaino;
    }
    
    public Lastiruuma() {
        this.lista = new ArrayList<>();
    }
    
    public void lisaaMatkalaukku(Matkalaukku laukku) {
        if (this.yhteispaino() + laukku.yhteispaino() <= maxPaino) {
            this.lista.add(laukku);
        }
    }

    @Override
    public String toString() {
        if (this.getMaara() == 0) {
            return "ei matkalaukkuja (0 kg)";
        } else if (this.getMaara() == 1) {
            return "1 matkalaukku (" +this.yhteispaino() +" kg)";
        } else {
            return this.getMaara() +" matkalaukkua (" +this.yhteispaino() +" kg)";
        }
    }
    
    public int yhteispaino() {
        int paino = 0;
        for (int i = 0; i < this.lista.size(); i++) {
            paino += this.lista.get(i).yhteispaino();
        }
        return paino;
    }

    public int getMaara() {
        return this.lista.size();
    }

    public void tulostaTavarat() {
        for (Matkalaukku matkalaukku : this.lista) {
            matkalaukku.tulostaTavarat();
        }
    }

}

/*
import java.util.ArrayList;

public class Lastiruuma {

    private ArrayList<Matkalaukku> matkalaukut;
    private int maksimipaino;

    public Lastiruuma(int maksimipaino) {
        this.maksimipaino = maksimipaino;
        this.matkalaukut = new ArrayList<>();
    }

    public void lisaaMatkalaukku(Matkalaukku matkalaukku) {
        if (this.yhteispaino() + matkalaukku.yhteispaino() > maksimipaino) {
            return;
        }
        this.matkalaukut.add(matkalaukku);
    }

    public int yhteispaino() {
        int summa = 0;
        int indeksi = 0;
        while (indeksi < this.matkalaukut.size()) {
            summa += this.matkalaukut.get(indeksi).yhteispaino();
            indeksi++;
        }
        return summa;
    }

    public void tulostaTavarat() {
        int indeksi = 0;
        while (indeksi < this.matkalaukut.size()) {
            this.matkalaukut.get(indeksi).tulostaTavarat();
            indeksi++;
        }
    }

    @Override
    public String toString() {
        if (this.matkalaukut.isEmpty()) {
            return "ei matkalaukkuja (0 kg)";
        }
        if (this.matkalaukut.size() == 1) {
            return "1 matkalaukku (" + this.yhteispaino() + " kg)";
        }
        return this.matkalaukut.size() + " matkalaukkua (" + this.yhteispaino() + " kg)";
    }
}

*/