package practice.arrays;

import java.util.HashMap;

class TwoIndices {
    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        int target = 9;
        int[] indices  = twoSum(arr, target);
        System.out.println(indices);
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                ans[0] = map.get(target - nums[i]);
                ans[1] = i;
                return ans;
            }
            map.put(nums[i], i);
        }
        return ans;
    }
}