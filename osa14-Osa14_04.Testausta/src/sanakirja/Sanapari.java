/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanakirja;

import java.util.Objects;

/**
 *
 * @author einomies
 */
public class Sanapari {

    private String sana;
    private String kaannos;

    public Sanapari(String sana, String kaannos) {
        this.sana = sana;
        this.kaannos = kaannos;
    }

    public String getSana() {
        return sana;
    }

    public void setSana(String sana) {
        this.sana = sana;
    }

    public String getKaannos() {
        return kaannos;
    }

    public void setKaannos(String kaannos) {
        this.kaannos = kaannos;
    }

    @Override
    public String toString() {
        return "Sanapari{" + "sana=" + sana + ", kaannos=" + kaannos + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.sana);
        hash = 71 * hash + Objects.hashCode(this.kaannos);
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
        final Sanapari other = (Sanapari) obj;
        if (!Objects.equals(this.sana, other.sana)) {
            return false;
        }
        if (!Objects.equals(this.kaannos, other.kaannos)) {
            return false;
        }
        return true;
    }

}
