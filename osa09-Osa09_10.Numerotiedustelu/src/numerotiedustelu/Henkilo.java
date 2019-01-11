/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numerotiedustelu;

import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author einomies
 */
public class Henkilo {

    private String nimi;
    private String osoiteKatu;
    private String osoiteKaupunki;
    private Set<String> puhNumerot;

    public Henkilo() {
    }

    public Henkilo(String nimi, String osoiteKatu, String osoiteKaupunki, String puhNumero) {
        this.nimi = nimi;
        if (osoiteKatu.isEmpty()) {
            this.osoiteKatu = null;
        } else {
            this.osoiteKatu = osoiteKatu;
        }
        if (osoiteKaupunki.isEmpty()) {
            this.osoiteKaupunki = null;
        } else {
            this.osoiteKaupunki = osoiteKaupunki;
        }
        this.puhNumerot = new HashSet<>();
        if (!puhNumero.isEmpty()) {
            this.puhNumerot.add(puhNumero);
        }
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getOsoiteKatu() {
        return osoiteKatu;
    }

    public void setOsoiteKatu(String osoiteKatu) {
        this.osoiteKatu = osoiteKatu;
    }

    public String getOsoiteKaupunki() {
        return osoiteKaupunki;
    }

    public void setOsoiteKaupunki(String osoiteKaupunki) {
        this.osoiteKaupunki = osoiteKaupunki;
    }

    public Set<String> getPuhNumerot() {
        return puhNumerot;
    }

    public void setPuhNumerot(Set<String> puhNumerot) {
        this.puhNumerot = puhNumerot;
    }

    public void lisaaPuhNumero(String puhNumero) {
        this.puhNumerot.add(puhNumero);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.nimi);
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
        final Henkilo other = (Henkilo) obj;
        if (!Objects.equals(this.nimi, other.nimi)) {
            return false;
        }
        return true;
    }

    public String toStringIlmanNimea() {
        String tulosString = "";

        String osoiteString = "osoite ei tiedossa";
        if (this.osoiteKatu != null && this.osoiteKaupunki != null) {
            osoiteString = "osoite: " + this.osoiteKatu + " " + this.osoiteKaupunki;
        }
        if (this.osoiteKatu != null && this.osoiteKaupunki == null) {
            osoiteString = "osoite: " + this.osoiteKatu;
        }
        if (this.osoiteKatu == null && this.osoiteKaupunki != null) {
            osoiteString = "osoite: " + this.osoiteKaupunki;
        }

        String puhNumerotString = "ei puhelinta";
        if (this.puhNumerot.size() > 0) {
            puhNumerotString = "puhelinnumerot:";
            for (String nro : this.puhNumerot) {
                puhNumerotString = puhNumerotString + "\n    " + nro;
            }
        }

        tulosString = osoiteString + "\n  " + puhNumerotString;
        return tulosString;
    }

    @Override
    public String toString() {
        String tulosString = "";

        String nimiString = this.nimi;

        String osoiteString = "osoite ei tiedossa";
        if (this.osoiteKatu != null && this.osoiteKaupunki != null) {
            osoiteString = "osoite: " + this.osoiteKatu + " " + this.osoiteKaupunki;
        }
        if (this.osoiteKatu != null && this.osoiteKaupunki == null) {
            osoiteString = "osoite: " + this.osoiteKatu;
        }
        if (this.osoiteKatu == null && this.osoiteKaupunki != null) {
            osoiteString = "osoite: " + this.osoiteKaupunki;
        }

        String puhNumerotString = "ei puhelinta";
        if (this.puhNumerot.size() > 0) {
            puhNumerotString = "puhelinnumerot:";
            for (String nro : this.puhNumerot) {
                puhNumerotString = puhNumerotString + "\n    " + nro;
            }
        }

        tulosString = nimiString + "\n  " + osoiteString + "\n  " + puhNumerotString;
        return tulosString;
    }

}
