package practice.dp;

import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        int[] arr1 = twoSum(arr, target);
        System.out.println(Arrays.toString(arr1));
    }

    public static int[] twoSum(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) return new int[]{left + 1, right + 1};
            else if (sum > target) --right;
            else ++left;
        }
        return null;
    }
}
