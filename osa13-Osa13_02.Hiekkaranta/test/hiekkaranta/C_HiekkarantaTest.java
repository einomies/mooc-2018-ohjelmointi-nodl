package hiekkaranta;

import fi.helsinki.cs.tmc.edutestutils.Points;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.testfx.service.support.Capture;

@Points("13-02.3")
public class C_HiekkarantaTest extends HiekkarantaBaseTest {

    @Test
    public void canvasAluksiMusta() {
        Canvas canvas = piirtoalusta();
        Capture kuvakaappaus = capture(canvas);

        Image kuva = kuvakaappaus.getImage();

        PixelReader kuvanlukija = kuva.getPixelReader();

        for (int x = 0; x < 200; x++) {

            for (int y = 0; y < 200; y++) {
                Color vari = kuvanlukija.getColor(x, y);
                assertEquals("Vain tyhjää sisältävän Simulaation Canvas-olion pitäisi sisältää vain mustaa väriä.\nKohdassa " + x + ", " + y + " oli väri " + vari + " vaikka odotettiin väriä " + Color.BLACK + ".", Color.BLACK, vari);
            }
        }
    }

    @Test
    public void valitaanMetalliJaPiirretaan() {
        clickOn(napit().get(0));

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
        int valkoista = 0;
        int mustaa = 0;

        for (int x = 0; x < 200; x++) {

            for (int y = 0; y < 200; y++) {
                Color vari = kuvanlukija.getColor(x, y);
                if (vari.equals(Color.WHITE)) {
                    valkoista++;
                }

                if (vari.equals(Color.BLACK)) {
                    mustaa++;
                }
            }
        }

        // Pytagoraan lause, oletetaan että ainakin osaan piirretään :)
        double pisteitaVahintaan = Math.sqrt((100 * 100) + (100 * 100));

        assertTrue("Kun ruudun vasemmasta ylälaidasta piirretään viiva ruudun oikeaan alalaitaan, simulaatioon pitäisi ilmestyä koko matkan kattava valkoinen viiva. Nyt valkoisia pisteitä oli liian vähän.", valkoista > pisteitaVahintaan);
        assertTrue("Kun ruudun vasemmasta ylälaidasta piirretään viiva ruudun oikeaan alalaitaan, simulaatioon pitäisi ilmestyä koko matkan kattava valkoinen viiva. Muun alueen tulee pysyä yhä mustana.", mustaa > (200 * 200 - pisteitaVahintaan * 40));
    }

}
