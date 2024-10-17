package practice.dp;

public class BestTimeToBuySellStocks {
    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        int i = maxProfit(arr);
        System.out.println(i);

    }

    public static int maxProfit(int[] nums) {
        int min = nums[0];
        int maxProfit = 0;
        for (int i = 0; i < nums.length; i++) {
            int cost = nums[i] - min;
            maxProfit = Math.max(maxProfit, cost);
            min = Math.min(min, nums[i]);
        }
        return maxProfit;
    }
}
