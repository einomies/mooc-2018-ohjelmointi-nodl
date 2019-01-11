import java.util.ArrayList;

public class Kirja {
    
    private String nimi;
    private int sivuja;
    private int vuosi;
	
    public Kirja(String nimi, int sivuja, int vuosi) {
        this.nimi = nimi;
        this.sivuja = sivuja;
        this.vuosi = vuosi;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public int getSivuja() {
        return sivuja;
    }

    public void setSivuja(int sivuja) {
        this.sivuja = sivuja;
    }

    public int getVuosi() {
        return vuosi;
    }

    public void setVuosi(int vuosi) {
        this.vuosi = vuosi;
    }

    @Override
    public String toString() {
        return nimi  +", " +sivuja +" sivua, " +vuosi;
    }

    public String toStringNimi() {
        return nimi;
    }

    public Kirja() {
        super();
        // TODO Auto-generated constructor stub
    }

}
