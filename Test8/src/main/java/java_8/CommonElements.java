package java_8;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.List.of;

public class CommonElements {
    public static void main(String[] args) {
        List<Integer> oneToTen = of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> twoToTen = of(2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> commonElements = oneToTen.stream()
                .filter(twoToTen::contains)
                .collect(Collectors.toList());
        System.out.println(commonElements);
    }
}
