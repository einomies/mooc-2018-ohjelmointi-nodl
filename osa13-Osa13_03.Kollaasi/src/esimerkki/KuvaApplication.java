package esimerkki;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class KuvaApplication extends Application {

    @Override
    public void start(Stage stage) {

        Image kuvatiedosto01 = new Image("file:humming.jpg");
        Image kuvatiedosto02 = new Image("file:monalisa.png");
        ImageView kuvaHumming = new ImageView(kuvatiedosto01);
        ImageView kuvaMonaLisa = new ImageView(kuvatiedosto02);

        Pane ruutu = new Pane();
        ruutu.getChildren().add(kuvaHumming);
        ruutu.getChildren().add(kuvaMonaLisa);

        stage.setScene(new Scene(ruutu));
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
