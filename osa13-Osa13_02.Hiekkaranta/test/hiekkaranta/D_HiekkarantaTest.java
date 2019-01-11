package hiekkaranta;

import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.Reflex;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
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

@Points("13-02.4")
public class D_HiekkarantaTest extends HiekkarantaBaseTest {

    @Test
    public void valitaanHiekkaJaPiirretaan() {
        clickOn(napit().get(1));

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
        int oranssia = 0;
        int mustaa = 0;

        for (int x = 0; x < 200; x++) {

            for (int y = 0; y < 200; y++) {
                Color vari = kuvanlukija.getColor(x, y);
                if (vari.equals(Color.ORANGE)) {
                    oranssia++;
                }

                if (vari.equals(Color.BLACK)) {
                    mustaa++;
                }
            }
        }

        // Pytagoraan lause :)
        double pisteitaVahintaan = Math.sqrt((100 * 100) + (100 * 100));

        assertTrue("Kun ruudun vasemmasta ylälaidasta piirretään hiekkaviiva ruudun oikeaan alalaitaan, simulaatioon pitäisi ilmestyä koko matkan kattava oranssi viiva, joka alkaa tippua alaspäin. Nyt oransseja pisteitä oli liian vähän.", oranssia > pisteitaVahintaan);
        assertTrue("Kun ruudun vasemmasta ylälaidasta piirretään hiekkaviiva ruudun oikeaan alalaitaan, simulaatioon pitäisi ilmestyä koko matkan kattava oranssi viiva, joka alkaa tippua alaspäin. Muun alueen tulee pysyä yhä mustana.", mustaa > (200 * 200 - pisteitaVahintaan * 40));

        oranssia = 0;

        for (int x = 0; x < 40; x++) {

            for (int y = 0; y < 40; y++) {
                Color vari = kuvanlukija.getColor(x, y);
                if (vari.equals(Color.ORANGE)) {
                    oranssia++;
                }
            }
        }

        assertTrue("Kun ruudun vasemmasta ylälaidasta piirretään hiekkaviiva ruudun oikeaan alalaitaan, simulaatioon pitäisi ilmestyä koko matkan kattava oranssi viiva. Nyt oranssia ei näkynyt vasemmassa yläkulmassa.", oranssia > 0);

        sleep(500);

        kuvakaappaus = capture(canvas);
        kuva = kuvakaappaus.getImage();
        kuvanlukija = kuva.getPixelReader();

        oranssia = 0;

        for (int x = 10; x < 20; x++) {

            for (int y = 10; y < 20; y++) {
                Color vari = kuvanlukija.getColor(x, y);
                if (vari.equals(Color.ORANGE)) {
                    oranssia++;
                }
            }
        }

        assertTrue("Kun simulaatio on toiminnassa 500 millisekuntia, hiekan tulee tippua ainakin hieman alaspäin. Nyt vasempaan yläkulmaan piiretty hiekka ei ollut siirtynyt.", oranssia == 0);

    }

    @Test
    public void hiekkaSiirtyySimulaatiossa() throws Throwable {
        Object simulaatio = null;
        try {
            simulaatio = Reflex.reflect("hiekkaranta.Simulaatio").ctor().taking(int.class, int.class).invoke(300, 200);
        } catch (Throwable ex) {
            fail("Kutsu new Simulaatio(300, 200) aiheutti virheen. Virhe: " + ex.getMessage());
        }

        Random rnd = new Random();
        Map<Point, Tyyppi> pisteet = new HashMap<>();

        for (int x = 10; x < 20; x++) {
            Reflex.reflect("hiekkaranta.Simulaatio").method("lisaa").returningVoid().taking(int.class, int.class, Tyyppi.class).invokeOn(simulaatio, x, 100, Tyyppi.HIEKKA);
            Tyyppi tyyppi = Reflex.reflect("hiekkaranta.Simulaatio").method("sisalto").returning(Tyyppi.class).taking(int.class, int.class).invokeOn(simulaatio, x, 100);

            assertEquals("Kun simulaatioon on lisätty kohtaan " + x + ", 100 hiekkaa eikä simulaation paivita-kutsua ole kutsuttu, sisalto-metodin pitäisi löytää hiekka kyseisestä kohdasta.", Tyyppi.HIEKKA, tyyppi);
        }

        Reflex.reflect("hiekkaranta.Simulaatio").method("paivita").returningVoid().takingNoParams().invokeOn(simulaatio);
        Reflex.reflect("hiekkaranta.Simulaatio").method("paivita").returningVoid().takingNoParams().invokeOn(simulaatio);
        Reflex.reflect("hiekkaranta.Simulaatio").method("paivita").returningVoid().takingNoParams().invokeOn(simulaatio);
        Reflex.reflect("hiekkaranta.Simulaatio").method("paivita").returningVoid().takingNoParams().invokeOn(simulaatio);

        int hiekkalaskuri = 0;
        for (int x = 5; x < 25; x++) {
            Tyyppi tyyppi = Reflex.reflect("hiekkaranta.Simulaatio").method("sisalto").returning(Tyyppi.class).taking(int.class, int.class).invokeOn(simulaatio, x, 105);
            if (tyyppi == Tyyppi.HIEKKA) {
                hiekkalaskuri++;
            }

        }

        Reflex.reflect("hiekkaranta.Simulaatio").method("paivita").returningVoid().takingNoParams().invokeOn(simulaatio);

        for (int x = 10; x < 20; x++) {
            Tyyppi tyyppi = Reflex.reflect("hiekkaranta.Simulaatio").method("sisalto").returning(Tyyppi.class).taking(int.class, int.class).invokeOn(simulaatio, x, 100);

            assertNotEquals("Kun simulaatioon on lisätty kohtaan (x=" + x + ", y=100) ja simulaation paivita-metodia on kutsuttu, ei hiekan enää pitäisi olla alkuperäisessä paikassa.", Tyyppi.HIEKKA, tyyppi);
        }

        for (int x = 5; x < 25; x++) {
            Tyyppi tyyppi = Reflex.reflect("hiekkaranta.Simulaatio").method("sisalto").returning(Tyyppi.class).taking(int.class, int.class).invokeOn(simulaatio, x, 105);
            if (tyyppi == Tyyppi.HIEKKA) {
                hiekkalaskuri++;
            }

        }

        Reflex.reflect("hiekkaranta.Simulaatio").method("paivita").returningVoid().takingNoParams().invokeOn(simulaatio);

        for (int x = 5; x < 25; x++) {
            Tyyppi tyyppi = Reflex.reflect("hiekkaranta.Simulaatio").method("sisalto").returning(Tyyppi.class).taking(int.class, int.class).invokeOn(simulaatio, x, 105);
            if (tyyppi == Tyyppi.HIEKKA) {
                hiekkalaskuri++;
            }

        }

        assertTrue("Kun simulaatioon on lisätty hiekkaa y-koordinaattiin 100 ja simulaation paivita-metodia on kutsutaan viisi kertaa, ainakin osan pitäisi löytyä y-koordinaatista 105.", hiekkalaskuri > 0);

    }

    @Test
    public void hiekkaEiSiirryMetallinYli() throws Throwable {
        Object simulaatio = null;
        try {
            simulaatio = Reflex.reflect("hiekkaranta.Simulaatio").ctor().taking(int.class, int.class).invoke(300, 200);
        } catch (Throwable ex) {
            fail("Kutsu new Simulaatio(300, 200) aiheutti virheen. Virhe: " + ex.getMessage());
        }

        Random rnd = new Random();
        Map<Point, Tyyppi> pisteet = new HashMap<>();

        for (int x = 10; x < 20; x++) {
            Reflex.reflect("hiekkaranta.Simulaatio").method("lisaa").returningVoid().taking(int.class, int.class, Tyyppi.class).invokeOn(simulaatio, x, 100, Tyyppi.METALLI);
            Reflex.reflect("hiekkaranta.Simulaatio").method("lisaa").returningVoid().taking(int.class, int.class, Tyyppi.class).invokeOn(simulaatio, x, 99, Tyyppi.HIEKKA);
        }

        Reflex.reflect("hiekkaranta.Simulaatio").method("paivita").returningVoid().takingNoParams().invokeOn(simulaatio);
        Reflex.reflect("hiekkaranta.Simulaatio").method("paivita").returningVoid().takingNoParams().invokeOn(simulaatio);
        Reflex.reflect("hiekkaranta.Simulaatio").method("paivita").returningVoid().takingNoParams().invokeOn(simulaatio);
        Reflex.reflect("hiekkaranta.Simulaatio").method("paivita").returningVoid().takingNoParams().invokeOn(simulaatio);
        Reflex.reflect("hiekkaranta.Simulaatio").method("paivita").returningVoid().takingNoParams().invokeOn(simulaatio);

        for (int x = 11; x < 19; x++) {
            Tyyppi tyyppi = Reflex.reflect("hiekkaranta.Simulaatio").method("sisalto").returning(Tyyppi.class).taking(int.class, int.class).invokeOn(simulaatio, x, 99);

            assertEquals("Kun simulaatioon on lisätty ensin metalliviiva, jonka päällä on hiekkaa, ei hiekan tule siirtyä metallin läpi.", Tyyppi.HIEKKA, tyyppi);
        }

    }

    @Test
    public void tippuvaHiekkaPutoaaPohjalle() throws Throwable {

        Object simulaatio = null;
        try {
            simulaatio = Reflex.reflect("hiekkaranta.Simulaatio").ctor().taking(int.class, int.class).invoke(300, 200);
        } catch (Throwable ex) {
            fail("Kutsu new Simulaatio(300, 200) aiheutti virheen. Virhe: " + ex.getMessage());
        }

        Random rnd = new Random();
        Map<Point, Tyyppi> pisteet = new HashMap<>();

        int hiekkaaLisatty = 0;
        for (int x = 10; x < 20; x++) {
            Reflex.reflect("hiekkaranta.Simulaatio").method("lisaa").returningVoid().taking(int.class, int.class, Tyyppi.class).invokeOn(simulaatio, x, 100, Tyyppi.HIEKKA);
            Reflex.reflect("hiekkaranta.Simulaatio").method("lisaa").returningVoid().taking(int.class, int.class, Tyyppi.class).invokeOn(simulaatio, x, 99, Tyyppi.HIEKKA);
            Reflex.reflect("hiekkaranta.Simulaatio").method("lisaa").returningVoid().taking(int.class, int.class, Tyyppi.class).invokeOn(simulaatio, x, 98, Tyyppi.HIEKKA);
            Reflex.reflect("hiekkaranta.Simulaatio").method("lisaa").returningVoid().taking(int.class, int.class, Tyyppi.class).invokeOn(simulaatio, x, 97, Tyyppi.HIEKKA);
            Reflex.reflect("hiekkaranta.Simulaatio").method("lisaa").returningVoid().taking(int.class, int.class, Tyyppi.class).invokeOn(simulaatio, x, 96, Tyyppi.HIEKKA);

            hiekkaaLisatty += 5;
        }

        for (int i = 0; i < 200; i++) {
            Reflex.reflect("hiekkaranta.Simulaatio").method("paivita").returningVoid().takingNoParams().invokeOn(simulaatio);
        }

        int hiekkaaLoytyi = 0;
        for (int x = 0; x < 300; x++) {
            for (int y = 0; y < 200; y++) {
                Tyyppi tyyppi = Reflex.reflect("hiekkaranta.Simulaatio").method("sisalto").returning(Tyyppi.class).taking(int.class, int.class).invokeOn(simulaatio, x, y);
                if (Tyyppi.HIEKKA == tyyppi) {
                    hiekkaaLoytyi++;
                }
            }
        }

        assertEquals("Kun hiekkaa lisätään " + hiekkaaLisatty + " jyvää, tulee jokaisen jyvän olla mukana simulaatiossa myös 200 päivitä-kutsun jälkeen.", hiekkaaLisatty, hiekkaaLoytyi);

        Tyyppi tyyppi = Reflex.reflect("hiekkaranta.Simulaatio").method("sisalto").returning(Tyyppi.class).taking(int.class, int.class).invokeOn(simulaatio, 8, 199);
        assertEquals("Valuuhan hiekka myös sivuille?", Tyyppi.HIEKKA, tyyppi);
        tyyppi = Reflex.reflect("hiekkaranta.Simulaatio").method("sisalto").returning(Tyyppi.class).taking(int.class, int.class).invokeOn(simulaatio, 22, 199);
        assertEquals("Valuuhan hiekka myös sivuille?", Tyyppi.HIEKKA, tyyppi);

    }

}
