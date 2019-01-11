/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esimerkki;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author einomies
 */
public class EsimBorderPane extends Application {

    @Override
    public void start(Stage ikkuna) {
        BorderPane asettelu = new BorderPane();
        
        asettelu.setTop(new Label("ylälaita"));
        asettelu.setRight(new Label("oikea laita"));
        asettelu.setBottom(new Label("alalaita"));
        asettelu.setLeft(new Label("vasen laita"));
        asettelu.setCenter(new Label("keskikohta"));

        Scene nakyma = new Scene(asettelu);

        ikkuna.setScene(nakyma);
        ikkuna.show();
    }

    public static void main(String[] args) {
        launch(EsimBorderPane.class);
    }

}
