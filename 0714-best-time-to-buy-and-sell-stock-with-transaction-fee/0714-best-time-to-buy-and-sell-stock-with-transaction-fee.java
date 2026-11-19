class Solution {
    public int maxProfit(int[] prices, int fee) {
        int profit = 0;
        int hold = prices[0]; 

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < hold) {
                hold = prices[i];
            } else if (prices[i] > hold + fee) {
                profit += prices[i] - hold - fee;
                hold = prices[i] - fee;
            }
        }

        return profit;
    }
}