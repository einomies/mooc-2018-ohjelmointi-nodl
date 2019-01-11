package sovellus;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;

/**
 * Sanojen syöttäminen
 *
 * Luodaan seuraavaksi sanojen syöttämiseen tarvittava toiminnallisuus. Sanojen
 * syöttämistä varten tarvitsemme viitteen sanakirja-olioon sekä tekstikentät
 * sanalle ja käännökselle. GridPane-asettelu sopii hyvin kenttien asetteluun.
 *
 * Luodaan luokka Syottonakyma, joka tarjoaa metodin getNakyma, joka luo sanojen
 * syöttämiseen tarvittavan näkymän. Metodi palauttaa viitteen Parent-tyyppiseen
 * olioon. Parent on muunmuassa asetteluun käytettävien luokkien yläluokka,
 * joten mitä tahansa asetteluun käytettävää luokkaa voidaan esittää
 * Parent-oliona.
 *
 * Luokka määrittelee myös käyttöliittymään liittyvän
 * napinpainallustoiminnallisuuden. Kun käyttäjä painaa nappia, sanapari
 * lisätään sanakirjaan. Samalla myös teksti- kentät tyhjennetään seuraavan
 * sanan syöttämistä varten.
 *
 * @author einomies
 */
public class Listausnakyma {

    private Sanakirja sanakirja;

    public Listausnakyma(Sanakirja sanakirja) {
        this.sanakirja = sanakirja;
    }

    public Parent getNakyma() {
        GridPane asettelu = new GridPane();
        ScrollPane scrollPane = new ScrollPane();

        Label sanaohje = new Label("Sana");
        Label kaannosohje = new Label("Käännös");

        asettelu.setAlignment(Pos.TOP_LEFT);
        asettelu.setVgap(10);
        asettelu.setHgap(10);
        asettelu.setPadding(new Insets(10, 10, 10, 10));

        asettelu.add(sanaohje, 0, 0);
        asettelu.add(kaannosohje, 1, 0);

        HashMap<String, String> map = this.sanakirja.listaaKaikki();

        int a = 1;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            asettelu.add(new Label(key), 0, a);
            asettelu.add(new Label(value), 1, a);
            a++;
        }

//        tulostaSanat(map);
        return asettelu;
    }

    private void tulostaSanat(HashMap<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "  --> " + value);
        }
    }

}
