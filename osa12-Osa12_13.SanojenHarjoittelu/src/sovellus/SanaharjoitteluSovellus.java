package sovellus;

// END SOLUTION
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SanaharjoitteluSovellus extends Application {

    private Sanakirja sanakirja;

    @Override
    public void init() {
        this.sanakirja = new Sanakirja();
    }

    @Override
    public void start(Stage ikkuna) throws Exception {

        Font font = new Font(STYLESHEET_MODENA, 20);

        Harjoittelunakyma harjoittelunakyma = new Harjoittelunakyma(sanakirja);
        Syottonakyma syottonakyma = new Syottonakyma(sanakirja);
        Listausnakyma listausnakyma = new Listausnakyma(sanakirja);

        BorderPane asettelu = new BorderPane();

        HBox valikko = new HBox();
        valikko.setPadding(new Insets(20, 20, 20, 20));
        valikko.setSpacing(10);

        Button lisaanappi = new Button("Lisää sanoja");
        lisaanappi.setFont(font);
        Button harjoittelenappi = new Button("Harjoittele");
        harjoittelenappi.setFont(font);
        Button listausnappi = new Button("Listaa ja lunttaa");
        listausnappi.setFont(font);

        valikko.getChildren().addAll(lisaanappi, harjoittelenappi, listausnappi);
        asettelu.setTop(valikko);

        lisaanappi.setOnAction((event) -> asettelu.setCenter(syottonakyma.getNakyma()));
        harjoittelenappi.setOnAction((event) -> asettelu.setCenter(harjoittelunakyma.getNakyma()));
        listausnappi.setOnAction((event) -> asettelu.setCenter(listausnakyma.getNakyma()));

        asettelu.setCenter(syottonakyma.getNakyma());

        Scene nakyma = new Scene(asettelu, 800, 600);

        ikkuna.setScene(nakyma);
        ikkuna.show();
    }

    public static void main(String[] args) {
        launch(SanaharjoitteluSovellus.class);
    }

}
/*
package sovellus;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class SanaharjoitteluSovellus extends Application {

    @Override
    public void start(Stage ikkuna) throws Exception {
        // 1. Luodaan sovelluksen käyttämä sanakirja
        Sanakirja sanakirja = new Sanakirja();
        // 2. Luodaan näkymät ("alinäkymät")
        Harjoittelunakyma harjoittelunakyma = new Harjoittelunakyma(sanakirja);
        Syottonakyma syottonakyma = new Syottonakyma(sanakirja);
        // 3. Luodaan päätason asettelu
        BorderPane asettelu = new BorderPane();
        // 3.1. Luodaan päätason asettelun valikko
        HBox valikko = new HBox();
        valikko.setPadding(new Insets(20, 20, 20, 20));
        valikko.setSpacing(10);
        // 3.2. Luodaan valikon napit
        Button lisaanappi = new Button("Lisää sanoja");
        Button harjoittelenappi = new Button("Harjoittele");
        // 3.3. Lisätään napit valikkoon
        valikko.getChildren().addAll(lisaanappi, harjoittelenappi);
        asettelu.setTop(valikko);
        // 4. Liitetään alinäkymät nappeihin. Napin painaminen vaihtaa alinäkymää.
        lisaanappi.setOnAction((event) -> asettelu.setCenter(syottonakyma.getNakyma()));
        harjoittelenappi.setOnAction((event) -> asettelu.setCenter(harjoittelunakyma.getNakyma()));
        // 5. Näytetään ensin syöttönäkymä
        asettelu.setCenter(syottonakyma.getNakyma());
        // 6. Luodaan päänäkymä ja asetetaan päätason asettelu siihen
        Scene nakyma = new Scene(asettelu, 400, 300);
        // 7. Näytetään sovellus
        ikkuna.setScene(nakyma);
        ikkuna.show();
    }

    public static void main(String[] args) {
        launch(SanaharjoitteluSovellus.class);
    }
}
*/