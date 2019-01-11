import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class StackyWindowsSovellus extends Application {

    double vanhaX, vanhaY;
    double uusiX, uusiY;

    public void start(Stage stage) {
        final int ikkunanLeveys = 800;
        final int ikkunanKorkeus = 600;

        stage.setTitle("StackyWindows 1.0");

        Group root = new Group();
        Scene scene = new Scene(root);
        stage.setScene(scene);

        Canvas piirtoalusta = new Canvas(ikkunanLeveys, ikkunanKorkeus);
        root.getChildren().add(piirtoalusta);

        GraphicsContext piirturi = piirtoalusta.getGraphicsContext2D();

        ArrayList<Ikkuna> ikkunat = new ArrayList<>();
        ikkunat.add(new Ikkuna(300, 120, 200, 400, Color.GREEN));
        ikkunat.add(new Ikkuna(350, 150, 250, 300, Color.RED));
        ikkunat.add(new Ikkuna(180, 180, 200, 300, Color.BLUE));
        ikkunat.add(new Ikkuna(520, 350, 150, 150, Color.CHOCOLATE));
        
        root.setOnMousePressed((MouseEvent event) -> {
            System.out.println("mouse click " + event.getSource());
            System.out.println("\t" + event.getX());
            System.out.println("\t" + event.getY());
            
            vanhaX = event.getX();
            vanhaY = event.getY();

            for (int i = 0; i < ikkunat.size(); i++) {
                if (!ikkunat.get(i).ulkopuolella((int)event.getX(), (int)event.getY())) {
//                    System.out.println("ikkuna index = " +i);
                    if (i != ikkunat.size()) {
                        ikkunat.add(ikkunat.get(i));
                        ikkunat.remove(i);
                    }
                }
            }
        });
        
        /*
        EK 16.4.2018
        Alla oleva suorakulmion drag-temppu ei toimi ainakaan tuolla uusiX/uusiY-
        virityksellä. Pistetään kuntoon myöhemmin, jos/kun jostain saa sopivia
        vinkkejä.
        */
        root.setOnMouseDragged((MouseEvent event) -> {
            System.out.println("moving mouse, mouse down!");
            System.out.println("\t" + event.getX());
            System.out.println("\t" + event.getY());
            // huom! jos haluat tarkastella hiiren siirtymisiä, tarvitset 
            // viittaustyyppisen muuttujan, jossa pidetään 
            // kirjaa hiiren aiemmasta sijainnista..
            uusiX = (int)event.getX();
            uusiY = (int)event.getY();
            ikkunat.get(ikkunat.size()).setX((int)uusiX);
            ikkunat.get(ikkunat.size()).setY((int)uusiY);
        });
        
//        System.out.println("vanhaX:" + vanhaX);
//        System.out.println("vanhaY:" + vanhaY);
//        System.out.println("uusiX:" + uusiX);
//        System.out.println("uusiY:" + uusiY);

        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                piirturi.clearRect(0, 0, ikkunanLeveys, ikkunanKorkeus);

                for (Ikkuna ikkuna : ikkunat) {
                    piirturi.setFill(ikkuna.getVari());
                    piirturi.fillRect(ikkuna.getX(), ikkuna.getY(), ikkuna.getLeveys(), ikkuna.getKorkeus());
                }
            }
        }.start();

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
