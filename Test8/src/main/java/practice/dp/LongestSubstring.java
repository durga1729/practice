package practice.dp;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
    public static void main(String[] args) {
        String s = "pwwkew";
        int i = lengthOfLongestSubString(s);
        System.out.println(i);
    }

    public static int lengthOfLongestSubString(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();
        while (i < s.length()) {
            char c = s.charAt(i);
            while (set.contains(c)) {
                set.remove(s.charAt(j));
                ++j;
            }
            set.add(c);
            max = Math.max(max, i - j + 1);
            ++i;
        }
        return max;
    }
}
