package sovellus;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UseampiNakyma extends Application {

    @Override
    public void start(Stage ikkuna) throws Exception {

        BorderPane borderPane = new BorderPane();
        Label label01 = new Label("Eka näkymä!");
        Button button01 = new Button("Tokaan näkymään!");
        borderPane.setTop(label01);
        borderPane.setCenter(button01);

        Scene scene01 = new Scene(borderPane);

        VBox vBox01 = new VBox();
        Button button02 = new Button("Kolmanteen näkymään!");
        Label label02 = new Label("Toka näkymä!");
        vBox01.setSpacing(10);
        vBox01.getChildren().add(button02);
        vBox01.getChildren().add(label02);

        Scene scene02 = new Scene(vBox01);

        GridPane gridPane01 = new GridPane();
        Label label03 = new Label("Kolmas näkymä!");
        Button button03 = new Button("Ekaan näkymään!");
        gridPane01.add(label03, 0, 0);
        gridPane01.add(button03, 1, 1);

        Scene scene03 = new Scene(gridPane01);

        button01.setOnAction((event) -> {
            ikkuna.setScene(scene02);
        });
        button02.setOnAction((event) -> {
            ikkuna.setScene(scene03);
        });
        button03.setOnAction((event) -> {
            ikkuna.setScene(scene01);
        });

        ikkuna.setScene(scene01);
        ikkuna.show();
    }

    public static void main(String[] args) {
        launch(UseampiNakyma.class);
    }

}
/*
package sovellus;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UseampiNakyma extends Application {

    @Override
    public void start(Stage ikkuna) throws Exception {
        Button ekaButton = new Button("Ekaan näkymään!");
        Button tokaButton = new Button("Tokaan näkymään!");
        Button kolmasButton = new Button("Kolmanteen näkymään!");
        BorderPane ekaLayout = new BorderPane();
        ekaLayout.setTop(new Label("Eka näkymä!"));
        ekaLayout.setCenter(tokaButton);
        VBox tokaLayout = new VBox();
        tokaLayout.getChildren().addAll(kolmasButton, new Label("Toka näkymä!"));
        GridPane kolmasLayout = new GridPane();
        kolmasLayout.add(new Label("Kolmas näkymä!"), 0, 0);
        kolmasLayout.add(ekaButton, 1, 1);
        Scene eka = new Scene(ekaLayout);
        Scene toka = new Scene(tokaLayout);
        Scene kolmas = new Scene(kolmasLayout);
        ekaButton.setOnAction((event) -> {
            ikkuna.setScene(eka);
        });
        tokaButton.setOnAction((event) -> {
            ikkuna.setScene(toka);
        });
        kolmasButton.setOnAction((event) -> {
            ikkuna.setScene(kolmas);
        });
        ikkuna.setScene(eka);
        ikkuna.show();
    }

    public static void main(String[] args) {
        launch(UseampiNakyma.class);
        System.out.println("Hello world!");
    }
}
*/