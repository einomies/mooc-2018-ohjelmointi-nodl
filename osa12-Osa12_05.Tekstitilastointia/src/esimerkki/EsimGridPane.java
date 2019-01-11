/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esimerkki;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author einomies
 */
public class EsimGridPane extends Application {

    @Override
    public void start(Stage ikkuna) {
        GridPane asettelu = new GridPane();

        for (int x = 1; x <= 3; x++) {
            for (int y = 1; y <= 3; y++) {
                asettelu.add(new Button("" + x + ", " + y), x, y);
            }
        }

        Scene nakyma = new Scene(asettelu);

        ikkuna.setScene(nakyma);
        ikkuna.show();
    }

    public static void main(String[] args) {
        launch(EsimGridPane.class);
    }

}
