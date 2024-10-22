package java_8;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamsExample {
    public static void main(String[] args) {
        List<Integer> l = Arrays.asList(1, 4, 4,5, 6, 2, 8);
        Set<Integer> resultList = l.stream().filter(n -> n % 2 == 0).map(m -> m * 2).collect(Collectors.toSet());
        System.out.println(resultList);
    }
}
