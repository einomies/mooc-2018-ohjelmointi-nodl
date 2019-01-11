/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arviot;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author einomies
 */
public class Testailua {

    public static void main(String[] args) {
        testi01();
        testi02();
//        testi03();
        testi04();
        testi05();
        testi06();
    }

    private static void testi01() {
//        sanojenLukumaara
        List<String> rivit = lueRivit("src/arviot.txt");
        TunteikkaatArviot arviot = new TunteikkaatArviot(rivit);
        System.out.println(arviot.sanojenLukumaara("what"));
        System.out.println(arviot.sanojenLukumaara("is"));
        System.out.println(arviot.sanojenLukumaara("love"));
        System.out.println(arviot.sanojenLukumaara("chuck"));
        System.out.println(arviot.sanojenLukumaara("norris"));
        System.out.println(arviot.sanojenLukumaara("mikkihiiri"));
        /*
        338
        2538
        172
        2
        1
        0
         */
    }

    private static void testi02() {
//        sananTunne
        List<String> rivit = lueRivit("src/arviot.txt");
        TunteikkaatArviot arviot = new TunteikkaatArviot(rivit);
        System.out.println(arviot.sananTunne("poor"));
        System.out.println(arviot.sananTunne("is"));
        System.out.println(arviot.sananTunne("love"));
        System.out.println(arviot.sananTunne("damme"));
        System.out.println(arviot.sananTunne("norris"));
        /*
        0.8235294117647058
        2.0260047281323876
        2.645348837209302
        2.5
        2.0
         */
    }

    private static void testi03() {
//        tulostaSanojenArviot
        List<String> rivit = lueRivit("src/arviot.txt");
        TunteikkaatArviot arviot = new TunteikkaatArviot(rivit);
        arviot.tulostaSanojenArviot();
    }

    private static void testi04() {
//        sananTunneMerkkijonona
        List<String> rivit = lueRivit("src/arviot.txt");
        TunteikkaatArviot arviot = new TunteikkaatArviot(rivit);
        System.out.println(arviot.sananTunneMerkkijonona("poor"));
        System.out.println(arviot.sananTunneMerkkijonona("is"));
        System.out.println(arviot.sananTunneMerkkijonona("love"));
        System.out.println(arviot.sananTunneMerkkijonona("damme"));
        System.out.println(arviot.sananTunneMerkkijonona("norris"));
        /*
        negatiivinen
        neutraali
        positiivinen
        positiivinen
        neutraali
         */
    }

    private static void testi05() {
//        lauseenTunne
        List<String> rivit = lueRivit("src/arviot.txt");
        TunteikkaatArviot arviot = new TunteikkaatArviot(rivit);
        System.out.println(arviot.lauseenTunne("unicorn is a mythical creature"));
        System.out.println(arviot.lauseenTunne("chuck norris made a happy meal cry"));
        System.out.println(arviot.lauseenTunne("the movie was an utter and complete failure"));
        /*
        2.181146685022733
        2.104368086244505
        1.73662040170538
         */
    }

    private static void testi06() {
//        lauseenTunneMerkkijonona
        List<String> rivit = lueRivit("src/arviot.txt");
        TunteikkaatArviot arviot = new TunteikkaatArviot(rivit);
        System.out.println(arviot.lauseenTunneMerkkijonona("unicorn is a mythical creature"));
        System.out.println(arviot.lauseenTunneMerkkijonona("chuck norris made a happy meal cry"));
        System.out.println(arviot.lauseenTunneMerkkijonona("the movie was an utter and complete failure"));
        /*
        positiivinen
        positiivinen
        negatiivinen
         */
    }

    private static List<String> lueRivit(String tiedosto) {
        List<String> rivit = new ArrayList<>();
        try {
            rivit = Files.lines(Paths.get(tiedosto)).collect(Collectors.toList());
        } catch (IOException ex) {
            System.out.println("Tiedoston " + tiedosto + " lukeminen epäonnistui.");
        }
        return rivit;
    }

}
