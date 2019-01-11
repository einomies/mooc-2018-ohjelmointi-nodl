package malli.domain;

import java.util.*;

public class Hyppykierros {

    private int kierrosNumero;
    private List<Hyppaaja> hyppyjarjestys;
    private Map<Hyppaaja, Hyppy> tulokset;

    public Hyppykierros(int kierrosNumero, List<Hyppaaja> hyppyjarjestys) {
        this.kierrosNumero = kierrosNumero;
        this.hyppyjarjestys = hyppyjarjestys;
        this.tulokset = new HashMap<>();
    }

    public List<Hyppaaja> getHyppyjarjestys() {
        return this.hyppyjarjestys;
    }

    public int getKierrosNumero() {
        return this.kierrosNumero;
    }

    public Hyppy getHyppy(Hyppaaja hyppaaja) {
        return this.tulokset.get(hyppaaja);
    }

    public void hyppaa() {
        Random random = new Random();
        for (Hyppaaja hyppaaja : this.hyppyjarjestys) {
            Hyppy hyppy = luoHyppy(random);
            this.tulokset.put(hyppaaja, hyppy);
            hyppaaja.lisaaHyppy(hyppy);
        }
    }

    private Hyppy luoHyppy(Random random) {
        List<Integer> hypynTyylipisteet = arvoTyylipisteet(random);
        int hypynPituus = 60 + random.nextInt(61);
        return new Hyppy(hypynPituus, hypynTyylipisteet);
    }

    private List<Integer> arvoTyylipisteet(Random random) {
        List<Integer> pisteet = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            pisteet.add(10 + random.nextInt(11));
        }
        return pisteet;
    }

}
