package hiekkaranta;

import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.Reflex;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;
import org.testfx.service.support.Capture;

@Points("13-02.5")
public class E_HiekkarantaTest extends HiekkarantaBaseTest {

    @Test
    public void valitaanVesiJaPiirretaan() {
        clickOn(napit().get(2));

        Canvas canvas = piirtoalusta();
        Bounds b = canvas.getBoundsInLocal();
        b = canvas.localToScreen(b);

        moveTo(new Point2D(b.getMinX(), b.getMinY()));
        press(MouseButton.PRIMARY);
        drag(b.getMaxX(), b.getMaxY(), MouseButton.PRIMARY);
        release(MouseButton.PRIMARY);

        Capture kuvakaappaus = capture(canvas);

        Image kuva = kuvakaappaus.getImage();

        PixelReader kuvanlukija = kuva.getPixelReader();
        int sinista = 0;
        int mustaa = 0;

        for (int x = 0; x < 200; x++) {

            for (int y = 0; y < 200; y++) {
                Color vari = kuvanlukija.getColor(x, y);
                if (vari.equals(Color.LIGHTBLUE)) {
                    sinista++;
                }

                if (vari.equals(Color.BLACK)) {
                    mustaa++;
                }
            }
        }

        // Pytagoraan lause :)
        double pisteitaVahintaan = Math.sqrt((100 * 100) + (100 * 100));

        assertTrue("Kun ruudun vasemmasta ylälaidasta piirretään vesiviiva ruudun oikeaan alalaitaan, simulaatioon pitäisi ilmestyä koko matkan kattava vaalean sininen viiva, joka alkaa tippua alaspäin. Nyt pisteitä oli liian vähän.", sinista > pisteitaVahintaan);
        assertTrue("Kun ruudun vasemmasta ylälaidasta piirretään vesiviiva ruudun oikeaan alalaitaan, simulaatioon pitäisi ilmestyä koko matkan kattava vaalean sininen viiva, joka alkaa tippua alaspäin. Muun alueen tulee pysyä yhä mustana.", mustaa > (200 * 200 - pisteitaVahintaan * 40));

        sinista = 0;

        for (int x = 0; x < 40; x++) {

            for (int y = 0; y < 40; y++) {
                Color vari = kuvanlukija.getColor(x, y);
                if (vari.equals(Color.LIGHTBLUE)) {
                    sinista++;
                }
            }
        }

        assertTrue("Kun ruudun vasemmasta ylälaidasta piirretään esiviiva ruudun oikeaan alalaitaan, simulaatioon pitäisi ilmestyä koko matkan kattava vaalean sininen viiva. Nyt väriä ei näkynyt vasemmassa yläkulmassa.", sinista > 0);

        sleep(500);

        kuvakaappaus = capture(canvas);
        kuva = kuvakaappaus.getImage();
        kuvanlukija = kuva.getPixelReader();

        sinista = 0;

        for (int x = 10; x < 20; x++) {

            for (int y = 10; y < 20; y++) {
                Color vari = kuvanlukija.getColor(x, y);
                if (vari.equals(Color.LIGHTBLUE)) {
                    sinista++;
                }
            }
        }

        assertTrue("Kun simulaatio on toiminnassa 500 millisekuntia, veden tulee tippua ainakin hieman alaspäin. Nyt vasempaan yläkulmaan piiretty vesi ei ollut siirtynyt.", sinista == 0);

    }

    @Test
    public void vesiSiirtyySimulaatiossa() throws Throwable {
        Object simulaatio = null;
        try {
            simulaatio = Reflex.reflect("hiekkaranta.Simulaatio").ctor().taking(int.class, int.class).invoke(300, 200);
        } catch (Throwable ex) {
            fail("Kutsu new Simulaatio(300, 200) aiheutti virheen. Virhe: " + ex.getMessage());
        }

        for (int x = 10; x < 20; x++) {
            Reflex.reflect("hiekkaranta.Simulaatio").method("lisaa").returningVoid().taking(int.class, int.class, Tyyppi.class).invokeOn(simulaatio, x, 100, Tyyppi.VESI);

            Tyyppi tyyppi = Reflex.reflect("hiekkaranta.Simulaatio").method("sisalto").returning(Tyyppi.class).taking(int.class, int.class).invokeOn(simulaatio, x, 100);
            assertEquals("Kun simulaatioon on lisätty kohtaan " + x + ", 100 vettä eikä simulaation paivita-kutsua ole kutsuttu, sisalto-metodin pitäisi löytää vettä kyseisestä kohdasta.", Tyyppi.VESI, tyyppi);
        }

        Reflex.reflect("hiekkaranta.Simulaatio").method("paivita").returningVoid().takingNoParams().invokeOn(simulaatio);
        Reflex.reflect("hiekkaranta.Simulaatio").method("paivita").returningVoid().takingNoParams().invokeOn(simulaatio);
        Reflex.reflect("hiekkaranta.Simulaatio").method("paivita").returningVoid().takingNoParams().invokeOn(simulaatio);
        Reflex.reflect("hiekkaranta.Simulaatio").method("paivita").returningVoid().takingNoParams().invokeOn(simulaatio);
        
        int vesilaskuri = 0;
        for (int x = 5; x < 25; x++) {
            Tyyppi tyyppi = Reflex.reflect("hiekkaranta.Simulaatio").method("sisalto").returning(Tyyppi.class).taking(int.class, int.class).invokeOn(simulaatio, x, 105);
            if (tyyppi == Tyyppi.VESI) {
                vesilaskuri++;
            }
        }

        
        Reflex.reflect("hiekkaranta.Simulaatio").method("paivita").returningVoid().takingNoParams().invokeOn(simulaatio);

        for (int x = 10; x < 20; x++) {
            Tyyppi tyyppi = Reflex.reflect("hiekkaranta.Simulaatio").method("sisalto").returning(Tyyppi.class).taking(int.class, int.class).invokeOn(simulaatio, x, 100);

            assertNotEquals("Kun simulaatioon on lisätty kohtaan (x=" + x + ", y=100) vettä ja simulaation paivita-metodia on kutsuttu, ei veden enää pitäisi olla alkuperäisessä paikassa.", Tyyppi.VESI, tyyppi);
        }

        
        for (int x = 5; x < 25; x++) {
            Tyyppi tyyppi = Reflex.reflect("hiekkaranta.Simulaatio").method("sisalto").returning(Tyyppi.class).taking(int.class, int.class).invokeOn(simulaatio, x, 105);
            if (tyyppi == Tyyppi.VESI) {
                vesilaskuri++;
            }
        }
        
        Reflex.reflect("hiekkaranta.Simulaatio").method("paivita").returningVoid().takingNoParams().invokeOn(simulaatio);

        for (int x = 5; x < 25; x++) {
            Tyyppi tyyppi = Reflex.reflect("hiekkaranta.Simulaatio").method("sisalto").returning(Tyyppi.class).taking(int.class, int.class).invokeOn(simulaatio, x, 105);
            if (tyyppi == Tyyppi.VESI) {
                vesilaskuri++;
            }
        }


        assertTrue("Kun simulaatioon on lisätty vetta y-koordinaattiin 100 ja simulaation paivita-metodia on kutsuttu viidesti, ainakin osan vedestä pitäisi löytyä y-koordinaatista 105.", vesilaskuri > 0);

    }

    @Test
    public void vesiJaHiekkaVaihtaaPaikkaa() throws Throwable {
        Object simulaatio = null;
        try {
            simulaatio = Reflex.reflect("hiekkaranta.Simulaatio").ctor().taking(int.class, int.class).invoke(2, 3);
        } catch (Throwable ex) {
            fail("Kutsu new Simulaatio(2, 3) aiheutti virheen. Virhe: " + ex.getMessage());
        }

        Reflex.reflect("hiekkaranta.Simulaatio").method("lisaa").returningVoid().taking(int.class, int.class, Tyyppi.class).invokeOn(simulaatio, 0, 1, Tyyppi.HIEKKA);
        Reflex.reflect("hiekkaranta.Simulaatio").method("lisaa").returningVoid().taking(int.class, int.class, Tyyppi.class).invokeOn(simulaatio, 1, 1, Tyyppi.HIEKKA);

        Reflex.reflect("hiekkaranta.Simulaatio").method("lisaa").returningVoid().taking(int.class, int.class, Tyyppi.class).invokeOn(simulaatio, 0, 2, Tyyppi.VESI);
        Reflex.reflect("hiekkaranta.Simulaatio").method("lisaa").returningVoid().taking(int.class, int.class, Tyyppi.class).invokeOn(simulaatio, 1, 2, Tyyppi.VESI);

        Reflex.reflect("hiekkaranta.Simulaatio").method("paivita").returningVoid().takingNoParams().invokeOn(simulaatio);
        Reflex.reflect("hiekkaranta.Simulaatio").method("paivita").returningVoid().takingNoParams().invokeOn(simulaatio);
        Reflex.reflect("hiekkaranta.Simulaatio").method("paivita").returningVoid().takingNoParams().invokeOn(simulaatio);

        Tyyppi tyyppi = Reflex.reflect("hiekkaranta.Simulaatio").method("sisalto").returning(Tyyppi.class).taking(int.class, int.class).invokeOn(simulaatio, 0, 2);
        assertEquals("Hiekan tulee olla painavampi kuin veden, eli hiekan tulee vaihtaa veden kanssa paikkaa simulaatiossa niiden ollessa päällekkäin. Kokeile toimintaa 2x3 kokoisella simulaatiolla..", Tyyppi.HIEKKA, tyyppi);
        tyyppi = Reflex.reflect("hiekkaranta.Simulaatio").method("sisalto").returning(Tyyppi.class).taking(int.class, int.class).invokeOn(simulaatio, 1, 2);
        assertEquals("Hiekan tulee olla painavampi kuin veden, eli hiekan tulee vaihtaa veden kanssa paikkaa simulaatiossa niiden ollessa päällekkäin. Kokeile toimintaa 2x3 kokoisella simulaatiolla.", Tyyppi.HIEKKA, tyyppi);
    }

    @Test
    public void vesiJaMetalliEiVaihdaPaikkaa() throws Throwable {
        Object simulaatio = null;
        try {
            simulaatio = Reflex.reflect("hiekkaranta.Simulaatio").ctor().taking(int.class, int.class).invoke(2, 3);
        } catch (Throwable ex) {
            fail("Kutsu new Simulaatio(2, 3) aiheutti virheen. Virhe: " + ex.getMessage());
        }

        Reflex.reflect("hiekkaranta.Simulaatio").method("lisaa").returningVoid().taking(int.class, int.class, Tyyppi.class).invokeOn(simulaatio, 0, 1, Tyyppi.METALLI);
        Reflex.reflect("hiekkaranta.Simulaatio").method("lisaa").returningVoid().taking(int.class, int.class, Tyyppi.class).invokeOn(simulaatio, 1, 1, Tyyppi.METALLI);

        Reflex.reflect("hiekkaranta.Simulaatio").method("lisaa").returningVoid().taking(int.class, int.class, Tyyppi.class).invokeOn(simulaatio, 0, 2, Tyyppi.VESI);
        Reflex.reflect("hiekkaranta.Simulaatio").method("lisaa").returningVoid().taking(int.class, int.class, Tyyppi.class).invokeOn(simulaatio, 1, 2, Tyyppi.VESI);

        Reflex.reflect("hiekkaranta.Simulaatio").method("paivita").returningVoid().takingNoParams().invokeOn(simulaatio);
        Reflex.reflect("hiekkaranta.Simulaatio").method("paivita").returningVoid().takingNoParams().invokeOn(simulaatio);
        Reflex.reflect("hiekkaranta.Simulaatio").method("paivita").returningVoid().takingNoParams().invokeOn(simulaatio);

        Tyyppi tyyppi = Reflex.reflect("hiekkaranta.Simulaatio").method("sisalto").returning(Tyyppi.class).taking(int.class, int.class).invokeOn(simulaatio, 0, 2);
        assertEquals("Veden ei tule syrjäyttää metallia. Kokeile toimintaa 2x3 kokoisella simulaatiolla.", Tyyppi.VESI, tyyppi);
        tyyppi = Reflex.reflect("hiekkaranta.Simulaatio").method("sisalto").returning(Tyyppi.class).taking(int.class, int.class).invokeOn(simulaatio, 1, 2);
        assertEquals("Veden ei tule syrjäyttää metallia. Kokeile toimintaa 2x3 kokoisella simulaatiolla.", Tyyppi.VESI, tyyppi);
    }

    @Test
    public void vesiTayttaaKuopan() throws Throwable {
        Object simulaatio = null;
        try {
            simulaatio = Reflex.reflect("hiekkaranta.Simulaatio").ctor().taking(int.class, int.class).invoke(50, 50);
        } catch (Throwable ex) {
            fail("Kutsu new Simulaatio(50, 50) aiheutti virheen. Virhe: " + ex.getMessage());
        }

        // muodostetaan kuoppa
        for (int y = 10; y < 20; y++) {
            Reflex.reflect("hiekkaranta.Simulaatio").method("lisaa").returningVoid().taking(int.class, int.class, Tyyppi.class).invokeOn(simulaatio, 20, y, Tyyppi.METALLI);
            Reflex.reflect("hiekkaranta.Simulaatio").method("lisaa").returningVoid().taking(int.class, int.class, Tyyppi.class).invokeOn(simulaatio, 30, y, Tyyppi.METALLI);
        }

        for (int x = 20; x <= 30; x++) {
            Reflex.reflect("hiekkaranta.Simulaatio").method("lisaa").returningVoid().taking(int.class, int.class, Tyyppi.class).invokeOn(simulaatio, x, 20, Tyyppi.METALLI);
        }

        // lisataan vetta ja päivitetään vuorotellen
        for (int i = 0; i < 200; i++) {
            Reflex.reflect("hiekkaranta.Simulaatio").method("lisaa").returningVoid().taking(int.class, int.class, Tyyppi.class).invokeOn(simulaatio, 25, 5, Tyyppi.VESI);
            Reflex.reflect("hiekkaranta.Simulaatio").method("paivita").returningVoid().takingNoParams().invokeOn(simulaatio);
        }

        for (int i = 0; i < 200; i++) {
            Reflex.reflect("hiekkaranta.Simulaatio").method("paivita").returningVoid().takingNoParams().invokeOn(simulaatio);
        }

        for (int x = 21; x <= 29; x++) {
            for (int y = 10; y < 20; y++) {
                Tyyppi tyyppi = Reflex.reflect("hiekkaranta.Simulaatio").method("sisalto").returning(Tyyppi.class).taking(int.class, int.class).invokeOn(simulaatio, x, y);
                assertEquals("Kun metallista muodostetaan kuppi, ja vettä kaadetaan kuppiin kupin yläpuolelta, tulee veden päätyä kuppiin.\nYlimenevän veden tulee valua yli.", Tyyppi.VESI, tyyppi);
            }
        }

        for (int x = 21; x <= 29; x++) {
            Tyyppi tyyppi = Reflex.reflect("hiekkaranta.Simulaatio").method("sisalto").returning(Tyyppi.class).taking(int.class, int.class).invokeOn(simulaatio, x, 9);
            assertEquals("Kun metallista muodostetaan kuppi, ja vettä kaadetaan kuppiin kupin yläpuolelta, tulee veden päätyä kuppiin.\nYlimenevän veden tulee valua yli.", Tyyppi.TYHJA, tyyppi);
        }
    }

}
