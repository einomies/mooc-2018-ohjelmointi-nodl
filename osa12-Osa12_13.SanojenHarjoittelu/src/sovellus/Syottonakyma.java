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
 * Sanojen syöttäminen
 *
 * Luodaan seuraavaksi sanojen syöttämiseen tarvittava toiminnallisuus. Sanojen
 * syöttämistä varten tarvitsemme viitteen sanakirja-olioon sekä tekstikentät
 * sanalle ja käännökselle. GridPane-asettelu sopii hyvin kenttien asetteluun.
 *
 * Luodaan luokka Syottonakyma, joka tarjoaa metodin getNakyma, joka luo sanojen
 * syöttämiseen tarvittavan näkymän. Metodi palauttaa viitteen Parent-tyyppiseen
 * olioon. Parent on muunmuassa asetteluun käytettävien luokkien yläluokka,
 * joten mitä tahansa asetteluun käytettävää luokkaa voidaan esittää
 * Parent-oliona.
 *
 * Luokka määrittelee myös käyttöliittymään liittyvän
 * napinpainallustoiminnallisuuden. Kun käyttäjä painaa nappia, sanapari
 * lisätään sanakirjaan. Samalla myös teksti- kentät tyhjennetään seuraavan
 * sanan syöttämistä varten.
 *
 * @author einomies
 */
public class Syottonakyma {

    private Sanakirja sanakirja;

    public Syottonakyma(Sanakirja sanakirja) {
        this.sanakirja = sanakirja;
    }

    public Parent getNakyma() {
        Font font = new Font(STYLESHEET_MODENA, 20);

        GridPane asettelu = new GridPane();

        Label sanaohje = new Label("Sana");
        TextField sanakentta = new TextField();
        Label kaannosohje = new Label("Käännös");
        TextField kaannoskentta = new TextField();

        sanaohje.setFont(font);
        sanakentta.setFont(font);
        kaannosohje.setFont(font);
        kaannoskentta.setFont(font);

        asettelu.setAlignment(Pos.CENTER);
        asettelu.setVgap(10);
        asettelu.setHgap(10);
        asettelu.setPadding(new Insets(10, 10, 10, 10));

        Button lisaanappi = new Button("Lisää sanapari");
        lisaanappi.setFont(font);

        Label paluuviesti = new Label("");
        paluuviesti.setFont(font);

        asettelu.add(sanaohje, 0, 0);
        asettelu.add(sanakentta, 0, 1);
        asettelu.add(kaannosohje, 0, 2);
        asettelu.add(kaannoskentta, 0, 3);
        asettelu.add(lisaanappi, 0, 4);
        asettelu.add(paluuviesti, 0, 5);

//        String sana = sanakentta.getText();
//        String kaannos = kaannoskentta.getText();
        sanakentta.setOnKeyPressed((event) -> {
            String sana = sanakentta.getText();
            String kaannos = kaannoskentta.getText();
            if (event.getCode() == KeyCode.ENTER) {
                if (!sana.isEmpty() && !kaannos.isEmpty()) {
                    sanakirja.lisaa(sana, kaannos);
                    paluuviesti.setText("Lisätty");
                } else {
                    paluuviesti.setText("Sana ei saa olla tyhjä");
                }
                sanakentta.clear();
                kaannoskentta.clear();
            }
//            paluuviesti.setText("");
        });

        kaannoskentta.setOnKeyPressed((event) -> {
            String sana = sanakentta.getText();
            String kaannos = kaannoskentta.getText();
            if (event.getCode() == KeyCode.ENTER) {
                if (!sana.isEmpty() && !kaannos.isEmpty()) {
                    sanakirja.lisaa(sana, kaannos);
                    paluuviesti.setText("Lisätty");
                } else {
                    paluuviesti.setText("Sana ei saa olla tyhjä");
                }
                sanakentta.clear();
                kaannoskentta.clear();
            }
//            paluuviesti.setText("");
        });

        lisaanappi.setOnMouseClicked((event) -> {
            String sana = sanakentta.getText();
            String kaannos = kaannoskentta.getText();

//            teePaivitys(sana, kaannos, sanakentta, kaannoskentta, paluuviesti);
            if (!sana.isEmpty() && !kaannos.isEmpty()) {
                sanakirja.lisaa(sana, kaannos);
                paluuviesti.setText("Lisätty");
            } else {
                paluuviesti.setText("Sana ei saa olla tyhjä");
            }
            sanakentta.clear();
            kaannoskentta.clear();
//            paluuviesti.setText("");
        });

        return asettelu;
    }

    private void teePaivitys(String sana, String kaannos, TextField sanakentta, TextField kaannoskentta, Label paluuviesti) {
        if (!sana.isEmpty() && !kaannos.isEmpty()) {
            sanakirja.lisaa(sana, kaannos);
            paluuviesti.setText("Lisätty");
        } else {
            paluuviesti.setText("Sana ei saa olla tyhjä");
        }
        sanakentta.clear();
        kaannoskentta.clear();
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

public class Syottonakyma {

    private Sanakirja sanakirja;

    public Syottonakyma(Sanakirja sanakirja) {
        this.sanakirja = sanakirja;
    }

    public Parent getNakyma() {
        GridPane asettelu = new GridPane();
        Label sanaohje = new Label("Sana");
        TextField sanakentta = new TextField();
        sanakentta.setId("sana");
        Label kaannosohje = new Label("Käännös");
        TextField kaannoskentta = new TextField();
        sanakentta.setId("kaannos");
        asettelu.setAlignment(Pos.CENTER);
        asettelu.setVgap(10);
        asettelu.setHgap(10);
        asettelu.setPadding(new Insets(10, 10, 10, 10));
        Button lisaanappi = new Button("Lisää sanapari");
        asettelu.add(sanaohje, 0, 0);
        asettelu.add(sanakentta, 0, 1);
        asettelu.add(kaannosohje, 0, 2);
        asettelu.add(kaannoskentta, 0, 3);
        asettelu.add(lisaanappi, 0, 4);
        lisaanappi.setOnMouseClicked((event) -> {
            String sana = sanakentta.getText();
            String kaannos = kaannoskentta.getText();
            sanakirja.lisaa(sana, kaannos);
            sanakentta.clear();
            kaannoskentta.clear();
        });
        return asettelu;
    }
}
*/