package practice.dp;

public class LongestIncreasingPath {
    private static int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {

    }

    public static int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int longestPath = 0;
        if (matrix == null || matrix.length == 0) return 0;
        int[][] cache = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int longest = longestIncreasingPath(matrix, cache, i, j, n, m);
                longestPath = Math.max(longestPath, longest);
            }
        }
        return longestPath;
    }

    private static int longestIncreasingPath(int[][] matrix, int[][] cache, int i, int j, int n, int m) {
        if (cache[i][j] > 0) return cache[i][j];
        int max = 0;
        for (int[] direction : DIRECTIONS) {
            int x = direction[0] + i, y = direction[1] + j;
            if (x > -1 && y > -1 && x < n && y < m && matrix[x][y] > matrix[i][j]) {
                int longest = longestIncreasingPath(matrix, cache, i, j, n, m);
                max = Math.max(max, longest);
            }
        }
        cache[i][j] = max + 1;
        return cache[i][j];
    }
}
