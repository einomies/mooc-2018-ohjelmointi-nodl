
import java.util.HashMap;
import java.util.Random;

public class Satunnaiskavely {

    private HashMap<Integer, HashMap<Integer, Double>> taulukko;
    private int sijaintiX = 0;
    private int sijaintiY = 0;

    public Satunnaiskavely(int leveys, int korkeus) {
        this.taulukko = new HashMap<>();
        int x = 0;
        while (x < leveys) {
            this.taulukko.putIfAbsent(x, new HashMap<>());

            int y = 0;
            while (y < korkeus) {
                this.taulukko.get(x).put(y, 0.0);
                y++;
            }
            
            x++;
        }

        this.sijaintiX = leveys / 2;
        this.sijaintiY = korkeus / 2;

        this.taulukko.get(this.sijaintiX).put(this.sijaintiY, 1.0);
    }

    public void randomAskel () {
        
    }

    public void askel() {
        
        int vanhaX = this.sijaintiX;
        int vanhaY = this.sijaintiY;
//        System.out.println("Satunnaiskavely.askel(), vanhaX=" +vanhaX);
//        System.out.println("Satunnaiskavely.askel(), vanhaY=" +vanhaY);
        
        Random random = new Random();
        int suuntaNro = random.nextInt(5);
        /*
        suunnat:
        0 = pysyy paikallaan
        1 = ylös
        2 = oikealle
        3 = alas
        4 = vasemmalle
        */
        System.out.println("Satunnaiskavely.askel(), suuntaNro=" +suuntaNro);
        System.out.println("");
        
        switch (suuntaNro) {
            case 0: break;
            
            case 1:
                if(this.sijaintiY < this.taulukko.size()) {
                    this.sijaintiY++;
                }
                break;
            
            case 2:
                if(this.sijaintiX < this.taulukko.size()) {
                    this.sijaintiX++;
                }
                break;
            
            case 3:
                if(this.sijaintiY > 0) {
                    this.sijaintiY--;
                }
                break;
            
            case 4:
                if(this.sijaintiX > 0) {
                    this.sijaintiX--;
                }
                break;
            
            default: break;
        }

        // pienennetään hajujalkeä
        int x = 0;
        while (x < this.taulukko.size()) {
            int y = 0;
            
            while (y < this.taulukko.get(x).size()) {

                double arvo = this.taulukko.get(x).get(y);
                if (arvo > 0) {
                    arvo -= 0.01;
                }

                this.taulukko.get(x).put(y, arvo);
                y++;
            }

            x++;
        }

        // kun hahmo on tietyssä pisteessä, asetetaan taulukkoon arvo 1
        this.taulukko.get(this.sijaintiX).put(this.sijaintiY, 1.0);
    }

    public HashMap<Integer, HashMap<Integer, Double>> getTaulukko() {
        return taulukko;
    }

    public void setTaulukko(HashMap<Integer, HashMap<Integer, Double>> taulukko) {
        this.taulukko = taulukko;
    }
}

/*
import java.util.HashMap;
import java.util.Random;

public class Satunnaiskavely {

    private HashMap<Integer, HashMap<Integer, Double>> taulukko;
    private int sijaintiX = 0;
    private int sijaintiY = 0;

    public Satunnaiskavely(int leveys, int korkeus) {
        this.taulukko = new HashMap<>();
        int x = 0;

        while (x < leveys) {
            this.taulukko.putIfAbsent(x, new HashMap<>());
            int y = 0;
            while (y < korkeus) {
                this.taulukko.get(x).put(y, 0.0);
                y++;
            }
            x++;
        }

        this.sijaintiX = leveys / 2;
        this.sijaintiY = korkeus / 2;
        this.taulukko.get(this.sijaintiX).put(this.sijaintiY, 1.0);
    }

    public void askel() {
        // pienennetään hajujalkeä
        int x = 0;
        while (x < this.taulukko.size()) {
            int y = 0;
            while (y < this.taulukko.get(x).size()) {
                double arvo = this.taulukko.get(x).get(y);
                if (arvo > 0) {
                    arvo -= 0.01;
                }
                this.taulukko.get(x).put(y, arvo);
                y++;
            }
            x++;
        }

        Random arpoja = new Random();
        int suunta = arpoja.nextInt(5);
        if (suunta == 0) {
            this.sijaintiX += 1;
        } else if (suunta == 1) {
            this.sijaintiX -= 1;
        } else if (suunta == 2) {
            this.sijaintiY += 1;
        } else if (suunta == 3) {
            this.sijaintiY -= 1;
        }

        // vikalla ei tehdä mitään
        // varmistetaan, että ollaan aina alueella
        this.sijaintiX += this.taulukko.size();
        this.sijaintiX %= this.taulukko.size();
        this.sijaintiY += this.taulukko.get(0).size();
        this.sijaintiY %= this.taulukko.get(0).size();

        // kun hahmo on tietyssä pisteessä, asetetaan taulukkoon arvo 1
        this.taulukko.get(this.sijaintiX).put(this.sijaintiY, 1.0);
    }

    public HashMap<Integer, HashMap<Integer, Double>> getTaulukko() {
        return taulukko;
    }

    public void setTaulukko(HashMap<Integer, HashMap<Integer, Double>> taulukko) {
        this.taulukko = taulukko;
    }

}
*/