package pong;

import pong.ai.FollowingPongAi;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PongSovellus extends Application {

    final int leveys = 480;
    final int korkeus = 300;

    private Pong pong;

    @Override
    public void start(Stage stage) throws Exception {

        this.pong = new Pong(leveys, korkeus, new FollowingPongAi(), new FollowingPongAi());

        Pane ruutu = new Pane();
        ruutu.setPrefSize(leveys, korkeus);

        ruutu.getChildren().add(this.pong.getPallo());
        ruutu.getChildren().add(this.pong.getPelaajanYksiMaila());
        ruutu.getChildren().add(this.pong.getPelaajanKaksiMaila());

        Text pisteet = new Text("0 - 0");
        pisteet.setTranslateX(leveys / 2 - pisteet.getLayoutBounds().getWidth() / 2);
        pisteet.setTranslateY(20);

        ruutu.getChildren().add(pisteet);

        new AnimationTimer() {
            private long edellinen;

            @Override
            public void handle(long nykyhetki) {
                if (nykyhetki - edellinen < 10_000_000L) {
                    return;
                }

                edellinen = nykyhetki;

                pong.liikuta();
                pisteet.setText("" + pong.getPelaajanYksiPisteet() + " - " + pong.getPelaajanKaksiPisteet());
            }
        }.start();

        Scene scene = new Scene(ruutu);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
