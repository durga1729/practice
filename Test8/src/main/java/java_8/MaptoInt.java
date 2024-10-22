package java_8;

import java.util.Arrays;
import java.util.List;

public class MaptoInt {
    public static void main(String[] args)
    {

        // Creating a list of Strings
        List<String> list = Arrays.asList("3", "6", "8",
                "14", "15");

        // Using Stream mapToInt(ToIntFunction mapper)
        // and displaying the corresponding IntStream
        list.stream().mapToInt(num -> Integer.parseInt(num))
                .filter(num -> num % 3 == 0)
                .forEach(System.out::println);
    }
}
