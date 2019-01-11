/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kirjallisuutta;

import java.util.Objects;

/**
 *
 * @author einomies
 */
public class Kirja implements Comparable<Kirja> {

    private String nimi;
    private int kohdeMinimiIka;

    public Kirja(String nimi, int kohdeMinimiIka) {
        this.nimi = nimi;
        this.kohdeMinimiIka = kohdeMinimiIka;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public int getKohdeMinimiIka() {
        return kohdeMinimiIka;
    }

    public void setKohdeMinimiIka(int kohdeMinimiIka) {
        this.kohdeMinimiIka = kohdeMinimiIka;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.nimi);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Kirja other = (Kirja) obj;
        if (!Objects.equals(this.nimi, other.nimi)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nimi + " (" + kohdeMinimiIka + "-vuotiaille ja vanhemmille)";
    }

    @Override
    public int compareTo(Kirja k) {
        if (this.getKohdeMinimiIka() == k.getKohdeMinimiIka()) {
            return this.getNimi().compareToIgnoreCase(k.getNimi());
        } else {
            return this.getKohdeMinimiIka() - k.getKohdeMinimiIka();
        }
    }

}
