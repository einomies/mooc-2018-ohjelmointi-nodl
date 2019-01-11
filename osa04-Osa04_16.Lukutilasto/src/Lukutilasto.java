public class Lukutilasto {
    private int lukujenMaara;
    private int lukujenSumma;

    public Lukutilasto() {
        this.lukujenMaara = 0;
    }

    public void lisaaLuku(int luku) {
        this.lukujenMaara++;
        this.lukujenSumma += luku;
    }

    public int haeLukujenMaara() {
        return this.lukujenMaara;
    }

    public int summa() {
        return this.lukujenSumma;
    }

    public double keskiarvo() {
        if (this.lukujenMaara > 0) {
            return (double)this.lukujenSumma / (double)this.lukujenMaara;
        }
        return 0;
    }
}

