package sovellus;

import javafx.application.Application;

public class Main {

    public static void main(String[] args) {
        Application.launch(JavaFxSovellus.class,
                "--organisaatio=Olipa kerran",
                "--kurssi=Otsikko");
    }

}
