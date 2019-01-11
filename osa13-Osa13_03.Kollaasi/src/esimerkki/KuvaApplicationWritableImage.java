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

public class KuvaApplicationWritableImage extends Application {

    @Override
    public void start(Stage stage) {

        Image kuvatiedosto = new Image("file:humming.jpg");

        PixelReader lukija = kuvatiedosto.getPixelReader();

        int leveys = (int) kuvatiedosto.getWidth();
        int korkeus = (int) kuvatiedosto.getHeight();

        WritableImage kohdeKuva = new WritableImage(leveys, korkeus);
        PixelWriter kirjoittaja = kohdeKuva.getPixelWriter();

        for (int y = 0; y < korkeus; y++) {
            for (int x = 0; x < leveys; x++) {

                Color vari = lukija.getColor(x, y);
                double punainen = vari.getRed();
                double vihrea = vari.getGreen();
                double sininen = vari.getBlue();
                double lapinakyvyys = vari.getOpacity();

                Color uusiVari = new Color(punainen, vihrea, sininen, lapinakyvyys);

                kirjoittaja.setColor(x, y, uusiVari);
            }
        }

        ImageView kuva = new ImageView(kohdeKuva);

        Pane pane = new Pane();
        pane.getChildren().add(kuva);

        stage.setScene(new Scene(pane));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
