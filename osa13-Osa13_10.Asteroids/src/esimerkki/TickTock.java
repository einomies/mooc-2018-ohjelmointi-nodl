/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esimerkki;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Creates a metronome with start/stop and tempo controls
 */
public class TickTock extends Application {

    private static final double INITIAL_TEMPO = 100;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage stage) {
        stage.setTitle("Metronome");
        stage.setScene(
                new Scene(
                        new MetronomeView(new Metronome(INITIAL_TEMPO))
                )
        );
        stage.show();
    }
}
