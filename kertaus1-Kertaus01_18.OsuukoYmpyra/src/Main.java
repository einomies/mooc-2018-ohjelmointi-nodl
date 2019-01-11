
public class Main {
    
    /*
    Toteuta luokka Ympyra, jolla on oliomuuttujat double x, double y sekä double sade.
    Muuttuja x kuvaa ympyrän keskipisteen x-koordinaattia, muuttuja y ympyrän keskipisteen
    y-koordinaattia sekä sade ympyrän sädettä.
    
    Toteuta tämän jälkeen metodi public boolean osuuko(Ympyra toinen), joka palauttaa true
    jos ympyrä osuu toiseen ympyrään.
    
    Edellisestä tehtävästä on tässä hyötyä.
    */

    public static void main(String[] args) {
        
        Ympyra ympyra1 = new Ympyra(3, 3, 2);
        Ympyra ympyra2 = new Ympyra(6, 6, 2);
        
        System.out.println("ympyra1: " +ympyra1);
        System.out.println("ympyra2: " +ympyra2);
        
        if (ympyra1.osuuko(ympyra2)) {
            System.out.println("Ympyrät osuvat toisiinsa");
        } else {
            System.out.println("Ympyrät eivät osu toisiinsa");
        }
    }

}
