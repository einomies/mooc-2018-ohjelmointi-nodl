/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esimerkki;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author einomies
 */
public class EsimGridPane01 extends Application {

    @Override
    public void start(Stage ikkuna) {
        GridPane asettelu = new GridPane();
        asettelu.setHgap(10);
        asettelu.setVgap(10);
        asettelu.setAlignment(Pos.CENTER);

        final Font font = Font.font(STYLESHEET_CASPIAN, 40);

//        ArrayList<Button> buttons = new ArrayList<>();
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                asettelu.add(new Button("" + x + "," + y), x, y);
            }
        }
        
        for (Node node : asettelu.getChildren()) {
            Button button = (Button) node;
            button.setFont(font);
            System.out.println(GridPane.getColumnIndex(node));
            System.out.println(GridPane.getRowIndex(node));
            System.out.println("------");
        }

        Scene nakyma = new Scene(asettelu);

        ikkuna.setScene(nakyma);
        ikkuna.show();
    }

    public static void main(String[] args) {
        launch(EsimGridPane01.class);
    }

}
