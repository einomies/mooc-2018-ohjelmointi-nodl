package sukunimet;

public class Paaohjelma {

    public static void main(String[] args) {
//        testi01();
        testi02();
    }

    private static void testi01() {

        Henkilo dolores = new Henkilo("Dolores", "D.", "Parto");
        System.out.println(dolores);

        Henkilo hay = new Henkilo("Hay", "Alen", "Gualarga");
        System.out.println(hay);

        Henkilo nacho = new Henkilo("Nacho", "Cuesta", "Parto");
        System.out.println(nacho);

        Henkilo valeria = new Henkilo("Valeria", "Mogollon", "Gualarga");
        System.out.println(valeria);

        Henkilo enrico = new Henkilo("Enrico", dolores, hay);
        System.out.println(enrico);

        Henkilo luz = new Henkilo("Luz", nacho, valeria);
        System.out.println(luz);

        Henkilo valentina = new Henkilo("Valentina", enrico, luz);
        System.out.println(valentina);

        Object valObject = valentina;
        System.out.println(valObject);

        /*
        Dolores D. Parto
        Hay Alen Gualarga
        Nacho Cuesta Parto
        Valeria Mogollon Gualarga
        Enrico D. Alen
        Luz Cuesta Mogollon
        Valentina D. Cuesta
        Valentina D. Cuesta
         */
    }

    private static void testi02() {
        Henkilo hay = new Henkilo("Hay", "Alen", "Gualarga");
        Henkilo nacho = new Henkilo("Nacho", "Cuesta", "Parto");
        Henkilo dolores = new Henkilo("Dolores", "D.", "Parto");
        Henkilo enrico = new Henkilo("Enrico", dolores, hay);
        Henkilo valeria = new Henkilo("Valeria", "Mogollon", "Gualarga");
        Henkilo luz = new Henkilo("Luz", nacho, valeria);
        Henkilo valentina = new Henkilo("Valentina", enrico, luz);

        Perhe perhe = new Perhe();
        perhe.lisaa(dolores);
        perhe.lisaa(luz);
        perhe.lisaa(valentina);
        System.out.println(perhe);

        System.out.println();

        perhe.poista(luz);
        System.out.println(perhe);

        System.out.println();

        Object perheObj = perhe;
        System.out.println(perheObj);

        System.out.println();

        perhe.lisaa(enrico);
        System.out.println(perheObj);

        /*
        Dolores D. Parto
        Luz Cuesta Mogollon
        Valentina D. Cuesta

        Dolores D. Parto
        Valentina D. Cuesta

        Dolores D. Parto
        Valentina D. Cuesta
        Enrico D. Alen
         */
    }

}
