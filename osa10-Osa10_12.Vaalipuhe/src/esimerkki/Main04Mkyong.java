/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esimerkki;

import java.util.Comparator;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 * @author einomies
 */
public class Main04Mkyong {

    public static void main(String[] args) {

//        testi01();
//        testi02();
        testi03();
    }

    private static void testi01() {

        Map<Integer, String> map = luoHashMap01();

        //Map -> Stream -> Filter -> String
        String resultString = map.entrySet().stream()
                .filter(x -> x.getValue().contains("g"))
                .map(x -> x.getKey().toString())
                .collect(Collectors.joining());
        System.out.println("resultString: " + resultString);
    }

    private static void testi02() {
        Map<Integer, String> map = luoHashMap01();

        //Map -> Stream -> Filter -> MAP
        Map<Integer, String> collect01 = map.entrySet().stream()
                .filter(x -> x.getKey() > 2)
                .filter(x -> x.getKey() < 6)
                .collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));
        tulostaMap01(collect01);

        // or like this
        Map<Integer, String> collect02 = map.entrySet().stream()
                .filter(x -> x.getKey() == 3)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        tulostaMap01(collect02);
    }

    private static void testi03() {
        Map<String, Integer> map = luoHashMap02();
        tulostaMap02(map);

        tulostaViivat();

        int rajaArvo = 9;
        System.out.println("rajaArvo: " + rajaArvo);

//        int summaYht = map.entrySet().stream()
//                .mapToInt(e -> e.getValue()).sum();
        Integer summaYht = map.entrySet().stream()
                .map(e -> e.getValue())
                .reduce(0, (edSumma, summa) -> edSumma + summa);
        System.out.println("summaYht: " + summaYht);

        IntSummaryStatistics summary = map.entrySet().stream()
                .collect(Collectors.summarizingInt(p -> p.getValue()));
        System.out.println(summary);

    }

    private static Map<Integer, String> luoHashMap01() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "linode.com");
        map.put(2, "heroku.com");
        map.put(3, "something.com");
        map.put(4, "einomies.com");
        map.put(5, "bullshit.com");
        map.put(6, "verkkokauppa.com");
        map.put(7, "google.com");
        map.put(8, "eighty.com");
        return map;
    }

    private static Map<String, Integer> luoHashMap02() {
        Map<String, Integer> map = new HashMap<>();
        map.put("linode.com", 1);
        map.put("heroku.com", 2);
        map.put("something.com", 3);
        map.put("einomies.com", 4);
        map.put("bullshit.com", 5);
        map.put("verkkokauppa.com", 6);
        map.put("google.com", 7);
        map.put("eighty.com", 8);
        return map;
    }

    private static void tulostaMap01(Map<Integer, String> map) {
        map.entrySet().stream()
                .forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));
    }

    private static void tulostaMap02(Map<String, Integer> map) {
        map.entrySet().stream()
                .sorted(Comparator.comparing(e -> e.getKey()))
                .forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));
    }

    private static void tulostaViivat() {
        System.out.println("-----------------------------------------");
    }

}
