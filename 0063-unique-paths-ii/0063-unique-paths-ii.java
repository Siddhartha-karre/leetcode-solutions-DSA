class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length - 1, n = obstacleGrid[0].length - 1;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m][n] == 1) return 0;
        int[] prev = new int[n + 1];
        prev[0] = 1;
        for (int row = 0; row <= m; row++) {
            int[] curr= new int[n+1];
            curr[0]=1;
            for (int col = 0; col <= n; col++) {
                if (row == 0 && col == 0)
                    continue;
                if (obstacleGrid[row][col] == 1) {
                    curr[col] = 0;
                    continue;
                }
                int up = 0, left = 0;
                if (row - 1 >= 0)
                    up = prev[col];
                if (col - 1 >= 0)
                    left = curr[col - 1];
                curr[col] = up + left;
            }
            prev=curr;
        }
        return prev[n];
    }
}