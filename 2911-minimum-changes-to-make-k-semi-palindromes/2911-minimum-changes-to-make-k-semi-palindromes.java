import java.util.Arrays;

class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        // cost[i][j] stores the minimum changes to make s[i..j] a semi-palindrome
        int[][] cost = new int[n][n];
        for (int[] row : cost) {
            Arrays.fill(row, 10000);
        }

        // Precompute the semi-palindrome conversion cost for every valid substring (length >= 2)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                cost[i][j] = getSemiPalindromeCost(s, i, j);
            }
        }

        // dp[i][p] = min changes to partition prefix s[0..i-1] into p semi-palindromes
        int[][] dp = new int[n + 1][k + 1];
        for (int[] row : dp) {
            Arrays.fill(row, 10000);
        }
        dp[0][0] = 0;

        for (int p = 1; p <= k; p++) {
            // Each semi-palindrome must have length at least 2, so p parts need at least 2*p chars
            for (int i = 2 * p; i <= n; i++) {
                for (int j = 2 * (p - 1); j <= i - 2; j++) {
                    dp[i][p] = Math.min(dp[i][p], dp[j][p - 1] + cost[j][i - 1]);
                }
            }
        }

        return dp[n][k];
    }

    private int getSemiPalindromeCost(String s, int start, int end) {
        int len = end - start + 1;
        int minChanges = 10000;

        // Check all proper divisors d of len (1 <= d < len)
        for (int d = 1; d * d <= len; d++) {
            if (len % d == 0) {
                minChanges = Math.min(minChanges, calculateCostForDivisor(s, start, len, d));
                if (d != 1 && d * d != len) {
                    minChanges = Math.min(minChanges, calculateCostForDivisor(s, start, len, len / d));
                }
            }
        }
        return minChanges;
    }

    private int calculateCostForDivisor(String s, int start, int len, int d) {
        int changes = 0;
        // Iterate over each of the d modulo groups
        for (int rem = 0; rem < d; rem++) {
            int left = start + rem;
            int right = start + len - d + rem;
            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    changes++;
                }
                left += d;
                right -= d;
            }
        }
        return changes;
    }
}