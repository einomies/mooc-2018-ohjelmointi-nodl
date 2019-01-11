/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package varastot;

/**
 *
 * @author einomies
 */
public class MuistavaTuotevarasto extends Tuotevarasto {

//    private double alkuSaldo;
    private Muutoshistoria muutoshistoria;

//    public MuistavaTuotevarasto(String tuotenimi, double tilavuus) {
//        super(tuotenimi, tilavuus);
//    }
    public MuistavaTuotevarasto(String tuotenimi, double tilavuus, double alkuSaldo) {
        super(tuotenimi, tilavuus);
        super.lisaaVarastoon(alkuSaldo);
//        this.alkuSaldo = alkuSaldo;
        this.muutoshistoria = new Muutoshistoria();
        this.muutoshistoria.lisaa(alkuSaldo);
    }

    public String historia() {
        return this.muutoshistoria.toString();
    }

    public void lisaaVarastoon(double maara) {
        super.lisaaVarastoon(maara);
        this.muutoshistoria.lisaa(super.getSaldo());
    }

    public double otaVarastosta(double maara) {
        double otettu = super.otaVarastosta(maara);
        this.muutoshistoria.lisaa(super.getSaldo());
        return otettu;
    }

    public void tulostaAnalyysi() {
        System.out.println("Tuote: " + super.getNimi());
        System.out.println("Historia: " + this.muutoshistoria.toString());
        System.out.println("Suurin tuotemäärä: " + this.muutoshistoria.maxArvo());
        System.out.println("Pienin tuotemäärä: " + this.muutoshistoria.minArvo());
        System.out.println("Keskiarvo: " + this.muutoshistoria.keskiarvo());
        System.out.println("Suurin muutos: " + this.muutoshistoria.suurinMuutos());
        System.out.println("Varianssi: " + this.muutoshistoria.varianssi());
    }

}

/*
package varastot;
public class MuistavaTuotevarasto extends Tuotevarasto {

    private Muutoshistoria historia;

    public MuistavaTuotevarasto(String nimi, double tilavuus, double alkusaldo) {
        super(nimi, tilavuus);
        historia = new Muutoshistoria();
        lisaaVarastoon(alkusaldo);
    }

    public String historia() {
        return historia.toString();
    }

    public void tulostaAnalyysi() {
        System.out.println("Tuote: " + getNimi());
        System.out.println("Historia: " + historia());
        System.out.println("Suurin tuotemäärä: " + historia.maxArvo());
        System.out.println("Pienin tuotemäärä: " + historia.minArvo());
        System.out.println("Keskiarvo: " + historia.keskiarvo());
        System.out.println("Suurin muutos: " + historia.suurinMuutos());
        System.out.println("Varianssi: " + historia.varianssi());
    }

    @Override
    public void lisaaVarastoon(double maara) {
        super.lisaaVarastoon(maara);
        historia.lisaa(getSaldo());
    }

    @Override
    public double otaVarastosta(double maara) {
        double saatiin = super.otaVarastosta(maara);
        historia.lisaa(getSaldo());
        return saatiin;
    }
}
*/