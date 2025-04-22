package com.company.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamTester {

    public static void main(String[] args) {
        //colours();
        //colourMap();
        System.out.println(countChar());
    }

    private static Map<Character, Long> countChar() {
        String ecommerce = "ecommerce";
        return ecommerce.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public static void colours() {
        List<String> colours = Arrays.asList("red", "green", "blue", "blue", "red", "green", "yellow");
        Map<String, Long> map = colours.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);
    }

    public static void colourMap() {
        List<String> colors = List.of(
                "Red", "Orange", "Yellow", "Green", "Blue", "Indigo", "Violet",
                "Red", "Green", "Blue", "Red"
        );
        Map<Boolean, List<String>> result = colors.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .collect(Collectors.partitioningBy(
                        entry -> entry.getValue() == 1,
                        Collectors.mapping(Map.Entry::getKey, Collectors.toList())
                ));

        List<String> uniqueColors = result.get(true);   // count == 1
        List<String> duplicateColors = result.get(false); // count > 1

        System.out.println("✅ Unique Colors: " + uniqueColors);
        System.out.println("🎯 Duplicate Colors: " + duplicateColors);
    }
}
