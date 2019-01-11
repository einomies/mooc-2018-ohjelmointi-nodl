package sovellus;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SaastolaskuriSovellus extends Application {

    @Override
    public void start(Stage ikkuna) throws Exception {

        XYChart.Series sarja01IlmanKorkoa = new XYChart.Series();
        XYChart.Series sarja02KorkojenKanssa = new XYChart.Series();

        sarja01IlmanKorkoa.setName("ilman korkoja");
        sarja02KorkojenKanssa.setName("korkojen kanssa");

        final int vuodetLkm = 30;
        final int kuukaudetLkm = 12 * vuodetLkm;

        BorderPane borderPane01 = new BorderPane();
        borderPane01.setPadding(new Insets(10, 10, 10, 10));
        Label label01 = new Label("Kuukausittainen tallennus");

        Slider slider01 = new Slider();
        slider01.setValue(25);
        slider01.setMin(25);
        slider01.setMax(250);
        slider01.setShowTickLabels(true);
        slider01.setShowTickMarks(true);
        slider01.setMajorTickUnit(25);
        slider01.setMinorTickCount(3);
        slider01.setBlockIncrement(10);

        final Label label02 = new Label(Double.toString(slider01.getValue()));
        borderPane01.setLeft(label01);
        borderPane01.setCenter(slider01);
        borderPane01.setRight(label02);

        BorderPane borderPane02 = new BorderPane();
        Label label03 = new Label("Vuosittainen korko");

        Slider slider02 = new Slider();
        slider02.setValue(0);
        slider02.setMin(0);
        slider02.setMax(10);
        slider02.setShowTickLabels(true);
        slider02.setShowTickMarks(true);
        slider02.setMajorTickUnit(2);
        slider02.setMinorTickCount(3);
        slider02.setBlockIncrement(0.5);

        final Label label04 = new Label(Double.toString(slider02.getValue()));
        borderPane02.setLeft(label03);
        borderPane02.setCenter(slider02);
        borderPane02.setRight(label04);

        VBox vBox01 = new VBox();
        vBox01.getChildren().addAll(borderPane01, borderPane02);
        vBox01.setMargin(borderPane01, new Insets(10, 10, 10, 10));
        vBox01.setMargin(borderPane02, new Insets(10, 10, 10, 10));

        NumberAxis xAkseli = new NumberAxis(0, vuodetLkm, 1);
        NumberAxis yAkseli = new NumberAxis();
        xAkseli.setLabel("vuodet");
        yAkseli.setLabel("pääoma");
        LineChart<Number, Number> viivakaavio = new LineChart<>(xAkseli, yAkseli);
        viivakaavio.setTitle("Säästölaskuri");
        viivakaavio.setLegendVisible(true);

        viivakaavio.getData().add(sarja01IlmanKorkoa);
        viivakaavio.getData().add(sarja02KorkojenKanssa);

        slider01.setOnMouseReleased(value -> {
            label02.setText(String.format("%.2f", slider01.getValue()));
            paivitaKappyrat(viivakaavio, sarja01IlmanKorkoa, sarja02KorkojenKanssa, slider01, slider02, vuodetLkm);
        });
        slider02.setOnMouseReleased(value -> {
            label04.setText(String.format("%.2f", slider02.getValue()));
            paivitaKappyrat(viivakaavio, sarja01IlmanKorkoa, sarja02KorkojenKanssa, slider01, slider02, vuodetLkm);
        });

        BorderPane borderPane03 = new BorderPane();
        borderPane03.setTop(vBox01);
        borderPane03.setCenter(viivakaavio);

        Scene scene = new Scene(borderPane03);
        ikkuna.setScene(scene);
        ikkuna.show();
    }

    private void paivitaKappyrat(LineChart<Number, Number> viivakaavio, Series sarja01IlmanKorkoa, Series sarja02KorkojenKanssa, Slider slider01, Slider slider02, int vuodetLkm) {
        viivakaavio.setAnimated(false);
        sarja01IlmanKorkoa.getData().clear();
        sarja02KorkojenKanssa.getData().clear();
        double kkSijoitus = slider01.getValue();
        double korkoPros = slider02.getValue();
        for (int i = 0; i <= vuodetLkm; i++) {
            double paaomaIlmanKorkoja = laskePaaoma(i, kkSijoitus, 0);
            double paaomaKorkojenKanssa = laskePaaoma(i, kkSijoitus, korkoPros);
//            System.out.println("i=" + i + " paaomaIlmanKorkoja:" + paaomaIlmanKorkoja + " paaomaKorkojenKanssa:" + paaomaKorkojenKanssa);
            sarja01IlmanKorkoa.getData().add(new XYChart.Data(i, paaomaIlmanKorkoja));
            sarja02KorkojenKanssa.getData().add(new XYChart.Data(i, paaomaKorkojenKanssa));
        }
    }

    private double laskePaaoma(int vuodet, double kkSijoitus, double korkoPros) {
        double paaomaVuodenAlussa = 0;
        double paaomaVuodenLopussa = 0;
        double edPaaomaVuodenLopussa = 0;
        double vuodenSijoitukset = 12 * kkSijoitus;
        double vuodenTuotto = 0;
        for (int i = 0; i < vuodet; i++) {
            paaomaVuodenAlussa = edPaaomaVuodenLopussa;
            paaomaVuodenLopussa = (paaomaVuodenAlussa + vuodenSijoitukset) * (1 + korkoPros / 100);
            edPaaomaVuodenLopussa = paaomaVuodenLopussa;
        }
        return paaomaVuodenLopussa;
    }

    public static void main(String[] args) {
        launch(SaastolaskuriSovellus.class);
    }

}
