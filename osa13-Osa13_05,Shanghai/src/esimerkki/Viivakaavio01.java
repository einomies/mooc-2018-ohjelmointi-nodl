/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esimerkki;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

/**
 *
 * @author einomies
 */
public class Viivakaavio01 extends Application {

    @Override
    public void start(Stage ikkuna) {
//        NumberAxis xAkseli = new NumberAxis();
        NumberAxis xAkseli = new NumberAxis(1960, 2018, 4);
        NumberAxis yAkseli = new NumberAxis();
        xAkseli.setLabel("Vuosi");

        yAkseli.setLabel("Suhteellinen kannatus (%)");

        LineChart<Number, Number> viivakaavio = new LineChart<>(xAkseli, yAkseli);
        viivakaavio.setTitle("Suhteellinen kannatus vuosina 1968-2008");

        XYChart.Series rkpData = new XYChart.Series();
        rkpData.setName("RKP");
        rkpData.getData().add(new XYChart.Data(1968, 5.6));
        rkpData.getData().add(new XYChart.Data(1972, 5.2));
        rkpData.getData().add(new XYChart.Data(1976, 4.7));
        rkpData.getData().add(new XYChart.Data(1980, 4.7));
        rkpData.getData().add(new XYChart.Data(1984, 5.1));
        rkpData.getData().add(new XYChart.Data(1988, 5.3));
        rkpData.getData().add(new XYChart.Data(1992, 5.0));
        rkpData.getData().add(new XYChart.Data(1996, 5.4));
        rkpData.getData().add(new XYChart.Data(2000, 5.1));
        rkpData.getData().add(new XYChart.Data(2004, 5.2));
        rkpData.getData().add(new XYChart.Data(2008, 4.7));

        XYChart.Series vihreatData = new XYChart.Series();
        vihreatData.setName("VIHR");
        vihreatData.getData().add(new XYChart.Data(1984, 2.8));
        vihreatData.getData().add(new XYChart.Data(1988, 2.3));
        vihreatData.getData().add(new XYChart.Data(1992, 6.9));
        vihreatData.getData().add(new XYChart.Data(1996, 6.3));
        vihreatData.getData().add(new XYChart.Data(2000, 7.7));
        vihreatData.getData().add(new XYChart.Data(2004, 7.4));
        vihreatData.getData().add(new XYChart.Data(2008, 8.9));
        
        viivakaavio.getData().add(rkpData);
        viivakaavio.getData().add(vihreatData);

        Scene nakyma = new Scene(viivakaavio, 640, 480);
        ikkuna.setScene(nakyma);
        ikkuna.show();
    }

    public static void main(String[] args) {
        launch(Viivakaavio01.class);
    }

}
