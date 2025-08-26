package com.company.stream;

import com.company.model.Dept;
import com.company.model.Student;

public class RecordTester {

    public static void main(String[] args) {
        Dept dept = new Dept(1, "IT");
        Student emp = new Student(101, "John Doe", 75000.00, dept);

        System.out.println(emp);
        System.out.println("Employee Name: " + emp.name());
        System.out.println("Department Name: " + emp.dept().name());
    }
}
