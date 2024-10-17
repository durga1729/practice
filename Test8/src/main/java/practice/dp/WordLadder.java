package practice.dp;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {

        List<String> words = new ArrayList<>();
        words.add("ce");
        words.add("mo");
        words.add("ko");
        words.add("me");
        words.add("co");

        String beginWord = "be";
        String endWord = "ko";
        int length = ladderLength(beginWord, endWord, words);
        System.out.println(length);
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordsList) {
        Set<String> set = new HashSet<>(wordsList);
        if (!set.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Queue<String> visited = new LinkedList<>();
        visited.add(beginWord);

        int changes = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equalsIgnoreCase(endWord)) {
                    return changes;
                }

                for (int j = 0; j < word.length(); j++) {
                    for (int k = 'a'; k <= 'z'; k++) {
                        char[] arr = word.toCharArray();
                        arr[j] = (char) k;

                        String str = new String(arr);
                        if (set.contains(str) && !visited.contains(str)) {
                            queue.add(str);
                            visited.add(str);
                        }
                    }
                }
            }
            ++changes;
        }
        return 0;
    }
}
