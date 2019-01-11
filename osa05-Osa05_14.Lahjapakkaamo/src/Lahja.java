public class Lahja {
    
    private String nimi;
    private int paino;
    
    public Lahja(String nimi, int paino) {
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
