package com.company.oops.eg01;

public class Tester001 {

    public static void main(String[] args) {
        Parent p = new Child();
        p.print();
    }
}

class Parent {

    private int marks = 100;

    public void show() {
        System.out.println("Parent show marks: " + marks);
    }

    public void print() {
        show();
    }
}

class Child extends Parent {

    int marks = 200;

    public void show() {
        System.out.println("Child show marks: " + marks);
    }

}
