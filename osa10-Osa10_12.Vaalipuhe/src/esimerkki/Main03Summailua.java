/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esimerkki;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;
import vaalit.Sanajakauma;

/**
 *
 * @author einomies
 */
public class Main03Summailua {

    public static void main(String[] args) {

        testi01();
//        testi02();
//        testi03();
//        testi04();
    }

    private static void testi01() {
        Map<String, Integer> sanat = new HashMap<>();
        sanat.put("0.nolla", 0);
        sanat.put("1.yksi", 1);
        sanat.put("2.kaksi", 2);
        sanat.put("3.kolme", 3);
        sanat.put("4.neljä", 4);
        sanat.put("5.viisi", 5);
        sanat.put("6.kuusi", 6);
        sanat.put("7.seitsemän", 7);
        sanat.put("8.kahdeksan", 8);
        sanat.put("9.yhdeksän", 9);

        int raja = 10;

//        sanat.values().stream().reduce(0, (a, b) -> a + b > raja ? a : a + b);
        sanat.entrySet().stream()
                .forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));

        System.out.println();
        int summa = sanat.values().stream()
                .reduce(0, (edellinenSumma, luku) -> edellinenSumma + luku);
        System.out.println("summa: " + summa);

        double keskiarvo = sanat.entrySet().stream()
                .collect(Collectors.averagingDouble(e -> e.getValue()));
        System.out.println("keskiarvo: " + keskiarvo);

        System.out.println();
        System.out.println("kumulatiivinen raja-arvo: " + raja);

//        String sana = sanat.entrySet().stream()
//                .filter(s -> s.getValue() > 1)
//                .forEach(s -> System.out.println(s.getKey());
//        System.out.println("raja-arvoa vastaava sana: " + sana);
        IntSummaryStatistics summary = sanat.entrySet().stream()
                .collect(Collectors.summarizingInt(p -> p.getValue()));
        System.out.println(summary);

//        sanat.entrySet().stream()
//                .reduce(0, (a, b) -> a + b)
//                .ifPresent(System.out::println);

        /*
        Integer summa01 = sanat.entrySet()
                .stream()
                .reduce(0,
                        (sum, p) -> {
                            System.out.format("accumulator: sum=%s; entry=%s\n", sum, p);
                            return sum += p.getValue();
                        },
                        (sum1, sum2) -> {
                            System.out.format("combiner: sum1=%s; sum2=%s\n", sum1, sum2);
                            return sum1 + sum2;
                        });
// accumulator: sum=0; person=Max
// accumulator: sum=18; person=Peter
// accumulator: sum=41; person=Pamela
// accumulator: sum=64; person=David
         */
    }

    private static void testi02() {
        Map<String, Double> map = new LinkedHashMap<>();
        map.put("first", 1.0);
        map.put("second", 5.0);
        map.put("third", 4.0);

        AtomicReference<Double> atomicSum = new AtomicReference<>(0.0);
        map.entrySet().forEach(e -> e.setValue(
                atomicSum.accumulateAndGet(e.getValue(), (x, y) -> x + y)
        ));

// tested in JUnit
//        assertEquals(10.0, atomicSum.get(), 0.0001);
//        assertEquals(1.0, map.get("first"), 0.0001);
//        assertEquals(6.0, map.get("second"), 0.0001);
//        assertEquals(10.0, map.get("third"), 0.0001);
    }

    private static void testi03() {
        int[] array = {23, 43, 56, 97, 32};

        System.out.println("--Using IntStream.sum()--");
        int sum = Arrays.stream(array).sum();
        System.out.println(sum);

        System.out.println("--Using Stream.reduce() with IntBinaryOperator--");
        IntBinaryOperator ibop = (x, y) -> x + y;
        sum = Arrays.stream(array).reduce(0, ibop);
        System.out.println(sum);

        System.out.println("--Using Stream.reduce() with Integer.sum()--");
        sum = Arrays.stream(array).reduce(0, Integer::sum);
        System.out.println(sum);
    }

    private static void testi04() {
    }

}
