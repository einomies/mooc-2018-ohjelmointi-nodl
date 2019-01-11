
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Maara extends Application {

    @Override
    public void start(Stage stage) {

        // luodaan ulkoasu ja määritetään käyttöliittymän komponenttien asettelu
        GridPane root = new GridPane();
        root.setVgap(10);
        root.setHgap(5);
        root.setPadding(new Insets(10));

        // luodaan liukuri sekä tekstikenttä
        Slider liukuri = new Slider(0, 100, 50);
        liukuri.setId("liukuri");
        liukuri.setShowTickMarks(true);
        liukuri.setShowTickLabels(true);
        liukuri.setMajorTickUnit(25);
        liukuri.setBlockIncrement(5);

        Label teksti = new Label("Kohtalaisesti.");
        teksti.setId("teksti");

        // liitetään liukuriin toiminnallisuus, jolla muutetaan tekstiä
        liukuri.valueProperty().addListener((ObservableValue<? extends Number> ov, Number oldValue, Number newValue) -> {
            int arvo = newValue.intValue();

            if (arvo == 0) {
                teksti.setText("Ei lainkaan.");
            } else if (arvo < 26) {
                teksti.setText("Vähän.");
            } else if (arvo < 75) {
                teksti.setText("Kohtalaisesti.");
            } else if (arvo < 100) {
                teksti.setText("Paljon.");
            } else {
                teksti.setText("Kaikki.");
            }
            /*
            Jos liukurin arvo on 0, tekstin tulee olla "Ei lainkaan."
            Jos liukurin arvo on 1-25, tekstin tulee olla "Vähän."
            Jos liukurin arvo on 26-74, tekstin tulee olla "Kohtalaisesti."
            Jos liukurin arvo on 75-99, tekstin tulee olla "Paljon."
            Jos liukurin arvo on 100, tekstin tulee olla "Kaikki."
            */
        });

        // lisätään luodut elementit käyttöliittymään
        root.add(liukuri, 0, 0);
        root.add(teksti, 0, 1);

        // näytetään ohjelma
        Scene scene = new Scene(root);

        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
