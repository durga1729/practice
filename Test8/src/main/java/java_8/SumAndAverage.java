package java_8;

import java.util.IntSummaryStatistics;
import java.util.List;

import static java.util.List.of;
import static java.util.stream.Collectors.summarizingInt;

public class SumAndAverage {
    public static void main(String[] args) {
        List<Integer> oneToTen = of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        IntSummaryStatistics summaryStatistics = oneToTen.stream()
                .collect(summarizingInt(Integer::intValue));
        System.out.println(summaryStatistics.getSum());
        System.out.println(summaryStatistics.getAverage());
    }
}
