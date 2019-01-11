package tekstitilastointia;

import esimerkki.EsimBorderPane;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TekstitilastointiaSovellus extends Application {

    @Override
    public void start(Stage ikkuna) {
        BorderPane asettelu = new BorderPane();
        asettelu.setCenter(new TextArea("TextArea"));
        
        HBox hBox = new HBox();
        hBox.setSpacing(50);
        hBox.getChildren().add(new Label("Kirjaimia: 0"));
        hBox.getChildren().add(new Label("Sanoja: 0"));
        hBox.getChildren().add(new Label("Pisin sana on:"));
        
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
