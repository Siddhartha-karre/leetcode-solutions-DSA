class Solution {
    public int uniquePaths(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        int[][] dp = new int[n][2];
        dp[0][0]=1; dp[0][1]=1;
        int MOD=1000000007;

        for(int col=1; col<n; col++){
            dp[col][0]=1;
            if(grid[0][col]==1) break;
        }

        for(int row=1; row<m; row++){
            int[][] nextDp=new int[n][2];
            if(grid[row-1][0]==0){
                nextDp[0][1]=dp[0][1];
            }
            for(int col=1; col<n; col++){
                if(grid[row][col-1]==1){
                    nextDp[col][0]=nextDp[col-1][1];
                }else{
                    nextDp[col][0]=(nextDp[col-1][0]+nextDp[col-1][1])%MOD;
                }

                if(grid[row-1][col]==1){
                    nextDp[col][1]=dp[col][0];
                }else{
                    nextDp[col][1]=(dp[col][0]+ dp[col][1])%MOD;
                }
            }
            dp=nextDp;
        }
        return (dp[n-1][0]+dp[n-1][1])%MOD;
    }
}