package java_8;

// Implementation of Stream.max()
// to get the maximum element
// of the Stream according to the
// provided Comparator.
import java.util.*;
import java.util.Optional;
import java.util.Comparator;

class MaxNumber {

    // Driver code
    public static void main(String[] args)
    {

        // Creating a list of integers
        List<Integer> list = Arrays.asList(-9, -18, 0, 25, 4);

        System.out.print("The maximum value is : ");

        // Using stream.max() to get maximum
        // element according to provided Comparator
        // and storing in variable var
        Integer var = list.stream().max(Integer::compare).get();

        System.out.print(var);
    }
}

