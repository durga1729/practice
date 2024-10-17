package practice.dp;

public class ReverseVowels {
    public static void main(String[] args) {
        String s = "APPLEPIE";
        String result = reverseVowels(s);
        System.out.println(result);
    }

    public static String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int left = 0, right = arr.length - 1;
        while (left < right) {
            boolean leftVowel = isVowel(arr[left]);
            boolean rightVowel = isVowel(arr[right]);
            if (leftVowel && rightVowel) {
                swap(arr, left, right);
                ++left;
                --right;
            }

            if (!leftVowel) {
                ++left;
            }

            if (!rightVowel) {
                --right;
            }
        }
        return new String(arr);
    }

    public static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static boolean isVowel(char letter) {
        char c = Character.toLowerCase(letter);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
