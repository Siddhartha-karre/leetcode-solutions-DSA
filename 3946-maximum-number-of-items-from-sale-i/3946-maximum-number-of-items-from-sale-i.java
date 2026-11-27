class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] factors = new int[n];
        int minPrice = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            minPrice = Math.min(minPrice, items[i][1]);
            for(int j=0; j<n; j++){
                if(i!=j && items[j][0]%items[i][0] == 0) factors[i]+=1;
            }
        }
        if(budget<minPrice) return 0;

        int[] dp = new int[budget+1];

        //Base case: 
        for(int cost = budget; cost>=minPrice; cost--){
            dp[cost] = cost/minPrice;
        }

        for(int idx = n-1; idx>=0; idx--){
            int price = items[idx][1];
            int gain = factors[idx]+1;
            for(int cost = budget; cost >= 0; cost--){
                if(cost>=price) dp[cost] = Math.max(dp[cost], dp[cost-price]+gain);
            }
        }

        
        return dp[budget];
    }
}