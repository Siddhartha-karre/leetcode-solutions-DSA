class Solution {
    int MOD=1000000007;
    private int helper(int row, int col, int[][] grid, int prevDirection, int[][][] dp){
        int m=grid.length, n=grid[0].length;
        if(row==m-1 && col==n-1) return 1;
        if(row<0 || row>=m || col<0 || col>=n) return 0;
        if(dp[row][col][prevDirection]!=-1) return dp[row][col][prevDirection];
        if(grid[row][col]==0){
            return dp[row][col][prevDirection] = (helper(row, col+1, grid, 1, dp)%MOD+helper(row+1, col, grid, 0, dp)%MOD)%MOD;
        }

        if(prevDirection==1) return dp[row][col][prevDirection] = helper(row+1, col, grid, 0, dp);
        return dp[row][col][prevDirection] = helper(row, col+1, grid, 1, dp)%MOD;
    }
    public int uniquePaths(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        int[][][] dp = new int[m][n][2];
        for(int[][] arr1: dp){
            for(int[] arr: arr1) Arrays.fill(arr, -1);
        }
        return helper(0, 0, grid, 0, dp);
    }
}