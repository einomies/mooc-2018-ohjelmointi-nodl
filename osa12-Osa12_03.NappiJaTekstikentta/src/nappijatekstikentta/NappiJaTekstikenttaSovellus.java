package nappijatekstikentta;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class NappiJaTekstikenttaSovellus extends Application {

    public static void main(String[] args) {
        launch(NappiJaTekstikenttaSovellus.class);
        System.out.println("Hello world!");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Button button = new Button("Nappi elikkäs namiskuukkeli");
        TextField textField = new TextField("TextField, tekstikenttä");

        FlowPane flowPane = new FlowPane();
        flowPane.getChildren().add(button);
        flowPane.getChildren().add(textField);

        Scene scene = new Scene(flowPane);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
