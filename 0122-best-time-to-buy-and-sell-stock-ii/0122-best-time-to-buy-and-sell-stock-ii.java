class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0, n = prices.length, hold = prices[0];

        for (int i = 1; i < n; i++) {
            if (hold == prices[i])
                continue;
            else if (hold < prices[i]) {
                profit += prices[i] - hold;
            }
            hold = prices[i];

        }
        return profit;
    }
}