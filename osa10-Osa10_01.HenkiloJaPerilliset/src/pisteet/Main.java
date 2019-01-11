package pisteet;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        testi01();
        testi02();
    }

    private static void testi01() {
        List<Piste> pisteet = new ArrayList<>();
        pisteet.add(new Piste(4, 8));
        pisteet.add(new VariPiste(1, 1, "vihreä"));
        pisteet.add(new VariPiste(2, 5, "sininen"));
        pisteet.add(new Piste(0, 0));

        pisteet.stream().forEach(p -> System.out.println(p));
        /*
        (4, 8) etäisyys 12
        (1, 1) etäisyys 2 väri: vihreä
        (2, 5) etäisyys 7 väri: sininen
        (0, 0) etäisyys 0
         */
    }

    private static void testi02() {
        List<Piste> pisteet = new ArrayList<>();
        pisteet.add(new Piste(4, 8));
        pisteet.add(new VariPiste(1, 1, "vihreä"));
        pisteet.add(new VariPiste(2, 5, "sininen"));
        pisteet.add(new Piste3D(5, 2, 8));
        pisteet.add(new Piste(0, 0));

        pisteet.stream().forEach(p -> System.out.println(p));
        /*
        (4, 8) etäisyys 12
        (1, 1) etäisyys 2 väri: vihreä
        (2, 5) etäisyys 7 väri: sininen
        (5, 2, 8) etäisyys 15
        (0, 0) etäisyys 0
         */
    }
}
