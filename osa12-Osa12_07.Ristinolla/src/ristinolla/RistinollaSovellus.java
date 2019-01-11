package ristinolla;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class RistinollaSovellus extends Application {

    @Override
    public void start(Stage ikkuna) {

        final javafx.scene.text.Font font = javafx.scene.text.Font.font("Monospaced", 80);

        final String VUORO_X = "Vuoro: X";
        final String VUORO_O = "Vuoro: O";
        final String LOPPU = "Loppu!";

        BorderPane borderPane = new BorderPane();
        Label label = new Label(VUORO_X);
        label.setFont(font);
        borderPane.setTop(label);

        ArrayList<Button> buttons = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            buttons.add(new Button(" "));
        }
        buttons.forEach((button) -> {
            button.setFont(font);
        });

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        int i = 0;
        while (i < buttons.size()) {
            for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 3; y++) {
                    gridPane.add(buttons.get(i), x, y);
                    i++;
                }
            }
        }

        borderPane.setCenter(gridPane);

        buttons.forEach((button) -> {
            button.setOnAction((event) -> {
                String merkki = "";
                if (!label.getText().equals(LOPPU) && button.getText().equals(" ")) {
                    if (label.getText().equals(VUORO_X)) {
                        merkki = "X";
                        label.setText(VUORO_O);
                    } else {
                        merkki = "O";
                        label.setText(VUORO_X);
                    }
                    button.setText(merkki);

                    /**
                     * Jos kaikissa buttoneissa on jo arvo, lopetetaan peli
                     */
                    int tyhjaLkm = 0;
                    tyhjaLkm = buttons.stream()
                            .filter((button1) -> (button1.getText().equals(" ")))
                            .map((item) -> 1)
                            .reduce(tyhjaLkm, Integer::sum);
                    if (tyhjaLkm == 0) {
                        label.setText(LOPPU);
                    }

                    /**
                     * Samojen merkkien tarkistus pysty- ja vaakariveille sekä
                     * diagonaaleille, osa 1
                     */
                    ArrayList<PositiotArvot> arvot = new ArrayList<>();
                    for (Node node : gridPane.getChildren()) {
                        Button namiska = (Button) node;
                        arvot.add(new PositiotArvot(GridPane.getColumnIndex(node),
                                GridPane.getRowIndex(node),
                                namiska.getText()));
                    }

                    boolean samaaMerkkia = false;
                    /**
                     * Samojen merkkien tarkistus pysty- ja vaakariveille sekä
                     * diagonaaleille, osa 2
                     */
                    int lkmX = 0;
                    int lkmY = 0;
                    for (int a = 0; a < 3; a++) {
                        if (samaaMerkkia) {
                            break;
                        }
                        lkmX = 0;
                        lkmY = 0;
                        String ekaMerkkiX = "";
                        String ekaMerkkiY = "";
                        for (int b = 0; b < arvot.size(); b++) {
                            if (arvot.get(b).getX() == a) {
                                if (arvot.get(b).getArvo().equals("X") || arvot.get(b).getArvo().equals("O")) {
                                    lkmX++;
                                    if (lkmX == 1) {
                                        ekaMerkkiX = arvot.get(b).getArvo();
                                    } else {
                                        if (arvot.get(b).getArvo().equals(ekaMerkkiX)) {
                                            samaaMerkkia = true;
                                        } else {
                                            samaaMerkkia = false;
                                            break;
                                        }
                                    }
                                } else {
                                    samaaMerkkia = false;
                                }
                            }
                        }
                        if (lkmX == 3 && samaaMerkkia) {
                            break;
                        }
                        for (int c = 0; c < arvot.size(); c++) {
                            if (arvot.get(c).getY() == a) {
                                if (arvot.get(c).getArvo().equals("X") || arvot.get(c).getArvo().equals("O")) {
                                    lkmY++;
                                    if (lkmY == 1) {
                                        ekaMerkkiY = arvot.get(c).getArvo();
                                    } else {
                                        if (arvot.get(c).getArvo().equals(ekaMerkkiY)) {
                                            samaaMerkkia = true;
                                        } else {
                                            samaaMerkkia = false;
                                            break;
                                        }
                                    }
                                } else {
                                    samaaMerkkia = false;
                                }
                            }
                        }
                        if (lkmY == 3 && samaaMerkkia) {
                            break;
                        }
                    }

                    if (!samaaMerkkia) {
                        String keskimmainen = "";
                        for (PositiotArvot arvo : arvot) {
                            if (arvo.getX() == 1 && arvo.getY() == 1) {
                                keskimmainen = arvo.getArvo();
                            }
                        }
                        for (PositiotArvot arvo : arvot) {
                            if ((arvo.getX() == 0 && arvo.getY() == 0)
                                    || (arvo.getX() == 2 && arvo.getY() == 2)) {
                                if (!arvo.getArvo().equals(" ") && arvo.getArvo().equals(keskimmainen)) {
                                    samaaMerkkia = true;
                                } else {
                                    samaaMerkkia = false;
                                    break;
                                }
                            }
                        }
                        if (!samaaMerkkia) {
                            for (PositiotArvot arvo : arvot) {
                                if ((arvo.getX() == 2 && arvo.getY() == 0)
                                        || (arvo.getX() == 0 && arvo.getY() == 2)) {
                                    if (!arvo.getArvo().equals(" ") && arvo.getArvo().equals(keskimmainen)) {
                                        samaaMerkkia = true;
                                    } else {
                                        samaaMerkkia = false;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if (samaaMerkkia) {
                        label.setText(LOPPU);
                    }
                }
            });
        });

        Scene scene = new Scene(borderPane);

        ikkuna.setScene(scene);
        ikkuna.show();
    }

    public static void main(String[] args) {
        launch(RistinollaSovellus.class);
    }

}
/*
package ristinolla;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class RistinollaSovellus extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Ristinolla ristinolla = new Ristinolla();
        Font tasaleveys = Font.font("Monospaced", 40);
        Label pelitilanne = new Label("Vuoro: " + ristinolla.vuoro());
        pelitilanne.setFont(tasaleveys);
        BorderPane asettelu = new BorderPane();
        asettelu.setTop(pelitilanne);
        GridPane ruudukko = new GridPane();
        ruudukko.setHgap(10);
        ruudukko.setVgap(10);
        ruudukko.setPadding(new Insets(10, 10, 10, 10));
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                Button nappi = new Button(ristinolla.status(x, y));
                nappi.setFont(tasaleveys);
                ruudukko.add(nappi, x, y);
                int rx = x;
                int ry = y;
                nappi.setOnAction((event) -> {
                    ristinolla.aseta(rx, ry);
                    nappi.setText(ristinolla.status(rx, ry));
                    pelitilanne.setText("Vuoro: " + ristinolla.vuoro());
                    if (ristinolla.loppu()) {
                        pelitilanne.setText("Loppu!");
                    }
                });
            }
        }
        asettelu.setCenter(ruudukko);
        Scene nakyma = new Scene(asettelu);
        stage.setScene(nakyma);
        stage.show();
    }

    public static void main(String[] args) {
        launch(RistinollaSovellus.class);
        System.out.println("Hello world!");
    }
}
*/