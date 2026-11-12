class Solution {
    
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n==1) return 0;
        if(n==2) return Math.max(0, prices[1]-prices[0]);
        int[][] profits = new int[2][3];

        profits[0][1] = prices[n - 1];
        profits[0][2] = prices[n - 1];

        for (int idx = n - 2; idx >= 0; idx--) {
            int[][] tempProfits = new int[2][3];
            for (int buy = 0; buy <= 1; buy++) {
                for (int transactions = 1; transactions <= 2; transactions++) {
                    if (buy == 1) {
                        tempProfits[buy][transactions] = Math.max(
                                -prices[idx] + profits[0][transactions],
                                profits[1][transactions]);
                    }

                    else {
                        tempProfits[buy][transactions] = Math.max(
                                prices[idx] + profits[1][transactions - 1],
                                profits[0][transactions]);
                    }
                }
            }
            profits = tempProfits;
        }

        return profits[1][2];
    }
}