
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

// Luokka (ohjelma) Puisevaa "perii" graafisen käyttöliittymän rakentamiseen
// tarvittavia ominaisuuksia Application-luokalta (ohjelmalta)
public class Puisevaa extends Application {

    // Käyttöliittymän käynnistäminen kutsuu alla olevaa metodia
    @Override
    public void start(Stage ikkuna) throws Exception {

        // luodaan 640 pikseliä leveä ja 480 pikseliä korkea alusta
        // piirtämiselle ja otetaan alustaan liittyvä piirtoväline
        // käyttöön
        Canvas piirtoalusta = new Canvas(640, 480);
        GraphicsContext piirturi = piirtoalusta.getGraphicsContext2D();

        // kutsutaan piirtämiseen käytettävää metodia piirrä
        // -- metodiin tullaan toteuttamaan piirtotoiminnallisuus
        piirra(piirturi);

        // asetetaan käyttöliittymän osat paikalleen ja 
        // näytetään se käyttäjälle
        Pane ruutu = new Pane(piirtoalusta);
        Scene nakyma = new Scene(ruutu);

        ikkuna.setTitle("Niin hyvää puuta!");
        ikkuna.setScene(nakyma);
        ikkuna.show();
    }

    // Ohjelma käynnistetään metodilla public static void main. 
    // Metodissa kutsutaan Application luokalta perittyä toiminnallisuutta, 
    // joka lopulta suorittaa yllä kuvatun start-metodin
    public static void main(String[] args) {
        launch(Puisevaa.class);
    }

    // Oma piirra-metodimme, jonne toteutetaan piirtotoiminnallisuus
    public static void piirra(GraphicsContext piirturi) {

        // viivan piirtäminen kohdasta (0,0) kohtaan (100, 100)
//        piirturi.strokeLine(0, 0, 100, 100);
        
        // Suorakulmio (640x100) ikkunan alareunaan
        piirturi.strokeRect(0, 380, 640, 100);
        
//        piirturi.strokeLine(0, 0, 300, 300);
//        piirturi.strokeOval(200, 200, 80, 80);
        
        piirraPuut(piirturi, 5);
    }
    
    private static void piirraPuut(GraphicsContext piirturi, int lkm) {
        
        int vasenMarginaali = 10;
        int oikeaMarginaali = 10;
        int piirtoalueX = 640 - vasenMarginaali - oikeaMarginaali;
        
        int ylaMarginaali = 120;
        int alaMarginaali = 80;
        int piirtoalueY = 480 - ylaMarginaali - alaMarginaali;

        int ovaaliVasenYlakulmaX = 30;
        int ovaaliYlakulmavaliX = 120;
        int ovaaliVasenYlakulmaY = 120;
        
        int ovaaliKorkeus = 80;
        int ovaaliLeveys = 80;
        
        int viivaMistaX = 0;
        int viivaMihinX = 0;

        int viivaMistaY = 0;
        int viivaMihinY = 400;
        
        boolean lkmParillinen = false;
        
        if (lkm < 1) {
            piirturi.strokeText("E I    P U I T A", 250, 200);
        } else {
            if (lkm%2 == 0) {
                lkmParillinen = true;
            } else {
                lkmParillinen = false;
            }
        }

        for (int i = 0; i < lkm; i++) {
//          Piirretään ympyrä
            piirturi.strokeOval(ovaaliVasenYlakulmaX+(i*ovaaliYlakulmavaliX), ovaaliVasenYlakulmaY, ovaaliLeveys, ovaaliKorkeus);
//          Piirretään pystyviiva ympyrän alareunasta ruudun alareunassa
//          olevaan nelikulmioon. Ensin lasketaan viivan X-koordinaatit.
            int viivaX = ovaaliVasenYlakulmaX+(i*ovaaliYlakulmavaliX)+(ovaaliLeveys/2);
//            System.out.println("viivaX: " +viivaX);
            piirturi.strokeLine(viivaX, ovaaliVasenYlakulmaY+ovaaliKorkeus, viivaX, viivaMihinY);
        }
    }
/*
piirturi.strokeLine(int mistaX, int mistaY, int mihinX, int mihinY) piirtää
viivan kohdasta (mistaX, mistaY) kohtaan (mihinX, mihinY).

piirturi.strokeRect(int mistaX, int mistaY, int leveys, int korkeus) piirtää
suorakulmion, jonka leveys on leveys ja korkeus on korkeus. Suorakulmion vasen
yläkulma on pisteessä (mistaX, mistaY). 

piirturi.strokeOval(int mistaX, int mistaY, int leveys, int korkeus) piirtää
ovaalin, jonka leveys on leveys ja korkeus on korkeus. Pienimmän mahdollisimman
suorakulmion, joka rajaa ovaalin, vasen yläkulma on pisteessä (mistaX, mistaY) 
*/

}
