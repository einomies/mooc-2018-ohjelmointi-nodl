package sovellus;

import java.util.HashMap;
import java.util.Map;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class ShanghaiSovellus extends Application {

    @Override
    public void start(Stage ikkuna) throws Exception {
        NumberAxis xAkseli = new NumberAxis(2006, 2018, 2);
        NumberAxis yAkseli = new NumberAxis();
        xAkseli.setLabel("Vuosi");

        yAkseli.setLabel("Sijoitus");

        LineChart<Number, Number> viivakaavio = new LineChart<>(xAkseli, yAkseli);
        viivakaavio.setTitle("Helsingin yliopisto, Shanghai-ranking");

        Map<Integer, Integer> arvot = luoArvotMappiin();

        XYChart.Series sarja01 = new XYChart.Series();
        sarja01.setName("Hesa o ygöne");

        arvot.entrySet().forEach((entry) -> {
            sarja01.getData().add((new XYChart.Data(entry.getKey(), entry.getValue())));
        });
        viivakaavio.getData().add(sarja01);

        Scene nakyma = new Scene(viivakaavio, 640, 480);
        ikkuna.setScene(nakyma);
        ikkuna.show();
    }

    public static void main(String[] args) {
        launch(ShanghaiSovellus.class);
    }

    private Map<Integer, Integer> luoArvotMappiin() {
        Map<Integer, Integer> arvot = new HashMap<>();
        arvot.put(2007, 73);
        arvot.put(2008, 68);
        arvot.put(2009, 72);
        arvot.put(2010, 72);
        arvot.put(2011, 74);
        arvot.put(2012, 73);
        arvot.put(2013, 76);
        arvot.put(2014, 73);
        arvot.put(2015, 67);
        arvot.put(2016, 56);
        arvot.put(2017, 56);
        return arvot;
    }

}
/*
package sovellus;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class ShanghaiSovellus extends Application {

    @Override
    public void start(Stage ikkuna) {

        NumberAxis xAkseli = new NumberAxis(2006, 2018, 1);
        NumberAxis yAkseli = new NumberAxis(0, 100, 5);
        xAkseli.setLabel("Vuosi");
        yAkseli.setLabel("Sijoitus");

        LineChart<Number, Number> viivakaavio = new LineChart<>(xAkseli, yAkseli);
        viivakaavio.setTitle("Helsingin yliopisto, Shanghai-ranking");
        viivakaavio.setLegendVisible(false);

        XYChart.Series sijainti = new XYChart.Series();
        sijainti.getData().add(new XYChart.Data(2007, 73));
        sijainti.getData().add(new XYChart.Data(2008, 68));
        sijainti.getData().add(new XYChart.Data(2009, 72));
        sijainti.getData().add(new XYChart.Data(2010, 72));
        sijainti.getData().add(new XYChart.Data(2011, 74));
        sijainti.getData().add(new XYChart.Data(2012, 73));
        sijainti.getData().add(new XYChart.Data(2013, 76));
        sijainti.getData().add(new XYChart.Data(2014, 73));
        sijainti.getData().add(new XYChart.Data(2015, 67));
        sijainti.getData().add(new XYChart.Data(2016, 56));
        sijainti.getData().add(new XYChart.Data(2017, 56));

        viivakaavio.getData().add(sijainti);

        Scene nakyma = new Scene(viivakaavio, 400, 300);

        ikkuna.setScene(nakyma);
        ikkuna.show();
    }

    public static void main(String[] args) {
        launch(ShanghaiSovellus.class);
        System.out.println("Hello world!");
    }
}
*/