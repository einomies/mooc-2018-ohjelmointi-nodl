package reseptit;

import java.util.List;

public class Main {

    public static void main(String[] args) {

//        testi01();
//        testi02();
        testi03();
    }

    private static void testi01() {
        Reseptikirja kirja = new Reseptikirja();
        kirja.lisaaResepti(new Resepti("Omenaleivos"));

        Resepti resepti = kirja.haeNimella("Omenaleivos");
        System.out.println(resepti);

        Resepti toinen = kirja.haeNimella("leivos");
        System.out.println(toinen);
        /*
        Omenaleivos
        null
         */
    }

    private static void testi02() {
        Reseptikirja kirja = new Reseptikirja();
        Resepti omenaleivos = new Resepti("Omenaleivos");
        omenaleivos.lisaaRaakaAine("omena");
        omenaleivos.lisaaRaakaAine("kaurahiutale");
        omenaleivos.lisaaRaakaAine("fariinisokeri");
        omenaleivos.lisaaRaakaAine("voi");

        kirja.lisaaResepti(omenaleivos);

        List<Resepti> reseptit = kirja.haeRaakaAineella("jauheliha");
        System.out.println(reseptit);
        System.out.println(reseptit.size());

        List<Resepti> reseptit2 = kirja.haeRaakaAineella("omena");
        System.out.println(reseptit2.size());
        System.out.println(reseptit2.get(0).getNimi());

        List<Resepti> reseptit3 = kirja.haeRaakaAineella("mena");
        System.out.println(reseptit3.size());
        System.out.println(reseptit3);
        /*
        []
        0
        1
        Omenaleivos
        0
        []
         */
    }

    private static void testi03() {
        Reseptikirja reseptikirja = new Reseptikirja();

        Resepti r = new Resepti("Puolukkasurvos");
        r.lisaaRaakaAine("puolukka");
        r.lisaaRaakaAine("sokeri");

        reseptikirja.lisaaResepti(r);

        Resepti j = new Resepti("Juolukkasurvos");
        j.lisaaRaakaAine("juolukka");
        j.lisaaRaakaAine("sokeri");

        reseptikirja.lisaaResepti(j);
        
        System.out.println(reseptikirja);

        /*
        assertEquals("Reseptin lisääminen ja/tai raaka-aineella haku ei toiminut odotetusti. Tarkastele testejä ja etsi syy.", 2, reseptikirja.haeRaakaAineella("sokeri").size());
        assertEquals("Reseptin lisääminen ja/tai raaka-aineella haku ei toiminut odotetusti. Tarkastele testejä ja etsi syy.", 0, reseptikirja.haeRaakaAineella("pokeri").size());
        assertEquals("Reseptin lisääminen ja/tai raaka-aineella haku ei toiminut odotetusti. Tarkastele testejä ja etsi syy.", 1, reseptikirja.haeRaakaAineella("puolukka").size());
        assertEquals("Reseptin lisääminen ja/tai raaka-aineella haku ei toiminut odotetusti. Tarkastele testejä ja etsi syy.", 1, reseptikirja.haeRaakaAineella("juolukka").size());
        assertEquals("Reseptin lisääminen ja/tai raaka-aineella haku ei toiminut odotetusti. Tarkastele testejä ja etsi syy.", 0, reseptikirja.haeRaakaAineella("Juolukkasurvos").size());
        assertEquals("Reseptin lisääminen ja/tai raaka-aineella haku ei toiminut odotetusti. Tarkastele testejä ja etsi syy.", 0, reseptikirja.haeRaakaAineella("Puolukkasurvos").size());
        assertEquals("Reseptin lisääminen ja/tai raaka-aineella haku ei toiminut odotetusti. Tarkastele testejä ja etsi syy.", 0, reseptikirja.haeRaakaAineella("uolukka").size());

        assertTrue("Reseptin lisääminen ja/tai raaka-aineella haku ei toiminut odotetusti. Tarkastele testejä ja etsi syy.", reseptikirja.haeRaakaAineella("puolukka").contains(r));
        assertTrue("Reseptin lisääminen ja/tai raaka-aineella haku ei toiminut odotetusti. Tarkastele testejä ja etsi syy.", reseptikirja.haeRaakaAineella("sokeri").contains(r));
        assertTrue("Reseptin lisääminen ja/tai raaka-aineella haku ei toiminut odotetusti. Tarkastele testejä ja etsi syy.", reseptikirja.haeRaakaAineella("sokeri").contains(j));
         */
    }
}
