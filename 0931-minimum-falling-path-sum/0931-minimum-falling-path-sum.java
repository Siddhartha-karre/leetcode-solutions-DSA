class Solution {
    private int path(int row, int col, int[][] matrix, int n, int[][] dp){
        if(row==0) return dp[row][col]= matrix[row][col];
        if(dp[row][col]!=Integer.MAX_VALUE) return dp[row][col];
        int down=Integer.MAX_VALUE, left=Integer.MAX_VALUE, right=Integer.MAX_VALUE;
        if(row>0){
            down=path(row-1, col, matrix, n, dp);
            if(col-1>=0) left=path(row-1, col-1, matrix, n, dp);
            if(col+1<n) right=path(row-1, col+1, matrix, n, dp);
        }
        return dp[row][col]= matrix[row][col]+Math.min(down, Math.min(left, right));
    }
    public int minFallingPathSum(int[][] matrix) {
        int m=matrix.length, n=matrix[0].length, min=Integer.MAX_VALUE;
        int[][] dp = new int[m][n];
        for(int[] arr: dp) Arrays.fill(arr, Integer.MAX_VALUE);
        for(int i=0; i<n; i++){
            min=Math.min(min, path(m-1, i, matrix, n, dp));
        }
        return min;
    }
}