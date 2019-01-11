package esimerkki;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class EsimKopiointiButton extends Application {

    @Override
    public void start(Stage ikkuna) {
        TextField vasenTeksti = new TextField();
        TextField oikeaTeksti = new TextField();
        Button nappi = new Button("Kopioi");

        nappi.setOnAction((event) -> {
            oikeaTeksti.setText(vasenTeksti.getText());
        });

        HBox komponenttiryhma = new HBox();
        komponenttiryhma.setSpacing(20);
        komponenttiryhma.getChildren().addAll(vasenTeksti, nappi, oikeaTeksti);

        Scene nakyma = new Scene(komponenttiryhma);

        ikkuna.setScene(nakyma);
        ikkuna.show();
    }

    public static void main(String[] args) {
        launch(EsimKopiointiButton.class);
    }
}
