public class Paaohjelma {

    public static void main(String[] args) {
        /*
        Maksukortti pekanKortti = new Maksukortti(10);

        System.out.println("rahaa " + pekanKortti.saldo());
        boolean onnistuiko = pekanKortti.otaRahaa(8);
        System.out.println("onnistuiko otto: " + onnistuiko);
        System.out.println("rahaa " + pekanKortti.saldo());

        onnistuiko = pekanKortti.otaRahaa(4);
        System.out.println("onnistuiko otto: " + onnistuiko);
        System.out.println("rahaa " + pekanKortti.saldo());
        */

        /*
        Kassapaate unicafeExactum = new Kassapaate();

        double vaihtorahaa = unicafeExactum.syoEdullisesti(10);
        System.out.println("vaihtorahaa jäi " + vaihtorahaa);

        vaihtorahaa = unicafeExactum.syoEdullisesti(5);
        System.out.println("vaihtorahaa jäi " + vaihtorahaa);

        vaihtorahaa = unicafeExactum.syoMaukkaasti(4.3);
        System.out.println("vaihtorahaa jäi " + vaihtorahaa);

        System.out.println(unicafeExactum);
        */

        /*
        Kassapaate unicafeExactum = new Kassapaate();

        double vaihtorahaa = unicafeExactum.syoEdullisesti(10);
        System.out.println("vaihtorahaa jäi " + vaihtorahaa);

        Maksukortti antinKortti = new Maksukortti(7);

        boolean onnistuiko = unicafeExactum.syoMaukkaasti(antinKortti);
        System.out.println("riittikö raha: " + onnistuiko);

        onnistuiko = unicafeExactum.syoMaukkaasti(antinKortti);
        System.out.println("riittikö raha: " + onnistuiko);

        onnistuiko = unicafeExactum.syoEdullisesti(antinKortti);
        System.out.println("riittikö raha: " + onnistuiko);

        System.out.println(unicafeExactum);
        */
        
        Kassapaate unicafeExactum = new Kassapaate();
        System.out.println(unicafeExactum);

        Maksukortti antinKortti = new Maksukortti(2);

        System.out.println("kortilla rahaa " + antinKortti.saldo() + " euroa");

        boolean onnistuiko = unicafeExactum.syoMaukkaasti(antinKortti);
        System.out.println("riittikö raha: " + onnistuiko);
        
        System.out.println("lataaRahaaKortille(antinKortti, 100)");
        unicafeExactum.lataaRahaaKortille(antinKortti, 100);
        System.out.println("kortilla rahaa " + antinKortti.saldo() + " euroa");

        onnistuiko = unicafeExactum.syoMaukkaasti(antinKortti);
        System.out.println("riittikö raha: " + onnistuiko);

        System.out.println("kortilla rahaa " + antinKortti.saldo() + " euroa");
 
        System.out.println(unicafeExactum);
    }
}
