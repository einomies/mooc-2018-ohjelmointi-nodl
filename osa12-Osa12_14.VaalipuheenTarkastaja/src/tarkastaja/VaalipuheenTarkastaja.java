package tarkastaja;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class VaalipuheenTarkastaja extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Ennustaja ennustaja = new Ennustaja();
        ennustaja.taydennaTaustadata();

        Font font = new Font(STYLESHEET_MODENA, 16);

        TextArea tekstikentta = new TextArea();
        tekstikentta.setWrapText(true);
        tekstikentta.setFont(font);

        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10, 10, 10, 10));
        Label labelEsiintyma = new Label("Sanojen esiintymien perusteella: ???");
        labelEsiintyma.setFont(font);
        Label labelEnnustaja = new Label("Mystisen ennustajan perusteella: ???");
        labelEnnustaja.setFont(font);

        tekstikentta.textProperty().addListener((muutos, vanhaArvo, uusiArvo) -> {
            if (ennustaja.valitaanSanojenLukumaariinPerustuen(uusiArvo) > 0) {
                labelEsiintyma.setText("Sanojen esiintymien perusteella: Kyllä");
            } else if (ennustaja.valitaanSanojenLukumaariinPerustuen(uusiArvo) < 0) {
                labelEsiintyma.setText("Sanojen esiintymien perusteella: Ei");
            } else {
                labelEsiintyma.setText("Sanojen esiintymien perusteella: ???");
            }

            if (ennustaja.valitaanMystisellaEnnustajalla(uusiArvo) > 0) {
                labelEnnustaja.setText("Mystisen ennustajan perusteella: Kyllä");
            } else if (ennustaja.valitaanMystisellaEnnustajalla(uusiArvo) < 0) {
                labelEnnustaja.setText("Mystisen ennustajan perusteella: Ei");
            } else {
                labelEnnustaja.setText("Mystisen ennustajan perusteella: ???");
            }
        });

        vBox.getChildren().addAll(labelEsiintyma, labelEnnustaja);

        BorderPane komponenttiryhma = new BorderPane();
        komponenttiryhma.setCenter(tekstikentta);
        komponenttiryhma.setBottom(vBox);

        Scene nakyma = new Scene(komponenttiryhma);

        stage.setScene(nakyma);
        stage.show();
    }
    // END SOLUTION

    public static void main(String[] args) {
        launch(VaalipuheenTarkastaja.class);
    }

}
/*
package tarkastaja;

import java.nio.file.Files;
import java.nio.file.Paths;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VaalipuheenTarkastaja extends Application {

    private Ennustaja ennustaja;

    @Override
    public void init() throws Exception {
        this.ennustaja = new Ennustaja();
        Files.lines(Paths.get("vaalidata.csv"))
                .map(s -> s.split(";"))
                .filter(a -> a.length > 1)
                .forEach(a -> {
                    this.ennustaja.lisaa(a[0].equals("1"), a[1]);
                });
    }

    @Override
    public void start(Stage stage) throws Exception {
        TextArea tekstikentta = new TextArea();
        tekstikentta.setWrapText(true);
        Label summaajaTeksti = new Label("Sanojen esiintymien perusteella: ???");
        Label mystinenTeksti = new Label("Mystisen ennustajan perusteella: ???");
        BorderPane komponenttiryhma = new BorderPane();
        komponenttiryhma.setCenter(tekstikentta);
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(20));
        vbox.getChildren().add(summaajaTeksti);
        vbox.getChildren().add(mystinenTeksti);
        komponenttiryhma.setBottom(vbox);
        tekstikentta.textProperty().addListener((muutos, vanhaLause, uusiLause) -> {
            int summaajaEnnustus = ennustaja.valitaanSanojenLukumaariinPerustuen(uusiLause);
            if (summaajaEnnustus == 1) {
                summaajaTeksti.setText("Sanojen esiintymien perusteella: Kyllä");
            } else if (summaajaEnnustus == -1) {
                summaajaTeksti.setText("Sanojen esiintymien perusteella: Ei");
            } else {
                summaajaTeksti.setText("Sanojen esiintymien perusteella: ???");
            }
            int mystinenEnnustus = ennustaja.valitaanMystisellaEnnustajalla(uusiLause);
            if (mystinenEnnustus == 1) {
                mystinenTeksti.setText("Mystisen ennustajan perusteella: Kyllä");
            } else if (mystinenEnnustus == -1) {
                mystinenTeksti.setText("Mystisen ennustajan perusteella: Ei");
            } else {
                mystinenTeksti.setText("Mystisen ennustajan perusteella: ???");
            }
        });
        Scene nakyma = new Scene(komponenttiryhma);
        stage.setScene(nakyma);
        stage.show();
    }

    public static void main(String[] args) {
        launch(VaalipuheenTarkastaja.class);
    }
}
*/