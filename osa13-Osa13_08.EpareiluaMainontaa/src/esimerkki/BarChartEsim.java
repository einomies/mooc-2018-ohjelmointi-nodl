package esimerkki;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class BarChartEsim extends Application {

    @Override
    public void start(Stage ikkuna) {
        CategoryAxis xAkseli = new CategoryAxis();
        NumberAxis yAkseli = new NumberAxis();
        BarChart<String, Number> pylvaskaavio = new BarChart<>(xAkseli, yAkseli);

        pylvaskaavio.setTitle("Pohjoismaiden asukasluvut");
        pylvaskaavio.setLegendVisible(false);

        XYChart.Series asukasluvut = new XYChart.Series();
        asukasluvut.getData().add(new XYChart.Data("Ruotsi", 9801616));
        asukasluvut.getData().add(new XYChart.Data("Tanska", 5678348));
        asukasluvut.getData().add(new XYChart.Data("Suomi", 5483533));
        asukasluvut.getData().add(new XYChart.Data("Norja", 5165800));
        asukasluvut.getData().add(new XYChart.Data("Islanti", 329100));

        pylvaskaavio.getData().add(asukasluvut);
        Scene nakyma = new Scene(pylvaskaavio, 640, 480);
        ikkuna.setScene(nakyma);
        ikkuna.show();
    }

    public static void main(String[] args) {
        launch(BarChartEsim.class);
    }

}
