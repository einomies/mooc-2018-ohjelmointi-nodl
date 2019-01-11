public class Main {

    public static void main(String[] args) {
        // käytä tätä pääohjelmaa luokkiesi testaamiseen!
        
//        Lahja kirja = new Lahja("Aapiskukko", 2);
//        System.out.println("Lahjan nimi: " + kirja.getNimi());
//        System.out.println("Lahjan paino: " + kirja.getPaino());
//        System.out.println("Lahja: " + kirja);
        
        Lahja kirja = new Lahja("Aapiskukko", 2);
        Pakkaus paketti = new Pakkaus();
        paketti.lisaaLahja(kirja);

        Lahja kitara = new Lahja("Stratocaster", 4);
        paketti.lisaaLahja(kitara);

        System.out.println(paketti.getPaino());
    }

}
