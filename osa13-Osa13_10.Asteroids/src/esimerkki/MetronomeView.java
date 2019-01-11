/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esimerkki;

import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.HBox;

/**
 * Provides a UI to control a metronome which ticks on pulses generated by a
 * tempo in beats per minute.
 */
class MetronomeView extends HBox {

    private static final double MIN_TEMPO = 40;
    private static final double MAX_TEMPO = 180;

    public MetronomeView(Metronome metronome) {
        super(10);
        getChildren().addAll(
                createStartStopControl(metronome),
                createTempoControl(metronome),
                createTempoReadout(metronome)
        );
        setAlignment(Pos.CENTER);
        setStyle("-fx-background-color: cornsilk; -fx-padding: 10;");
    }

    protected Label createTempoReadout(Metronome metronome) {
        Label label = new Label();
        label.textProperty().bind(Bindings.format("%.0f", metronome.getPulsar().tempoProperty()));
        label.setPrefWidth(25);
        label.setAlignment(Pos.CENTER_RIGHT);

        return label;
    }

    protected Slider createTempoControl(Metronome metronome) {
        final Slider slider = new Slider(MIN_TEMPO, MAX_TEMPO, metronome.getPulsar().getTempo());
        slider.valueProperty().bindBidirectional(metronome.getPulsar().tempoProperty());
        slider.setMajorTickUnit(1);
        slider.setMinorTickCount(0);
        slider.setSnapToTicks(true);

        return slider;
    }

    protected ToggleButton createStartStopControl(final Metronome metronome) {
        final ToggleButton playControl = new ToggleButton("Start");
        playControl.setPrefWidth(60);
        playControl.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean wasSelected, Boolean selected) {
                if (selected) {
                    metronome.getPulsar().start();
                    playControl.setText("Stop");
                } else {
                    metronome.getPulsar().stop();
                    playControl.setText("Start");
                }
            }
        });
        return playControl;
    }
}
