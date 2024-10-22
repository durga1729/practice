package java_8;

import java.util.List;

import static java.util.Collections.reverseOrder;
import static java.util.List.of;

public class SecondLargestNumber {
    public static void main(String[] args) {
        List<Integer> oneToTen = of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer secondLarge = oneToTen.stream()
                .sorted(reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(Integer.MAX_VALUE);

        System.out.println(secondLarge);
    }
}
