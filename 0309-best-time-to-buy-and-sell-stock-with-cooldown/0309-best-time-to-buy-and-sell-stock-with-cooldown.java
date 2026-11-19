class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        dp[n - 1][0] = prices[n - 1];

        for (int idx = n - 2; idx >= 0; idx--) {

            dp[idx][1] = Math.max(-prices[idx] + dp[idx + 1][0],
                    dp[idx + 1][1]);

            dp[idx][0] = Math.max(prices[idx] + (idx+2<n ? dp[idx + 2][1] : 0),
                    dp[idx + 1][0]);
        }

        return dp[0][1];
    }
}