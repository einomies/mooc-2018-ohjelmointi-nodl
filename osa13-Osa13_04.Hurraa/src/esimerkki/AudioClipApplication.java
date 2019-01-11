package esimerkki;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class AudioClipApplication extends Application {

    @Override
    public void start(Stage stage) {

        AudioClip leike = new AudioClip("file:bell.wav");
        leike.play();

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
