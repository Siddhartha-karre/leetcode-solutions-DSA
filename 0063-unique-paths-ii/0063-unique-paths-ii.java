class Solution {
    private int path(int row, int col, int[][] obstacleGrid, int[][] dp){
        if(row==0 && col==0) return 1;
        if(dp[row][col]!=-1) return dp[row][col];
        if(obstacleGrid[row][col]==1) return dp[row][col]= 0;
        int up=0, left=0;
        if(row-1>=0 ) up=path(row-1, col, obstacleGrid, dp);
        if(col-1>=0 ) left=path(row, col-1, obstacleGrid, dp);
        return dp[row][col]= up+left;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length-1, n=obstacleGrid[0].length-1;
        int[][] dp = new int[m+1][n+1];
        for(int[] arr: dp) Arrays.fill(arr, -1);
        if(obstacleGrid[0][0]==1 || obstacleGrid[m][n]==1) return 0;
        return path(m, n, obstacleGrid, dp);
    }
}