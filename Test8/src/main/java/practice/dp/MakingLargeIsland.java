package practice.dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MakingLargeIsland {
    public static void main(String[] args) {
        int grid[][] = {{0, 1, 0, 1, 0}, {1, 1, 0, 0, 1}, {0, 0, 1, 1, 0}};
        int i = makeLargestIsland(grid);
        System.out.println(i);
    }

    public static int makeLargestIsland(int[][] grid) {
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        if (grid == null || grid.length == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        int max = 0, islandId = 2;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int size = getIslandSize(grid, i, j, m, n, islandId);
                    max = Math.max(max, size);
                    map.put(islandId++, size);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> set = new HashSet<>();
                    for (int[] direction : directions) {
                        int x = direction[0] + i, y = direction[1] + j;
                        if (x > -1 && y > -1 && x < m && y < n && grid[x][y] != 0) {
                            set.add(grid[x][y]);
                        }
                    }
                    int sum = 1;
                    for (int num : set) {
                        int value = map.get(num);
                        sum += value;
                    }
                    max = Math.max(max, sum);
                }
            }
        }
        return max;
    }

    public static int getIslandSize(int[][] grid, int i, int j, int m, int n, int islandId) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != 1) return 0;
        grid[i][j] = islandId;
        int left = getIslandSize(grid, i, j - 1, m, n, islandId);
        int right = getIslandSize(grid, i, j + 1, m, n, islandId);
        int up = getIslandSize(grid, i - 1, j, m, n, islandId);
        int down = getIslandSize(grid, i + 1, j, m, n, islandId);
        return left + right + up + down + 1;
    }
}
