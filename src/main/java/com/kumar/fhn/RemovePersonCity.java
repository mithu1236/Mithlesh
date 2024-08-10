package com.kumar.fhn;
import java.util.*;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

class person {
    private String name;
    private String city;
    private double height;

    public person(String name, String city, double height) {
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
        return name + " (" + city + ", " + height + " m)";
    }
}

public class RemovePersonCity {

    public static void main(String[] args) {
        List<person> people = Arrays.asList(
                new person("Alice", "New York", 1.65),
                new person("Bob", "New York", 1.85),
                new person("Charlie", "Los Angeles", 1.75),
                new person("Alice", "Los Angeles", 1.68),
                new person("Eve", "Chicago", 1.70),
                new person("Frank", "Chicago", 1.80)
        );

        List<person> unique = people.stream()
                .collect(collectingAndThen(
                        toCollection(() -> new TreeSet<>(comparing(person::getName))),
                        ArrayList::new
                ));

        for (com.kumar.fhn.person person : unique) {
            System.out.println(person.getName() + ": " + person.getCity());
        }
    }
}
