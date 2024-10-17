package practice.dp;

public class MaximumSubArray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int n = maxSubArray(nums);
        System.out.println(n);
    }

    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i],nums[i]+nums[i-1]);
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
