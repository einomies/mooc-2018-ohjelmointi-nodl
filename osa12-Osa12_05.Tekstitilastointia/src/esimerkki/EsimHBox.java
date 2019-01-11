/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esimerkki;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author einomies
 */
public class EsimHBox extends Application {

    @Override
    public void start(Stage ikkuna) {
        HBox asettelu = new HBox();
        asettelu.setSpacing(10);

        asettelu.getChildren().add(new Label("eka"));
        asettelu.getChildren().add(new Label("toka"));
        asettelu.getChildren().add(new Label("kolmas"));

        Scene nakyma = new Scene(asettelu);

        ikkuna.setScene(nakyma);
        ikkuna.show();
    }

    public static void main(String[] args) {
        launch(EsimHBox.class);
    }

}
