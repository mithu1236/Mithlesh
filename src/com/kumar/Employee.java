/*
package com.kumar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Employee {

    public Employee(int i, String john, int i1, int i2) {
    }

    public static void main(String[] args) {
        List<Employee> employees = (List<Employee>) new Employee();
        employees.add(new Employee(1, "John", 30, 50000));
        employees.add(new Employee(2, "Alice", 28, 60000));
        employees.add(new Employee(3, "Bob", 35, 75000));

        // Query 1: Find employees earning more than a certain amount
        double minSalary = 60000;
        List<Employee> highEarners = employees.stream()
                .filter(e -> e.getSalary() > minSalary)
                .collect(Collectors.toList());

        System.out.println("Employees earning more than " + minSalary + ":");
        highEarners.forEach(e -> System.out.println(e.getName()));

        // Query 2: Calculate the average age of employees
        double averageAge = employees.stream()
                .mapToDouble(Employee::getAge)
                .average()
                .orElse(0);

        System.out.println("Average Age of Employees: " + averageAge);

        // Query 3: Increase the salary of all employees by a certain percentage
        double salaryIncreasePercentage = 10;
        employees.forEach(e -> e.setSalary(e.getSalary() * (1 + salaryIncreasePercentage / 100.0)));

        System.out.println("Salaries after " + salaryIncreasePercentage + "% increase:");
        employees.forEach(e -> System.out.println(e.getName() + ": " + e.getSalary()));

        // Query 4: Find the oldest employee
        Employee oldestEmployee = employees.stream()
                .max(Comparator.comparingInt(Employee::getAge))
                .orElse(null);

        System.out.println("Oldest Employee: " + oldestEmployee.getName() + " (Age: " + oldestEmployee.getAge() + ")");
    }

    private double getAge() {
    }

    private boolean getName() {
    }

    private boolean getSalary() {
    }
}
*/
