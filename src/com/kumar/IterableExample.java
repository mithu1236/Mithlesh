package com.kumar;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class IterableExample {

    public static void main(String[] args) {
        List<String> languages = Arrays.asList("Java", "Python", "JavaScript", "C++","C#","dotnet","DS", "OS","Golang");

        // Using forEach on Iterable
        iterateOverLanguages(languages);

        // Using ExecutorService for parallel execution
        executeParallelTasks(languages);

        // Scheduled task
        scheduleTask(languages);
    }

    // Iterable.forEach implementation
    public static <T> void iterateOverLanguages(Iterable<T> iterable) {
        System.out.println("Iterating over languages:");
        iterable.forEach(language -> System.out.println("Language: " + language));
        System.out.println();
    }

    // ExecutorService for parallel execution
    public static void executeParallelTasks(List<String> languages) {
        System.out.println("Executing tasks in parallel:");

        var executorService = Executors.newFixedThreadPool(2);

        for (String language : languages) {
            executorService.submit(() -> {
                // Perform some task (here, classify languages based on length)
                classifyLanguage(language);
            });
        }

        executorService.shutdown();
    }

    // Switch statement to classify languages based on length
    public static void classifyLanguage(String language) {
        int length = language.length();
        System.out.println("Language: " + language + ", Length: " + length);

        switch (length) {
            case 4:
                System.out.println("Short language!");
                break;
            case 7:
                System.out.println("Medium-length language!");
                break;
            default:
                System.out.println("Other length!");
        }

        System.out.println();
    }

    // ScheduledExecutorService for a scheduled task
    public static void scheduleTask(List<String> languages) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

        scheduledExecutorService.scheduleAtFixedRate(() -> {
            System.out.println("Scheduled Task: Printing languages...");
            iterateOverLanguages(languages);
        }, 0, 5, TimeUnit.SECONDS); // Print languages every 5 seconds

        // Shutdown the scheduler after some time (for demonstration purposes)
        scheduledExecutorService.schedule(() -> scheduledExecutorService.shutdown(), 30, TimeUnit.SECONDS);
    }
}
