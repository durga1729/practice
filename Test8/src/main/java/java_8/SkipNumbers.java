package java_8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SkipNumbers {
    public static void main(String[] args) {
        // Creating a list of integers
        List<Integer> list = new ArrayList<Integer>();

        // adding elements in the list
        list.add(-2);
        list.add(0);
        list.add(2);
        list.add(4);
        list.add(6);
        list.add(8);
        list.add(10);
        list.add(12);
        list.add(14);
        list.add(16);

        list = list.stream().skip(4).collect(Collectors.toList());
        System.out.println(list);
    }
}
