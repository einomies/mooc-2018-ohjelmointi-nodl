package borderpane;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BorderPaneSovellus extends Application {

    public static void main(String[] args) {
        launch(BorderPaneSovellus.class);
        System.out.println("Hello world!");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane asettelu = new BorderPane();
        asettelu.setTop(new Label("NORTH"));
        asettelu.setRight(new Label("EAST"));
        asettelu.setBottom(new Label("SOUTH"));

        Scene nakyma = new Scene(asettelu);

        primaryStage.setScene(nakyma);
        primaryStage.show();
    }

}
