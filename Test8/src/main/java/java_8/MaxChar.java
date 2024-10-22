package java_8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaxChar {

        // Driver code
        public static void main(String[] args)
        {

            // Creating a list of Strings
            List<String> list = Arrays.asList("G", "E", "E", "K",
                    "g", "e", "e", "k");

            // using Stream.max() method with Comparator
            // Here, the character with maximum ASCII value
            // is stored in variable MAX
            String MAX = list.stream().max(Comparator.
                    comparing(String::valueOf)).get();

            // Displaying the maximum element in
            // the stream according to provided Comparator
            System.out.println("Maximum element in the "
                    + "stream is : " + MAX);
        }
    }


