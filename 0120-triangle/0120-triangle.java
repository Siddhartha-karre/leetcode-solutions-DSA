class Solution {
    private int pathSum(int row, int col, List<List<Integer>> triangle, int[][] dp){
        if(row==0) return triangle.get(0).get(0);
        if(dp[row][col]!=-1) return dp[row][col];
        int left=Integer.MAX_VALUE, right=Integer.MAX_VALUE, curr=triangle.get(row).get(col);
        if(col>0) left=pathSum(row-1, col-1, triangle, dp);
        if(col<triangle.get(row).size()-1) right=pathSum(row-1, col, triangle, dp);

        return dp[row][col]= curr+Math.min(left, right);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size(), minSum=Integer.MAX_VALUE;
        int[][] dp= new int[n][];
        for(int i=0; i<n; i++){
            dp[i]= new int[i+1];
            Arrays.fill(dp[i], -1);
        }
        for(int i=0; i<n; i++){
            minSum=Math.min(minSum, pathSum(n-1, i, triangle, dp));
        }
        return minSum;
    }
}