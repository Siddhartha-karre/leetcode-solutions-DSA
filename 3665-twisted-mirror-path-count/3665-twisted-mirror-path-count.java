class Solution {
    public int uniquePaths(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        int[][][] dp = new int[m][n][2];
        dp[0][0][0]=1; dp[0][0][1]=1;
        int MOD=1000000007;

        for(int col=1; col<n; col++){
            dp[0][col][0]=1;
            if(grid[0][col]==1) break;
        }

        for(int row=1; row<m; row++){
            dp[row][0][1]=1;
            if(grid[row][0]==1) break;
        }

        for(int row=1; row<m; row++){
            for(int col=1; col<n; col++){
                if(grid[row][col-1]==1){
                    dp[row][col][0]=dp[row][col-1][1];
                }else{
                    dp[row][col][0]=(dp[row][col-1][0]+dp[row][col-1][1])%MOD;
                }

                if(grid[row-1][col]==1){
                    dp[row][col][1]=dp[row-1][col][0];
                }else{
                    dp[row][col][1]=(dp[row-1][col][0]+ dp[row-1][col][1])%MOD;
                }
            }
        }
        return (dp[m-1][n-1][0]+dp[m-1][n-1][1])%MOD;
    }
}