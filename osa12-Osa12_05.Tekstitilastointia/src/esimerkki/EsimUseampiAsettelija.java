/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esimerkki;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author einomies
 */
public class EsimUseampiAsettelija extends Application {

    @Override
    public void start(Stage ikkuna) {
        BorderPane asettelu = new BorderPane();

        HBox napit = new HBox();
        napit.setSpacing(10);
        napit.getChildren().add(new Button("Eka"));
        napit.getChildren().add(new Button("Toka"));
        napit.getChildren().add(new Button("Kolmas"));

        VBox tekstit = new VBox();
        tekstit.setSpacing(10);
        tekstit.getChildren().add(new Label("Eka"));
        tekstit.getChildren().add(new Label("Toka"));
        tekstit.getChildren().add(new Label("Kolmas"));

        asettelu.setTop(napit);
        asettelu.setLeft(tekstit);

        asettelu.setCenter(new TextArea(""));

        Scene nakyma = new Scene(asettelu);

        ikkuna.setScene(nakyma);
        ikkuna.show();
    }

    public static void main(String[] args) {
        launch(EsimUseampiAsettelija.class);
    }

}
