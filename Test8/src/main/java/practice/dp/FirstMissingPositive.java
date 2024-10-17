package practice.dp;

public class FirstMissingPositive {
    public static void main(String[] args) {
        int arr[] = {7, -2, 3, 1, 2, 20, -5};
        int i = firstMissingPositive(arr);
        System.out.println(i);
    }

    public static int firstMissingPositive(int nums[]) {
        if (nums == null || nums.length == 0) return 1;
        int n = nums.length, containsOne = 0;

        // step 1
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                containsOne = 1;
            } else if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = 1;
            }
        }
        if (containsOne == 0) return 1;

        //step 2
        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) nums[index] = -1 * nums[index];
        }


        //step 3
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;

    }
}
