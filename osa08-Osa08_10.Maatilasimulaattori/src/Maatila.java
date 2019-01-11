
import java.util.ArrayList;
import java.util.Collection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author einomies
 */
public class Maatila implements Eleleva {

    private String omistaja;
    private Navetta navetta;
    private ArrayList<Lehma> lehmat;

    public Maatila(String omistaja, Navetta navetta) {
        this.omistaja = omistaja;
        this.navetta = navetta;
        this.lehmat = new ArrayList<>();
    }

    public String getOmistaja() {
        return this.omistaja;
    }

    @Override
    public String toString() {
        String lehmat = "";

        if (this.lehmat.size() > 0) {
            lehmat = "Lehmät:";
            for (Lehma lehma : this.lehmat) {
                lehmat = lehmat + "\n\t" + lehma.toString();
            }
        } else {
            lehmat = "Ei lehmiä.";
        }

        return "Maatilan omistaja: "
                + omistaja
                + "\n"
                + "Navetan maitosäiliö: "
                + navetta
                + "\n"
                + lehmat;
        /*
Maatilan omistaja: Esko
Navetan maitosäiliö: 0.0/2000.0
Lehmät:
    Naatti 0.0/19.0
    Hilke 0.0/30.0
    Sylkki 0.0/29.0
         */
    }

    public void lisaaLehma(Lehma lehma) {
        this.lehmat.add(lehma);
    }

    public void eleleTunti() {
        for (Lehma lehma : this.lehmat) {
            lehma.eleleTunti();
        }
    }

    public void asennaNavettaanLypsyrobotti(Lypsyrobotti robo) {
        this.navetta.asennaLypsyrobotti(robo);
    }

    public void hoidaLehmat() {
        this.navetta.hoida(this.lehmat);
    }

}

/*
import java.util.HashSet;
import java.util.Set;

public class Maatila {

    private String omistaja;
    private Navetta navetta;
    private Set<Lehma> lehmat;

    public Maatila(String omistaja, Navetta navetta) {
        this.omistaja = omistaja;
        this.navetta = navetta;
        this.lehmat = new HashSet<>();
    }

    public String getOmistaja() {
        return omistaja;
    }

    public void lisaaLehma(Lehma lehma) {
        lehmat.add(lehma);
    }

    public void eleleTunti() {
        for (Lehma lehma : lehmat) {
            lehma.eleleTunti();
        }
    }

    public void hoidaLehmat() {
        navetta.hoida(lehmat);
    }

    public void asennaNavettaanLypsyrobotti(Lypsyrobotti lypsyrobotti) {
        navetta.asennaLypsyrobotti(lypsyrobotti);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Maatilan omistaja: ");
        sb.append(omistaja);
        sb.append("\n");
        sb.append("Navetan maitosäiliö: ");
        sb.append(navetta.getMaitosailio());
        sb.append("\n");
        if (lehmat.isEmpty()) {
            sb.append("Ei lehmiä.");
        } else {
            sb.append("Lehmät:\n");
            for (Lehma lehma : lehmat) {
                sb.append("        ");
                sb.append(lehma);
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
*/