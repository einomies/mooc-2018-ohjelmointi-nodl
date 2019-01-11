public class Tavara {
    
    private String nimi;
    private int paino;
    
    public Tavara(String nimi, int paino) {
        this.nimi = nimi;
        this.paino = paino;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public int getPaino() {
        return paino;
    }

    public void setPaino(int paino) {
        this.paino = paino;
    }
    
    @Override
    public String toString() {
        return this.nimi +" (" +this.paino +" kg)";
    }

}

/*
public class Tavara {
 
    private String nimi;
    private int paino;
 
    public Tavara(String nimi, int paino) {
        this.nimi = nimi;
        this.paino = paino;
    }
 
    public String getNimi() {
        return this.nimi;
    }
 
    public int getPaino() {
        return this.paino;
    }
 
    @Override
    public String toString() {
        return this.nimi + ": (" + this.paino + " kg)";
    }
}
*/