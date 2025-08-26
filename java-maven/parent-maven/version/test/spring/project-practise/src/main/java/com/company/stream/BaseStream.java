package com.company.stream;

import com.company.model.Department;
import com.company.model.Employee;

import java.util.Arrays;
import java.util.List;

public class BaseStream {

    public static List<Employee> getEmployees() {
        Department hr = new Department(1, "HR");
        Department it = new Department(2, "IT");
        Department sales = new Department(3, "Sales");

        return Arrays.asList(
                new Employee(101, "Alice", 50000, hr),
                new Employee(102, "Bob", 60000, it),
                new Employee(103, "Charlie", 55000, sales),
                new Employee(104, "David", 70000, it),
                new Employee(105, "Eve", 45000, hr),
                new Employee(106, "Frank", 80000, sales)
        );
    }

}
