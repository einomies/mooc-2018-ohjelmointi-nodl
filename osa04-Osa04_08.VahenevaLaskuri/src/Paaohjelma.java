public class Paaohjelma {

    public static void main(String[] args) {
        VahenevaLaskuri laskuri = new VahenevaLaskuri(10);
        VahenevaLaskuri laskuriAlussa = new VahenevaLaskuri(10);

        laskuri.tulostaArvo();

        laskuri.vahene();
        laskuri.tulostaArvo();

        laskuri.vahene();
        laskuri.tulostaArvo();

        laskuri.vahene();
        laskuri.tulostaArvo();

        laskuri.nollaa();
        laskuri.tulostaArvo();
        
        laskuri.palautaAlkuarvo();
        laskuri.tulostaArvo();
    }
}
