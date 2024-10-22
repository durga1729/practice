package java_8;

import java.util.Arrays;
import java.util.List;

public class ReduceExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Reduce to sum the elements of the list
        int sum = numbers.stream()
                .reduce(0, (a, b) -> a + b); // a = accumulator, b = current element

        System.out.println("Sum: " + sum); // Output: Sum: 15
    }
}
