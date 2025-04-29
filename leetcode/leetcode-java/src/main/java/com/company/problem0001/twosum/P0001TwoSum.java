package com.company.problem0001.twosum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P0001TwoSum {

    public static void main(String[] args) {

        P0001TwoSum obj = new P0001TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(obj.twoSumUsingForLoop(nums, target)));
        System.out.println(Arrays.toString(obj.twoSum(nums, target)));
    }

    public int[] twoSumUsingForLoop(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * Two Sum using HashMap
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
