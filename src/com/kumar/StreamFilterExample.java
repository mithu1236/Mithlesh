package com.kumar;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamFilterExample {

    public static void main(String[] args) {
        List<String> languages = Arrays.asList("Java", "Python", "JavaScript", "C++", "Ruby", "Swift");

        System.out.println("Original list of languages: " + languages);

        // Use ScheduledExecutorService for scheduling tasks
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        // Schedule a task to run after a delay and at fixed intervals
        scheduler.scheduleAtFixedRate(() -> {
            // Use Stream.filter to filter languages that contain the letter 'a'
            List<String> filteredLanguages = languages.stream()
                    .filter(language -> languageContainsA(language))
                    .collect(Collectors.toList());

            System.out.println("Filtered list of languages (contains 'a'): " + filteredLanguages);
        }, 0, 3, TimeUnit.SECONDS); // Run every 3 seconds

        // Sleep to allow scheduled tasks to execute
        try {
            Thread.sleep(150000); // Sleep for 15 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Shutdown the scheduler
        scheduler.shutdown();
    }

    // Method to check if a language contains the letter 'a'
    private static boolean languageContainsA(String language) {
        // Use switch statement to handle different cases
        switch (language.toLowerCase()) {
            case "java":
            case "javascript":
            case "swift":
                return true;
            default:
                return false;
        }
    }
}

