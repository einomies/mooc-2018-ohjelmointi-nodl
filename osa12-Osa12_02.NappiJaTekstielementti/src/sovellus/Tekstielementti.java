/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sovellus;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 *
 * @author einomies
 */
public class Tekstielementti extends Application {

    @Override
    public void start(Stage ikkuna) {
        Label teksti = new Label("Tekstielementti");

        FlowPane komponenttiryhma = new FlowPane();
        komponenttiryhma.getChildren().add(teksti);

        Scene nakyma = new Scene(komponenttiryhma);

        ikkuna.setScene(nakyma);
        ikkuna.show();
    }

    public static void main(String[] args) {
        launch(Tekstielementti.class);
    }

}
