
public class Muistio {

    private String nimi;
    private int vuosi;

    public Muistio(String nimi, int vuosi) {
        this.nimi = nimi;
        this.vuosi = vuosi;
    }

    public boolean equals(Object olio) {
        if (olio == null || this.getClass() != olio.getClass()) {
            return false;
        }

        if (olio == this) {
            return true;
        }

        Muistio verrattava = (Muistio) olio;

        return this.nimi.equals(verrattava);
    }
}
