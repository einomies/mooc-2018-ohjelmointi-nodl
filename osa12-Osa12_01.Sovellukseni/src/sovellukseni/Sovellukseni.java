package sovellukseni;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;

public class Sovellukseni extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Sovellukseni");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(Sovellukseni.class);
        System.out.println("Hello world!");
    }

}
