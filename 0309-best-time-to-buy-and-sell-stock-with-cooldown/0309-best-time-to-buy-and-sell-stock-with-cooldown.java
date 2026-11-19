class Solution {
    int n = 0;
    private int buyAndSell(int idx, int buy, int[] prices, int[][] dp){
        if(idx >= n) return 0;
        if(dp[idx][buy]!=-1) return dp[idx][buy];
        if(buy == 1){
            return dp[idx][1] = Math.max(-prices[idx]+buyAndSell(idx+1, 0, prices, dp),
            buyAndSell(idx+1, 1, prices, dp));
        }

        return dp[idx][0] = Math.max(prices[idx] + buyAndSell(idx+2, 1, prices, dp), 
        buyAndSell(idx+1, 0, prices, dp));
    }
    public int maxProfit(int[] prices) {
        this.n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] arr: dp) Arrays.fill(arr, -1);
        return buyAndSell(0, 1, prices, dp);
    }
}