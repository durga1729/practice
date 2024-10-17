package practice.dp;

import java.util.LinkedList;
import java.util.Queue;

public class NumOfIslandsUsingBFS {
    static int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args) {
        char[][] grid = {{'1','0', '1'}, {'1', '1', '0'}};
        int i = numIslands(grid);
        System.out.println(i);
    }

    public static int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0) return 0;
        int islands = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    ++islands;
                    filledWithGrid(grid, rows, cols, i, j);
                }
            }
        }
        return islands;

    }

    public static void filledWithGrid(char[][] grid, int rows, int cols, int i, int j) {
        Queue<Integer> queue = new LinkedList<>();
        //2D--1D = row #cols + col
        //1D--2D = index/#cols = R, index % #cols = C
        queue.add(i * cols + j);
        grid[i][j] = '0';
        while (!queue.isEmpty()) {
            int index = queue.poll();
            int row = index / cols;
            int col = index % cols;
            for (int[] direction : DIRECTIONS) {
                int x = direction[0] + row;
                int y = direction[1] + col;
                if (x > -1 && y > -1 && x < rows && y < cols && grid[x][y] == '1') {
                    grid[x][y] = '0';
                    queue.add(x * cols + y);
                }
            }
        }
    }
}
