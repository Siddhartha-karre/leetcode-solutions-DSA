class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp0 = prices[n - 1];
        int dp1 = 0;
        int dp2 = 0;

        for (int idx = n - 2; idx >= 0; idx--) {
            int temp1 = Math.max(-prices[idx] + dp0, dp1);
            int temp0 = Math.max(prices[idx] + dp2, dp0);

            dp2 = dp1; 
            dp1 = temp1;
            dp0 = temp0;
        }

        return dp1;
    }
}