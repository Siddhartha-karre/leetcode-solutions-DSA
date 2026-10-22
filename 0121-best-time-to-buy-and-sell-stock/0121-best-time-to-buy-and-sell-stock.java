class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0, min=prices[0], n=prices.length;
        for(int i=1; i<n; i++){
            profit=Math.max(profit, prices[i]-min);
            min=Math.min(min, prices[i]);
        }
        return profit;
    }
}