package esimerkki;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class KollaasiTesti extends Application {

    @Override
    public void start(Stage stage) {

        Image kuvatiedosto = new Image("file:monalisa.png");

        PixelReader lukija = kuvatiedosto.getPixelReader();
        int leveys = (int) kuvatiedosto.getWidth();
        int korkeus = (int) kuvatiedosto.getHeight();
        System.out.println("leveys: " + leveys);
        System.out.println("korkeus: " + korkeus);

        WritableImage kohdeKuva = new WritableImage(leveys, korkeus);
        PixelWriter kirjoittaja = kohdeKuva.getPixelWriter();
        /*
        Ensimmäisen kuvan vasemman yläkulman tulee olla koordinaatissa 0, 0.
        Toisen kuvan vasemman yläkulman tulee olla koordinaatissa (kuvan leveys / 2), 0.
        Kolmannen kuvan vasemman yläkulman tulee olla koordinaatissa 0, (kuvan korkeus / 2).
        Neljännen kuvan vasemman yläkulman tulee olla koordinaatissa (kuvan leveys / 2), (kuvan korkeus / 2).
         */

        for (int y = 0; y < korkeus; y++) {
            for (int x = 0; x < leveys; x++) {

                if (x % 2 == 0 && y % 2 == 0) {
                    Color vari = lukija.getColor(x, y);
                    double punainen = vari.getRed();
                    double vihrea = vari.getGreen();
                    double sininen = vari.getBlue();
                    double lapinakyvyys = vari.getOpacity();

                    Color uusiVari = new Color(punainen, vihrea, sininen, lapinakyvyys);

                    kirjoittaja.setColor(x / 2, y / 2, uusiVari);
                }
            }
        }
        ImageView kuva = new ImageView(kohdeKuva);

        Pane pane = new Pane();
        pane.getChildren().add(kuva);
//        pane.getChildren().add(kuva);
//        pane.getChildren().add(kuva);
//        pane.getChildren().add(kuva);

        stage.setScene(new Scene(pane));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
