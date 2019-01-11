package esimerkki;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MiniPaint extends Application {

    @Override
    public void start(Stage ikkuna) {

        Canvas piirtoalusta = new Canvas(640, 480);
        GraphicsContext piirturi = piirtoalusta.getGraphicsContext2D();

        ColorPicker varinValitsin = new ColorPicker();

        BorderPane asettelu = new BorderPane();
        asettelu.setCenter(piirtoalusta);
        asettelu.setRight(varinValitsin);

        piirtoalusta.setOnMouseDragged((event) -> {
            double kohtaX = event.getX();
            double kohtaY = event.getY();
            piirturi.setFill(varinValitsin.getValue());
            piirturi.fillOval(kohtaX, kohtaY, 4, 4);
        });

        Scene nakyma = new Scene(asettelu);

        ikkuna.setScene(nakyma);
        ikkuna.show();
    }

    public static void main(String[] args) {
        launch(MiniPaint.class);
    }

}
