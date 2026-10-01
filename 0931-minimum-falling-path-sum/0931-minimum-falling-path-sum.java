class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m=matrix.length, n=matrix[0].length, min=Integer.MAX_VALUE;
        int[][] dp = new int[m][n];
        for(int i=0; i<n; i++) dp[0][i]=matrix[0][i];
        for(int row=1; row<m; row++){
            for(int col=0; col<n; col++){
                int down=Integer.MAX_VALUE, left=Integer.MAX_VALUE, right=Integer.MAX_VALUE;
                if(row>0){
                    down=dp[row-1][col];
                    if(col-1>=0) left=dp[row-1][col-1];
                    if(col+1<n) right=dp[row-1][col+1];
                }
                dp[row][col]= matrix[row][col]+Math.min(down, Math.min(left, right));
            }
        }
        for(int i=0; i<n; i++){ 
            min=Math.min(min, dp[m-1][i]);
        }
        return min;
    }
}