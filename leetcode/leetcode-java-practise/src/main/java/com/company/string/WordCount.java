package com.company.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class WordCount {

    public static void main(String[] args) {
        WordCount wordCount = new WordCount();
        String sentence = "A ball, A knife and an Elephant.";
        System.out.println(wordCount.countWords(sentence));
    }

    private Map<String, Integer> countWords(String sentence) {
        Map<String, Integer> wordCount = new LinkedHashMap<>();
        String[] words = sentence.split("\\s+");
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        return wordCount;
    }

}
