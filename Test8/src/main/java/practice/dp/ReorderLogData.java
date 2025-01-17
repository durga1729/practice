package practice.dp;

import java.util.Arrays;

public class ReorderLogData {
    public static void main(String[] args) {
         String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
       String[] s = reorderLogFiles(logs);
        System.out.println(Arrays.toString(s));
    }

    public static String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            int index1 = log1.indexOf(" ");
            String id1 = log1.substring(0, index1);
            String main1 = log1.substring(index1 + 1);

            int index2 = log2.indexOf(" ");
            String id2 = log2.substring(0, index2);
            String main2 = log2.substring(index2 + 1);

            boolean isDigit1 = Character.isDigit(main1.charAt(0));
            boolean isDigit2 = Character.isDigit(main2.charAt(0));

            if (!isDigit1 && !isDigit2) {
                int value = main1.compareTo(main2);
                if (value == 0) return id1.compareTo(id2);
                return value;
            }
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;

        });
        return logs;
    }
}
