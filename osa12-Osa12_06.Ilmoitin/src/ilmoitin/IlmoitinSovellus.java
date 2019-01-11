package ilmoitin;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class IlmoitinSovellus extends Application {

    @Override
    public void start(Stage ikkuna) {
        TextField tekstisyote = new TextField();
        Button nappi = new Button("Päivitä");
        Label label = new Label();

        nappi.setOnAction((event) -> {
            label.setText(tekstisyote.getText());
        });

        VBox komponenttiryhma = new VBox();
        komponenttiryhma.setSpacing(10);
        komponenttiryhma.getChildren().addAll(tekstisyote, nappi, label);

        Scene nakyma = new Scene(komponenttiryhma);

        ikkuna.setScene(nakyma);
        ikkuna.show();
    }

    public static void main(String[] args) {
        launch(IlmoitinSovellus.class);
    }

}
