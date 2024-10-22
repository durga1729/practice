package java_8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PeekExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        // Using peek to log and debug the stream elements
        List<String> result = names.stream()
                .filter(name -> name.length() > 3) // Filter names longer than 3 characters
                .peek(name -> System.out.println("Filtered name: " + name)) // Peek at filtered elements
                .map(String::toUpperCase) // Convert to uppercase
                .peek(name -> System.out.println("Uppercased name: " + name)) // Peek at mapped elements
                .collect(Collectors.toList()); // Collect the results

        System.out.println("Final Result: " + result); // Output: [ALICE, CHARLIE, DAVID]
    }
}