package com.company.problem0217.containsDuplicate;

import java.util.HashSet;
import java.util.Set;

public class P0217ContainsDuplicate {

    static void main() {
        P0217ContainsDuplicate containsDuplicate = new P0217ContainsDuplicate();
        System.out.println(containsDuplicate.containsDuplicate(new int[]{1, 3, 2, 5}));
        System.out.println(containsDuplicate.containsDuplicate(new int[]{1, 3, 1, 2, 5}));
    }

    public boolean containsDuplicate(int[] numbers) {
        Set<Integer> seenNumbers = new HashSet<>();
        for (int number : numbers) {
            if (seenNumbers.contains(number)) {
                return true;
            }
            seenNumbers.add(number);
        }
        return false;
    }
}
