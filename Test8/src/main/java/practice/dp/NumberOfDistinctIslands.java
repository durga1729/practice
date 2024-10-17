package practice.dp;

import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctIslands {
    public static void main(String[] args) {
        int[][] grid = {{1, 1, 0, 1, 1}, {1, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {1, 1, 0, 1, 1}};
        int count = numDistinctIslands(grid);
        System.out.println("number of unique paths " + count);
    }


    // X= start
    // O = out of bounds or water
    // U = up
    // D = down
    // R = right
    // L = left
    public static int numDistinctIslands(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        Set<String> stringSet = new HashSet<>();
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    String path = computePath(grid, i, j, m, n, "X");
                    stringSet.add(path);
                }
            }
        }
        return stringSet.size();
    }

    public static String computePath(int[][] grid, int i, int j, int m, int n, String direction) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0) return "O";
        grid[i][j] = 0;
        String left = computePath(grid, i, j - 1, m, n, "L");
        String right = computePath(grid, i, j + 1, m, n, "R");
        String up = computePath(grid, i - 1, j, m, n, "U");
        String down = computePath(grid, i + 1, j, m, n, "D");
        return direction + left + right + up + down;
    }
}
