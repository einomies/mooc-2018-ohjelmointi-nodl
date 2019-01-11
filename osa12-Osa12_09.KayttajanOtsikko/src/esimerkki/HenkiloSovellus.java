/*
package esimerkki;

import java.util.Collection;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class HenkiloSovellus extends Application {

    @Override
    public void start(Stage ikkuna) {
        Henkilovarasto henkilovarasto = new Henkilovarasto();

        Label nimiTeksti = new Label("Nimi: ");
        TextField nimiKentta = new TextField();
        Label hetuTeksti = new Label("Hetu: ");
        TextField hetuKentta = new TextField();

        Button lisaaNappi = new Button("Lisää henkilö!");
        lisaaNappi.setOnAction((event) -> {
            Henkilo lisattava = new Henkilo(nimiTeksti.getText(), hetuTeksti.getText());
            henkilovarasto.talleta(new Henkilo(lisattava);
        });

        GridPane komponenttiryhma = new GridPane();
        komponenttiryhma.add(nimiTeksti, 0, 0);
        komponenttiryhma.add(nimiKentta, 1, 0);
        komponenttiryhma.add(hetuTeksti, 0, 1);
        komponenttiryhma.add(hetuKentta, 1, 1);
        komponenttiryhma.add(lisaaNappi, 1, 2);

        // tyylittelyä: lisätään tyhjää tilaa reunoille ym
        komponenttiryhma.setHgap(10);
        komponenttiryhma.setVgap(10);
        komponenttiryhma.setPadding(new Insets(10, 10, 10, 10));

        Scene nakyma = new Scene(komponenttiryhma);

        ikkuna.setScene(nakyma);
        ikkuna.show();
    }

    public static void main(String[] args) {
        launch(HenkiloSovellus.class);
    }

}
*/