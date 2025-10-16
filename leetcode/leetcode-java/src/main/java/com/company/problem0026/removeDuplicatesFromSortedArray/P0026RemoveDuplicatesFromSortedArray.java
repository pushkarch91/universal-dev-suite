package com.company.problem0026.removeDuplicatesFromSortedArray;

import java.util.Arrays;

public class P0026RemoveDuplicatesFromSortedArray {

    static void main() {
        int[] numbers = {1, 1, 2, 2, 2, 3, 3, 4, 5, 9};
        P0026RemoveDuplicatesFromSortedArray obj = new P0026RemoveDuplicatesFromSortedArray();
        System.out.println(Arrays.toString(obj.removeDuplicates(numbers)));
        System.out.println(obj.removeDuplicatesAndSortInPlace(numbers));
    }

    public int[] removeDuplicates(int[] numbers) {
        int j = 0;

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] != numbers[j]) {
                j++;
                numbers[j] = numbers[i];
            }
        }
        return Arrays.copyOf(numbers, j + 1);
    }

    public int removeDuplicatesAndSortInPlace(int[] numbers) {
        if (numbers == null || numbers.length == 0) return 0;

        Arrays.sort(numbers);

        int i = 0;

        for (int j = 1; j < numbers.length; j++) {
            if (numbers[i] != numbers[j]) {
                i++;
                numbers[i] = numbers[j];
            }
        }
        return i + 1;
    }
}
