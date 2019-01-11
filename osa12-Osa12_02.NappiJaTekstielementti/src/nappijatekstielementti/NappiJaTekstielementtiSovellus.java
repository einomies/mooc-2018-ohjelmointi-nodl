package nappijatekstielementti;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class NappiJaTekstielementtiSovellus extends Application {
    
    public static void main(String[] args) {
        launch(NappiJaTekstielementtiSovellus.class);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Button button = new Button("Tämä nappi elikkäs namiska");
        Label label = new Label("Tekstielementti");
        
        FlowPane flowPane = new FlowPane();
        flowPane.getChildren().add(button);
        flowPane.getChildren().add(label);
        
        Scene scene = new Scene(flowPane);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}
