class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        boolean[][] isPalindrome = new boolean[n][n];
        for (int l = 1; l <= n; l++) {
            for (int i = 0; i + l <= n; i++) {
                int j = i + l - 1;
                if (i == j)
                    isPalindrome[i][j] = true;
                else if (i + 1 == j)
                    isPalindrome[i][j] = (s.charAt(i) == s.charAt(j));
                else {
                    isPalindrome[i][j] = (s.charAt(i) == s.charAt(j)) && isPalindrome[i + 1][j - 1];
                }
            }
        }

        for(int len=0; len<k; len++){
            dp[len]=0;
        }

        for (int len = k; len <= n; len++) {
            int result = dp[len-1];
            int j = len - 1;
            for (int i = 0; j - i + 1 >= k; i++) {
                if (isPalindrome[i][j])
                    result = Math.max(result, 1 + dp[i]);
            }
            dp[len]=result;
        }

        return dp[n];
    }
}