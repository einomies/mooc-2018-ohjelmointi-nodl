
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        // voit tehdä tänne testikoodia

        // Jos ohjelmassa on useampi luokka, joka sisältää main-metodin, voi
        // halutun main metodin käynnistää valitsemalla luokka vasemmalla
        // olevasta projektilistauksesta ja painamalla oikealla
        // hiirennapilla "Run File".

        // luodaan hajautustaulu
        HashMap<Integer, HashMap<Integer, Integer>> taulukko = new HashMap<>();

//      yllä olevassa hajautustaulussa jokainen x-koordinaatti viittaa uuteen hajautustauluun:
//      näitä ei ole kuitenkaan vielä tehty, joten alustetaan kaikki arvot nolliksi
//      luodaan 10 x 10 kokoinen maailma, missä kaikki arvot ovat nollia
        int leveys = 10;
        int korkeus = 10;

        int x = 0;
        while (x < leveys) {
            taulukko.putIfAbsent(x, new HashMap<>());

            int y = 0;
            while (y < korkeus) {
                taulukko.get(x).put(y, 0);
                y++;
            }

            x++;
        }

//      asetetaan kohtaan (3, 2) arvo 5
        taulukko.get(3).put(2, 5);

//      haetaan arvo kohdasta (0, 1) ja tulostetaan se
        System.out.println(taulukko.get(0).get(1));
    }

}
