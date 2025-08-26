package com.company.stream;

import com.company.model.Employee;

import java.util.List;

public class StreamTester extends BaseStream {

    public static void main(String[] args) {
        StreamTester obj = new StreamTester();
        List<Employee> employees = getEmployees();

        System.out.println("\n Print all Employees\n ");
        obj.printAllEmployees(employees);

        System.out.println("\n Filter Employees by Salary\n ");
        obj.filterEmployeesBySalaryGreaterThan(employees, 60000);

        System.out.println("\n Filter Employees from Dept HR\n ");
        obj.printEmployeeFromDept(employees, "HR");
    }

    public void printAllEmployees(List<Employee> employees) {
        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
    }

    public void filterEmployeesBySalaryGreaterThan(List<Employee> employees, double salary) {
        employees.stream()
                .filter(e -> e.getSalary() > salary)
                .forEach(System.out::println);
    }

    public void printEmployeeFromDept(List<Employee> employees, String deptName) {
        employees.stream()
                .filter(e -> e.getDepartment().getName().equalsIgnoreCase(deptName))
                .forEach(System.out::println);
    }
}
