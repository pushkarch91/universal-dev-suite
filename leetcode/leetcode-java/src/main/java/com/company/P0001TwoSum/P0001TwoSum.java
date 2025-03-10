package com.company.P0001TwoSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P0001TwoSum {

    public static void main(String[] args) {
        P0001TwoSum obj = new P0001TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 13;
        System.out.println(Arrays.toString(obj.twoSum(nums, target)));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
