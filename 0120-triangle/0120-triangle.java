class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size(), minSum = Integer.MAX_VALUE;
        int[]dp = new int[1];
        dp[0] = triangle.get(0).get(0);

        for (int row = 1; row < n; row++) {
            int[] curr=new int[row+1];
            for (int col = 0; col <=row; col++) {
                int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE, val = triangle.get(row).get(col);
                if (col > 0)
                    left = dp[col - 1];
                if (col < row)
                    right = dp[col];

                curr[col] = val + Math.min(left, right);
            }
            dp=curr;
        }

        for (int i = 0; i < n; i++) {
            minSum = Math.min(minSum, dp[i]);
        }
        return minSum;
    }
}