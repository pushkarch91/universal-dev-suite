package com.company.problem0049.groupAnagram;

import java.util.*;

public class P0049GroupAnagram {

    static void main() {
        P0049GroupAnagram solution = new P0049GroupAnagram();
        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(solution.groupAnagrams(words));
        System.out.println(solution.groupAnagrams2(words));
    }

    public List<List<String>> groupAnagrams(String[] words) {
        List<List<String>> result = new ArrayList<>();
        if (words == null || words.length == 0) {
            return result;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String word : words) {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());

            }
            map.get(key).add(word);
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            List<String> list = entry.getValue();
            Collections.sort(list);
            result.add(list);
        }
        return result;
    }

    public List<List<String>> groupAnagrams2(String[] words) {
        List<List<String>> result = new ArrayList<>();
        if (words == null || words.length == 0) {
            return result;
        }
        Map<String, List> answer = new HashMap<>();
        int[] count = new int[26];
        for (String word : words) {
            Arrays.fill(count, 0);
            for (char c : word.toCharArray()) {
                count[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append("#");
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!answer.containsKey(key)) {
                answer.put(key, new ArrayList<>());
            }
            answer.get(key).add(word);
        }
        return new ArrayList(answer.values());
    }
}
