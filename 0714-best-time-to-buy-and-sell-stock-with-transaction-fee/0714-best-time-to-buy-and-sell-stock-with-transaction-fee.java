class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int dp0 = prices[n - 1]-fee, dp1 = 0;

        for (int idx = n - 2; idx >= 0; idx--) {
            int temp1 = Math.max(-prices[idx] + dp0, dp1);
            int temp0 = Math.max(prices[idx]-fee + dp1, dp0);
            dp0 = temp0;
            dp1 = temp1;
        }

        return dp1;
    }
}