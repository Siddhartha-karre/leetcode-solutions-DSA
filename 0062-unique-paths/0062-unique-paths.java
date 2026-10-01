class Solution {
    private int path(int row, int col, int[][] dp){
        if(row==0 && col==0) return 1;
        if(dp[row][col]!=-1) return dp[row][col];
        int left =0, up =0;
        if(row-1>=0) up = path(row-1, col, dp);
        if(col-1>=0) left = path(row, col-1, dp);
        return dp[row][col]=up+left;
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] arr: dp) Arrays.fill(arr, -1);
        return path(m-1, n-1, dp);
    }
}