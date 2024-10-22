package java_8;

import java.util.Arrays;

import static java.util.stream.Collectors.joining;

public class ReverseEachWord {
    public static void main(String[] args) {
        String stmt = "java is OOP language";
        String reverseEachWord = Arrays.stream(stmt.split(" "))
                .map(word -> new StringBuffer(word).reverse())
                .collect(joining(" "));
        System.out.println(reverseEachWord);
    }
}
