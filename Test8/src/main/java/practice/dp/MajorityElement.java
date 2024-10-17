package practice.dp;

public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 1, 2, 1, 3, 1};
        int i = majorityElement(arr);
        System.out.println(i);
    }

    public static int majorityElement(int nums[]) {
        int candidate = 0;
        int count = 0;
        for (int element : nums) {
            if (count == 0) {
                candidate = element;
            }
            if (element == candidate) {
                ++count;
            } else {
                count--;
            }
        }
        return candidate;
    }
}
