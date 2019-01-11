
public class Suurin {

    public static int suurin(int luku1, int luku2, int luku3) {
        return Math.max(luku1, Math.max(luku2, luku3));
    }

    public static void main(String[] args) {
        int vastaus = suurin(2, 7, 3);
        System.out.println("Suurin: " + vastaus);
    }
}
