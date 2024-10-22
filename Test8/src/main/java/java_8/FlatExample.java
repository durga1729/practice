package java_8;

import java.util.Arrays;
import java.util.List;

public class FlatExample {
    public static void main(String[] args)
    {
        // Creating a List of Lists
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("Geeks", "For"),
                Arrays.asList("GeeksForGeeks", "A computer portal"),
                Arrays.asList("Java", "Programming")
        );

        // Using Stream flatMap(Function mapper)
        listOfLists.stream()
                .flatMap(list -> list.stream())
                .forEach(System.out::println);
    }
}
