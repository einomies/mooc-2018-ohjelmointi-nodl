package sovellus;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class VitsiSovellus extends Application {

    @Override
    public void start(Stage ikkuna) throws Exception {

        // 1. Luodaan päätason asettelu
        BorderPane asettelu = new BorderPane();

        // 1.1. Luodaan päätason asettelun valikko
        HBox valikko = new HBox();
        valikko.setPadding(new Insets(20, 20, 20, 20));
        valikko.setSpacing(10);

        // 1.2. Luodaan valikon napit
        Button button01 = new Button("Vitsi");
        Button button02 = new Button("Vastaus");
        Button button03 = new Button("Selitys");

        // 1.3. Lisätään napit valikkoon
        valikko.getChildren().addAll(button01, button02, button03);

        asettelu.setTop(valikko);

        // 2. Luodaan alinäkymät ja kytketään ne valikon nappeihin

        // 2.1. Luodaan alinäkymät -- tässä asettelut
        StackPane asettelu01 = luoNakyma("What do you call a bear with no teeth?");
        StackPane asettelu02 = luoNakyma("A gummy bear.");
        StackPane asettelu03 = luoNakyma("Tähän jokin naseva vitsin selitys...");

        // 2.2. Liitetään alinäkymät nappeihin. Napin painaminen vaihtaa alinäkymää.
        button01.setOnAction((event) -> asettelu.setCenter(asettelu01));
        button02.setOnAction((event) -> asettelu.setCenter(asettelu02));
        button03.setOnAction((event) -> asettelu.setCenter(asettelu03));

        // 2.3. Näytetään aluksi asettelu01
        asettelu.setCenter(asettelu01);

        // 3. Luodaan päänäkymä ja asetetaan päätason asettelu siihen
        Scene nakyma = new Scene(asettelu);

        // 4. Näytetään sovellus
        ikkuna.setScene(nakyma);
        ikkuna.show();
    }

    private StackPane luoNakyma(String teksti) {

        StackPane asettelu = new StackPane();
        asettelu.setPrefSize(300, 180);
        asettelu.getChildren().add(new Label(teksti));
        asettelu.setAlignment(Pos.CENTER);

        return asettelu;
    }

    public static void main(String[] args) {
        launch(VitsiSovellus.class);
    }

}
