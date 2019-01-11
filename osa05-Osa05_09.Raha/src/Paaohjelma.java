public class Paaohjelma {

    public static void main(String[] args) {
        // tee tänne koodia jolla testaat ohjelmoimasi luokan toimintaa
        /*
        Raha a = new Raha(10,0);
        Raha b = new Raha(5,0);

        Raha c = a.plus(b);

        System.out.println(a);  // 10.00e
        System.out.println(b);  // 5.00e
        System.out.println(c);  // 15.00e

        a = a.plus(c);
        // HUOM: tässä syntyy uusi Raha-olio, joka laitataan "a:n langan päähän"
        // vanha a:n langan päässä ollut 10 euroa häviää ja Javan roskien kerääjä korjaa sen pois

        System.out.println(a);  // 25.00e
        System.out.println(b);  // 5.00e
        System.out.println(c);  // 15.00e
        */
        
        /*
        Raha a = new Raha(10, 51);
        Raha b = new Raha(10, 20);
        Raha c = new Raha(10, 50);

        System.out.println("a: " +a);
        System.out.println("b: " +b);
        System.out.println("c: " +c);

        System.out.println("a.vahemman(b): " +a.vahemman(b));  // false
        System.out.println("b.vahemman(c): " +b.vahemman(c));  // true
        */
        
        Raha a = new Raha(10, 0);
        Raha b = new Raha(3, 50);

        Raha c = a.miinus(b);

        System.out.println(a);  // 10.00e
        System.out.println(b);  // 3.50e
        System.out.println(c);  // 6.50e

        c = c.miinus(a);
        // HUOM: tässä syntyy uusi Raha-olio, joka laitataan "c:n langan päähän"
        // vanha c:n langan päässä ollut 6.5 euroa häviää ja Javan roskien kerääjä korjaa sen pois

        System.out.println(a);  // 10.00e
        System.out.println(b);  // 3.50e
        System.out.println(c);  // 0.00e
    }
}
