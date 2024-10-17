package practice.dp;

public class AddStrings {
    public static void main(String[] args) {
        String string = addStrings("99", "1");
        System.out.println(string);
    }

    public static String addStrings(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;
        StringBuilder result = new StringBuilder();

        while (i > -1 || j > -1) {
            int d1 = i > -1 ? a.charAt(i) - '0' : 0;
            int d2 = j > -1 ? b.charAt(j) - '0' : 0;
            int sum = d1 + d2 + carry;
            result.append(sum % 10);
            carry = sum /10;
            i--;
            j--;
        }

        if (carry == 1) {
            result.append(1);
        }
        return result.reverse().toString();
    }
}
