public class Main {
    
    public static void main(String[] args) {
        
        /*
        Tavara kirja = new Tavara("Aapiskukko", 2);
        Tavara puhelin = new Tavara("Nokia 3210", 1);

        System.out.println("Kirjan nimi: " + kirja.getNimi());
        System.out.println("Kirjan paino: " + kirja.getPaino());

        System.out.println("Kirja: " + kirja);
        System.out.println("Puhelin: " + puhelin);
        */
        
        /*
        Tavara kirja = new Tavara("Aapiskukko", 2);
        Tavara puhelin = new Tavara("Nokia 3210", 1);
        Tavara tiiliskivi = new Tavara("tiiliskivi", 4);

        Matkalaukku matkalaukku = new Matkalaukku(5);
        System.out.println(matkalaukku);

        matkalaukku.lisaaTavara(kirja);
        System.out.println(matkalaukku);

        matkalaukku.lisaaTavara(puhelin);
        System.out.println(matkalaukku);

        matkalaukku.lisaaTavara(tiiliskivi);
        System.out.println(matkalaukku);
        */
        
        /*
        Tavara kirja = new Tavara("Aapiskukko", 2);
        Tavara puhelin = new Tavara("Nokia 3210", 1);
        Tavara tiiliskivi = new Tavara("tiiliskivi", 4);

        Matkalaukku matkalaukku = new Matkalaukku(10);
        matkalaukku.lisaaTavara(kirja);
        matkalaukku.lisaaTavara(puhelin);
        matkalaukku.lisaaTavara(tiiliskivi);

        System.out.println("Matkalaukussa on seuraavat tavarat:");
        matkalaukku.tulostaTavarat();
        System.out.println("Yhteispaino: " + matkalaukku.yhteispaino() + " kg");
        */
        
        /*
        Tavara kirja = new Tavara("Aapiskukko", 2);
        Tavara puhelin = new Tavara("Nokia 3210", 1);
        Tavara basso = new Tavara("Marcus Miller V7", 5);
        Tavara tiiliskivi = new Tavara("Tiiliskivi", 4);

        Matkalaukku matkalaukku = new Matkalaukku(10);
        matkalaukku.lisaaTavara(kirja);
        matkalaukku.lisaaTavara(puhelin);
        matkalaukku.lisaaTavara(basso);
        matkalaukku.lisaaTavara(tiiliskivi);

        Tavara raskain = matkalaukku.raskainTavara();
        System.out.println("Raskain tavara: " + raskain);
        */
        
        /*
        Tavara kirja = new Tavara("Aapiskukko", 2);
        Tavara puhelin = new Tavara("Nokia 3210", 1);
        Tavara tiiliskivi = new Tavara("tiiliskivi", 4);

        Matkalaukku adanLaukku = new Matkalaukku(10);
        adanLaukku.lisaaTavara(kirja);
        adanLaukku.lisaaTavara(puhelin);

        Matkalaukku pekanLaukku = new Matkalaukku(10);
        pekanLaukku.lisaaTavara(tiiliskivi);

        Lastiruuma lastiruuma = new Lastiruuma(1000);
        lastiruuma.lisaaMatkalaukku(adanLaukku);
        lastiruuma.lisaaMatkalaukku(pekanLaukku);

        System.out.println(lastiruuma);
        */
        
        Matkalaukku matkalaukku = new Matkalaukku(20);
        matkalaukku.lisaaTavara(new Tavara("Porkkana", 2));
        matkalaukku.lisaaTavara(new Tavara("Kaali", 8));
        matkalaukku.lisaaTavara(new Tavara("Nauris", 4));
        Tavara raskain = matkalaukku.raskainTavara();
        System.out.println(raskain);

        /*
        Tavara kirja = new Tavara("Aapiskukko", 2);
        Tavara puhelin = new Tavara("Nokia 3210", 1);
        Tavara tiiliskivi = new Tavara("tiiliskivi", 4);

        Matkalaukku adanLaukku = new Matkalaukku(10);
        adanLaukku.lisaaTavara(kirja);
        adanLaukku.lisaaTavara(puhelin);

        Matkalaukku pekanLaukku = new Matkalaukku(10);
        pekanLaukku.lisaaTavara(tiiliskivi);

        Lastiruuma lastiruuma = new Lastiruuma(1000);
        lastiruuma.lisaaMatkalaukku(adanLaukku);
        lastiruuma.lisaaMatkalaukku(pekanLaukku);

        System.out.println("Ruuman matkalaukuissa on seuraavat tavarat:");
        lastiruuma.tulostaTavarat();
        */
    }

}