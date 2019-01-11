package esimerkki;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class KuvaApplicationKaannetty extends Application {

    /**
     * ImageView-olio tarjoaa joukon menetelmiä kuvan (yksinkertaiseen
     * käsittelyyn). Kuvaa voi muunmuassa kääntää, sen kokoa voi muuttaa, ja
     * sitä voi siirtää ruudulla.
     *
     * Alla olevassa esimerkissä kuva on käännetty ympäri, sen koko on
     * puolitettu, ja sitä on siirretty hieman oikealle.
     */
    @Override
    public void start(Stage stage) {

        Image kuvatiedosto = new Image("file:humming.jpg");
        ImageView kuva = new ImageView(kuvatiedosto);

        kuva.setRotate(180);
        kuva.setScaleX(0.5);
        kuva.setScaleY(0.5);

        kuva.setTranslateX(50);

        Pane ruutu = new Pane();
        ruutu.getChildren().add(kuva);

        stage.setScene(new Scene(ruutu));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
