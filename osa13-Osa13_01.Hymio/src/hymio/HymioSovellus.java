package hymio;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class HymioSovellus extends Application {

    @Override
    public void start(Stage ikkuna) throws Exception {
        final int piirtoalustaLeveys = 800;
        final int piirtoalustaKorkeus = 800;
        Canvas piirtoalusta = new Canvas(piirtoalustaLeveys, piirtoalustaKorkeus);
        GraphicsContext piirturi = piirtoalusta.getGraphicsContext2D();

        final int korkeusGlobal = piirtoalustaKorkeus / 8;
        final int leveysNelio = piirtoalustaLeveys / 8;

        piirturi.fillRect(piirtoalustaLeveys / 4, piirtoalustaKorkeus / 8, leveysNelio, korkeusGlobal);
        piirturi.fillRect(piirtoalustaLeveys / 2 + piirtoalustaLeveys / 8, piirtoalustaKorkeus / 8, leveysNelio, korkeusGlobal);

        piirturi.fillRect(piirtoalustaLeveys / 8, piirtoalustaKorkeus / 2, leveysNelio, korkeusGlobal);
        piirturi.fillRect(piirtoalustaLeveys / 2 + piirtoalustaLeveys / 4, piirtoalustaKorkeus / 2, leveysNelio, korkeusGlobal);

        piirturi.fillRect(piirtoalustaLeveys / 4, piirtoalustaKorkeus / 2 + piirtoalustaKorkeus / 8, 4 * leveysNelio, korkeusGlobal);

        piirturi.setFill(Color.BEIGE);

        BorderPane asettelu = new BorderPane();
        asettelu.setCenter(piirtoalusta);
        Scene nakyma = new Scene(asettelu);

        ikkuna.setScene(nakyma);
        ikkuna.show();
    }

    public static void main(String[] args) {
        launch(HymioSovellus.class);
    }

}
/*
package hymio;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class HymioSovellus extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Canvas piirtoalusta = new Canvas(400, 400);
        GraphicsContext piirturi = piirtoalusta.getGraphicsContext2D();
        piirturi.setFill(Color.WHITE);
        piirturi.clearRect(0, 0, 640, 480);
        piirturi.setFill(Color.BLACK);
        piirturi.fillRect(100, 50, 50, 50);
        piirturi.fillRect(250, 50, 50, 50);
        piirturi.fillRect(100, 250, 200, 50);
        piirturi.fillRect(50, 200, 50, 50);
        piirturi.fillRect(300, 200, 50, 50);
        BorderPane asettelu = new BorderPane();
        asettelu.setCenter(piirtoalusta);
        Scene nakyma = new Scene(asettelu);
        stage.setScene(nakyma);
        stage.show();
    }

    public static void main(String[] args) {
        launch(HymioSovellus.class);
        System.out.println("Hello world!");
    }
}
*/