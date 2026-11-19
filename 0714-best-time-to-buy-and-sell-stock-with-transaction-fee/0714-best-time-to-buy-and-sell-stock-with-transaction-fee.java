class Solution {
    private int buyAndSell(int[] prices, int idx, int buy, int[][] dp, int fee) {
        if (idx == prices.length - 1) {
            return buy == 1 ? 0 : +prices[idx]-fee;
        }
        if(dp[idx][buy]!=-1) return dp[idx][buy];
        if (buy == 1) {
            return dp[idx][buy]=Math.max(-prices[idx] + buyAndSell(prices, idx + 1, 0,dp, fee),
                    buyAndSell(prices, idx + 1, 1, dp, fee));
        }
        return dp[idx][buy] = Math.max(prices[idx]-fee + buyAndSell(prices, idx + 1, 1, dp, fee),
                buyAndSell(prices, idx + 1, 0, dp, fee));
    }

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] arr: dp) Arrays.fill(arr, -1);
        return buyAndSell(prices, 0, 1, dp, fee);
    }
}