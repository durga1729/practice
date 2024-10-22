package java_8;

import java.util.stream.Stream;

public class NoneMatch {

    // Main driver method
    public static void main(String[] args) {

        // Creating a Stream of strings
        // Custom input strings are passed as arguments
        Stream<String> stream
                = Stream.of("CSE", "C++", "Java", "DS");

        // Now using Stream noneMatch(Predicate predicate)
        // and later storing the boolean answer as
        boolean answer = stream.noneMatch(str -> (str.length() == 4));

        // Printing the boolean value on the console
        System.out.println(answer);

    }
}
