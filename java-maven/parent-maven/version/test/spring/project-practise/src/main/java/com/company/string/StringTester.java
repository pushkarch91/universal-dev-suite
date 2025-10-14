package com.company.string;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class StringTester {

    static void main() {
        StringTester obj = new StringTester();
        String name = "Pushkar";

        System.out.println("ASCII map              : " + obj.getMapWithAscii(name));
        System.out.println("Frequencies (groupingBy): " + obj.getMapUsingGroupingBy(name));
        System.out.println("Frequencies (compute)   : " + obj.getMapUsingCompute(name));
        System.out.println("Frequencies (toMap)     : " + obj.getMapUsingToMap(name));
        System.out.println("Code point counts       : " + obj.getCodePointCounts(name));
    }

    /**
     * Maps each character to its Unicode/ASCII code.
     */
    public Map<Character, Integer> getMapWithAscii(String str) {
        Map<Character, Integer> characterMap = new LinkedHashMap<>();
        if (str == null) return characterMap;
        str.chars().forEach(c -> characterMap.put((char) c, c));
        return characterMap;
    }

    /**
     * Counts char frequency using groupingBy (preserves encounter order).
     */
    public Map<Character, Integer> getMapUsingGroupingBy(String str) {
        if (str == null) return new LinkedHashMap<>();
        return str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        c -> c,
                        LinkedHashMap::new,          // preserves order
                        Collectors.summingInt(x -> 1)
                ));
    }

    /**
     * Counts char frequency using Map.compute.
     */
    public Map<Character, Integer> getMapUsingCompute(String str) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        if (str == null) return map;
        for (char ch : str.toCharArray()) {
            map.compute(ch, (k, v) -> v == null ? 1 : v + 1);
        }
        return map;
    }

    /**
     * Counts char frequency using toMap + merge function.
     */
    public Map<Character, Integer> getMapUsingToMap(String str) {
        if (str == null) return new LinkedHashMap<>();
        return str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toMap(
                        c -> c, c -> 1,
                        Integer::sum,
                        LinkedHashMap::new            // preserves order
                ));
    }

    /**
     * Counts full Unicode code points (handles emojis/surrogates).
     */
    public Map<Integer, Integer> getCodePointCounts(String str) {
        if (str == null) return new LinkedHashMap<>();
        return str.codePoints()
                .boxed()
                .collect(Collectors.groupingBy(
                        cp -> cp,
                        LinkedHashMap::new,
                        Collectors.summingInt(x -> 1)
                ));
    }
}

