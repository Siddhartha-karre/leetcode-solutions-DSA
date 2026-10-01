class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length - 1, n = obstacleGrid[0].length - 1;
        int[][] dp = new int[m + 1][n + 1];
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m][n] == 1)
            return 0;
        dp[0][0] = 1;
        for (int row = 0; row <= m; row++) {
            for (int col = 0; col <= n; col++) {
                if (row == 0 && col == 0)
                    continue;
                if (obstacleGrid[row][col] == 1) {
                    dp[row][col] = 0;
                    continue;
                }
                int up = 0, left = 0;
                if (row - 1 >= 0)
                    up = dp[row - 1][col];
                if (col - 1 >= 0)
                    left = dp[row][col - 1];
                dp[row][col] = up + left;
            }
        }
        return dp[m][n];
    }
}