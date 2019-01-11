package esimerkki;

import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AnimaationAlku extends Application {

    @Override
    public void start(Stage ikkuna) {

        Canvas piirtoalusta = new Canvas(320, 240);
        GraphicsContext piirturi = piirtoalusta.getGraphicsContext2D();
        piirturi.setFill(Color.BLACK);

        BorderPane asettelu = new BorderPane();
        asettelu.setCenter(piirtoalusta);

        Random arpoja = new Random();

        new AnimationTimer() {
            long edellinen = 0;

            @Override
            public void handle(long nykyhetki) {
                if (nykyhetki - edellinen < 100000000) {
                    return;
                }

                int x = arpoja.nextInt(310);
                int y = arpoja.nextInt(230);

                piirturi.fillOval(x, y, 10, 10);

                this.edellinen = nykyhetki;
            }
        }.start();

        Scene nakyma = new Scene(asettelu);

        ikkuna.setScene(nakyma);
        ikkuna.show();
    }

    public static void main(String[] args) {
        launch(AnimaationAlku.class);
    }

}
