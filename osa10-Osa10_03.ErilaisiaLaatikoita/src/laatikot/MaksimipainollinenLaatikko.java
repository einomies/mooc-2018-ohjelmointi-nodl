/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laatikot;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author einomies
 */
public class MaksimipainollinenLaatikko extends Laatikko {

    private int maksimipaino;
    private Set<Tavara> tavarat;

    public MaksimipainollinenLaatikko(int maksimipaino) {
        if (maksimipaino >= 0) {
            this.maksimipaino = maksimipaino;
        } else {
            throw new IllegalArgumentException("Maksimipaino ei saa olla negatiivinen");
        }
//        this.painoSaldo = 0;
        this.tavarat = new HashSet<>();
    }

    @Override
    public void lisaa(Tavara tavara) {
        int painoYht = laskePainoYht();
        if (painoYht + tavara.getPaino() <= this.maksimipaino) {
            this.tavarat.add(tavara);
        }
    }

    @Override
    public boolean onkoLaatikossa(Tavara tavara) {
        if (this.tavarat.contains(tavara)) {
            return true;
        }
        return false;
    }

    private int laskePainoYht() {
        int painoYht = 0;
        for (Tavara tavara : this.tavarat) {
            painoYht += tavara.getPaino();
        }
        return painoYht;
    }

}

/*
package laatikot;
import java.util.ArrayList;
import java.util.List;

public class MaksimipainollinenLaatikko extends Laatikko {

    private List<Tavara> tavarat;
    private int maksimipaino;

    public MaksimipainollinenLaatikko(int tilavuus) {
        this.maksimipaino = tilavuus;
        this.tavarat = new ArrayList<>();
    }

    @Override
    public void lisaa(Tavara tavara) {
        if (this.tavaroidenPaino() + tavara.getPaino() > this.maksimipaino) {
            return;
        }
        this.tavarat.add(tavara);
    }

    @Override
    public boolean onkoLaatikossa(Tavara tavara) {
        return this.tavarat.contains(tavara);
    }

    private int tavaroidenPaino() {
        return this.tavarat.stream().mapToInt(t -> t.getPaino()).sum();
    }
}
*/