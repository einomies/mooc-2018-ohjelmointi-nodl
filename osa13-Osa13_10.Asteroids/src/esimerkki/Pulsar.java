/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esimerkki;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

/**
 * handles events according to a tempo in beats per minute.
 */
class Pulsar {

    private final DoubleProperty tempo = new SimpleDoubleProperty(100);
    private final Timeline timeline = new Timeline();

    public Pulsar(final double initialTempo, final EventHandler<ActionEvent> pulseHandler) {
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.getKeyFrames().setAll(
                new KeyFrame(Duration.ZERO, pulseHandler),
                new KeyFrame(Duration.minutes(1), null)
        );
        timeline.rateProperty().bind(tempo);

        setTempo(initialTempo);
    }

    public DoubleProperty tempoProperty() {
        return tempo;
    }

    public double getTempo() {
        return tempo.get();
    }

    public void setTempo(double newTempo) {
        tempo.set(newTempo);
    }

    public void start() {
        timeline.play();
    }

    public void stop() {
        timeline.stop();
    }
}
