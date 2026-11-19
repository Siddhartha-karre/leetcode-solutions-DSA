class Solution {
    private int buyAndSell(int[] prices, int idx, int buy, int[][] dp) {
        if (idx == prices.length - 1) {
            return buy == 1 ? 0 : +prices[idx];
        }
        if(dp[idx][buy]!=-1) return dp[idx][buy];
        if (buy == 1) {
            return dp[idx][buy]=Math.max(-prices[idx] + buyAndSell(prices, idx + 1, 0,dp),
                    buyAndSell(prices, idx + 1, 1, dp));
        }

        return dp[idx][buy] = Math.max(prices[idx] + buyAndSell(prices, idx + 1, 1, dp),
                buyAndSell(prices, idx + 1, 0, dp));
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] arr: dp) Arrays.fill(arr, -1);
        return buyAndSell(prices, 0, 1, dp);
    }
}