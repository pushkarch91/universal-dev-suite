package com.company.number;

public class Swapping {

    public static void main(String[] args) {
        Swapping swapping = new Swapping();
        System.out.println("Before swapping " + 10 + " " + 20);
        swapping.swappingUsingThirdVariable(10, 20);
        swapping.swappingUsingTemporaryVariable(10, 20);
        swapping.swappingUsingXOR(10, 20);
    }

    private void swappingUsingThirdVariable(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.println("After swapping " + a + " " + b);
    }

    private void swappingUsingTemporaryVariable(int a, int b) {
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("After swapping " + a + " " + b);
    }

    private void swappingUsingXOR(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("After swapping " + a + " " + b);
    }

}
