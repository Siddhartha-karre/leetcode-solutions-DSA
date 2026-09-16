class Solution {
    int MOD = (int) (1e9 + 7);

    private int solve(int n, int k, int i, int[][] dp) {
        if (k == 0)
            return 1;
        if (i >= n)
            return 0;
        if (dp[k][i] != -1)
            return dp[k][i];
        long take = 0;
        for (int j = i + 1; j < n; j++) {
            take += solve(n, k - 1, j, dp) % MOD;
        }
        long skip = solve(n, k, i + 1, dp) % MOD;
        return dp[k][i] = (int)(skip%MOD + take%MOD);
    }

    public int numberOfSets(int n, int k) {
        int[][] dp = new int[1001][1001];
        for (int[] arr : dp)
            Arrays.fill(arr, -1);
        return solve(n, k, 0, dp)%MOD;
    }
}