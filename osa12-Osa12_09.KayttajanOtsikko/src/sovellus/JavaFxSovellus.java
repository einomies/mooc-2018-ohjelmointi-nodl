package sovellus;

import javafx.application.Application;
import javafx.application.Application.Parameters;
import javafx.stage.Stage;

public class JavaFxSovellus extends Application {

    @Override
    public void start(Stage ikkuna) {
        Parameters params = getParameters();
        String organisaatio = params.getNamed().get("organisaatio");
        String kurssi = params.getNamed().get("kurssi");

        ikkuna.setTitle(organisaatio + ": " + kurssi);
        ikkuna.show();
    }

}
