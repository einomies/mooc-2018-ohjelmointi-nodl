package jaolliset;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Jaolliset {

    public static void main(String[] args) {
        ArrayList<Integer> luvut = new ArrayList<>();
        luvut.add(3);
        luvut.add(2);
        luvut.add(-17);
        luvut.add(-5);
        luvut.add(7);

        ArrayList<Integer> jaolliset = jaolliset(luvut);

        jaolliset.stream()
                .forEach(luku -> System.out.println(luku));
    }

    public static ArrayList<Integer> jaolliset(ArrayList<Integer> luvut) {

//        ArrayList<Integer> poimitut = luvut.stream()
//                .filter(luku -> Jaolliset.onkoJaollinen(luku))
//                .collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Integer> poimitut = luvut.stream()
                .filter(Jaolliset::onkoJaollinen)
                .collect(Collectors.toCollection(ArrayList::new));

        return poimitut;
    }

    private static boolean onkoJaollinen(int luku) {
        if (luku % 2 == 0 || luku % 3 == 0 || luku % 5 == 0) {
            return true;
        }
        return false;
    }

}

/*
package jaolliset;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Jaolliset {

    public static void main(String[] args) {
        ArrayList<Integer> luvut = new ArrayList<>();
        luvut.add(3);
        luvut.add(2);
        luvut.add(-17);
        luvut.add(-5);
        luvut.add(7);
        ArrayList<Integer> jaolliset = jaolliset(luvut);
        jaolliset.stream()
                .forEach(luku -> System.out.println(luku));
    }

    public static ArrayList<Integer> jaolliset(ArrayList<Integer> luvut) {
        return luvut.stream()
                .filter(luku -> luku % 2 == 0 || luku % 3 == 0 || luku % 5 == 0)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
*/