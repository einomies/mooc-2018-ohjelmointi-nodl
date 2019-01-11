package sovellus;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class EdesTakaisinSovellus extends Application {

    @Override
    public void start(Stage ikkuna) {

        Button edes = new Button("Edes ..");
        Button takaisin = new Button(".. takaisin.");

        Scene eka = new Scene(edes);
        Scene toka = new Scene(takaisin);

        edes.setOnAction((event) -> {
            ikkuna.setScene(toka);
        });

        takaisin.setOnAction((event) -> {
            ikkuna.setScene(eka);
        });

        ikkuna.setScene(eka);
        ikkuna.show();
    }

    public static void main(String[] args) {
        launch(EdesTakaisinSovellus.class);
    }

}
