import java.util.ArrayList;

public class Matkalaukku {
    
    private ArrayList<Tavara> lista;
    private int maxPaino;
    
    public Matkalaukku(int maxPaino) {
        this.lista = new ArrayList<>();
        this.maxPaino = maxPaino;
    }
    
    public void lisaaTavara(Tavara tavara) {
        if (this.yhteispaino()+ tavara.getPaino() <= this.maxPaino) {
            this.lista.add(tavara);
        }
    }

    public int yhteispaino() {
        int paino = 0;
        for (int i = 0; i < this.lista.size(); i++) {
            paino += this.lista.get(i).getPaino();
        }
        return paino;
    }

    public int getMaara() {
        return this.lista.size();
    }
    
    @Override
    public String toString() {
        if (this.getMaara() == 0) {
            return "ei tavaroita (0 kg)";
        } else if (this.getMaara() == 1) {
            return "1 tavara (" +this.yhteispaino() +" kg)";
        } else {
            return this.getMaara() +" tavaraa (" +this.yhteispaino() +" kg)";
        }
    }

    public void tulostaTavarat() {
        for (Tavara t : lista) {
            System.out.println(t.getNimi() +" (" +t.getPaino() +" kg)");
        }
    }
    
    public Tavara raskainTavara() {
        Tavara raskain = null;
        int maxPaino = 0;
        for (Tavara t : lista) {
            if (t.getPaino() > maxPaino) {
                maxPaino = t.getPaino();
                raskain = t;
            }
        }
        return raskain;
    }

}

/*
import java.util.ArrayList;

public class Matkalaukku {

    private int maksimipaino;
    private ArrayList<Tavara> tavarat;

    public Matkalaukku(int maksimipaino) {
        this.tavarat = new ArrayList<>();
        this.maksimipaino = maksimipaino;
    }

    public void lisaaTavara(Tavara tavara) {
        if (this.yhteispaino() + tavara.getPaino() > this.maksimipaino) {
            return;
        }

        this.tavarat.add(tavara);
    }

    public int yhteispaino() {
        int summa = 0;
        int indeksi = 0;
        while (indeksi < this.tavarat.size()) {
            summa += this.tavarat.get(indeksi).getPaino();
            indeksi++;
        }
        return summa;
    }

    public void tulostaTavarat() {
        int indeksi = 0;
        while (indeksi < this.tavarat.size()) {
            Tavara t = this.tavarat.get(indeksi);
            System.out.println(t);
            indeksi++;
        }
    }

    public Tavara raskainTavara() {
        if (this.tavarat.isEmpty()) {
            return null;
        }

        Tavara raskain = this.tavarat.get(0);
        int indeksi = 0;
        while (indeksi < this.tavarat.size()) {
            Tavara t = this.tavarat.get(indeksi);

            if(t.getPaino() > raskain.getPaino()) {
                raskain = t;
            }

            indeksi++;
        }

        return raskain;
    }

    @Override
    public String toString() {
        if (this.tavarat.isEmpty()) {
            return "ei tavaroita (0 kg)";
        }

        if (this.tavarat.size() == 1) {
            return "1 tavara (" + this.yhteispaino() + " kg)";
        }

        return this.tavarat.size() + " tavaraa (" + this.yhteispaino() + " kg)";
    }
}

*/