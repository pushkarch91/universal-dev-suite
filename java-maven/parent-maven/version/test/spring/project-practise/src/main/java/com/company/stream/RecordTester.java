package com.company.stream;

import com.company.model.Department;
import com.company.model.Employee;

public class RecordTester {

    public static void main(String[] args) {
        Department dept = new Department(1, "IT");
        Employee emp = new Employee(101, "John Doe", 75000.00, dept);

        System.out.println(emp);
        System.out.println("Employee Name: " + emp.name());
        System.out.println("Department Name: " + emp.department().name());
    }
}
