/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esimerkki;

import java.util.HashMap;
import java.util.Map;
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
public class Viivakaavio02 extends Application {

    @Override
    public void start(Stage ikkuna) {

        NumberAxis xAkseli = new NumberAxis(1964, 2012, 4);
        NumberAxis yAkseli = new NumberAxis();
        xAkseli.setLabel("Vuosi");

        yAkseli.setLabel("Suhteellinen kannatus (%)");

        LineChart<Number, Number> viivakaavio = new LineChart<>(xAkseli, yAkseli);
        viivakaavio.setTitle("Suhteellinen kannatus vuosina 1968-2008");

        Map<String, Map<Integer, Double>> arvot = luoArvotMappiin();

        // käydään puolueet läpi ja lisätään ne kaavioon
        arvot.keySet().stream().forEach(puolue -> {
            XYChart.Series data = new XYChart.Series();
            data.setName(puolue);

            arvot.get(puolue).entrySet().stream().forEach(pari -> {
                data.getData().add(new XYChart.Data(pari.getKey(), pari.getValue()));
            });

            viivakaavio.getData().add(data);
        });

        Scene nakyma = new Scene(viivakaavio, 640, 480);
        ikkuna.setScene(nakyma);
        ikkuna.show();
    }

    public static void main(String[] args) {
        launch(Viivakaavio02.class);
    }

    private Map<String, Map<Integer, Double>> luoArvotMappiin() {

        Map<String, Map<Integer, Double>> puolueet = new HashMap<>();

        Map<Integer, Double> luvutRkp = new HashMap<>();
        luvutRkp.put(1968, 5.6);
        luvutRkp.put(1972, 5.2);
        luvutRkp.put(1976, 4.7);
        luvutRkp.put(1980, 4.7);
        luvutRkp.put(1984, 5.1);
        luvutRkp.put(1988, 5.3);
        luvutRkp.put(1992, 5.0);
        luvutRkp.put(1996, 5.4);
        luvutRkp.put(2000, 5.1);
        luvutRkp.put(2004, 5.2);
        luvutRkp.put(2008, 4.7);
        puolueet.put("RKP", luvutRkp);

        Map<Integer, Double> luvutVihr = new HashMap<>();
        luvutVihr.put(1984, 2.8);
        luvutVihr.put(1988, 2.3);
        luvutVihr.put(1992, 6.9);
        luvutVihr.put(1996, 6.3);
        luvutVihr.put(2000, 7.7);
        luvutVihr.put(2004, 7.4);
        luvutVihr.put(2008, 8.9);
        puolueet.put("VIHR", luvutVihr);

        return puolueet;
    }

}
