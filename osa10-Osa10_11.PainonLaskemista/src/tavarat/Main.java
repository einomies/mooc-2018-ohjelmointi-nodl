package tavarat;

public class Main {

    public static void main(String[] args) {
        testi01();
//        testi02();
//        testi03();
    }

    private static void testi01() {
        Tavara kirja01 = new Tavara("Raamattu", 2);
        Tavara kirja02 = new Tavara("Tasku-Aku", 1);
        Tavara kirja03 = new Tavara("Joku Dostojevski", 3);
        Tavara kirja04 = new Tavara("Kalle Päätalo", 3);
        Tavara kirja05 = new Tavara("Mika Waltari", 1);

        Tavara kitara01 = new Tavara("Strato", 3);
        Tavara kitara02 = new Tavara("Les Paul", 4);
        Tavara kitara03 = new Tavara("PRS", 3);
        Tavara kitara04 = new Tavara("Gretsch", 4);
        Tavara kitara05 = new Tavara("ESP Hevikirves", 3);

        Tavara muuntaja05 = new Tavara("Muuntaja 05", 5);
        Tavara muuntaja07 = new Tavara("Muuntaja 07", 7);
        Tavara muuntaja08 = new Tavara("Muuntaja 08", 8);
        Tavara muuntaja10 = new Tavara("Muuntaja 10", 10);
        Tavara muuntaja12 = new Tavara("Muuntaja 12", 12);

        Tavara raskas020 = new Tavara("Raskas 020", 20);
        Tavara raskas040 = new Tavara("Raskas 040", 40);
        
        Matkalaukku matkalaukku01 = new Matkalaukku(10);
        matkalaukku01.lisaaTavara(kirja01);
        matkalaukku01.lisaaTavara(kirja02);
        matkalaukku01.lisaaTavara(kirja03);
        matkalaukku01.lisaaTavara(kirja04);
        matkalaukku01.lisaaTavara(kirja05);
        
        Matkalaukku matkalaukku02 = new Matkalaukku(20);
        matkalaukku02.lisaaTavara(kitara01);
        matkalaukku02.lisaaTavara(kitara02);
        matkalaukku02.lisaaTavara(kitara03);
        matkalaukku02.lisaaTavara(kitara04);
        matkalaukku02.lisaaTavara(kitara05);

        Matkalaukku matkalaukku03 = new Matkalaukku(30);
        matkalaukku03.lisaaTavara(muuntaja05);
        matkalaukku03.lisaaTavara(muuntaja07);
        matkalaukku03.lisaaTavara(muuntaja08);
        matkalaukku03.lisaaTavara(muuntaja10);
        matkalaukku03.lisaaTavara(muuntaja12);

        Matkalaukku matkalaukku04 = new Matkalaukku(40);
        matkalaukku04.lisaaTavara(raskas020);

        Matkalaukku matkalaukku05 = new Matkalaukku(50);
        matkalaukku05.lisaaTavara(raskas040);
        
        Lastiruuma lastiruuma01 = new Lastiruuma(200);
        lastiruuma01.lisaaMatkalaukku(matkalaukku01);
        lastiruuma01.lisaaMatkalaukku(matkalaukku02);
        lastiruuma01.lisaaMatkalaukku(matkalaukku03);
        lastiruuma01.lisaaMatkalaukku(matkalaukku04);
        lastiruuma01.lisaaMatkalaukku(matkalaukku05);
        
        tulostaLastiRuumanSisalto(lastiruuma01);

        Lastiruuma lastiruuma02 = new Lastiruuma(300);
        Matkalaukku matkalaukku06 = new Matkalaukku(50);
        matkalaukku06.lisaaTavara(new Tavara("raskas050", 50));
        lastiruuma02.lisaaMatkalaukku(matkalaukku06);
        Matkalaukku matkalaukku07 = new Matkalaukku(100);
        matkalaukku07.lisaaTavara(new Tavara("raskas050", 50));
        matkalaukku07.lisaaTavara(new Tavara("raskas050", 50));
        lastiruuma02.lisaaMatkalaukku(matkalaukku07);

        tulostaLastiRuumanSisalto(lastiruuma02);
    }
    
    private static void testi02() {
    }

    private static void testi03() {
    }

    private static void tulostaLastiRuumanSisalto(Lastiruuma lastiruuma) {
        System.out.println("-------------------------------------");
        System.out.println(lastiruuma);
        lastiruuma.tulostaTavarat();
    }

}
