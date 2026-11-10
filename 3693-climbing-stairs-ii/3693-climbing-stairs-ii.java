class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[3];
        dp[0]=0;
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= 3 && i - j >= 0; j++) {
                min = Math.min(min, j * j + dp[j-1]);
            }
            dp[2]=dp[1];
            dp[1]=dp[0];
            dp[0]=costs[i - 1] + min;
        }
        return dp[0];
    }
}