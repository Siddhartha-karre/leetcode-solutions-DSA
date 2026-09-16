class Solution {
    int MOD = (int) (1e9 + 7);

    public int numberOfSets(int n, int k) {
        int[][] dp = new int[1001][1001];
        //Base case
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        //Bottom UP
        for (int K = 1; K <= k; K++) {
            int[] prevRowSum=new int[n+1];
            for(int x=n-1; x>=0; x--){
                prevRowSum[x]=(prevRowSum[x+1]+dp[K-1][x])%MOD;
            }
            for (int i = n-1; i >= 0; i--) {
                int take = prevRowSum[i+1]%MOD;
                int skip = dp[K][i + 1] % MOD;
                dp[K][i] = (skip + take)%MOD;
            }
        }
        return dp[k][0] % MOD;
    }
}