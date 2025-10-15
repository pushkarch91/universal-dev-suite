package com.company.collection;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapTester {

    public static void main(String[] args) {
        MapTester tester = new MapTester();
        Map<String, String> map = new LinkedHashMap<>();
        map.put("India", "New Delhi");
        map.put("USA", "Washington");
        map.put("UK", "London");

        System.out.println("\n Using For Each");
        tester.iterateUsingForEach(map);

        System.out.println("\n Using Stream Entry Set");
        tester.iterateUsingStreamEntrySet(map);

        System.out.println("\n Using Entry Set");
        tester.iterateUsingEntrySet(map);

        System.out.println("\n Using Key Set");
        tester.iterateUsingKeySet(map);
    }

    private void iterateUsingForEach(Map<String, String> map) {
        map.forEach((k, v) -> {
            System.out.println(k + " : " + v);
        });
    }

    private void iterateUsingStreamEntrySet(Map<String, String> map) {
        map.entrySet().stream().forEach(entry -> {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        });
    }

    private void iterateUsingEntrySet(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    private void iterateUsingKeySet(Map<String, String> map) {
        for (String key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }
    }


}
