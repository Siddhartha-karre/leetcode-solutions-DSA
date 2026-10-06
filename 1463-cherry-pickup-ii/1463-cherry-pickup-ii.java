class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][][] dp = new int[m][n][n];

        for (int j1 = 0; j1 < n; j1++) {
            for (int j2 = 0; j2 < n; j2++) {
                if (j1 == j2)
                    dp[m-1][j1][j1] = grid[m-1][j1];
                else
                    dp[m-1][j1][j2] = grid[m-1][j1] + grid[m-1][j2];
            }
        }

        for (int row = m-2; row >= 0; row--) {
            for (int col1 = 0; col1 < n; col1++) {
                for (int col2 = 0; col2 < n; col2++) {
                    int max = Integer.MIN_VALUE;
                    for (int dcol1 = -1; dcol1 <= 1; dcol1++) {
                        for (int dcol2 = -1; dcol2 <= 1; dcol2++) {

                            int value=0;
                            if (col1 == col2) value=grid[row][col1];
                            else value=grid[row][col1]+grid[row][col2];

                            if(col1+dcol1>=0 && col1+dcol1<n && col2+dcol2>=0 && col2+dcol2<n){
                                value+=dp[row+1][col1+dcol1][col2+dcol2];
                                max=Math.max(max, value);
                            }
                        }
                    }
                    dp[row][col1][col2] = max;
                }
            }
        }

        return dp[0][0][n - 1];
    }
}