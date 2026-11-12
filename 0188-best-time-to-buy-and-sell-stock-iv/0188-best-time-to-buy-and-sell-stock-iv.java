class Solution {
    private int trade(int buy, int idx, int[] prices, int transactions, int[][][] profits){
        if(transactions == 0) return 0;
        if(idx>=prices.length) return 0;
        if(idx==prices.length-1){
            return buy==1? 0: prices[idx];
        }
        if(profits[idx][buy][transactions]!=-1) return profits[idx][buy][transactions];
        if(buy==1){
            return profits[idx][buy][transactions] = Math.max(
                -prices[idx]+trade(0, idx+1, prices, transactions, profits), 
                trade(1, idx+1, prices, transactions, profits)
            );
        }

        return profits[idx][buy][transactions] = Math.max(
            prices[idx]+trade(1, idx+1, prices, transactions-1, profits),
            trade(0, idx+1, prices, transactions, profits)
        );

    }
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int[][][] profits=new int[n][2][k+1];
        for(int[][] num1: profits){
            for(int[] arr: num1) Arrays.fill(arr, -1);
        }
        return trade(1, 0, prices, k, profits);
    }
}