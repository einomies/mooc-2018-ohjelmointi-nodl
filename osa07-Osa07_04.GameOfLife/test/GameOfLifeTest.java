
import fi.helsinki.cs.tmc.edutestutils.Points;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class GameOfLifeTest {

    @Test
    @Points("07-04.1")
    public void elossaOlevatNaapurit1() {
        GameOfLife gol = new GameOfLife(3, 3);

        Taulukko taulukko = new Taulukko(3, 3);
        taulukko.aseta(0, 0, true);
        taulukko.aseta(0, 1, true);
        taulukko.aseta(1, 1, true);
        taulukko.aseta(2, 2, true);

        assertTrue("Kokeile ohjelmaasi tehtävänannossa annetulla ensimmäisellä esimerkillä. Odotettiin, että kohdassa 0, 0 olisi 2 naapuria. Nyt niitä oli: " + gol.elossaOleviaNaapureita(taulukko, 0, 0), gol.elossaOleviaNaapureita(taulukko, 0, 0) == 2);
        assertTrue("Kokeile ohjelmaasi tehtävänannossa annetulla ensimmäisellä esimerkillä. Odotettiin, että kohdassa 1, 0 olisi 3 naapuria. Nyt niitä oli: " + gol.elossaOleviaNaapureita(taulukko, 1, 0), gol.elossaOleviaNaapureita(taulukko, 1, 0) == 3);
        assertTrue("Kokeile ohjelmaasi tehtävänannossa annetulla ensimmäisellä esimerkillä. Odotettiin, että kohdassa 1, 1 olisi 3 naapuria. Nyt niitä oli: " + gol.elossaOleviaNaapureita(taulukko, 1, 1), gol.elossaOleviaNaapureita(taulukko, 1, 1) == 3);
        assertTrue("Kokeile ohjelmaasi tehtävänannossa annetulla ensimmäisellä esimerkillä. Odotettiin, että kohdassa 2, 2 olisi 1 naapuri. Nyt niitä oli: " + gol.elossaOleviaNaapureita(taulukko, 2, 2), gol.elossaOleviaNaapureita(taulukko, 2, 2) == 1);
    }

    @Test
    @Points("07-04.1")
    public void elossaOlevatNaapurit2() {
        GameOfLife gol = new GameOfLife(4, 4);

        Taulukko taulukko = new Taulukko(4, 4);
        taulukko.aseta(0, 0, true);
        taulukko.aseta(0, 1, true);
        taulukko.aseta(0, 2, true);
        taulukko.aseta(0, 3, true);
        taulukko.aseta(1, 0, true);
        taulukko.aseta(1, 1, true);
        taulukko.aseta(1, 2, true);
        taulukko.aseta(1, 3, true);
        taulukko.aseta(2, 0, true);
        taulukko.aseta(2, 2, true);
        taulukko.aseta(3, 1, true);
        taulukko.aseta(3, 3, true);

        assertTrue("Kokeile ohjelmaasi tehtävänannossa annetulla toisella esimerkillä. Odotettiin, että kohdassa 0, 0 olisi 3 naapuria. Nyt niitä oli: " + gol.elossaOleviaNaapureita(taulukko, 0, 0), gol.elossaOleviaNaapureita(taulukko, 0, 0) == 3);
        assertTrue("Kokeile ohjelmaasi tehtävänannossa annetulla toisella esimerkillä. Odotettiin, että kohdassa 1, 1 olisi 7 naapuria. Nyt niitä oli: " + gol.elossaOleviaNaapureita(taulukko, 1, 1), gol.elossaOleviaNaapureita(taulukko, 1, 1) == 7);
        assertTrue("Kokeile ohjelmaasi tehtävänannossa annetulla toisella esimerkillä. Odotettiin, että kohdassa 2, 2 olisi 5 naapuria. Nyt niitä oli: " + gol.elossaOleviaNaapureita(taulukko, 2, 2), gol.elossaOleviaNaapureita(taulukko, 2, 2) == 5);
        assertTrue("Kokeile ohjelmaasi tehtävänannossa annetulla toisella esimerkillä. Odotettiin, että kohdassa 3, 3 olisi 1 naapuri. Nyt niitä oli: " + gol.elossaOleviaNaapureita(taulukko, 3, 3), gol.elossaOleviaNaapureita(taulukko, 3, 3) == 1);
    }

}
