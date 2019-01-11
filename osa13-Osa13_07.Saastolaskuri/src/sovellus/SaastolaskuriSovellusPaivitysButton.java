package sovellus;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SaastolaskuriSovellusPaivitysButton extends Application {

    @Override
    public void start(Stage ikkuna) throws Exception {

        XYChart.Series sarja01IlmanKorkoa = new XYChart.Series();
        XYChart.Series sarja02KorkojenKanssa = new XYChart.Series();

        sarja01IlmanKorkoa.setName("ilman korkoja");
        sarja02KorkojenKanssa.setName("korkojen kanssa");

        final int vuodetLkm = 30;
        final int kuukaudetLkm = 12 * vuodetLkm;

        BorderPane borderPaneTop = new BorderPane();
        Button buttonPaivitys = new Button("Päivitä");
        borderPaneTop.setCenter(buttonPaivitys);

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

        slider01.valueProperty().addListener((muutos, vanhaArvo, uusiArvo) -> {
//            System.out.println(vanhaArvo + " -> " + uusiArvo);
            label02.setText(String.format("%.2f", uusiArvo));
        });

        slider02.valueProperty().addListener((muutos, vanhaArvo, uusiArvo) -> {
//            System.out.println(vanhaArvo + " -> " + uusiArvo);
            label04.setText(String.format("%.2f", uusiArvo));
        });

        VBox vBox01 = new VBox();
        vBox01.getChildren().addAll(borderPaneTop, borderPane01, borderPane02);
        VBox.setMargin(borderPane01, new Insets(10, 10, 10, 10));
        VBox.setMargin(borderPane02, new Insets(10, 10, 10, 10));

        NumberAxis xAkseli = new NumberAxis(0, vuodetLkm, 1);
        NumberAxis yAkseli = new NumberAxis();
        xAkseli.setLabel("vuodet");
        yAkseli.setLabel("pääoma");
        LineChart<Number, Number> viivakaavio = new LineChart<>(xAkseli, yAkseli);
        viivakaavio.setTitle("Säästölaskuri");
        viivakaavio.setLegendVisible(true);

        buttonPaivitys.setOnAction((event) -> {
            viivakaavio.setAnimated(false);
            sarja01IlmanKorkoa.getData().clear();
            sarja02KorkojenKanssa.getData().clear();
            double kkSijoitus = slider01.getValue();
            double korkoPros = slider02.getValue();
            for (int i = 0; i <= vuodetLkm; i++) {
                sarja01IlmanKorkoa.getData().add(new XYChart.Data(i, laskePaaoma(i, kkSijoitus, 0)));
                sarja02KorkojenKanssa.getData().add(new XYChart.Data(i, laskePaaoma(i, kkSijoitus, korkoPros)));
            }
        });

        viivakaavio.getData().add(sarja01IlmanKorkoa);
        viivakaavio.getData().add(sarja02KorkojenKanssa);

        BorderPane borderPane03 = new BorderPane();
        borderPane03.setTop(vBox01);
        borderPane03.setCenter(viivakaavio);

        Scene scene = new Scene(borderPane03);
        ikkuna.setScene(scene);
        ikkuna.show();
    }

    private Object laskePaaoma(int vuodet, double kkSijoitus, double korkoPros) {
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
        double paaomaLoppu = paaomaVuodenAlussa + (korkoPros / 100 * paaomaVuodenAlussa);
        return paaomaLoppu;
    }

    public static void main(String[] args) {
        launch(SaastolaskuriSovellusPaivitysButton.class);
    }

}
