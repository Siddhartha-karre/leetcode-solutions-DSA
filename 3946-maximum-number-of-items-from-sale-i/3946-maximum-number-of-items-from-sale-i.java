class Solution {
    int n;
    int minPrice;
    private int buyOrSkip(int idx, int budget, int[][] items, int[] factors, int[][] dp){
        if(idx == n) return budget/minPrice;
        
        if(dp[idx][budget] != -1) return dp[idx][budget];

        int skip = buyOrSkip(idx+1, budget, items, factors, dp);
        int buy = 0;
        if(items[idx][1] <= budget) buy= buyOrSkip(idx+1, budget-items[idx][1], items, factors, dp) + factors[idx]+ 1;
        return dp[idx][budget] = Math.max(buy, skip);
    }
    public int maximumSaleItems(int[][] items, int budget) {
        this.n = items.length;
        int[] factors = new int[n];
        minPrice = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            minPrice = Math.min(minPrice, items[i][1]);
            for(int j=0; j<n; j++){
                if(i!=j && items[j][0]%items[i][0] == 0) factors[i]+=1;
            }
        }
        int[][] dp = new int[n][budget+1];
        for(int[] arr: dp) Arrays.fill(arr, -1);

        if(budget<minPrice) return 0;
        return buyOrSkip(0, budget, items, factors, dp);
    }
}