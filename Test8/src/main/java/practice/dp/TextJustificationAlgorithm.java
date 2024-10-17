package practice.dp;

import java.util.ArrayList;
import java.util.List;

public class TextJustificationAlgorithm {
    public static void main(String[] args) {
        String words[] = {"what", "must", "acknowledgment", "shall", "be"};
        int maxWidth = 15;
        List<String> result = fullJustify(words, maxWidth);
        System.out.println(result);

    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0, n = words.length;
        while (i < n) {
            int j = i + 1;
            int lineLength = words[i].length();
            while (j < n && (lineLength + words[j].length() + (j - i - 1) < maxWidth)) {
                lineLength += words[j].length();
                ++j;
            }

            int diff = maxWidth - lineLength;
            int numberOfWords = j - i;
            if (numberOfWords == 1 || j >= n) result.add(leftJustify(words, diff, i, j));
            else result.add(middleJustify(words, diff, i, j));

            i = j;
        }
        return result;
    }

    public static String leftJustify(String[] words, int diff, int i, int j) {
        int spacesOnRight = diff - (j - i - 1);
        int extraSpaces = diff % spacesOnRight;
        StringBuilder result = new StringBuilder(words[i]);
        for (int k = i + 1; k < j; ++k) {
            int spacesToApply =  (extraSpaces-- > 0 ? 1 : 0);
            result.append("_".repeat(spacesToApply) + words[k]);
            //   result.append("_".repeat(spacesOnRight));
        }
        result.append("_".repeat(spacesOnRight));
        return result.toString();
    }

    public static String middleJustify(String[] words, int diff, int i, int j) {
        int spacesNeed = j - i - 1;
        int spaces = diff / spacesNeed;
        int extraSpaces = diff % spacesNeed;
        StringBuilder result = new StringBuilder(words[i]);
        for (int k = i + 1; k < j; ++k) {
            int spacesToApply = spaces + (extraSpaces-- > 0 ? 1 : 0);
            result.append("_".repeat(spacesToApply) + words[k]);
        }
        return result.toString();
    }

}
