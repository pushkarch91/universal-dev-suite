package com.company.array;

public class SumArray {
    public static void main(String[] args) {
        SumArray sumArray = new SumArray();
        sumArray.sumArray();
        sumArray.productArray();
    }

    private void sumArray() {
        int[] arr = {1, 2, 3, 4, 5};
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        System.out.println("sum = " + sum);
    }

    private void productArray() {
        int[] arr = {1, 2, 3, 4, 5};
        int sum = 1;
        for (int i : arr) {
            sum *= i;
        }
        System.out.println("sum = " + sum);
    }
}
