package malli.ui;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import malli.domain.Hyppaaja;
import malli.domain.Hyppy;
import malli.domain.Hyppykierros;
import malli.logiikka.Kilpailu;

public class Kayttoliittyma {

    private Scanner lukija;
    private Kilpailu kilpailu;

    public Kayttoliittyma(Scanner lukija, Kilpailu kilpailu) {
        this.lukija = lukija;
        this.kilpailu = kilpailu;
    }

    public void kaynnista() {
        System.out.println(this.kilpailu.getNimi());
        System.out.println("");
        lueOsallistujat();
        System.out.println("");
        System.out.println("Kilpailu alkaa!");
        System.out.println("");
        hyppaaKierrokset();
        System.out.println("");
        System.out.println("Kiitos!");
        System.out.println("");
        tulostaLopputulokset();
    }

    private void lueOsallistujat() {
        System.out.println("Syötä kilpailun osallistujat yksi kerrallaan, "
                + "tyhjällä merkkijonolla siirtyy hyppyvaiheeseen.");
        while (true) {
            System.out.print("  Osallistujan nimi: ");
            String osallistujanNimi = this.lukija.nextLine();
            if (osallistujanNimi.equals("")) {
                break;
            }
            this.kilpailu.lisaaHyppaaja(new Hyppaaja(osallistujanNimi));
        }
    }

    private void hyppaaKierrokset() {
        int kierrosNumero = 1;
        while (true) {
            System.out.print("Kirjoita \"hyppaa\" niin hypätään, muuten lopetetaan: ");
            String syote = lukija.nextLine();
            if (!syote.equals("hyppaa")) {
                break;
            }
            System.out.println("");
            System.out.println(kierrosNumero + ". kierros");
            System.out.println("");
            hyppaaKierros();
            kierrosNumero++;
            System.out.println("");
        }
    }

    private void hyppaaKierros() {
        Hyppykierros kierros = this.kilpailu.luoSeuraavaHyppykierros();
        tulostaHyppyjarjestys(kierros);
        System.out.println("");
        kierros.hyppaa();
        tulostaKierroksenTulokset(kierros);
    }

    private void tulostaHyppyjarjestys(Hyppykierros kierros) {
        System.out.println("Hyppyjärjestys: ");
        List<Hyppaaja> hyppaajat = kierros.getHyppyjarjestys();
        for (int i = 0; i < hyppaajat.size(); i++) {
            Hyppaaja hyppaaja = hyppaajat.get(i);
            System.out.println("  " + (i + 1) + ". " + hyppaaja);
        }
    }

    private void tulostaKierroksenTulokset(Hyppykierros kierros) {
        System.out.println("Kierroksen " + kierros.getKierrosNumero() + " tulokset");
        kierros.getHyppyjarjestys().stream().forEach(h -> {
            System.out.println("  " + h.getNimi());
            System.out.println(kierros.getHyppy(h));
        });
    }

    private void tulostaLopputulokset() {
        System.out.println("Kilpailun lopputulokset: ");
        System.out.println("Sija    Nimi");
        List<Hyppaaja> hyppaajat = this.kilpailu.getHyppaajat();
        Collections.sort(hyppaajat);
        Collections.reverse(hyppaajat);
        for (int i = 0; i < hyppaajat.size(); i++) {
            Hyppaaja hyppaaja = hyppaajat.get(i);
            System.out.println((i + 1) + "       " + hyppaaja);
            tulostaHyppaajanHypyt(hyppaaja);
        }
    }

    private void tulostaHyppaajanHypyt(Hyppaaja hyppaaja) {
        String merkkijono = "          hyppyjen pituudet: ";
        List<Hyppy> hypyt = hyppaaja.getHypyt();
        for (int i = 0; i < hypyt.size(); i++) {
            Hyppy hyppy = hypyt.get(i);
            merkkijono += hyppy.getPituus() + " m";
            if (i < hypyt.size() - 1) {
                merkkijono += ", ";
            }
        }
        System.out.println(merkkijono);
    }

}
