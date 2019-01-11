/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sovellus;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 *
 * @author einomies
 */
public class JavaFxSovellus extends Application {

    @Override
    public void start(Stage ikkuna) {
        Label teksti = new Label("Tekstielementti");
        Button nappi = new Button("Tämä on nappi");

        final ToggleGroup group = new ToggleGroup();

        RadioButton rb1 = new RadioButton("Home");
        rb1.setToggleGroup(group);
        rb1.setSelected(true);

        RadioButton rb2 = new RadioButton("Calendar");
        rb2.setToggleGroup(group);

        RadioButton rb3 = new RadioButton("Contacts");
        rb3.setToggleGroup(group);

        FlowPane komponenttiryhma = new FlowPane();
        komponenttiryhma.getChildren().add(teksti);
        komponenttiryhma.getChildren().add(nappi);
        komponenttiryhma.getChildren().add(rb1);
        komponenttiryhma.getChildren().add(rb2);
        komponenttiryhma.getChildren().add(rb3);

        Scene nakyma = new Scene(komponenttiryhma);

        ikkuna.setScene(nakyma);
        ikkuna.show();
    }

    public static void main(String[] args) {
        launch(JavaFxSovellus.class);
    }

}
