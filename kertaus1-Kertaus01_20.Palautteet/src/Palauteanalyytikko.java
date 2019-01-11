
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
public class Palauteanalyytikko {

    ArrayList<Palaute> lista = new ArrayList<>();

    private int lkm;
    private int summa;
    private double keskiarvo;

    public Palauteanalyytikko() {
        this.lista = new ArrayList<>();
    }

//  lisää palautteen analysoitavaksi
    public void add(Palaute p) {
        this.lista.add(p);
    }

//  laskee palautteiden keskiarvon ja palauttaa sen. Mikäli palautteita ei ole, palauta arvo -1    
    public double palautteidenKeskiarvo() {
        lkm = 0;
        summa = 0;
        for (Palaute palaute : this.lista) {
            lkm++;
            summa = summa + palaute.getArvosana();
            keskiarvo = (double)summa / (double)lkm;
        }
        return keskiarvo;
    }

//  palauttaa kaikki palautteet, joiden arvosana on annetulla välillä
    public ArrayList<Palaute> palautteetValilta(int alku, int loppu) {
        ArrayList<Palaute> palautteet = new ArrayList<>();
        for (Palaute palaute : this.lista) {
            if (palaute.getArvosana() >= alku && palaute.getArvosana() <= loppu) {
                palautteet.add(palaute);
            }
        }
        return palautteet;
    }

//  tulostaa kaikki palautteet    
    @Override
    public String toString() {
        String merkkijono = "Palautteet:\n";
        for (Palaute palaute : lista) {
            merkkijono = 
                    merkkijono
                    +"* (" 
                    +palaute.getArvosana() 
                    +"/" 
                    +palaute.getArvosanaMax()
                    +") "
                    +palaute.getKuvaus()
                    +"\n"
                    ;
        }
        return merkkijono;
        /*
    Palautteet:
    * (2/5) Kiitti letuista
    * (4/5) Kiitti letuista ja hillosta
         */
    }

}
