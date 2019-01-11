Solution for osa12-Osa12_07.Ristinolla

src/ristinolla/Ristinolla.java
package ristinolla;
import java.util.Arrays;
public class Ristinolla {
    private String[][] ristinolla;
    private String vuoro;
    public Ristinolla() {
        this.ristinolla = new String[][]{{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
        this.vuoro = "X";
    }
    public String status(int x, int y) {
        if (x < 0 || y < 0 || x > 2 || y > 2) {
            return "";
        }
        return this.ristinolla[x][y];
    }
    public void aseta(int x, int y) {
        if (x < 0 || y < 0 || x > 2 || y > 2) {
            return;
        }
        if (!this.ristinolla[x][y].equals(" ")) {
            return;
        }
        if (loppu()) {
            return;
        }
        this.ristinolla[x][y] = this.vuoro;
        if (this.vuoro.equals("X")) {
            this.vuoro = "O";
        } else {
            this.vuoro = "X";
        }
    }
    public boolean loppu() {
        int[][] samat = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {0, 4, 8},
            {6, 4, 2},
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8}
        };
        for (int i = 0; i < samat.length; i++) {
            if (taulukossaSamatKohdissa(samat[i])) {
                return true;
            }
        }
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (status(x, y).trim().isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }
    public String vuoro() {
        return this.vuoro;
    }
    private boolean taulukossaSamatKohdissa(int[] taulukko) {
        String[] arvot = {arvoTaulukossa(taulukko[0]), arvoTaulukossa(taulukko[1]), arvoTaulukossa(taulukko[2])};
        Arrays.sort(arvot);
        return arvot[0].equals(arvot[1]) && arvot[1].equals(arvot[2]) && !arvot[0].trim().isEmpty();
    }
    private String arvoTaulukossa(int kohta) {
        int x = kohta % 3;
        int y = kohta / 3;
        return this.ristinolla[x][y];
    }
}

src/ristinolla/RistinollaSovellus.java
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