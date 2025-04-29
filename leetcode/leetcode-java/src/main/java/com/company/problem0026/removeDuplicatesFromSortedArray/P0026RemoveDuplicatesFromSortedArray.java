package com.company.problem0026.removeDuplicatesFromSortedArray;

import java.util.Arrays;

public class P0026RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 3, 3, 4, 5};
        P0026RemoveDuplicatesFromSortedArray obj = new P0026RemoveDuplicatesFromSortedArray();
        System.out.println(Arrays.toString(obj.removeDuplicates(nums)));
        System.out.println(obj.removeDuplicatesAndSortInPlace(nums));
    }

    public int[] removeDuplicates(int[] nums) {
        int j = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return Arrays.copyOf(nums, j + 1);
    }

    public int removeDuplicatesAndSortInPlace(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        Arrays.sort(nums);

        int j = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }
}
