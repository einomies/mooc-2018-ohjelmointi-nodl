public class Main {

    public static void main(String[] args) {
        // Voit tehdä täällä tehtävään liittyviä kokeiluja
        Henkilo eikka = new Henkilo("Eikka", 26, 1, 1975);
        Henkilo arttu = new Henkilo("Arttu", 8, 10, 2007);
        Henkilo otso = new Henkilo("Otso", 14, 9, 2010);
        Henkilo terhi = new Henkilo("Terhi", 14, 7, 1977);
        
        System.out.println(eikka);
        System.out.println(eikka.getNimi() +" ikä: " +eikka.ikaVuosina());
        System.out.println("");
        

//        System.out.println(arttu);
//        System.out.println(otso);
    }
}
