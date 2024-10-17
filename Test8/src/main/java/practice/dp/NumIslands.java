package practice.dp;

public class NumIslands {
    public static void main(String[] args) {
        int[][] grid = {{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 1, 1}};
        int n = numIslands(grid);
        System.out.println(n);
    }

    public static int numIslands(int grid[][]) {
        if (grid == null) return 0;
        int islandCount = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    ++islandCount;
                    changeLandToWater(grid, i, j, m, n);
                }
            }
        }
        return islandCount;

    }

    private static void changeLandToWater(int[][] grid, int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0) return;
        grid[i][j] = 0;

        changeLandToWater(grid, i, j - 1, m, n);
        changeLandToWater(grid, i, j + 1, m, n);
        changeLandToWater(grid, i - 1, j, m, n);
        changeLandToWater(grid, i + 1, j, m, n);
    }
}
