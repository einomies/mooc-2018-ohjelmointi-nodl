package sovellus;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class SalattuSovellus extends Application {

    @Override
    public void start(Stage ikkuna) throws Exception {

        // 1. Luodaan salasanan kysymiseen käytetty näkymä

        // 1.1 luodaan käytettävät komponentit
        Label ohjeteksti = new Label("Kirjoita salasana ja paina kirjaudu");
        PasswordField salasanakentta = new PasswordField();
        Button aloitusnappi = new Button("Kirjaudu");
        Label virheteksti = new Label("");

        // 1.2 luodaan asettelu ja lisätään komponentit siihen
        GridPane asettelu = new GridPane();

        asettelu.add(ohjeteksti, 0, 0);
        asettelu.add(salasanakentta, 0, 1);
        asettelu.add(aloitusnappi, 0, 2);
        asettelu.add(virheteksti, 0, 3);

        // 1.3 tyylitellään asettelua
        asettelu.setPrefSize(300, 180);
        asettelu.setAlignment(Pos.CENTER);
        asettelu.setVgap(10);
        asettelu.setHgap(10);
        asettelu.setPadding(new Insets(20, 20, 20, 20));

        // 1.4 luodaan itse näkymä ja asetetaan asettelu siihen
        Scene salasanaNakyma = new Scene(asettelu);

        // 2. Luodaan tervetuloa-tekstin näyttämiseen käytetty näkymä
        Label tervetuloaTeksti = new Label("Tervetuloa, tästä se alkaa!");

        StackPane tervetuloaAsettelu = new StackPane();
        tervetuloaAsettelu.setPrefSize(300, 180);
        tervetuloaAsettelu.getChildren().add(tervetuloaTeksti);
        tervetuloaAsettelu.setAlignment(Pos.CENTER);

        Scene tervetuloaNakyma = new Scene(tervetuloaAsettelu);

        // 3. Lisätään salasanaruudun nappiin tapahtumankäsittelijä
        //    näkymää vaihdetaan jos salasana on oikein
        aloitusnappi.setOnAction((event) -> {
            if (!salasanakentta.getText().trim().equals("salasana")) {
                virheteksti.setText("Tuntematon salasana!");
                return;
            }

            ikkuna.setScene(tervetuloaNakyma);
        });

        ikkuna.setScene(salasanaNakyma);
        ikkuna.show();
    }

    public static void main(String[] args) {
        launch(SalattuSovellus.class);
    }
}
