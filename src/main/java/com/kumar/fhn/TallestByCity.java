package com.kumar.fhn;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.*;
/*import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;*/

class Person {
    private String name;
    private String city;
    private double height;

    public Person(String name, String city, double height) {
        this.name = name;
        this.city = city;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return name + " (" + height + " m)";
    }
}

public class TallestByCity {

    public static void main(String[] args) {
        List<person> people = Arrays.asList(
                new person("Plano", "Mithlesh", 1.65),
                new person("Kumar", "Texas", 1.85),
                new person("Irving", "Wipro", 1.75),
                new person("Gaikwad", "Orlando", 1.68),
                new person("Eva", "Pune", 1.70),
                new person("Danish", "Blr", 1.80)
        );

        Comparator<person> byHeight = Comparator.comparing(person::getHeight);
        Map<String, Optional<person>> tallestByCity = people.stream()
                .collect(Collectors.groupingBy(person::getCity, Collectors.reducing(BinaryOperator.maxBy(byHeight))));

        for (Map.Entry<String, Optional<person>> entry : tallestByCity.entrySet()) {
            entry.getValue().ifPresent(person ->
                    System.out.println(entry.getKey() + ": " + person)
            );
        }
    }
}