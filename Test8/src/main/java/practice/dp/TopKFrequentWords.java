package practice.dp;

import java.util.*;

public class TopKFrequentWords {
    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};

        List<String> frequentWords = topFrequentKWords(words, 2);
        System.out.println(frequentWords);

    }

    public static List<String> topFrequentKWords(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> priorityQueue = new PriorityQueue(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int frequency = map.get(o1);
                int frequency1 = map.get(o2);
                if (frequency == frequency1) return o2.compareTo(o1);
                return frequency - frequency1;
            }
        });

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            priorityQueue.add(entry.getKey());
            if (priorityQueue.size() > k)  {
                priorityQueue.poll();
            }
        }

        List<String> result = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            result.add(priorityQueue.poll());
        }
        Collections.reverse(result);
        return result;
    }
}
