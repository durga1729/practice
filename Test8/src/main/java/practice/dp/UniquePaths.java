package practice.dp;

public class UniquePaths {
    public static void main(String[] args) {
        int n = uniquePaths(2,3);
        System.out.println("--------- "+n);
    }

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
               if (i==0 || j==0) {
                   dp[i][j] =1;
               } else {
                   dp[i][j] = dp[i][j-1]+dp[i-1][j];
               }
            }
        }
       return dp[m-1][n-1];
    }
}
