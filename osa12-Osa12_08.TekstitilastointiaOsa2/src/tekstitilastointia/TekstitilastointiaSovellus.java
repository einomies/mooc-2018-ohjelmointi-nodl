package tekstitilastointia;

import java.util.Arrays;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TekstitilastointiaSovellus extends Application {

    @Override
    public void start(Stage ikkuna) {
        BorderPane asettelu = new BorderPane();

        TextArea textArea = new TextArea("");

        asettelu.setCenter(textArea);

        HBox hBox = new HBox();
        hBox.setSpacing(50);
        Label kirjaimetLabel = new Label("Kirjaimia: 0");
        Label sanatLabel = new Label("Sanoja: 0");
        Label pisinSanaLabel = new Label("Pisin sana on: ");
        hBox.getChildren().add(kirjaimetLabel);
        hBox.getChildren().add(sanatLabel);
        hBox.getChildren().add(pisinSanaLabel);

        textArea.textProperty().addListener((muutos, vanhaArvo, uusiArvo) -> {
            int merkkeja = uusiArvo.length();
            String[] palat = uusiArvo.split(" ");
            int sanoja = palat.length;
//            int sanoja = uusiArvo.split(" ").length;
            String pisin = Arrays.stream(palat)
                    .sorted((s1, s2) -> s2.length() - s1.length())
                    .findFirst()
                    .get();
            // asetetaan arvot tekstielementteihin
            kirjaimetLabel.setText("Kirjaimia: " + merkkeja);
            sanatLabel.setText("Sanoja: " + sanoja);
            pisinSanaLabel.setText("Pisin sana on: " + pisin);
        });

        asettelu.setBottom(hBox);

//        asettelu.setTop(new Label("ylälaita"));
//        asettelu.setRight(new Label("oikea laita"));
//        asettelu.setLeft(new Label("vasen laita"));
        Scene nakyma = new Scene(asettelu);

        ikkuna.setScene(nakyma);
        ikkuna.show();
    }

    public static void main(String[] args) {
        launch(TekstitilastointiaSovellus.class);
    }

}
