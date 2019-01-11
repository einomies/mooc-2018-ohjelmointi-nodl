package lukutaito;

public class Tulos {

    private String sukupuoli;
    private String maa;
    private int vuosi;
    private double lukutaitoprosentti;

    public Tulos(String sukupuoli, String maa, int vuosi, double lukutaitoprosentti) {
        this.sukupuoli = sukupuoli;
        this.maa = maa;
        this.vuosi = vuosi;
        this.lukutaitoprosentti = lukutaitoprosentti;
    }

    public double getLukutaitoprosentti() {
        return lukutaitoprosentti;
    }

    @Override
    public String toString() {
        return this.maa + " (" + this.vuosi + "), " + this.sukupuoli + ", " + this.lukutaitoprosentti;
    }

}
