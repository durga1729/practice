package practice.dp;

public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int sum = minPathSum(grid);
        System.out.println(sum);
    }

    public static int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int top = i - 1 < 0 ? Integer.MAX_VALUE : grid[i - 1][j];
                int bottom = j - 1 < 0 ? Integer.MAX_VALUE : grid[i][j - 1];
                int min = (top == Integer.MAX_VALUE && bottom == Integer.MAX_VALUE) ? 0 : Math.min(top, bottom);
                grid[i][j] += min;
            }
        }
        return grid[m - 1][n - 1];
    }
}
