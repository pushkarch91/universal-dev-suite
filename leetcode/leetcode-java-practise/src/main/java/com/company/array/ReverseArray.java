package com.company.array;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        ReverseArray reverseArray = new ReverseArray();
        System.out.println(Arrays.toString(reverseArray.reverseInplace(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(reverseArray.reverseUsingNewArray(new int[]{1, 2, 3, 4, 5})));
    }

    // faster
    private int[] reverseInplace(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return arr;
    }

    // slower
    private int[] reverseUsingNewArray(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            result[i] = arr[arr.length - i - 1];
        }
        return result;
    }
}
