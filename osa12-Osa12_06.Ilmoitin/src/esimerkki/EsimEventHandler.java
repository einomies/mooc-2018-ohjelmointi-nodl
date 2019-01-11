package esimerkki;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class EsimEventHandler extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Button button = new Button("Nappi elikkäs namiskuukkeli");
        /*
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Painettu!");
            }
        });
         */
        button.setOnAction((event) -> {
            System.out.println("Painettu!");
        });

        TextField textField = new TextField("TextField, tekstikenttä");

        FlowPane flowPane = new FlowPane();
        flowPane.getChildren().add(button);
        flowPane.getChildren().add(textField);

        Scene scene = new Scene(flowPane);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(EsimEventHandler.class);
    }
}
