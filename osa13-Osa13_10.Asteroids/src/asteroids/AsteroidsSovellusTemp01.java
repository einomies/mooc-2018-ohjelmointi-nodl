package asteroids;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AsteroidsSovellusTemp01 extends Application {

    public static int LEVEYS = 300;
    public static int KORKEUS = 200;

    @Override
    public void start(Stage stage) throws Exception {

        Pane ruutu = new Pane();
        ruutu.setPrefSize(LEVEYS, KORKEUS);

        Text text = new Text(10, 20, "Points: 0");
        ruutu.getChildren().add(text);

        AtomicInteger pisteet = new AtomicInteger();

        Alus alus = new Alus(LEVEYS / 2, KORKEUS / 2);
        ruutu.getChildren().add(alus.getHahmo());

        List<Ammus> ammukset = new ArrayList<>();

        List<Asteroidi> asteroidit = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Random rnd = new Random();
            Asteroidi asteroidi = new Asteroidi(rnd.nextInt(LEVEYS / 3), rnd.nextInt(KORKEUS));
            asteroidit.add(asteroidi);
        }
        asteroidit.forEach(asteroidi -> ruutu.getChildren().add(asteroidi.getHahmo()));

        Scene scene = new Scene(ruutu);

        Map<KeyCode, Boolean> painetutNapit = new HashMap<>();
        scene.setOnKeyPressed(event -> {
            painetutNapit.put(event.getCode(), Boolean.TRUE);
        });
        scene.setOnKeyReleased(event -> {
            painetutNapit.put(event.getCode(), Boolean.FALSE);
        });

        new AnimationTimer() {

            @Override
            public void handle(long now) {

                if (painetutNapit.getOrDefault(KeyCode.LEFT, false)) {
                    alus.kaannaVasemmalle();
                }
                if (painetutNapit.getOrDefault(KeyCode.RIGHT, false)) {
                    alus.kaannaOikealle();
                }
                if (painetutNapit.getOrDefault(KeyCode.UP, false)) {
                    alus.kiihdyta();
                }
                if (painetutNapit.getOrDefault(KeyCode.DOWN, false)) {
                    alus.hidasta();
                }

                if (painetutNapit.getOrDefault(KeyCode.SPACE, false) && ammukset.size() < 3) {
                    // ammutaan
                    Ammus ammus = new Ammus((int) alus.getHahmo().getTranslateX(), (int) alus.getHahmo().getTranslateY());
                    ammus.getHahmo().setRotate(alus.getHahmo().getRotate());
                    ammukset.add(ammus);

                    ammus.kiihdyta();
                    ammus.setLiike(ammus.getLiike().normalize().multiply(3));

                    ruutu.getChildren().add(ammus.getHahmo());
                }

                ammukset.forEach(ammus -> {
                    asteroidit.forEach(asteroidi -> {
                        if (ammus.tormaa(asteroidi)) {
                            ammus.setElossa(false);
                            asteroidi.setElossa(false);
                        }
                    });
                    if (!ammus.isElossa()) {
                        text.setText("Points: " + pisteet.addAndGet(1000));
                    }
                });

                ammukset.stream()
                        .filter(ammus -> !ammus.isElossa())
                        .forEach(ammus -> ruutu.getChildren().remove(ammus.getHahmo()));

                ammukset.removeAll(ammukset.stream()
                        .filter(ammus -> !ammus.isElossa())
                        .collect(Collectors.toList()));

                asteroidit.stream()
                        .filter(asteroidi -> !asteroidi.isElossa())
                        .forEach(asteroidi -> ruutu.getChildren().remove(asteroidi.getHahmo()));

                asteroidit.removeAll(asteroidit.stream()
                        .filter(asteroidi -> !asteroidi.isElossa())
                        .collect(Collectors.toList()));

                alus.liiku();
                asteroidit.forEach(asteroidi -> asteroidi.liiku());
                ammukset.forEach(ammus -> ammus.liiku());

                asteroidit.forEach(asteroidi -> {
                    if (alus.tormaa(asteroidi)) {
                        this.stop();
                    }
                });

                if (Math.random() < 0.005) {
                    Asteroidi asteroidi = new Asteroidi(LEVEYS, KORKEUS);
                    if (!asteroidi.tormaa(alus)) {
                        asteroidit.add(asteroidi);
                        ruutu.getChildren().add(asteroidi.getHahmo());
                    }
                }

            }
        }.start();

        stage.setTitle("Asteroids!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static int osiaToteutettu() {
        return 4;
    }

}
