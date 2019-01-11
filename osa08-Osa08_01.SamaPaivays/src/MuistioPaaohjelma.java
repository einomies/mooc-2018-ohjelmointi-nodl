
public class MuistioPaaohjelma {

    public static void main(String[] args) {
        Muistio alkeet = new Muistio("Equalsin alkeet", 2000);
        Muistio jatko = new Muistio("Equalsin jatko", 2001);

        System.out.println(alkeet.equals(alkeet));
        System.out.println(alkeet.equals(jatko));
        System.out.println(alkeet.equals(new Muistio("Equalsin alkeet", 2000)));
        System.out.println(alkeet.equals(new Muistio("Equalsin alkeet", 2001)));
    }

}
