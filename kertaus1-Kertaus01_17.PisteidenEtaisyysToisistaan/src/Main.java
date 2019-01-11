
public class Main {

    /*
    Toteuta luokka Piste, jolla on oliomuuttujat double x ja double y, sopiva konstruktori
    sekä metodit public double getX() ja public double getY().
    
    Toteuta tämän jälkeen luokalle metodi public double etaisyys(Piste toinen), joka laskee
    pisteen etäisyyden toisesta pisteestä.
    
    Kahden pisteen etäisyyden laskemiseen löytyy esimerkiksi apua Wikipediasta.
    */

    public static void main(String[] args) {
        
        Piste piste1 = new Piste(0, 0);
        Piste piste2 = new Piste(3, 4);
        
        System.out.println("piste1: " +piste1);
        System.out.println("piste2: " +piste2);
        
        double etaisyys = piste1.etaisyys(piste2);
        System.out.println("etäisyys: " +etaisyys);
    }

}
