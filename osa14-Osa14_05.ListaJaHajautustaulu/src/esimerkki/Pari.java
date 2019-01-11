package esimerkki;

public class Pari<K, V> {

    private K avain;
    private V arvo;

    public Pari(K avain, V arvo) {
        this.avain = avain;
        this.arvo = arvo;
    }

    public K getAvain() {
        return avain;
    }

    public void setAvain(K avain) {
        this.avain = avain;
    }

    public V getArvo() {
        return arvo;
    }

    public void setArvo(V arvo) {
        this.arvo = arvo;
    }

}
