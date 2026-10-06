class Solution {
    private int pick(int row, int col1, int col2, int[][] grid, int m, int n, int[][][] dp){
        if(col1<0 || col1>=n || col2<0 || col2>=n || row>=m) return (int)-1e9;
        if(dp[row][col1][col2]!=-1) return dp[row][col1][col2];
        if(row==m-1){
            if(col1==col2) return dp[row][col1][col1] = grid[row][col1];
            else return dp[row][col1][col2] = grid[row][col1]+grid[row][col2];
        }

        int max=Integer.MIN_VALUE;
        for(int dcol1=-1; dcol1<=1; dcol1++){
            for(int dcol2=-1; dcol2<=1; dcol2++){
                if(col1==col2) max=Math.max(max, grid[row][col1]+pick(row+1, col1+dcol1, col2+dcol2, grid, m, n, dp));
                else max=Math.max(max, grid[row][col1]+grid[row][col2]+pick(row+1, col1+dcol1, col2+dcol2, grid, m, n, dp));
            }
        }
        return dp[row][col1][col2] = max;

    }
    public int cherryPickup(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        int[][][] dp = new int[m][n][n];
        for(int[][] arr1: dp){
            for(int[] arr: arr1) Arrays.fill(arr, -1);
        }
        return pick(0, 0, n-1, grid, m, n, dp);
    }
}