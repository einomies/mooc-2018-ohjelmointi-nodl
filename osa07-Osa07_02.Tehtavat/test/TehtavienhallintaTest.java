import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TehtavienhallintaTest {

    private Tehtavienhallinta hallinta;

    @Before
    public void alusta() {
        hallinta = new Tehtavienhallinta();
    }

    @Test
    public void tehtavalistaAlussaTyhja() {
        assertEquals(0, hallinta.tehtavalista().size());
    }

    @Test
    public void tehtavanLisaaminenKasvattaaListanKokoaYhdella() {
        hallinta.lisaa("Kirjoita testi");
        assertEquals(1, hallinta.tehtavalista().size());
    }

    @Test
    public void lisattyTehtavaLoytyyTehtavalistalta() {
        hallinta.lisaa("Kirjoita testi");
        assertTrue(hallinta.tehtavalista().contains("Kirjoita testi"));
    }

    @Test
    public void tehtavanVoiMerkataTehdyksi() {
        hallinta.lisaa("Satunnainen tehtava");
        hallinta.merkkaaTehdyksi("Satunnainen tehtava");
    }

    @Test
    public void tehdyksiMerkattuOnTehty() {
        hallinta.lisaa("Uusi tehtava");
        hallinta.merkkaaTehdyksi("Uusi tehtava");
        assertTrue(hallinta.onTehty("Uusi tehtava"));
    }

    @Test
    public void tehdyksiMerkkaamatonEiOleTehty() {
        hallinta.lisaa("Uusi tehtava");
        hallinta.merkkaaTehdyksi("Uusi tehtava");
        assertFalse(hallinta.onTehty("Joku tehtava"));
    }

    @Test
    public void poistaTehtava() {
        String poistettavaTehtava = "Poistettava tehtava";
        hallinta.lisaa(poistettavaTehtava);
        assertTrue(hallinta.tehtavalista().contains(poistettavaTehtava));
        hallinta.poista(poistettavaTehtava);
        assertFalse(hallinta.tehtavalista().contains(poistettavaTehtava));
    }

}