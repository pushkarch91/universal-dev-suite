package com.company.problem0347.topKFrequentOccuringElements;

import java.util.*;

public class P0347TopKFrequentOccuringElements {

    static void main() {
        P0347TopKFrequentOccuringElements solution = new P0347TopKFrequentOccuringElements();
        //int[] numbers = {1, 3, 4, 3, 4, 2, 3, 4, 2, 5, 4, 5, 5};
        //int k = 3;
        // Map (1:1, 2:2, 3:3, 4:4, 5:3)
        // [4,3,5,2,1]
        // top 3 : 4,3,5
        System.out.println(Arrays.toString(solution.topKFrequent(new int[]{1, 3, 4, 3, 4, 2, 3, 4, 2, 5, 4, 5, 5}, 3)));
        System.out.println(Arrays.toString(solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        if (k == nums.length) return nums;

        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        Queue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(count::get));
        for (int num : count.keySet()) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll();
        }
        return result;
    }
}
// HashMap + Heap (Priority Queue)