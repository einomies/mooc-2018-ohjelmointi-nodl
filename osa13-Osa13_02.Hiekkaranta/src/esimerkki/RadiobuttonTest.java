package esimerkki;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class RadiobuttonTest extends Application {

    @Override
    public void start(Stage ikkuna) throws Exception {
        final int canvasLeveys = 400;
        final int canvasKorkeus = 400;
        Canvas canvas = new Canvas(canvasLeveys, canvasKorkeus);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setFill(Color.BLACK);
//        graphicsContext.clearRect(0, 0, 200, 200);
        graphicsContext.fillRect(0, 0, canvasLeveys, canvasKorkeus);

        ToggleGroup toggleGroup = new ToggleGroup();
        RadioButton radioButtonMetalli = new RadioButton("Metalli");
        RadioButton radioButtonHiekka = new RadioButton("Hiekka");
        RadioButton radioButtonVesi = new RadioButton("Vesi");
        radioButtonMetalli.setToggleGroup(toggleGroup);
        radioButtonMetalli.setUserData("Metalli");
        radioButtonHiekka.setToggleGroup(toggleGroup);
        radioButtonHiekka.setUserData("Hiekka");
        radioButtonVesi.setToggleGroup(toggleGroup);
        radioButtonVesi.setUserData("Vesi");

        VBox vBox = new VBox();
        vBox.getChildren().addAll(radioButtonMetalli, radioButtonHiekka, radioButtonVesi);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(canvas);
        borderPane.setRight(vBox);

        canvas.setOnMouseDragged((event) -> {
            int kohtaX = (int) event.getX();
            int kohtaY = (int) event.getY();
            
            if (radioButtonMetalli.isSelected()) {
                graphicsContext.setFill(Color.WHITE);
            } else if (radioButtonHiekka.isSelected()) {
                graphicsContext.setFill(Color.ORANGE);
            } else if (radioButtonVesi.isSelected()) {
                graphicsContext.setFill(Color.LIGHTBLUE);
            } else {
                graphicsContext.setFill(Color.BLACK);
            }
            graphicsContext.fillOval(kohtaX, kohtaY, 10, 10);
        });

        Scene scene = new Scene(borderPane);

        ikkuna.setScene(scene);
        ikkuna.show();
    }

    public static void main(String[] args) {
        launch(RadiobuttonTest.class);
    }

}
