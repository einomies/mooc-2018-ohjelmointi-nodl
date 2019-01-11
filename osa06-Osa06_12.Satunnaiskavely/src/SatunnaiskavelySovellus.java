
import java.util.HashMap;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SatunnaiskavelySovellus extends Application {

    public void start(Stage stage) {
        final int leveys = 800;
        final int korkeus = 800;

        stage.setTitle("Satunnaiskävely");

        Group root = new Group();
        Scene scene = new Scene(root);
        stage.setScene(scene);

        Canvas piirtoalusta = new Canvas(leveys, korkeus);
        root.getChildren().add(piirtoalusta);

        GraphicsContext piirturi = piirtoalusta.getGraphicsContext2D();

        Satunnaiskavely kavely = new Satunnaiskavely(100, 100);

        new AnimationTimer() {
            // päivitetään animaatiota noin 100 millisekunnin välein
            private long sleepNanoseconds = 100 * 1000000;
            private long prevTime = 0;

            public void handle(long currentNanoTime) {
                // päivitetään animaatiota noin 100 millisekunnin välein
                if ((currentNanoTime - prevTime) < sleepNanoseconds) {
                    return;
                }

                // piirretään alusta
                piirturi.setFill(Color.BLACK);
                piirturi.fillRect(0, 0, leveys, korkeus);

                // piirretään liike ja liikkeen jälki
                HashMap<Integer, HashMap<Integer, Double>> taulukko = kavely.getTaulukko();
                int x = 0;
                while (x < taulukko.size()) {

                    int y = 0;
                    while (y < taulukko.get(x).size()) {

                        if (taulukko.get(x).get(y) > 0) {

                            double vari = Math.min(1.0, taulukko.get(x).get(y));

                            Color color = new Color(vari, vari, vari, 1);

                            piirturi.setFill(color);
                            piirturi.fillRect(x * 8, y * 8, 8, 8);
                        }

                        y++;
                    }

                    x++;
                }
                
                // kutsutaan satunnaiskävelyn metodia askel
                kavely.askel();
                
                // älä muuta tätä
                prevTime = currentNanoTime;
            }
        }.start();

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
