package com.company.stream;

import com.company.model.Employee;

import java.util.Comparator;
import java.util.List;

public class StreamSortTester extends BaseStream {

    public static void main(String[] args) {
        StreamSortTester obj = new StreamSortTester();

        List<Employee> employees = getEmployees();

        System.out.println("\n Sort Employees by Salary Ascending\n ");
        obj.sortEmployeesBySalaryAscending(employees);

        System.out.println("\n Sort Employees by Salary Descending\n ");
        obj.sortEmployeesBySalaryDescending(employees);
    }

    public void sortEmployeesBySalaryAscending(List<Employee> employees) {
        employees.stream()
                .sorted(Comparator.comparingDouble(Employee::salary))
                .forEach(System.out::println);
    }

    public void sortEmployeesBySalaryDescending(List<Employee> employees) {
        employees.stream()
                .sorted(Comparator.comparingDouble(Employee::salary).reversed())
                .forEach(System.out::println);
    }
}
