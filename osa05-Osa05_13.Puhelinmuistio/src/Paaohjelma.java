public class Paaohjelma {

    public static void main(String[] args) {
        // tee tänne koodia jolla testaat ohjelmoimiesi luokkien Henkilo ja Puhelinmuistio toimintaa
        
        Henkilo pekka = new Henkilo("Pekka Mikkola", "040-123123");

        System.out.println(pekka.getNimi());
        System.out.println(pekka.getNumero());

        System.out.println(pekka);

        pekka.vaihdaNumeroa("050-333444");
        System.out.println(pekka);

        
        Puhelinmuistio muistio1 = new Puhelinmuistio();

        muistio1.lisaa("Pekka Mikkola", "040-123123");
        muistio1.lisaa("Antti Laaksonen", "045-456123");
        muistio1.lisaa("Juhana Laurinharju", "050-222333");

        muistio1.tulostaKaikki();

        
        Puhelinmuistio muistio2 = new Puhelinmuistio();
        muistio2.lisaa("Pekka Mikkola", "040-123123");
        muistio2.lisaa("Antti Laaksonen", "045-456123");
        muistio2.lisaa("Juhana Laurinharju", "050-222333");

        String numero = muistio2.haeNumero("Pekka Mikkola");
        System.out.println(numero);

        numero = muistio2.haeNumero("Martti Tienari");
        System.out.println(numero);
    }
}
