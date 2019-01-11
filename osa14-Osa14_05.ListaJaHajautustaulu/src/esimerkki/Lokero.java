package esimerkki;

public class Lokero<T> {

    private T alkio;

    public void asetaArvo(T alkio) {
        this.alkio = alkio;
    }

    public T haeArvo() {
        return alkio;
    }

}
