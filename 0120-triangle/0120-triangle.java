class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size(), minSum = Integer.MAX_VALUE;
        int[][] dp = new int[n][];
        for (int i = 0; i < n; i++) {
            dp[i] = new int[i + 1];
        }

        dp[0][0] = triangle.get(0).get(0);
        for (int row = 1; row < n; row++) {
            for (int col = 0; col <=row; col++) {
                int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE, curr = triangle.get(row).get(col);
                if (col > 0)
                    left = dp[row - 1][col - 1];
                if (col < row)
                    right = dp[row - 1][col];

                dp[row][col] = curr + Math.min(left, right);
            }
        }

        for (int i = 0; i < n; i++) {
            minSum = Math.min(minSum, dp[n - 1][i]);
        }
        return minSum;
    }
}