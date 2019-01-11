/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esimerkki;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.AudioClip;

/**
 * ticks according to a tempo in beats per minute controlled by the associated
 * pulsar.
 */
class Metronome {

    private final AudioClip tick = new AudioClip("http://www.denhaku.com/r_box/sr16/sr16perc/losticks.wav");
    private final Pulsar pulsar;

    public Metronome(final double initialTempo) {
        // the first time the audioclip is played, there is a delay before you hear it,
        // so play with zero volume now as to make sure it is ready to play when straight away when needed.
        tick.play(0);

        pulsar = new Pulsar(initialTempo, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                tick.play();
            }
        });
    }

    public Pulsar getPulsar() {
        return pulsar;
    }
}
