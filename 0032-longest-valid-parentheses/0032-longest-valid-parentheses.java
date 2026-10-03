class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        if (n <= 1) return 0;

        int[] dp = new int[n];
        int max = 0;

        for (int i = 1; i < n; i++) {

            if (s.charAt(i) == '(') {
                dp[i] = 0;
            }

            else if (s.charAt(i - 1) == '(') {
                dp[i] = 2 + (i - 2 >= 0 ? dp[i - 2] : 0);
            }

            else {
                int match = i - dp[i - 1] - 1;

                if (match >= 0 && s.charAt(match) == '(') {
                    dp[i] = dp[i - 1] + 2;

                    if (match > 0)
                        dp[i] += dp[match - 1];
                }
            }

            max = Math.max(max, dp[i]);
        }

        return max;
    }
}