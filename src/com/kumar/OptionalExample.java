package com.kumar;
import java.util.Optional;
import java.util.stream.Stream;

public class OptionalExample {

    public static void main(String[] args) {
        Optional<String> nameGt4 = findFirstNameWithLengthGreaterThan4();

        if (nameGt4.isPresent()) {
            System.out.println("First name with length greater than 4: " + nameGt4.get());
        } else {
            System.out.println("No name found with length greater than 4.");
        }
    }

    public static Optional<String> findFirstNameWithLengthGreaterThan4() {
        return Stream.of("java", "perl")
                .filter(e -> e.length() > 4)
                .findFirst();
    }
}
