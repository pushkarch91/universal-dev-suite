package com.company.problem0001.twosum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P0001TwoSum {

    static void main() {
        P0001TwoSum solution = new P0001TwoSum();
        int[] numbers = {15, 7, 2, 11};
        int target = 9;
        System.out.println(Arrays.toString(solution.twoSumUsingForLoop(numbers, target)));
        System.out.println(Arrays.toString(solution.twoSumUsingHashMap(numbers, target)));
    }

    public int[] twoSumUsingForLoop(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    public int[] twoSumUsingHashMap(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(numbers[i], i);
        }
        return new int[]{-1, -1};
    }
}
