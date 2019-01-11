
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class ChuckNorrisVitsit {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        String komento="";
        ArrayList<String> rivit = new ArrayList<>();
        
        String urlRandom = "http://api.icndb.com/jokes/random/";
        String urlTunnus = "http://api.icndb.com/jokes/";
        String urlJokes = "http://api.icndb.com/jokes/";
        String url="";
        
        System.out.println("Chuck Norris -vitsien haku (api.icndb.com)");
        System.out.println("------------------------------------------");
        System.out.println("Komennot:");
        System.out.println("satunnainen - haetaan satunnainen vitsi");
        System.out.println("vitsi <numero> - haetaan vitsin numeron perusteella");
        System.out.println("lopeta - lopetetaan ohjelman suoritus");
        System.out.println("");

        while (true) {
            System.out.print("Syötä komento: ");
            komento = lukija.nextLine();
            
            if (komento.equals("lopeta")) {
                break;
            }
           
            if (komento.equals("satunnainen")) {
                url = urlRandom;
                try {
                    URL urlTest1 = new URL(url);
                    Scanner vitsienLukija = new Scanner(urlTest1.openStream());
                    while (vitsienLukija.hasNextLine()) {
                        rivit.add(vitsienLukija.nextLine());
                    }
                    for (int i = 0; i < rivit.size(); i++) {
                        System.out.println("rivi " +i +": " +rivit.get(i));
                    }
                } catch (Exception e) {
                    System.out.println("Virhe: " + e.getMessage());
                }
            } else if (komento.equals("vitsi")) {
                System.out.print("Syötä vitsin tunnus: ");
                int tunnus = Integer.parseInt(lukija.nextLine());
                url = urlTunnus;
                try {
                    URL urlTest1 = new URL(url+tunnus);
                    Scanner vitsienLukija = new Scanner(urlTest1.openStream());
                    while (vitsienLukija.hasNextLine()) {
                        rivit.add(vitsienLukija.nextLine());
                    }
                    for (int i = 0; i < rivit.size(); i++) {
                        System.out.println("rivi " +i +": " +rivit.get(i));
                    }
                } catch (Exception e) {
                    System.out.println("Virhe: " + e.getMessage());
                }
            }
        }
    }

}
/*
rivi 0: { "type": "success", "value": { "id": 345, "joke": "When in a bar, you can order a drink called a &quot;Chuck Norris&quot;. It is also known as a &quot;Bloody Mary&quot;, if your name happens to be Mary.", "categories": [] } }
rivi 0: { "type": "success", "value": { "id": 46, "joke": "Chuck Norris once ate three 72 oz. steaks in one hour. He spent the first 45 minutes having sex with his waitress.", "categories": ["explicit"] } }
rivi 0: { "type": "success", "value": { "id": 169, "joke": "Chuck Norris won super bowls VII and VIII singlehandedly before unexpectedly retiring to pursue a career in ass-kicking.", "categories": [] } }
*/