/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tyokalut;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author einomies
 */
public class OmaDuplikaattienPoistaja implements DuplikaattienPoistaja {

    private List<String> lista;

    public OmaDuplikaattienPoistaja() {
        this.lista = new LinkedList<>();
    }

    @Override
    public void lisaa(String merkkijono) {
        this.lista.add(merkkijono);
    }

    @Override
    public int getHavaittujenDuplikaattienMaara() {
        int lkm = 0;
        String edellinen = "";
        Collections.sort(this.lista);
        for (String merkkijono : this.lista) {
            if (merkkijono.equals(edellinen)) {
                lkm++;
            }
            edellinen = merkkijono;
        }
        return lkm;
    }

    @Override
    public Set<String> getUniikitMerkkijonot() {
        String edellinen = "";
        Collections.sort(this.lista);
        Set<String> uniikit = new HashSet<>();
        for (String merkkijono : this.lista) {
            if (!merkkijono.equals(edellinen)) {
                uniikit.add(merkkijono);
            }
            edellinen = merkkijono;
        }
        return uniikit;
    }

    @Override
    public void tyhjenna() {
        this.lista.clear();
    }

    @Override
    public String toString() {
        return "OmaDuplikaattienPoistaja{" + "lista=" + lista + '}';
    }

}

/*
package tyokalut;
import java.util.HashSet;

import java.util.Set;
public class OmaDuplikaattienPoistaja implements DuplikaattienPoistaja {

    private Set<String> merkkijonot;
    private int duplikaattienMaara;

    public OmaDuplikaattienPoistaja() {
        this.merkkijonot = new HashSet<>();
        this.duplikaattienMaara = 0;
    }

    @Override
    public void lisaa(String merkkijono) {
        boolean lisatty = this.merkkijonot.add(merkkijono);
        if (!lisatty) {
            this.duplikaattienMaara++;
        }
    }

    @Override
    public int getHavaittujenDuplikaattienMaara() {
        return this.duplikaattienMaara;
    }

    @Override
    public Set<String> getUniikitMerkkijonot() {
        return this.merkkijonot;
    }

    @Override
    public void tyhjenna() {
        this.merkkijonot.clear();
        this.duplikaattienMaara = 0;
    }
}
*/