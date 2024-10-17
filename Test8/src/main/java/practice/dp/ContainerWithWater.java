package practice.dp;

public class ContainerWithWater {
    public static void main(String[] args) {

        int height[] = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int area = mostWater(height);
        System.out.println(area);
    }

    public static int mostWater(int[] height) {
        int n = height.length;
        int max = 0;
        int left = 0, right = n - 1;
        while (left < right) {
            int lh = height[left];
            int rh = height[right];
            int w = right - left;
            int h = Math.min(lh, rh);
            int area = w * h;
            max = Math.max(max, area);

            if (lh < rh) {
                ++left;
            } else if (rh < lh) {
                --right;
            } else {
                ++left;
                --right;
            }
        }
        return max;
    }
}
