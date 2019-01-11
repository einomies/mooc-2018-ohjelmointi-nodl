package sovellus;

import static javafx.application.Application.STYLESHEET_MODENA;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

/**
 * Sanaharjoittelu
 *
 * Luodaan tämän jälkeen harjoitteluun tarvittava toiminnallisuus. Harjoittelua
 * varten tarvitsemme myös viitteen sanakirja-olioon, jotta voimme hakea
 * harjoiteltavia sanoja sekä tarkastaa käyttäjän syöttämien käännösten
 * oikeellisuuden. Sanakirjan lisäksi tarvitsemme tekstin, jonka avulla kysytään
 * sanaa, sekä tekstikentän, johon käyttäjä voi syöttää käännöksen. Myös tässä
 * GridPane sopii hyvin kenttien asetteluun.
 *
 * Kullakin hetkellä harjoiteltava sana on luokalla oliomuuttujana.
 * Oliomuuttujaa voi käsitellä ja muuttaa myös tapahtumankäsittelijän yhteyteen
 * määrittelyssä metodissa.
 *
 * @author einomies
 */
public class Harjoittelunakyma {

    private Sanakirja sanakirja;
    private String sana;

    public Harjoittelunakyma(Sanakirja sanakirja) {
        this.sanakirja = sanakirja;
        this.sana = sanakirja.arvoSana();
    }

    public Parent getNakyma() {
        Font font = new Font(STYLESHEET_MODENA, 20);
        GridPane asettelu = new GridPane();

        Label sanaohje = new Label("Käännä sana '" + this.sana + "'");
        TextField kaannoskentta = new TextField();

        asettelu.setAlignment(Pos.CENTER);
        asettelu.setVgap(10);
        asettelu.setHgap(10);
        asettelu.setPadding(new Insets(10, 10, 10, 10));

        Button lisaanappi = new Button("Tarkista");

        Label palaute = new Label("");

        sanaohje.setFont(font);
        kaannoskentta.setFont(font);
        lisaanappi.setFont(font);
        palaute.setFont(font);

        asettelu.add(sanaohje, 0, 0);
        asettelu.add(kaannoskentta, 0, 1);
        asettelu.add(lisaanappi, 0, 2);
        asettelu.add(palaute, 0, 3);

        kaannoskentta.setOnKeyPressed((event) -> {
            if (event.getCode() == KeyCode.ENTER) {
                String kaannos = kaannoskentta.getText();
                if (sanakirja.hae(sana).equalsIgnoreCase(kaannos)) {
                    palaute.setText("Oikein!");
                } else {
                    palaute.setText("Väärin! Sanan '" + sana + "' käännös on '" + sanakirja.hae(sana) + "'.");
                    return;
                }

                this.sana = this.sanakirja.arvoSana();
                sanaohje.setText("Käännä sana '" + this.sana + "'");
                kaannoskentta.clear();
            }
        });

        lisaanappi.setOnMouseClicked((event) -> {
            String kaannos = kaannoskentta.getText();
            if (sanakirja.hae(sana).equalsIgnoreCase(kaannos)) {
                palaute.setText("Oikein!");
            } else {
                palaute.setText("Väärin! Sanan '" + sana + "' käännös on '" + sanakirja.hae(sana) + "'.");
                return;
            }

            this.sana = this.sanakirja.arvoSana();
            sanaohje.setText("Käännä sana '" + this.sana + "'");
            kaannoskentta.clear();
        });

        return asettelu;
    }

}
/*
package sovellus;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Harjoittelunakyma {

    private Sanakirja sanakirja;
    private String sana;

    public Harjoittelunakyma(Sanakirja sanakirja) {
        this.sanakirja = sanakirja;
        this.sana = sanakirja.arvoSana();
    }

    public Parent getNakyma() {
        GridPane asettelu = new GridPane();
        Label sanaohje = new Label("Käännä sana '" + this.sana + "'");
        TextField kaannoskentta = new TextField();
        asettelu.setAlignment(Pos.CENTER);
        asettelu.setVgap(10);
        asettelu.setHgap(10);
        asettelu.setPadding(new Insets(10, 10, 10, 10));
        Button lisaanappi = new Button("Tarkista");
        Label palaute = new Label("");
        asettelu.add(sanaohje, 0, 0);
        asettelu.add(kaannoskentta, 0, 1);
        asettelu.add(lisaanappi, 0, 2);
        asettelu.add(palaute, 0, 3);
        lisaanappi.setOnMouseClicked((event) -> {
            String kaannos = kaannoskentta.getText();
            if (sanakirja.hae(sana).equals(kaannos)) {
                palaute.setText("Oikein!");
            } else {
                palaute.setText("Väärin! Sanan '" + sana + "' käännös on '" + sanakirja.hae(sana) + "'.");
                return;
            }
            this.sana = this.sanakirja.arvoSana();
            sanaohje.setText("Käännä sana '" + this.sana + "'");
            kaannoskentta.clear();
        });
        return asettelu;
    }
}
*/