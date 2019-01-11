/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esimerkki;

import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

/**
 *
 * @author einomies
 */
public class NopanHeitto extends Application {

    @Override
    public void start(Stage ikkuna) {
        BorderPane asettelu = new BorderPane();
        final String buttonPysayta = "Pysäytä";
        final String buttonJatka = "Jatka";
        Button button = new Button(buttonPysayta);
        Label labelViimeisimmatOtsikko = new Label("Viimeisimmät tulokset: ");
        Label labelViimeisimmatLuvut = new Label("");
        Label labelKeskiarvo = new Label("Tulosten keskiarvo: 0");
        int[] viimeisimmat = new int[10];

        Region region01 = new Region();
        Region region02 = new Region();

        HBox.setHgrow(region01, Priority.ALWAYS);
        HBox.setHgrow(region02, Priority.ALWAYS);

        HBox hBox = new HBox();
        hBox.getChildren().add(labelViimeisimmatOtsikko);
        hBox.getChildren().add(labelViimeisimmatLuvut);
        hBox.getChildren().add(region01);
        hBox.getChildren().add(button);
        hBox.getChildren().add(region02);
        hBox.getChildren().add(labelKeskiarvo);
        hBox.setPadding(new Insets(5, 5, 5, 5));

        asettelu.setTop(hBox);

        // Luokkaa Random käytetään nopan heittojen arpomiseen
        Random arpoja = new Random();

        NumberAxis xAkseli = new NumberAxis();
        xAkseli.setLabel("Nopanheittojen lukumäärä");
        // y-akseli kuvaa nopanheittojen keskiarvoa. Keskiarvo on aina välillä [1-6]
        NumberAxis yAkseli = new NumberAxis(1, 6, 1);

        LineChart<Number, Number> viivakaavio = new LineChart<>(xAkseli, yAkseli);
        // kaaviosta poistetaan mm. pisteisiin liittyvät ympyrät
        viivakaavio.setLegendVisible(false);
        viivakaavio.setAnimated(false);
        viivakaavio.setCreateSymbols(false);

        // luodaan dataa kuvaava muuttuja ja lisätään se kaavioon
        XYChart.Series keskiarvo = new XYChart.Series();
        viivakaavio.getData().add(keskiarvo);

        asettelu.setCenter(viivakaavio);

        new AnimationTimer() {
            private long edellinen;
            private long summa;
            private long lukuja;
            String viimeisimmatString = "";

            @Override
            public void handle(long nykyhetki) {

                button.setOnAction((event) -> {
                    if (button.getText().equals(buttonPysayta)) {
                        this.stop();
                        button.setText(buttonJatka);
                    } else {
                        this.start();
                        button.setText(buttonPysayta);
                    }
                });

                if (nykyhetki - edellinen < 100_000_000L) {
                    return;
                }

                edellinen = nykyhetki;

                // heitetään noppaa
                int luku = arpoja.nextInt(6) + 1;

                // kasvatetaan summaa ja lukujen määrää
                summa += luku;
                lukuja++;

                for (int i = viimeisimmat.length - 2; i >= 0; i--) {
                    viimeisimmat[i + 1] = viimeisimmat[i];
                }
                viimeisimmat[0] = luku;

                viimeisimmatString = "";
                for (int k = 0; k < viimeisimmat.length; k++) {
                    if (k < viimeisimmat.length - 1) {
                        viimeisimmatString += viimeisimmat[k] + ", ";
                    } else {
                        viimeisimmatString += viimeisimmat[k];
                    }
                }

                double ka = 1.0 * summa / lukuja;

                // lisätään dataan uusi piste
                keskiarvo.getData().add(new XYChart.Data(lukuja, ka));

                // päivitetään keskiarvon Label
                labelKeskiarvo.setText("Tulosten keskiarvo: " + String.format("%.2f", ka));

                // päivitetään viimeisimpien tulosten Label
                labelViimeisimmatLuvut.setText(viimeisimmatString);
            }
        }.start();

//        Scene nakyma = new Scene(viivakaavio, 400, 300);
        Scene nakyma = new Scene(asettelu, 800, 600);
        ikkuna.setScene(nakyma);
        ikkuna.show();
    }

    public static void main(String[] args) {
        launch(NopanHeitto.class);
    }

}
