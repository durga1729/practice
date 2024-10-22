package java_8;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class Dropwhile {

    public static void main(String[] args)
    {

        // create a stream of numbers from 1 to 10
        Stream<Integer> stream
                = Stream.of(4, 4, 4, 5, 6, 7, 8, 9, 10);

        // apply dropWhile to drop all the numbers
        // matches passed predicate
        List<Integer> list
                = stream.dropWhile(number -> (number / 4 == 1))
                .collect(Collectors.toList());

        // print list
        System.out.println(list);
    }
}
