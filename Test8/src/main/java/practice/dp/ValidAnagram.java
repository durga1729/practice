package practice.dp;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "ngarama";
        boolean flag = isAnagram(s, t);
        System.out.println(flag);
    }

    public static boolean isAnagram(String s, String t) {
        int[] letters = new int[26];
        char[] arr = s.toCharArray();
        char[] arr1 = t.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            letters[arr[i] - 'a']++;
        }

        for (int j = 0; j < arr1.length; j++) {
            letters[arr1[j] - 'a']--;
        }

        for (int letter : letters) {
            if (letter != 0) {
                return false;
            }
        }
        return true;
    }
}
