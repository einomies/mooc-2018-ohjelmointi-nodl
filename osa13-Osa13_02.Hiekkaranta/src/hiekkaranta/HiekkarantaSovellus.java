package hiekkaranta;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class HiekkarantaSovellus extends Application {

    @Override
    public void start(Stage ikkuna) throws Exception {
        final int canvasLeveys = 200;
        final int canvasKorkeus = 200;
        Canvas canvas = new Canvas(canvasLeveys, canvasKorkeus);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setFill(Color.BLACK);
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

        Simulaatio simulaatio = new Simulaatio(canvasLeveys, canvasKorkeus);

        canvas.setOnMouseDragged((event) -> {
            int kohtaX = (int) event.getX();
            int kohtaY = (int) event.getY();

            Tyyppi tyyppi = Tyyppi.TYHJA;
            if (radioButtonMetalli.isSelected()) {
                tyyppi = Tyyppi.METALLI;
            } else if (radioButtonHiekka.isSelected()) {
                tyyppi = Tyyppi.HIEKKA;
            } else if (radioButtonVesi.isSelected()) {
                tyyppi = Tyyppi.VESI;
            } else {
                tyyppi = Tyyppi.TYHJA;
            }

//          Lisätään useampi piste (3 x 3) samalla hiiren klikkauksella
            for (int x = -1; x < 2; x++) {
                for (int y = -1; y < 2; y++) {
                    simulaatio.lisaa(kohtaX + x, kohtaY + y, tyyppi);
                }
            }
            graphicsContext.setFill(haeVari(tyyppi));
            if (kohtaX >= 0 && kohtaX < canvasLeveys && kohtaY >= 0 && kohtaY < canvasKorkeus) {
                graphicsContext.fillOval(kohtaX, kohtaY, 4, 4);
            }
        });

        new AnimationTimer() {
            long edellinen = 0;

            @Override
            public void handle(long nykyhetki) {
                if (nykyhetki - edellinen < 100000000) {
                    return;
                }
                simulaatio.paivita();
                piirraSimulatio(simulaatio);
            }

            private void piirraSimulatio(Simulaatio sisalto) {
                for (int i = 0; i < simulaatio.getLeveys(); i++) {
                    for (int j = 0; j < simulaatio.getKorkeus(); j++) {
                        graphicsContext.setFill(haeVari(simulaatio.sisalto(i, j)));
                        graphicsContext.fillOval(i, j, 4, 4);
                    }
                }
            }
        }.start();

        Scene scene = new Scene(borderPane);

        ikkuna.setScene(scene);
        ikkuna.show();
    }

    public static void main(String[] args) {
        launch(HiekkarantaSovellus.class);
    }

    private Paint haeVari(Tyyppi tyyppi) {
        switch (tyyppi) {
            case HIEKKA:
                return Color.ORANGE;
            case METALLI:
                return Color.WHITE;
            case TYHJA:
                return Color.BLACK;
            case VESI:
                return Color.LIGHTBLUE;
            default:
                return Color.BLACK;
        }
    }

}
