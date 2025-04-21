package com.company.oops.eg02;


public class Tester002 {

    public static void main(String[] args) {
        Parent p = new Child();
        p.print();
        System.out.println(p.marks);
    }
}

class Parent {

    int marks = 100;

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
