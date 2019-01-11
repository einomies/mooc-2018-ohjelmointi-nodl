package sovellus;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SaastolaskuriSovellusMalli extends Application {

    @Override
    public void start(Stage ikkuna) {
        BorderPane asettelu = new BorderPane();
        Slider tallennus = new Slider();
        tallennus.setMin(25);
        tallennus.setMax(250);
        tallennus.setSnapToTicks(true);
        tallennus.setBlockIncrement(500);
        tallennus.setShowTickLabels(true);
        tallennus.setShowTickMarks(true);
        Slider korko = new Slider();
        korko.setMin(0);
        korko.setMax(10);
        korko.setMinorTickCount(10);
        korko.setShowTickLabels(true);
        korko.setShowTickMarks(true);
        Label tallennusTeksti = new Label("25");
        Label korkoTeksti = new Label("0");
        BorderPane tallennusAsettelu = new BorderPane();
        tallennusAsettelu.setLeft(new Label("Kuukausittainen tallennus"));
        tallennusAsettelu.setCenter(tallennus);
        tallennusAsettelu.setRight(tallennusTeksti);
        tallennusAsettelu.setPadding(new Insets(10));
        BorderPane korkoAsettelu = new BorderPane();
        korkoAsettelu.setLeft(new Label("Vuosittainen korko"));
        korkoAsettelu.setCenter(korko);
        korkoAsettelu.setRight(korkoTeksti);
        korkoAsettelu.setPadding(new Insets(10));
        VBox ylaAsettelu = new VBox();
        ylaAsettelu.getChildren().add(tallennusAsettelu);
        ylaAsettelu.getChildren().add(korkoAsettelu);
        ylaAsettelu.setPadding(new Insets(10));
        ylaAsettelu.setSpacing(10);
        asettelu.setTop(ylaAsettelu);
        NumberAxis xAkseli = new NumberAxis(0, 30, 1);
        NumberAxis yAkseli = new NumberAxis();
        LineChart<Number, Number> viivakaavio = new LineChart<>(xAkseli, yAkseli);
        viivakaavio.setAnimated(false);
        viivakaavio.setLegendVisible(false);
        viivakaavio.setTitle("Säästölaskuri");
        asettelu.setCenter(viivakaavio);
        XYChart.Series saastot = new XYChart.Series();
        XYChart.Series saastotKoroilla = new XYChart.Series();
        viivakaavio.getData().add(saastot);
        viivakaavio.getData().add(saastotKoroilla);
        tallennus.setOnMouseReleased(e -> {
            tallennusTeksti.setText("" + tallennus.getValue());
            paivitaKaavio(tallennus.getValue(), korko.getValue(), saastot, saastotKoroilla);
        });
        korko.setOnMouseReleased(e -> {
            String korkoString = "" + korko.getValue();
            if (korkoString.length() > 4) {
                korkoString = korkoString.substring(0, 4);
            }
            korkoTeksti.setText(korkoString);
            paivitaKaavio(tallennus.getValue(), korko.getValue(), saastot, saastotKoroilla);
        });
        Scene nakyma = new Scene(asettelu, 640, 480);
        ikkuna.setScene(nakyma);
        ikkuna.show();
    }

    private void paivitaKaavio(double kuukausiSaasto, double korko, XYChart.Series saastot, XYChart.Series saastotKoroilla) {
        saastot.getData().clear();
        saastotKoroilla.getData().clear();
        saastot.getData().add(new XYChart.Data(0, 0));
        saastotKoroilla.getData().add(new XYChart.Data(0, 0));
        double edellinen = 0;
        for (int i = 1; i <= 30; i++) {
            saastot.getData().add(new XYChart.Data(i, i * kuukausiSaasto * 12));
            edellinen += kuukausiSaasto * 12;
            edellinen *= (1 + korko / 100.0);
            saastotKoroilla.getData().add(new XYChart.Data(i, edellinen));
        }
    }

    public static void main(String[] args) {
        launch(SaastolaskuriSovellus.class);
        System.out.println("Hello world!");
    }

}
