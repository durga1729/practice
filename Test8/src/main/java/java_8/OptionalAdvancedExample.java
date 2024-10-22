package java_8;

import java.util.Optional;

public class OptionalAdvancedExample {
    public static void main(String[] args) {
        // Create an Optional with a null value using ofNullable
        Optional<String> optionalValue = Optional.ofNullable(null);

        // Use orElseGet to provide a value dynamically
        String result = optionalValue.orElseGet(() -> "Generated Default Value");
        System.out.println("Result: " + result); // Output: Result: Generated Default Value

        // Example with orElseThrow: If no value is present, throw an exception
        try {
            optionalValue.orElseThrow(() -> new IllegalArgumentException("No value present!"));
        } catch (IllegalArgumentException e) {
            System.out.println("Exception: " + e.getMessage()); // Output: Exception: No value present!
        }
    }
}
