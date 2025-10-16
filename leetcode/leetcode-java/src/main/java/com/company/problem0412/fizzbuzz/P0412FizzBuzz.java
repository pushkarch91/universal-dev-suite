package com.company.problem0412.fizzbuzz;

import java.util.ArrayList;
import java.util.List;

public class P0412FizzBuzz {

    static void main(String... args) {
        P0412FizzBuzz p = new P0412FizzBuzz();
        System.out.println(p.fizzBuzz(5));
        System.out.println(p.fizzBuzz(15));
        System.out.println(p.fizzBuzz(25));
        System.out.println(p.fizzBuzz(30));
        System.out.println(p.fizzBuzz(35));
        System.out.println(p.fizzBuzz(45));
        System.out.println(p.fizzBuzz(55));
    }

    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(i + "");
            }
        }
        return result;
    }
}
