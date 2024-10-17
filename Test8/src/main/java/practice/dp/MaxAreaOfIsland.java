package practice.dp;

public class MaxAreaOfIsland {
    public static void main(String[] args) {
        int[][] grid = {{1, 1, 0, 1, 1}, {1, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {1, 1, 0, 1, 1}};
        int maxArea = maxAreaOfIsland(grid);
        System.out.println(maxArea);
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = getArea(grid, i, j, m, n);
                    max = Math.max(max, area);
                }
            }
        }
        return max;
    }

    public static int getArea(int[][] grid, int i, int j, int m, int n) {
        //check for out of bounds
        //check if the position is water or '0'
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0) return 0;

        grid[i][j] = 0;
        int left = getArea(grid, i, j - 1, m, n);
        int right = getArea(grid, i, j + 1, m, n);
        int up = getArea(grid, i - 1, j, m, n);
        int down = getArea(grid, i + 1, j, m, n);

        return left + right + up + down + 1;
    }
}
