
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
public class Ruudukko {

    ArrayList<Suorakulmio> ruudukko = new ArrayList<>();

    public Ruudukko() {
        this.ruudukko = new ArrayList<>();
    }

    public void lisaa(Suorakulmio suorakulmio) {
        this.ruudukko.add(suorakulmio);
    }
    
    public Piste maxPiste() {
        int x=0, y=0;
        for (Suorakulmio suorakulmio : this.ruudukko) {
            if (suorakulmio.maxPiste().getX() > x) {
                x = suorakulmio.maxPiste().getX();
            }
            if (suorakulmio.maxPiste().getY() > y) {
                y = suorakulmio.maxPiste().getY();
            }
        }
        return new Piste(x, y);
    }
    
    public String ruudukkoPiirros( ) {
    	String piirros="";
    	Piste maxPiste = maxPiste();
    	int maxX = maxPiste.getX();
    	int maxY = maxPiste.getY();
    	Piste piste = new Piste(0, 0);
    	for (int y = 0; y < maxY; y++) {
    		for (int x = 0; x < maxX; x++) {
    			piste.setX(x);
    			piste.setY(y);
    			if (suorakulmionPisteRuudukossa(piste)) {
    				piirros = piirros + "x";
    			} else {
    				piirros = piirros + " ";
    			}
    		}
    		piirros = piirros + "\n";
		}
    	return piirros;
    }
    
    private boolean suorakulmionPisteRuudukossa(Piste piste) {
    	boolean loytyyko = false;
		for (Suorakulmio suorakulmio : ruudukko) {
			if (suorakulmio.pisteAlueella(piste)) {
    			loytyyko = true;
    			break;
			}
		}
    	return loytyyko;
    }

    @Override
    public String toString() {
//        return "Ruudukko{" + "ruudukko=" + ruudukko + '}';
        return ruudukkoPiirros();
    }

}
