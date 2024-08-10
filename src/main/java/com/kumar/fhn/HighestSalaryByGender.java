package com.kumar.fhn;
import java.util.*;
import static java.util.Comparator.comparingDouble;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;

class Employee {
    private String name;
    private String gender;
    private double salary;

    public Employee(String name, String gender, double salary) {
        this.name = name;
        this.gender = gender;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return name + " (" + gender + ", $" + salary + ")";
    }
}

public class HighestSalaryByGender {

    public static void main(String[] args) {
        List<Employee> employeeList = Arrays.asList(
                new Employee("Mithlesh", "Male", 115000),
                new Employee("Kumar", "Male", 80000),
                new Employee("ok", "Male", 95000),
                new Employee("Shweta", "Female", 85000),
                new Employee("Eve", "Female", 70000),
                new Employee("Gaikwad", "Male", 78000)
        );

        Map<String, Optional<Employee>> maxSalary = employeeList.stream()
                .collect(groupingBy(Employee::getGender, maxBy(comparingDouble(Employee::getSalary))));

        maxSalary.forEach((gender, employee) -> {
            employee.ifPresent(e ->
                    System.out.println(gender + ": " + e.getName() + " - $" + e.getSalary())
            );
        });
    }
}

