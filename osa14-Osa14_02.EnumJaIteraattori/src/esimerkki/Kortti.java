package esimerkki;

public class Kortti {

    private int arvo;
    private Maa maa;

    public Kortti(int arvo, Maa maa) {
        this.arvo = arvo;
        this.maa = maa;
    }

    @Override
    public String toString() {
        return maa + " " + arvo;
    }

    public Maa getMaa() {
        return maa;
    }

    public int getArvo() {
        return arvo;
    }

}
